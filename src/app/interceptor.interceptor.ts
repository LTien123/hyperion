import { HttpEvent, HttpHandler, HttpHandlerFn, HttpHeaders, HttpInterceptor, HttpInterceptorFn, HttpRequest } from '@angular/common/http';
import { BehaviorSubject, catchError, Observable, switchMap, tap, throwError } from 'rxjs';
import { AuthService } from './auth/service/auth.service';
import { inject, Injectable } from '@angular/core';
import { ToastrService } from 'ngx-toastr';


@Injectable()
export class interceptor implements HttpInterceptor {

  private isRefreshing = false;

  constructor(private authService: AuthService, private toastrService:ToastrService,) { }

  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {

    const token = localStorage.getItem('token');
    if (req.url.includes('/auth/refresh')) {
      const cleanReq = req.clone({ headers: req.headers.delete('Authorization') });
      return next.handle(cleanReq);
    }
    
    
    
    let authReq = req;
    
    if (token) {
      authReq = req.clone({
        setHeaders: {
          Authorization: `Bearer ${token}`,
        },
      });
    }

    

    return next.handle(authReq).pipe(
      catchError((error) => {
        if (error.status === 401) {
          if(token) {
            console.log("this check if token exist")
            // return this.handle401error(authReq, next, token);

            return this.handdle401(authReq, next, token);
            
          }
        }
        return throwError(() => error + " co phai vao day khong ?");
      })
    );
  }

  private handle401error(authReq: HttpRequest<any>, next: HttpHandler, token: string) {
    if (!this.isRefreshing) {
      this.isRefreshing = true;
        console.log("check if refreshing")
        return this.authService.refreshToken(token).pipe(
          tap((res: any) => {console.log("check refreshService")}),
          switchMap((res: any) => {
            console.log("vao day chua?")
            
            const newToken = res.result.token;
    
            this.isRefreshing = false;

            localStorage.setItem("token", newToken)
    
            console.log(newToken);

            const cloneReq = authReq.clone({
              setHeaders: {
                Authorization: `Bearer ${newToken}`,
              },
            })
    
            return next.handle(cloneReq);
          }), catchError((err) => {
            this.isRefreshing = false;
            console.log("co vao day khong /")
            return throwError(() => err);
          })
        )
    }

    

    return next.handle(authReq);
  }

  private handdle401(authReq: HttpRequest<any>, next: HttpHandler, token: string) {
    if(!this.isRefreshing) {
      this.isRefreshing = true
      console.log("check if refresh");

      this.authService.$refreshToken.next(true);
      
      const refreshToken = localStorage.getItem("refreshToken");
      console.log("check if refresh token is exist");
      console.log(refreshToken);
      if (!refreshToken)
        return next.handle(authReq);

      localStorage.setItem("token", refreshToken);
      console.log(refreshToken);

      const cloneReq = authReq.clone({
        setHeaders: {
          Authorization: `Bearer ${refreshToken}`,
        },
      });

      return next.handle(cloneReq);
      
    }

    return next.handle(authReq);
  }

  
}


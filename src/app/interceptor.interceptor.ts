import { HttpEvent, HttpHandler, HttpHandlerFn, HttpHeaders, HttpInterceptor, HttpInterceptorFn, HttpRequest } from '@angular/common/http';
import { catchError, Observable, switchMap, throwError } from 'rxjs';
import { AuthService } from './auth/service/auth.service';
import { inject, Injectable } from '@angular/core';
import { ToastrService } from 'ngx-toastr';


@Injectable()
export class interceptor implements HttpInterceptor {

  constructor(private authService: AuthService, private toastrService:ToastrService,) { }

  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    const token = localStorage.getItem('token');
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
          // this.toastrService.error('token is expried, login again!!')
          // localStorage.removeItem('token'); // Xóa token khỏi localStorage
          
          
        }
        return throwError(() => error);
      })
    );

    //   // Tiếp tục xử lý request
    //   return next.handle(authReq).pipe(
    //     catchError((error) => {
    //       // Xử lý lỗi 401 (Unauthorized)
    //       if (error.status === 401 && token) {
    //         return this.authService.refreshToken(token).pipe(
    //           switchMap((res: any) => {
    //             const newToken = res.result.token;
    //             localStorage.setItem('token', newToken); // Lưu token mới vào localStorage

    //             // Clone request với token mới
    //             const clonedReq = authReq.clone({
    //               setHeaders: {
    //                 Authorization: `Bearer ${newToken}`,
    //               },
    //             });

    //             // Gửi lại request đã sửa đổi
    //             return next.handle(clonedReq);
    //           }),
    //           catchError((refreshError) => {
    //             console.error('Refresh token failed:', refreshError);
    //             localStorage.removeItem('token'); // Xóa token nếu refresh token thất bại
    //             return throwError(() => refreshError);
    //           })
    //         );
    //       }

    //       // Trả lỗi nếu không xử lý được
    //       return throwError(() => error);
    //     })
    //   );
    // }
  }
}
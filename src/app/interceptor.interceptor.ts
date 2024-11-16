import { HttpEvent, HttpHeaders, HttpInterceptorFn, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';

export const interceptorInterceptor: HttpInterceptorFn = (req: HttpRequest<unknown>, next: { (req: HttpRequest<unknown>): Observable<HttpEvent<unknown>>; (arg0: any): any; }) => {
  const token = localStorage.getItem('token');
  if (token) {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    const clonedRequest = req.clone({ headers });
    return next(clonedRequest);
  }
  return next(req);
};
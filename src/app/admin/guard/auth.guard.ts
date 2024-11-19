import { inject, Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthService } from '../../auth/service/auth.service';
import { firstValueFrom } from 'rxjs';


@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate {
  constructor(private authService: AuthService, private router: Router) { }

  async canActivate(): Promise<boolean> {
    const token = localStorage.getItem('token');
    
    if (token) {
      try {
        
        if (this.authService.isTokenExpired()) {
          return true;
        } else {
          
          const resp = await firstValueFrom(this.authService.refreshToken(token));
          const refresh = resp.result.token;
          if (!refresh) {
            alert("login session expired")
            localStorage.removeItem("token");
            this.router.navigate(['auth/login']);
            return false;
          }
          localStorage.setItem("token", refresh);
          console.log(refresh);

          return true;
          
        }
      } catch (err) {
        console.log("deo biet co vao day khong");
        localStorage.removeItem("token");
        localStorage.removeItem("refreshToken");
        console.log(err);
        this.router.navigate(['auth/login']);
        return false;
      }
    } else {
      this.router.navigate(['auth/login']);
      return false;
    }
  }
}
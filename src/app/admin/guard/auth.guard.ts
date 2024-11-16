import { Injectable } from '@angular/core';
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
        const res = await firstValueFrom(this.authService.introspect(token));
        console.log(res.result.valid)
        if (res.result.valid) {
          return true;
        } else {
          alert("login session expired")
          this.router.navigate(['auth/login']);
          return false
        }
      } catch (err) {
        console.log(err)
        this.router.navigate(['auth/login']);
        return false;
      }
    } else {
      this.router.navigate(['auth/login']);
      return false;
    }
  }
}
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LogoutService } from '../../../auth/service/logout.service';
import { AuthService } from '../../../auth/service/auth.service';

@Component({
  selector: 'app-side-nav',
  templateUrl: './side-nav.component.html',
  styleUrl: './side-nav.component.scss'
})
export class SideNavComponent {
  constructor(private logoutService: LogoutService, private router: Router, private authService: AuthService) { }


  logout() {
    this.logoutService.logout(localStorage.getItem("token") as string).subscribe({
      next: (res) => {
        this.authService.clearUserInfo();
        this.router.navigate(['/auth/login']);
      }
    })
  }

}

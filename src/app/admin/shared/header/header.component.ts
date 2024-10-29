import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../../auth/service/auth.service';
import { JwtPayloadDto } from '../../../dto/JwtPayloadDto';
import { ActivatedRoute, NavigationCancel, NavigationEnd, NavigationError, NavigationStart, Router } from '@angular/router';
import { filter } from 'rxjs';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent implements OnInit {
  userInfo: JwtPayloadDto | undefined | null;
  currentPage: string = "";
  constructor(private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getUserInfo();
    this.getCurrentPage();
  }

  getUserInfo() {
    this.userInfo = this.authService.getUserInfo()
  }

  getCurrentPage() {
    this.router.events
    .subscribe(() => {
      const currentUrl = this.router.url;
      const segments = currentUrl.split('/');
      const adminIndex = segments.indexOf('admin');
     this.currentPage = segments.slice(adminIndex + 1).join('/');
     console.log(this.currentPage);
    });
  }
}

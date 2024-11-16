import { Component, OnInit } from '@angular/core';
import { NotificationService } from '../../service/notification.service';
import { AuthService } from '../../../auth/service/auth.service';
import { JwtPayloadDto } from '../../../dto/JwtPayloadDto';
import { Notification } from '../../../dto/Notification';
import { Route, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-notification',
  templateUrl: './notification.component.html',
  styleUrl: './notification.component.scss'
})
export class NotificationComponent implements OnInit {
  currentPage: number = 1;
  pageSize: number = 5;
  allNotification: Notification[] | undefined;
  pageAmount: number[] = [];
  totalPages: number | undefined;
  targetPage: number | undefined;
  userInfo: JwtPayloadDto | undefined;

  
  constructor(private notificationService: NotificationService, private authService: AuthService, private router:Router, private toastrService:ToastrService) { }
  ngOnInit(): void {
    this.getAllNotification();
  }


  getAllNotification() {
    this.userInfo = this.authService.getUserInfo();
    this.notificationService.getAllNotification(this.currentPage - 1, this.pageSize, Number(this.userInfo?.sub)).subscribe({
      next: (res) => {
        this.allNotification = res.result.content;
        this.totalPages = res.result.totalPages;
        this.pageAmount = [];
        this.pageAmount = this.getPageAmount();
        console.log(this.allNotification);
      },
      error:(err)=>{
        console.log(err)
      }
    })
  }

  navigateToOrder(id:number){
    this.notificationService.setNotificationStatusToRead(id).subscribe({
      next:(res)=>{
        this.router.navigate(['/admin/order']);
      },error:(err)=>{

      }
    })
  }



  getPageAmount(): any[] {
    if (this.totalPages)
      for (let i = 1; i <= this.totalPages; i++) {
        this.pageAmount.push(i);
      }
    return this.pageAmount;
  }

  changePage(page: number) {
    this.currentPage = page;
    this.getAllNotification();

  }

  goToPage() {
    if (this.totalPages)
      if (this.targetPage && this.targetPage >= 1 && this.targetPage <= this.totalPages) {
        this.changePage(this.targetPage);
        this.targetPage == null;
      } else {
        this.toastrService.success(`can't navigate, please check again`, 'Navigate Notification');
      }
  }
}

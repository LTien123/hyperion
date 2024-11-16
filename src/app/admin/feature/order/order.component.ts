import { Component, OnInit } from '@angular/core';
import { Order } from '../../../dto/Order';
import { OrderService } from '../../service/order.service';
import { AuthService } from '../../../auth/service/auth.service';
import { JwtPayloadDto } from '../../../dto/JwtPayloadDto';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrl: './order.component.scss'
})
export class OrderComponent implements OnInit {
  isSubmitting = false;
  userInfo: JwtPayloadDto | undefined;
  currentPage: number = 1;
  pageSize: number = 9;
  allOrders: Order[] | undefined;
  pageAmount: number[] = [];
  totalPages: number | undefined;
  targetPage: number | undefined;

  constructor(private orderService: OrderService, private authService: AuthService, private toastrService: ToastrService) { }

  ngOnInit(): void {
    this.getAllOrders();
    this.getUserInfo();
  }

  getAllOrders() {
    this.isSubmitting = true;
    this.orderService.findAllOrders(this.currentPage - 1, this.pageSize).subscribe({
      next: (res) => {
        this.isSubmitting = false;
        this.allOrders = res.result.content;
        this.totalPages = res.result.totalPages;
        this.pageAmount = [];
        this.pageAmount = this.getPageAmount();
      }, error: (err) => {
        this.isSubmitting = false;
        this.toastrService.error(`Can't open order`, 'Order Notification');
      }
    })
  }
  getUserInfo() {
    this.userInfo = this.authService.getUserInfo();
    this.userInfo?.scope
  }

  checkScope(roles: string[]): boolean {
    return roles.some(role => this.userInfo?.scope.includes(role))
  }

  confirmOrder(id: number) {
    this.isSubmitting = true;
    this.orderService.confirmOrder(id).subscribe({
      next: (res) => {
        this.isSubmitting = false;
        this.getAllOrders();
        this.toastrService.success(`order id ${id} is confirmed`, 'Order Notification');
      }, error: () => {
        this.isSubmitting = false;
        this.toastrService.error(`can't confirm order id ${id}, check again`, 'Order Notification');
      }
    })
  }

  denyOrder(id: number) {
    this.isSubmitting = true;
    this.orderService.denyOrder(id).subscribe({
      next: (res) => {
        this.isSubmitting = false;
        this.getAllOrders();
        this.toastrService.success(`order id ${id} is denied`, 'Order Notification');
      }, error: () => {
        this.isSubmitting = false;
        this.toastrService.error(`can't deny order id ${id}, check again`, 'Order Notification');
      }
    })
  }

  totalPrice(order: Order): number {
    return order.orderDetailResponseList.reduce((total, detail) => {
      return total + (detail.productDetailResponse.productDto.price * detail.amount);
    }, 0);
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
    this.getAllOrders();
  }

  goToPage() {
    if (this.totalPages)
      if (this.targetPage && this.targetPage >= 1 && this.targetPage <= this.totalPages) {
        this.changePage(this.targetPage);
        this.targetPage == null;
      } else {
        this.toastrService.error(`can't navigate, please enter again`, 'navigate Notification');
      }
  }

  navigateNewWindow(id: number) {
    window.open(`/order/${id}`, '_blank')
  }
}

import { Component, OnInit } from '@angular/core';
import { Order } from '../../../dto/Order';
import { OrderService } from '../../service/order.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrl: './order.component.scss'
})
export class OrderComponent implements OnInit {
  isSubmitting = false;
  currentPage: number = 1;
  pageSize: number = 9;
  allOrders: Order[] | undefined;
  pageAmount: number[] = [];
  totalPages: number | undefined;
  targetPage: number | undefined;

  constructor(private orderService: OrderService) { }

  ngOnInit(): void {
    this.getAllOrders();
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
      }
    })
  }

  confirmOrder(id:number){
    this.isSubmitting = true;
    this.orderService.confirmOrder(id).subscribe({
      next: (res) =>{
        this.isSubmitting = false;
        this.getAllOrders();
        alert(`order id ${id} is confirmed`)
      },error:()=>{
        this.isSubmitting = false;
        alert(`can't confirm order id ${id}, check again`)
      }
    })
  }

  denyOrder(id:number){
    this.isSubmitting = true;
    this.orderService.denyOrder(id).subscribe({
      next: (res) =>{
        this.isSubmitting = false;
        this.getAllOrders();
        alert(`order id ${id} is denied`)
      },error:()=>{
        this.isSubmitting = false;
        alert(`can't deny order id ${id}, check again`)
      }
    })
  }

  totalPrice(order:Order):number{
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
        alert('please enter correctly');
      }
  }

  navigateNewWindow(id:number){
    window.open(`/order/${id}`, '_blank')
  }
}

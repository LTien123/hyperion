import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PaymentService } from '../../service/payment.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrl: './payment.component.scss'
})
export class PaymentComponent implements OnInit {
  isSubmitting = false;
  isSuccess!: boolean;
  orderId:number = 0;
  constructor(private route: ActivatedRoute, private paymentService: PaymentService) { }
  ngOnInit(): void {
    this.isSubmitting = true;
    const orderId = this.route.snapshot.paramMap.get('id');
    const token = this.route.snapshot.queryParams['token'];  
    console.log(orderId,token);
    if (orderId && token)
      this.paymentService.setPendingById(Number(orderId),token).subscribe({
        next:(res)=>{
          this.isSubmitting = false;
          this.isSuccess = true;
          this.orderId = res.result.id;
        },error:(err)=>{
          this.isSuccess = false;
          this.isSubmitting = false;
        }
      })
  }

}

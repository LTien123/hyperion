import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { CartService } from '../../service/cart.service';
import { CartItem } from '../../../dto/CartItem';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrl: './checkout.component.scss'
})
export class CheckoutComponent {
  paymentOptions = [{
    'method': 'Cash',
    'logo': '<i class="fa-solid fa-money-bill-1-wave"></i>'
  }, {
    'method': 'PayPal',
    'logo': '<i class="fa-brands fa-paypal"></i>'
  }];
  customerForm!: FormGroup;
  totalPrice: number = 0;
  cart: CartItem[] = [];

  constructor(private fb: FormBuilder, private cartService: CartService) { }

  ngOnInit(): void {
    this.getCartItem()

    this.customerForm = this.fb.group({
      customerName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phoneNumber: ['', Validators.required],
      address: ['', Validators.required],
      note: [''],
      paymentMethod: [this.paymentOptions[0].method, Validators.required] 
    });
  }

  onSubmit(): void {
    if (this.customerForm.valid) {
      console.log(this.customerForm.value);
    }
  }

  getCartItem() {
    this.cartService.getCartObservable().subscribe((cart => {
      this.cart = cart;
      this.totalPrice = this.cart.reduce((sum, item) => {
        return sum + (item.productDetail.productDto.price * item.amount);
      }, 0);
    }))
  }
}

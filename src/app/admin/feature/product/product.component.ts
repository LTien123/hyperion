import { Component, OnInit } from '@angular/core';
import { ProductCategories } from '../../../dto/ProductCategories';
import { ProductSubCategories } from '../../../dto/ProductSubCategories';
import { Product } from '../../../dto/Product';
import { ProductDetail } from '../../../dto/ProductDetail';
import { ProductService } from '../../service/product.service';
import { FullProduct } from '../../../dto/FullProduct';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrl: './product.component.scss'
})
export class ProductComponent implements OnInit {
  productCategories:ProductCategories[] = [];
  productSubCategories:ProductSubCategories[] = [];
  product:FullProduct[] =[];
  productDetail:ProductDetail | undefined
  constructor(private productService:ProductService) { }

  ngOnInit(): void {
   this.getAllProduct();
  }

  getAllProduct(){
    this.productService.getAllProduct().subscribe({
     next:(res)=>{
      this.product = res.result;
      console.log(this.product);
     } 
    })
  }

 




}

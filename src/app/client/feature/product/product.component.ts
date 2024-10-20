import { Component, OnInit } from '@angular/core';
import { ProductService } from '../../service/product.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from '../../../dto/Product';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrl: './product.component.scss'
})
export class ProductComponent implements OnInit {
  productSubCategoryName!: string;
  productCategoryName!: string;
  products:Product[] = [];
  productPage: number = 0;
  productSize: number = 10;

  constructor(private productService: ProductService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe((param) => {
      this.productCategoryName = param['productCategoryName'];
      this.productSubCategoryName = param['productSubCategoryName'];
      this.getData();

    })
  }

  getData() {
    this.productService.findAllProductBySubCategoryName(this.productSubCategoryName, this.productPage, this.productSize).subscribe({
      next: (res) => {
        this.products = res.result.content;
        console.log (this.products)
      }
    })
  }


}





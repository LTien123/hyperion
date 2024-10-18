import { Component, OnInit } from '@angular/core';
import { ProductSubCategoriesService } from '../../service/product-sub-categories.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductSubCategories } from '../../../dto/ProductSubCategories';

@Component({
  selector: 'app-product-sub-categories',
  templateUrl: './product-sub-categories.component.html',
  styleUrl: './product-sub-categories.component.scss'
})
export class ProductSubCategoriesComponent implements OnInit {
  productCategoryName: string = "";
  productSubCategories: ProductSubCategories[] = [];
  constructor(private router: Router, private route: ActivatedRoute, private productSubCategoriesService: ProductSubCategoriesService) { }

  ngOnInit(): void {
    this.route.params.subscribe(param => {
      this.productCategoryName = param['productCategoryName'];
      this.getAllProductSubCategories();
    })
  }

  getAllProductSubCategories() {
    this.productSubCategoriesService.getProductSubCategoryByName(this.productCategoryName).subscribe({
      next: (res) => {
        if (res.result.length === 0) {
          this.router.navigate(['not-found'])
        } else {
          this.productSubCategories = res.result;
        }
      },
      error: (err) => {
      }
    })
  }
}

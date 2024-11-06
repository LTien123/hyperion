import { Component, OnInit } from '@angular/core';
import { ProductCategories } from '../../../dto/ProductCategories';
import { ProductSubCategories } from '../../../dto/ProductSubCategories';
import { Product } from '../../../dto/Product';
import { ProductDetail } from '../../../dto/ProductDetail';
import { ProductService } from '../../service/product.service';
import { FullProduct, ProductDto } from '../../../dto/FullProduct';
import { ProductDetailService } from '../../service/product-detail.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrl: './product.component.scss'
})
export class ProductComponent implements OnInit {

  selectedCategoryId: number | null = null;
  selectedSubCategoryId: number | null = null;
  selectedProductId: number | null = null;
  data: FullProduct[] = [];
  isSubmitting = false;
  constructor(private productService: ProductService, private productDetailService: ProductDetailService) { }

  ngOnInit(): void {
    this.getAllProduct();
  }

  getAllProduct() {
    this.productService.getAllProduct().subscribe({
      next: (res) => {
        this.data = res.result;
        console.log(this.data);
      }
    })
  }

  deleteProductCategoryById(id: number) {
    this.isSubmitting = true;
    this.productService.deleteProductCategoryById(id).subscribe({
      next: () => {
        this.isSubmitting = false;
        alert("deleted successfully");
        this.getAllProduct();
      },
      error: () => {
        this.isSubmitting = false;
        alert("can't delete, please check again")
      }
    })
  }

  deleteProductSubCategoryById(id: number) {
    this.isSubmitting = true;
    this.productService.deleteProductSubCategoryById(id).subscribe({
      next: () => {
        this.isSubmitting = false;
        alert("deleted successfully");
        this.getAllProduct();
      },
      error: () => {
        this.isSubmitting = false;
        alert("can't delete, please check again")
      }
    })
  }


  hasHandlebarStyle(product: ProductDto): boolean {
    return product.productDetailDtoList.some(detail => detail.productHandlebarDto?.style);
  }

  hasMaterial(product: ProductDto): boolean {
    return product.productDetailDtoList.some(detail => detail.productMaterialDto?.material);
  }


  toggleCategory(categoryId: number) {
    this.selectedCategoryId = this.selectedCategoryId === categoryId ? null : categoryId;
    this.selectedSubCategoryId = null;  // Reset subcategory khi chuyển category
    this.selectedProductId = null;  // Reset product khi chuyển category
  }

  toggleSubCategory(subCategoryId: number) {
    this.selectedSubCategoryId = this.selectedSubCategoryId === subCategoryId ? null : subCategoryId;
    this.selectedProductId = null;  // Reset product khi chuyển subcategory
  }

  toggleProduct(productId: number) {
    this.selectedProductId = this.selectedProductId === productId ? null : productId;
  }

  editProduct(id: number) {
  }

  deleteProduct(id: number) {
    this.isSubmitting = true;
    this.productService.deleteProductById(id).subscribe({
      next: () => {
        this.isSubmitting = false;
        alert("deleted successfully");
        this.getAllProduct();
      },
      error: (err) => {
        this.isSubmitting = false;
        console.log(err);
        alert("can't delete, check again");
      }
    })
  }

  editProductDetail(arg0: number) {
    throw new Error('Method not implemented.');
  }
  deleteProductDetail(id: number) {
    this.isSubmitting = true;
    this.productDetailService.deleteProductDetailById(id).subscribe({
      next: () => {
        this.isSubmitting = false;
        alert("deleted successfully");
        this.getAllProduct();
      },
      error: (err) => {
        this.isSubmitting = false;
        console.log(err);
        alert("can't delete, check again");
      }
    })
  }




}

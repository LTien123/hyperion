import { Component } from '@angular/core';
import { ProductDetailService } from '../../service/product-detail.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CartService } from '../../service/cart.service';
import { CartItem } from '../../../dto/CartItem';
import { Product, ProductColorDto, ProductHandlebarDto, ProductMaterialDto } from '../../../dto/Product';
import { ProductDetail, ProductImageResponse } from '../../../dto/ProductDetail';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss']
})
export class ProductDetailComponent {
  selectedHandlebar: string | undefined;
  selectedColor: string | undefined;
  selectedMaterial: string | undefined;
  counter: number = 1;
  selectedImg: string | undefined;
  categoryName: string | undefined;
  subCategoryName: string | undefined;
  currentProductDetail: ProductDetail | undefined;
  productName: string | undefined;
  product: Product | undefined
  productDetail: ProductDetail[] = [];
  productColors: ProductColorDto[] = [];
  productHandlebars: ProductHandlebarDto[] = [];
  productMaterials: ProductMaterialDto[] = [];
  filteredImages: ProductImageResponse[] = [];

  constructor(private productDetailService: ProductDetailService, private cartService: CartService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(param => {
      this.categoryName = param['productCategoryName'];
      this.subCategoryName = param['productSubCategoryName'];
      this.productName = param['productName'];
      this.getData();
      this.updateImage();
      this.getFilteredImages()
    });
  }

  getData() {
    if (this.productName)
      this.productDetailService.getProductDetailByProductName(this.productName).subscribe({
        next: (res) => {
          this.productDetail = res.result;

          this.productDetail.forEach(detail => {
            if (this.productColors.every(color => color.id != detail.productColorDto.id)) {
              this.productColors.push(detail.productColorDto);
            }

          })

          this.productDetail.forEach(detail => {
            if (detail.productHandlebarDto)
              if (this.productHandlebars?.every(handlebar => handlebar.id != detail.productHandlebarDto?.id)) {
                this.productHandlebars.push(detail.productHandlebarDto);
              }
          })
          console.log(this.productHandlebars);

          this.productDetail.forEach(detail => {
            if (detail.productMaterialDto)
              if (this.productMaterials?.every(material => material.id != detail.productMaterialDto?.id)) {
                this.productMaterials?.push(detail.productMaterialDto);
              }



          })


          if (this.productDetail[0]?.productHandlebarDto)
            this.selectedHandlebar = this.productDetail[0]?.productHandlebarDto?.style;

          if (this.productDetail[0]?.productMaterialDto)
            this.selectedMaterial = this.productDetail[0]?.productMaterialDto?.material;

          this.selectedColor = this.productDetail[0]?.productColorDto.color;

          this.selectedImg = this.productDetail.filter(product =>
            product.productHandlebarDto?.style === this.selectedHandlebar &&
            product.productColorDto?.color === this.selectedColor
          )[0]?.productImageResponseList[0]?.url || "";

          this.getFilteredImages();


        }
      })

    if (this.productName)
      this.productDetailService.getProductByProductName(this.productName).subscribe({
        next: (res: { result: Product | undefined; }) => {
          this.product = res.result;

        }
      })
  }

  addToCart(): void {
    const matchingProduct = this.productDetail.find(productDetail =>
      productDetail.productHandlebarDto?.style === this.selectedHandlebar &&
      productDetail.productColorDto.color === this.selectedColor &&
      productDetail.productMaterialDto?.material === this.selectedMaterial
    );
    if (matchingProduct) {
      const cartItem: CartItem = {
        productDetail: matchingProduct,
        amount: this.counter
      };
      this.cartService.addToCart(cartItem)
    } else {
      alert("error! product is not existed please select again")
    }
  }

  selectHandlebar(handlebar: string) {
    this.selectedHandlebar = handlebar;
    this.updateImage();
    this.getFilteredImages()
  }

  selectMaterial(material: string) {
    this.selectedMaterial = material;
  }

  selectColor(color: string) {
    this.selectedColor = color;
    this.updateImage();
    this.getFilteredImages()

  }

  selectImg(url: string) {
    this.selectedImg = url;
  }

  updateImage() {
    const matchingProduct = this.productDetail.find(productDetail =>
      productDetail.productHandlebarDto?.style === this.selectedHandlebar &&
      productDetail.productColorDto?.color === this.selectedColor
    );

    this.selectedImg = matchingProduct?.productImageResponseList[0]?.url || '';
  }

  getFilteredImages() {
    this.filteredImages = this.productDetail.filter(productDetail =>
      productDetail.productHandlebarDto?.style == this.selectedHandlebar &&
      productDetail.productColorDto?.color == this.selectedColor
    ).flatMap(product => product.productImageResponseList || []);
  }

  increase() {
    this.currentProductDetail = this.productDetail.find(productDetail =>
      productDetail.productHandlebarDto?.style === this.selectedHandlebar &&
      productDetail.productColorDto?.color === this.selectedColor && productDetail.productMaterialDto?.material === this.selectedMaterial
    );

    if (this.currentProductDetail && this.currentProductDetail.stock > this.counter) {
      this.counter++;

    }
  }

  decrease() {
    const filteredProduct = this.productDetail.find(product =>
      product.productHandlebarDto?.style === this.selectedHandlebar &&
      product.productColorDto?.color === this.selectedColor && product.productMaterialDto?.material === this.selectedMaterial
    );

    if (this.counter > 0 && filteredProduct) {
      this.counter--;
    }
  }
}

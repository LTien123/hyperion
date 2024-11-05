import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Color } from '../../../../dto/Color';
import { Handlebar } from '../../../../dto/Handlebar';
import { Material } from '../../../../dto/Material';
import { Product } from '../../../../dto/Product';
import { ProductDetailService } from '../../../service/product-detail.service';
import { ProductService } from '../../../service/product.service';
import { ProductDetail } from '../../../../dto/ProductDetail';

@Component({
  selector: 'app-update-product-detail',
  templateUrl: './update-product-detail.component.html',
  styleUrl: './update-product-detail.component.scss'
})
export class UpdateProductDetailComponent {

  productDetailForm!: FormGroup;
  colors: Color[] = [];
  handlebars: Handlebar[] = [];
  materials: Material[] = [];
  selectedImages: string[] = [];
  isSubmitting = false;
  productDetailId!: number;
  productDetail!: ProductDetail;


  constructor(private fb: FormBuilder, private productDetailService: ProductDetailService, private router: Router, private route: ActivatedRoute) {
    this.productDetailForm = this.fb.group({
      product: ['', Validators.required],
      colorId: ['', Validators.required],
      handlebarId: [''],
      materialId: [''],
      stock: ['', [Validators.required, Validators.pattern(/^\d+$/)]],
      images: [null]
    });
  }


  ngOnInit(): void {
    this.route.params.subscribe((param) => {
      this.productDetailId = param['id'];
      if(this.productDetailId){}
      this.fetchDropdownData();
      this.getProductDetail();


    })


  }

  getProductDetail() {
    if (this.productDetailId)
      this.productDetailService.getProductDetailById(this.productDetailId).subscribe({
        next: (res) => {
          this.productDetail = res.result;
          this.productDetailForm.patchValue({
            product: this.productDetail.productDto.name,
            colorId: this.productDetail.productColorDto.id,
            handlebarId: this.productDetail.productHandlebarDto?.id,
            materialId: this.productDetail.productMaterialDto?.id,
            stock: this.productDetail.stock,
          })
        },
        error:()=>{
          this.router.navigate(['not-found'],{ replaceUrl: true });
        }
      })
  }



  fetchDropdownData() {

    this.productDetailService.getAllColors().subscribe(res => this.colors = res.result);

    this.productDetailService.getAllHandlebars().subscribe(res => this.handlebars = res.result);

    this.productDetailService.getAllMaterials().subscribe(res => this.materials = res.result);
  }

  deleteImage(id: number) {
    this.isSubmitting = true;
    this.productDetailService.deleteProductImageById(id).subscribe({
      next: (res) => {
        this.isSubmitting = false;
        alert("deleted successfully")
        console.log(this.productDetailId);
        this.getProductDetail();
        console.log(this.productDetailForm.get('product')?.value)
      },
      error: () => {
        alert("can't delete, check again")
        this.isSubmitting = false;
      }
    })
  }

  onFileChange(event: any) {
    const files = event.target.files;
    if (files) {
      const fileArray: File[] = Array.from(files);
      this.productDetailForm.patchValue({ images: fileArray });

      // Preview selected images
      this.selectedImages = [];
      for (let file of fileArray) {
        const reader = new FileReader();
        reader.onload = () => {
          if (reader.result) this.selectedImages.push(reader.result as string);
        };
        reader.readAsDataURL(file);
      }

    }
  }

  onSubmit() {
    this.isSubmitting = true;
    if (this.productDetailForm.valid) {
      const formData = new FormData();

      const colorId = this.productDetailForm.get('colorId')?.value;
      if (colorId) {
        formData.append('colorId', colorId);
      }
      const handlebarId = this.productDetailForm.get('handlebarId')?.value;
      if (handlebarId) {
        formData.append('handlebarId', handlebarId);
      }
      const materialId = this.productDetailForm.get('materialId')?.value;
      if (materialId) {
        formData.append('materialId', materialId);
      }
      const stock = this.productDetailForm.get('stock')?.value;
      if (stock) {
        formData.append('stock', stock);
      }
      const images = this.productDetailForm.get('images')?.value;
      if (images && images.length > 0) {
        images.forEach((file: File) => {
          formData.append('images', file, file.name);
        });
      }

      this.productDetailService.updateProductDetailById(this.productDetailId,formData).subscribe({
        next: (res) => {
          this.isSubmitting = false;
          this.router.navigate(['/admin/product']);
          alert("product updated successfully");

        }, error: (err) => {
          this.isSubmitting = false;
          alert("error!" + err);
        }
      })

      // for (const [key, value] of (formData as any).entries()) {
      //   console.log(`${key}:`, value);
      // }
    }
  }
}

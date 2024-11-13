import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ProductDetailService } from '../../../service/product-detail.service';
import { Color } from '../../../../dto/Color';
import { Handlebar } from '../../../../dto/Handlebar';
import { Material } from '../../../../dto/Material';
import { Product } from '../../../../dto/Product';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../../../service/product.service';

@Component({
  selector: 'app-create-product-detail',
  templateUrl: './create-product-detail.component.html',
  styleUrl: './create-product-detail.component.scss'
})
export class CreateProductDetailComponent {
  productDetailForm!: FormGroup;
  colors: Color[] = [];
  handlebars: Handlebar[] = [];
  materials: Material[] = [];
  selectedImages: string[] = [];
  product: Product | undefined;
  isSubmitting = false;
  productId: number | undefined;

  constructor(private fb: FormBuilder, private productService: ProductService, private productDetailService: ProductDetailService, private router: Router, private route: ActivatedRoute) {
    this.productDetailForm = this.fb.group({
      product: ['', Validators.required],
      colorId: ['', Validators.required],
      handlebarId: [''],
      materialId: [''],
      stock: ['', [Validators.required, Validators.pattern(/^\d+$/)]],
      images: [null, Validators.required]
    });
  }

  selectedColor: string = '';

  updateSelectedColor(event: Event) {
    const selectedId = (event.target as HTMLSelectElement).value;
    const selectedColorObj = this.colors.find(color => color.id === Number(selectedId));
    this.selectedColor = selectedColorObj ? selectedColorObj.color : '';
  }


  ngOnInit(): void {
    this.route.params.subscribe((param) => {
      this.productId = param['id'];
      if (this.productId) {
        this.fetchDropdownData();
        this.getProductByProductId()

      } else {
        this.fetchDropdownData();
        this.getProductByPreviousProduct();
      }
    })


  }

  getProductByProductId() {
    if (this.productId)
      this.productService.getProductById(this.productId).subscribe({
        next: (res) => {
          this.product = res.result;
          console.log(this.product);
          this.productDetailForm.patchValue({
            product: this.product
          })
        }
      })
  }

  getProductByPreviousProduct() {
    const productName = history.state.productName;
    this.productDetailService.getProductByProductName(productName).subscribe({
      next: (res) => {
        this.product = res.result;
        console.log(this.product);
        this.productDetailForm.patchValue({
          product: this.product
        })
      }
    })
  }

  fetchDropdownData() {

    this.productDetailService.getAllColors().subscribe(res => this.colors = res.result);

    this.productDetailService.getAllHandlebars().subscribe(res => this.handlebars = res.result);

    this.productDetailService.getAllMaterials().subscribe(res => this.materials = res.result);
  }

  onFileChange(event: any) {
    const files = event.target.files;
    if (files) {
      const fileArray: File[] = Array.from(files);
      this.productDetailForm.patchValue({ images: fileArray });


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
      const productId = this.productDetailForm.get('product')?.value.id;
      if (productId) {
        formData.append('productId', productId);
      }
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

      this.productDetailService.createNewProductDetail(formData).subscribe({
        next: (res) => {
          this.isSubmitting = false;
          this.router.navigate(['/admin/product']);
          alert("product created successfully");

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

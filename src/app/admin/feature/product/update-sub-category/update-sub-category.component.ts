import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { ProductService } from '../../../service/product.service';
import { ProductSubCategories } from '../../../../dto/ProductSubCategories';

@Component({
  selector: 'app-update-sub-category',
  templateUrl: './update-sub-category.component.html',
  styleUrl: './update-sub-category.component.scss'
})
export class UpdateSubCategoryComponent {
  isSubmitting: boolean = false;
  subCategoryForm!: FormGroup;
  selectedThumbnail: File | null = null;
  thumbnailError: string | null = null;
  productSubCategory!: ProductSubCategories;
  productSubCategoryId!: number;
  constructor(private fb: FormBuilder, private productService: ProductService, private router: Router, private route: ActivatedRoute) {
    this.subCategoryForm = this.fb.group({
      name: ['', [Validators.required]],
      thumbnail: [null],
      description: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.getProductSubCategory()

  }

  getProductSubCategory() {
    this.route.params.subscribe((param) => {
      this.productSubCategoryId = param['id'];
      this.productService.getProductSubCategoryById(this.productSubCategoryId).subscribe({
        next: (res) => {
          this.productSubCategory = res.result;
          this.initForm();
        },
        error: () => {

        }
      })
    })
  }

  initForm() {
    this.subCategoryForm.patchValue({
      name: this.productSubCategory.name,
      description: this.productSubCategory.description
    })
  }


  onFileChange(event: Event) {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files.length > 0) {
      const file = input.files[0];
      this.subCategoryForm.get('thumbnail')?.setValue(file);
    }
  }

  onSubmit() {
    if (this.subCategoryForm.valid) {
      this.isSubmitting = true;
      const formData = new FormData();
      formData.append('name', this.subCategoryForm.get('name')?.value);
      formData.append('description', this.subCategoryForm.get('description')?.value);
      const thumbnail = this.subCategoryForm.get('thumbnail')?.value;
      if (thumbnail) {
        formData.append('thumbnail', thumbnail);
      }



      for (const [key, value] of (formData as any).entries()) {
        console.log(`${key}:`, value);
      }
      this.productService.updateProductSubCategoryById(formData, this.productSubCategoryId).subscribe({
        next: (res) => {
          this.isSubmitting = false;
          this.router.navigate(['/admin/product']);
          alert("updated successfully");
        }, error: () => {
          this.isSubmitting = false;
          alert("error");
        }
      })
    }
  }
}

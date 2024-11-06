import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ProductService } from '../../../service/product.service';

@Component({
  selector: 'app-create-category',
  templateUrl: './create-category.component.html',
  styleUrl: './create-category.component.scss'
})
export class CreateCategoryComponent {
  isSubmitting = false;
  categoryForm!: FormGroup

  constructor(private fb: FormBuilder, private productService: ProductService, private router: Router) {
    this.categoryForm = this.fb.group({
      name: ['', [Validators.required]],

    });
  }

  onSubmit() {
    if (this.categoryForm.valid) {
      this.isSubmitting= true;
      this.productService.createNewCategory(this.categoryForm.value).subscribe({
        next:()=>{
          this.isSubmitting= false;
          alert("created successfully");
          this.router.navigate(['admin/product']);
        },
        error:(err)=>{
          this.isSubmitting = false;
          alert("can't create, check again")
          console.log(err)
        }
      })
    }

  }

}
import { Component, OnInit } from '@angular/core';
import { DomSanitizer, SafeHtml } from '@angular/platform-browser';
import { BlogService } from '../../../service/blog.service';
import { BlogCategories } from '../../../../dto/BlogCategories';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-blog',
  templateUrl: './create-blog.component.html',
  styleUrl: './create-blog.component.scss'
})
export class CreateBlogComponent implements OnInit {
  blogForm: FormGroup | undefined;
  blogCategories: BlogCategories[] = [];
  selectedThumbnail: File | null = null;
  thumbnailError: string | null = null;
  isSubmitting = false;

  constructor(private blogService: BlogService,  private fb: FormBuilder, private router:Router) {
  }
  ngOnInit(): void {
    this.getAllBlogCategories()
    this.initForm()
  }

  initForm() {
    this.blogForm = this.fb.group({
      title: ['', [Validators.required]],
      subTitle: ['', [Validators.required]],
      category: ['', [Validators.required]],
      description: ['', [Validators.required]]
    });
  }

  getAllBlogCategories() {
    this.blogService.getAllBlogCategories().subscribe({
      next: (res) => {
        this.blogCategories = res.result;
      }
    })
  }

  onFileChange(event: any) {
    const file: File = event.target.files[0];
    if (file) {
      if (file.size > 10 * 1024 * 1024) {
        this.thumbnailError = 'File size must be less than 10 MB';
      } else {
        this.selectedThumbnail = file;
        this.thumbnailError = null;
      }
    }
  }

  onSubmit(){
    if(this.blogForm?.valid && this.selectedThumbnail){
      this.isSubmitting = true; 
      const formData = new FormData();
      formData.append('title', this.blogForm.get('title')?.value);
      formData.append('subTitle', this.blogForm.get('subTitle')?.value);
      formData.append('blogCategoryId', this.blogForm.get('category')?.value);
      formData.append('description', this.blogForm.get('description')?.value);
      formData.append('thumbnail', this.selectedThumbnail);
      formData.append('userId',"1");//test với user id = 1,cần sửa lại
      alert("your blog has been sent, wait for response");
      this.blogService.addNewBlog(formData).subscribe({
       
        next:(res)=>{
          alert("your blog was sent successfully")
          console.log('Blog created successfully', res);
          this.router.navigate(['/admin/blog']);

        },
        error: (err) => {
          console.error('Error creating blog', err);
          this.isSubmitting = false;
        }
      })
    }
  }

}

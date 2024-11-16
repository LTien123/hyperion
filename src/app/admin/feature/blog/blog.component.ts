import { Component, OnInit } from '@angular/core';
import { BlogService } from '../../service/blog.service';
import { Blogs } from '../../../dto/Blog';
import { ToastrService } from 'ngx-toastr';
import { JwtPayloadDto } from '../../../dto/JwtPayloadDto';
import { AuthService } from '../../../auth/service/auth.service';

@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrl: './blog.component.scss'
})
export class BlogComponent implements OnInit {
  userInfo: JwtPayloadDto | undefined;
  currentPage: number = 1;
  pageSize: number = 9;
  allBlogs: Blogs[] | undefined;
  pageAmount: number[] = [];
  totalPages: number | undefined;
  targetPage: number | undefined;
  constructor(private blogService: BlogService, private toastrService: ToastrService, private authService: AuthService) { }

  ngOnInit(): void {
    this.getAllBlogs()
    this.getUserInfo()
  }

  getAllBlogs() {
    this.blogService.getAllBlogs(this.currentPage - 1, this.pageSize).subscribe({
      next: (res) => {
        this.allBlogs = res.result.content;
        this.totalPages = res.result.totalPages;
        this.pageAmount = [];
        this.pageAmount = this.getPageAmount();
        console.log(this.allBlogs);
      }
    })
  }

  getUserInfo() {
    this.userInfo = this.authService.getUserInfo();
    this.userInfo?.scope
  }

  checkScope(roles: string[]): boolean {
    return roles.some(role => this.userInfo?.scope.includes(role))
  }

  deleteBlogById(id: number) {
    this.blogService.deleteBlogById(id).subscribe({
      next: (res) => {
        this.toastrService.success(`deleted successfully`, 'Blog Notification');
        this.getAllBlogs();
      },
      error: () => {
        this.toastrService.success(`can't delete, check again`, 'Blog Notification');
      }
    })
  }

  getPageAmount(): any[] {
    if (this.totalPages)
      for (let i = 1; i <= this.totalPages; i++) {
        this.pageAmount.push(i);
      }
    return this.pageAmount;
  }

  changePage(page: number) {
    this.currentPage = page;
    this.getAllBlogs();

  }

  goToPage() {
    if (this.totalPages)
      if (this.targetPage && this.targetPage >= 1 && this.targetPage <= this.totalPages) {
        this.changePage(this.targetPage);
        this.targetPage == null;
      } else {
        this.toastrService.error(`can't navigate, please enter again`, 'navigate Notification');
      }
  }

  setCarousel(id: number) {
    this.blogService.setCarousel(id).subscribe({
      next: () => {
        console.log('done');
        this.toastrService.success('Carousel set successfully', 'Carousel Notification');
      },
      error: (err) => {
        console.error("Error setting carousel:", err);
        this.toastrService.error(`can't set carousel, please check again`, 'Carousel Notification');
      }
    })
  }



}

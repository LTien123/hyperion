import { Component, OnInit } from '@angular/core';
import { BlogService } from '../../service/blog.service';
import { Blogs } from '../../../dto/Blog';

@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrl: './blog.component.scss'
})
export class BlogComponent implements OnInit {
  currentPage: number = 1;
  pageSize: number = 9;
  allBlogs: Blogs[] | undefined;
  pageAmount: number[] = [];
  totalPages: number | undefined;
  targetPage: number | undefined;
  constructor(private blogService: BlogService) { }

  ngOnInit(): void {
    this.getAllBlogs()
  }

  getAllBlogs() {
    this.blogService.getAllBlogs(this.currentPage -1, this.pageSize).subscribe({
      next: (res) => {
        this.allBlogs = res.result.content;
        this.totalPages = res.result.totalPages;
        this.pageAmount = [];
        this.pageAmount = this.getPageAmount();
        console.log(this.allBlogs);
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
    if(this.totalPages)
    if (this.targetPage && this.targetPage >= 1 && this.targetPage <= this.totalPages) {
      this.changePage(this.targetPage);
      this.targetPage == null;
    } else {
      alert('please enter correctly');
    }
  }



}

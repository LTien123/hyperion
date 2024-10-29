import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { DashboardComponent } from './feature/dashboard/dashboard.component';
import { HeaderComponent } from './shared/header/header.component';
import { SideNavComponent } from './shared/side-nav/side-nav.component';
import { LayoutComponent } from './shared/layout/layout.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BlogComponent } from './feature/blog/blog.component';
import { ProductComponent } from './feature/product/product.component';
import { BillComponent } from './feature/bill/bill.component';
import { CreateBlogComponent } from './feature/blog/create-blog/create-blog.component';
import { EditorModule } from '@tinymce/tinymce-angular';
import { UpdateBlogComponent } from './feature/blog/update-blog/update-blog.component';
import { SignUpComponent } from './feature/sign-up/sign-up.component';
import { UsersComponent } from './feature/users/users.component';



@NgModule({
  declarations: [
    DashboardComponent,
    HeaderComponent,
    SideNavComponent,
    LayoutComponent,
    BlogComponent,
    ProductComponent,
    BillComponent,
    CreateBlogComponent,
    UpdateBlogComponent,
    SignUpComponent,
    UsersComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule,
    EditorModule,
    ReactiveFormsModule
  ],
})
export class AdminModule { }

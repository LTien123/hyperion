import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './feature/dashboard/dashboard.component';
import { LayoutComponent } from './shared/layout/layout.component';
import { BlogComponent } from './feature/blog/blog.component';
import { ProductComponent } from './feature/product/product.component';
import { BillComponent } from './feature/bill/bill.component';
import { NotificationComponent } from './feature/notification/notification.component';

import { CreateBlogComponent } from './feature/blog/create-blog/create-blog.component';
import { SignUpComponent } from './feature/sign-up/sign-up.component';
import { UsersComponent } from './feature/users/users.component';
import { UpdateUserComponent } from './feature/users/update-user/update-user.component';
import { UpdateBlogComponent } from './feature/blog/update-blog/update-blog.component';

const routes: Routes = [{
  path: '', component: LayoutComponent, children: [
    { path: 'dashboard', component: DashboardComponent },
    { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
    { path: 'blog', component: BlogComponent },
    { path: 'blog/create', component: CreateBlogComponent },
    { path: 'blog/update/:id', component: UpdateBlogComponent },
    { path: 'product', component: ProductComponent },
    { path: 'bill', component: BillComponent },
    { path: 'notification', component: NotificationComponent },
    { path: 'sign-up', component: SignUpComponent },
    { path: 'users', component: UsersComponent },
    { path: 'users/update/:id', component: UpdateUserComponent }
  ]
}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }

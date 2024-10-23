import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './feature/dashboard/dashboard.component';
import { LayoutComponent } from './shared/layout/layout.component';
import { BlogComponent } from './feature/blog/blog.component';
import { ProductComponent } from './feature/product/product.component';
import { BillComponent } from './feature/bill/bill.component';
import { NotificationComponent } from './feature/notification/notification.component';
import { ProfileComponent } from './feature/profile/profile.component';
import { CreateBlogComponent } from './feature/blog/create-blog/create-blog.component';

const routes: Routes = [{
  path: '', component: LayoutComponent, children: [
    { path: 'dashboard', component: DashboardComponent },
    { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
    { path: 'blog', component: BlogComponent },
    { path: 'blog/create', component: CreateBlogComponent },
    { path: 'product', component: ProductComponent },
    { path: 'bill', component: BillComponent },
    { path: 'notification', component: NotificationComponent },
    { path: 'profile', component: ProfileComponent }
  ]
}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }

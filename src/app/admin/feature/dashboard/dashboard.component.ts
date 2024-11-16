import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../../auth/service/auth.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent implements OnInit {
constructor(private authService:AuthService){}

  ngOnInit(): void {
    const a =localStorage.getItem('token');
    if(a)
    this.authService.introspect(a).subscribe({
      next:(res)=>{
        console.log(res.result.valid);
        console.log(a)
      }
    })
 
  }
 
 

}

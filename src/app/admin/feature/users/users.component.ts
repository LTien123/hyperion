import { Component, OnInit } from '@angular/core';
import { UsersService } from '../../service/users.service';
import { Router } from '@angular/router';
import { User } from '../../../dto/User';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrl: './users.component.scss'
})
export class UsersComponent implements OnInit {
  Users: User[] = [];
  constructor(private usersService: UsersService, private router: Router) { }

  ngOnInit(): void {
    this.getAllUsers()
  }

  getAllUsers() {
    this.usersService.getAllUser().subscribe({
      next: (res) => {
        this.Users = res.result;
      }
    })
  }

  deleteUser(id:number){
    this.usersService.deleteUserById(id).subscribe({
      next:(res)=>{
        alert("deleted successfully");
        this.getAllUsers()
      },
      error:(error)=>{
        alert("can't delete, please check again");
      }
    })
  }


}

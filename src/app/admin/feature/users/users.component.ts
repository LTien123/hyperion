import { Component, OnInit } from '@angular/core';
import { UsersService } from '../../service/users.service';
import { Router } from '@angular/router';
import { User } from '../../../dto/User';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrl: './users.component.scss'
})
export class UsersComponent implements OnInit {
  Users: User[] = [];
  constructor(private usersService: UsersService, private router: Router, private toastrService: ToastrService) { }

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

  deleteUser(id: number) {
    this.usersService.deleteUserById(id).subscribe({
      next: (res) => {

        this.toastrService.success(`user deleted successfully`, `User Notification`)
        this.getAllUsers()
      },
      error: (error) => {
        this.toastrService.success(`can't delete user, check again`, `User Notification`)
      }
    })
  }


}

import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { LoginService } from '../../service/login.service';
import { AuthService } from '../../service/auth.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;
  constructor(private fb: FormBuilder, private loginService: LoginService, private authService: AuthService, private router: Router, private cdr: ChangeDetectorRef, private toastrService:ToastrService) { }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  onSubmit(): void {
    if (this.loginForm.valid) {
      const formData = this.loginForm.value;
      this.loginService.login(formData).subscribe({
        next: (res) => {
          localStorage.setItem("token", res.result.token);
          this.authService.decodeToken(res.result.token)
          console.log(this.authService.getUserInfo())
          this.router.navigate(['/admin/dashboard'])
        },
        error: () => {
          this.toastrService.error(`wrong username or password`, `Login Notification`)

        }
      }
      )

    }
  }

  loginWithGoogle(): void {
    console.log('Google login clicked');
  }
}
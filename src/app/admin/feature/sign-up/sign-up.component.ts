import { Component, OnInit } from '@angular/core';
import { SignUpService } from '../../../auth/service/sign-up.service';
import { FormGroup, FormBuilder, Validators, FormArray } from '@angular/forms';
import { Role } from '../../../dto/Role';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrl: './sign-up.component.scss'
})
export class SignUpComponent implements OnInit {
  signUpForm!: FormGroup;
  roles: Role[] = [];

  constructor(
    private fb: FormBuilder,
    private signUpService: SignUpService,
    private router: Router
  ) {
    this.signUpForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(6)]],
      rePassword: ['', Validators.required],
      fullName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', Validators.required],
      image: [null],
      roles: this.fb.array([])
    });
  }

  ngOnInit(): void {
    this.getAllRoles();
  }

  onSubmit(): void {
    if (this.signUpForm.valid) {
      const formData = new FormData();
      formData.append('username', this.signUpForm.value.username);
      formData.append('password', this.signUpForm.value.password);
      formData.append('rePassword', this.signUpForm.value.rePassword);
      formData.append('fullName', this.signUpForm.value.fullName);
      formData.append('email', this.signUpForm.value.email);
      formData.append('phone', this.signUpForm.value.phone);
      if (this.signUpForm.value.image) {
        formData.append('image', this.signUpForm.value.image);
      }
      const selectedRoleIds = this.getSelectedRoleId();
      selectedRoleIds.forEach(roleId => {
        formData.append('roleId', roleId.toString());
      });
      //   for (const [key, value] of (formData as any).entries()) {
      //     console.log(`${key}:`, value);
      // }
      this.signUpService.signUp(formData).subscribe({
        next: (res) => {
          alert("created new user successfully")
          this.router.navigate(['/admin']);
        },
        error: (error) => {

          alert("error, please create again")
        }
      })
    }


  }

  onFileSelected(event: Event): void {
    const file = (event.target as HTMLInputElement).files?.[0];
    this.signUpForm.patchValue({ image: file });
  }

  getAllRoles(): void {
    this.signUpService.getAllRoles().subscribe({
      next: (res) => {
        this.roles = res.result;
        this.setRolesFormArray();
      }
    });
  }

  setRolesFormArray(): void {
    this.roles.forEach(() => this.rolesFormArray.push(this.fb.control(false)));
  }

  get rolesFormArray(): FormArray {
    return this.signUpForm.get('roles') as FormArray;
  }

  getSelectedRoleId(): number[] {
    return this.roles.map((role, index) => this.rolesFormArray.at(index).value ? role.id : null)
      .filter(id => id != null);
  }
}

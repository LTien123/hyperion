import { Injectable } from '@angular/core';
import { jwtDecode } from 'jwt-decode';
import { JwtPayloadDto } from '../../dto/JwtPayloadDto';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private userInfo:JwtPayloadDto | undefined;

  decodeToken(token: string) {
    this.userInfo = jwtDecode(token);
  }

  getUserInfo() {
    return this.userInfo;
  }

  clearUserInfo() {
    this.userInfo = undefined;
    localStorage.clear();
  }
}

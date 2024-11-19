import { Injectable } from '@angular/core';
import { jwtDecode } from 'jwt-decode';
import { JwtPayloadDto } from '../../dto/JwtPayloadDto';
import { Observable, Subject, tap } from 'rxjs';
import { ApiResponse } from '../../dto/ApiResponse';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { enviroment } from '../../enviroment/enviroment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private userInfo: JwtPayloadDto | undefined;
  public $refreshToken = new Subject<any>();

  constructor(private http: HttpClient) {
    this.$refreshToken.subscribe((res : any) => {
      this.refreshToken2();
    })
  }
  private url = enviroment.apiUrl;

  decodeToken(token: string) {
    this.userInfo = jwtDecode(token);
    localStorage.setItem('userInfo', JSON.stringify(this.userInfo));

  }

  getUserInfo() {
    if (!this.userInfo) {
      const storedUserInfo = localStorage.getItem('userInfo');
      this.userInfo = storedUserInfo ? JSON.parse(storedUserInfo) : undefined;
    }
    return this.userInfo;
  }

  clearUserInfo() {
    this.userInfo = undefined;
    localStorage.removeItem('userInfo');
    localStorage.clear();
  }

  introspect(token: string): Observable<ApiResponse<any>> {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.post<ApiResponse<any>>(`${this.url}/auth/introspect`, { token }, { headers })
  }

  isTokenExpired() {
    
    if(!this.userInfo) {
      const storedUserInfo = localStorage.getItem('userInfo');
      var Infor = storedUserInfo ? JSON.parse(storedUserInfo) : undefined;

      if (!Infor.exp) {
        console.warn("Token does not have an expiration field.");
        return true;
      }

      const currentTime = Math.floor(Date.now() / 1000);
      console.log("co vao day check khong ? ");

      console.log(Infor.exp > currentTime);
      console.log(Infor.exp);
      console.log(currentTime);
      return Infor.exp > currentTime;
    }
    return true;
  }

  refreshToken(token: string): Observable<ApiResponse<any>> {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.post<ApiResponse<any>>(`${this.url}/auth/refresh`, { token }, { headers });
  }

  refreshToken2() {
    const token = localStorage.getItem("token");
    var refresh = this.http.post<ApiResponse<any>>(`${this.url}/auth/refresh`, { token });
    refresh.subscribe(
      (res: any) => {
        localStorage.setItem("refreshToken", res.result.token);
        console.log("in ra refresh token");
        console.log(res.result.token);
      }
    )
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiResponse } from '../../dto/ApiResponse';
import { enviroment } from '../../enviroment/enviroment';
import { Login } from '../../dto/Login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  constructor(private http: HttpClient) { }
  private url = enviroment.apiUrl;

  login(login:Login):Observable<ApiResponse<any>>{
    return this.http.post<ApiResponse<any>>(`${this.url}/auth/login`, login);
  }
 
}
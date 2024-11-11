import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiResponse } from '../../dto/ApiResponse';
import { Order } from '../../dto/Order';
import { enviroment } from '../../enviroment/enviroment';
import { PagedResult } from '../../dto/PagedResult';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  constructor(private http: HttpClient) { }
  private url = enviroment.apiUrl;

  findAllOrders(page:number, size:number): Observable<ApiResponse<PagedResult<Order[]>>> {
    return this.http.get<ApiResponse<PagedResult<Order[]>>>(`${this.url}/order?page=${page}&size=${size}`);
  }

  confirmOrder(id:number):Observable<any>{
    return this.http.get<any>(`${this.url}/order/confirm/${id}`)
  }

  denyOrder(id:number):Observable<any>{
    return this.http.get<any>(`${this.url}/order/deny/${id}`)
  }
}

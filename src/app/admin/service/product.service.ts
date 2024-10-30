import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiResponse } from '../../dto/ApiResponse';
import { PagedResult } from '../../dto/PagedResult';
import { enviroment } from '../../enviroment/enviroment';
import { FullProduct } from '../../dto/FullProduct';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  constructor(private http: HttpClient) { }
  private url = enviroment.apiUrl;

  getAllProduct(): Observable<ApiResponse<FullProduct[]>> {
    return this.http.get<ApiResponse<FullProduct[]>>(`${this.url}/product-categories/all`);
  }
}

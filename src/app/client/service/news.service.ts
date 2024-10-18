import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PagedResult } from '../../dto/PagedResult';
import { ApiResponse } from '../../dto/ApiResponse';
import { Observable } from 'rxjs';
import { Blogs } from '../../dto/Blog';
import { enviroment } from '../../enviroment/enviroment';

@Injectable({
  providedIn: 'root'
})
export class NewsService {

  constructor(private http: HttpClient) { }
  private url = enviroment.apiUrl;

  getAllNews(page:number, size:number): Observable<ApiResponse<PagedResult<Blogs[]>>> {
    return this.http.get<ApiResponse<PagedResult<Blogs[]>>>(`${this.url}/blog?blogCategoryId=1&page=${page}&size=${size}`);
  }
}

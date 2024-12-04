import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const baseUrl = 'http://localhost:8080/api/';

@Injectable({
  providedIn: 'root'
})

export class CustomerService {

  constructor(private http: HttpClient) {}

  create_Customer(customer: any): Observable<any> {
    return this.http.post(baseUrl+"add_cus", customer);
  }
  get_Customers(): Observable<any> {
    return this.http.get(baseUrl+"allcus");
  }

  getCustomerById(id: number): Observable<any> {
    return this.http.get<any>(`${baseUrl}${id}`);
  }

  updateCustomerLocation(id: number, location: string): Observable<any> {
    return this.http.put<any>(`${baseUrl}update/${id}/${location}`, {});
  }

  deleteCustomerById(id: number): Observable<any> {
    return this.http.delete(`${baseUrl}delete/${id}`);
}

}

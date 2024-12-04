import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const baseUrl = 'http://localhost:8080/api/';

@Injectable({
  providedIn: 'root'
})

export class AdminServiceService {

  constructor(private http: HttpClient) {}

  adminDeleteCustomer(adminId: number, customerId: number): Observable<any> {
    return this.http.delete(`${baseUrl}admin/delete/${adminId}/${customerId}`, { responseType: 'text' });
}

}

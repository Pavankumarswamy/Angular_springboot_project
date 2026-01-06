import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiUrl = 'http://localhost:8082/api/v1';

  constructor(private http: HttpClient) { }

  login(userData: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/login`, userData);
  }

  signup(userData: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/signup`, userData, { responseType: 'text' });
  }

  getAllUsers(): Observable<any> {
    return this.http.get(`${this.apiUrl}/users`);
  }

  updateUser(email: string, user: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/user/${email}`, user, { responseType: 'text' });
  }

  deleteUser(email: string): Observable<any> {
    return this.http.delete(`${this.apiUrl}/user/${email}`, { responseType: 'text' });
  }
}

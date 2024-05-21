import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BaseService {
baseurl = "http://127.0.0.1:8000/api/"

  constructor(private http:HttpClient) { }

  getRentings(rentings:any){
    return this.http.get(this.baseurl+'foglalasok', rentings)
  }
  getRenters(renters:any){
    return this.http.get(this.baseurl+'foglalok', renters)
  }
  getRooms(rooms:any){
    return this.http.get(this.baseurl+"szobak", rooms)
  }
  updateRoom(id: any, data: any): Observable<any> {
    return this.http.put<any>(`${this.baseurl}szobak/${id}`, data);
  }
  
  deleteRoom(id: any): Observable<any> {
    return this.http.delete<any>(this.baseurl + 'deleteszobak/' + id);
  }
}


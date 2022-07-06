import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }

  loginURL:string="http://localhost:5252/auth/";
  
  login(data:any){

    return this.http.post<any>(this.loginURL+"login",data);
  }
  
  register(data:any){
    return this.http.post<any>(this.loginURL+"register",data);
  }
  userinfo='http://localhost:5252/user/get/'
// 5252 for gateway for all links...
  getUser(data:any){
    return this.http.get<any>(this.userinfo+data);
  }
}

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginComponent } from 'src/app/user/login/login.component';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

   
  projId:any;
  constructor(private httpClient:HttpClient,private tokenprovider:LoginComponent) { 
    this.projId=localStorage.getItem("projId");
  }

  url="http://localhost:5252/kanban/v1/project/";
  
  jwtToken=this.tokenprovider.loggedIn();
headersrq=new HttpHeaders().set("Authorization","Bearer "+this.jwtToken)

  public getAllTask(){
     return this.httpClient.get<any>(this.url+this.projId,{headers:this.headersrq})
 }

 public updatetaskStatus(taskId:any,data:any){
   return this.httpClient.put<any>(this.url+this.projId+"/"+taskId,data,{headers:this.headersrq})
 }

 public addTask(data:any)
 {
  return this.httpClient.post<any>(this.url+this.projId,data,{headers:this.headersrq})
 }

 deleteTask(taskId:any){
  return this.httpClient.delete<any>(this.url+this.projId+"/"+taskId,{headers:this.headersrq})
 }

}

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginComponent } from '../user/login/login.component';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  constructor(private httpClient:HttpClient,private tokenprovider:LoginComponent) { }
//5252 is gateway port.
  url="http://localhost:5252/kanban/v1/project/";
  projId=localStorage.getItem("projId");
  
 
jwtToken=this.tokenprovider.loggedIn();
headersrq=new HttpHeaders().set("Authorization","Bearer "+this.jwtToken)


getAllProjects(){
  
  console.log(this.jwtToken);
  
  return this.httpClient.get<any>(this.url,{headers:this.headersrq});
}

 createProject(data:any){
  return this.httpClient.post<any>(this.url,data,{headers:this.headersrq})
 }
deleteProject(projId:any){
  return this.httpClient.delete<any>(this.url+projId,{headers:this.headersrq})
}


}

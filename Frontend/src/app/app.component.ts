import { Component } from '@angular/core';
import { UserService } from './user/user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'KanbanApp';
  constructor(private uservice:UserService){
    this.openProfile();
  }
  //For Open/Close Nav-Drawer
  open:boolean=false
  
  loggedIn=sessionStorage.getItem("loggedIn");
 

  logout(){
    sessionStorage.setItem("loggedIn",'')
    localStorage.setItem("keyyy","")
    window.location.replace('/home')
  }

  user:any;
  userName:any;
  emailId:any;
  openProfile(){
    console.log("Opening Profile");
    
    let email=sessionStorage.getItem('email');
    this.uservice.getUser(email).subscribe(response=>{
      this.user=response
      this.userName=this.user.name
      this.emailId=this.user.email
    })
  }


  

}

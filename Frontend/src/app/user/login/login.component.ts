import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private userserv:UserService,private router:Router,private snakBar:MatSnackBar) { }

  ngOnInit(): void {
  }
  
  loginForm=new FormGroup({
    email:new FormControl('',[Validators.required,Validators.pattern(/\S+@\S+\.\S+/)]),
    password:new FormControl('',[Validators.required,Validators.minLength(5)])
  })

  onSubmit(){
    this.userserv.login(this.loginForm.value).subscribe((response)=>{
      localStorage.setItem("keyyy",response.token)
      sessionStorage.setItem('email',this.email.value);
      sessionStorage.setItem("loggedIn",'true')
      this.snakBar.open("Login Successfull With",this.loginForm.value.email,{
        duration:3000,
        verticalPosition:'bottom'
      });
      this.router.navigateByUrl('/project');
      window.location.replace('/project')
    },
    err=>{
      this.snakBar.open("Email & Password Does Not Match","Login Failed",{
        duration:3000,
        verticalPosition:'top'
      });
    })

  }

  loggedIn(){
     
    return localStorage.getItem('keyyy')
  }


  get email() {
    return this.loginForm.get('email') as FormControl;
    
  }
  
  get password(){
    return this.loginForm.get('password') as FormControl;
  }
  


}

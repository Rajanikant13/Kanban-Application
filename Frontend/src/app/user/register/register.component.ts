import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  
  constructor(private userserv:UserService,private router:Router,private snakBar:MatSnackBar) { }

  ngOnInit(): void {
  }
  
  registerForm=new FormGroup({
    name:new FormControl('',[Validators.required]),
    email:new FormControl('',[Validators.required,Validators.pattern(/\S+@\S+\.\S+/)]),
    password:new FormControl('',[Validators.required,Validators.minLength(5)])
  })

  onSubmit(){ 
    console.log(this.registerForm.value);
    this.userserv.register(this.registerForm.value).subscribe((response)=>{
  
      this.snakBar.open("Register Successfull With",this.registerForm.value.email,{
        duration:3000,
        verticalPosition:'bottom'
      });
      this.router.navigateByUrl('/login');
    })

  }




  get email() {
    return this.registerForm.get('email') as FormControl;
    
  }
  
  get password(){
    return this.registerForm.get('password') as FormControl;
  }


  
}

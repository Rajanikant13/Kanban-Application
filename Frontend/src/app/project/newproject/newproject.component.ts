import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { ProjectService } from '../project.service';

@Component({
  selector: 'app-newproject',
  templateUrl: './newproject.component.html',
  styleUrls: ['./newproject.component.css']
})
export class NewprojectComponent implements OnInit {

  constructor(private pService:ProjectService,
    private route:Router,
    private snakBar:MatSnackBar) { }

  ngOnInit(): void {
  }
  newProjectFrom=new FormGroup({
    //projId:new FormControl("",[Validators.required]),
    projName:new FormControl("",[Validators.required]),
  })
  
   createNewProject(){
    console.log(this.newProjectFrom.value);
    this.pService.createProject(this.newProjectFrom.value).subscribe(resposne=>{
      window.location.reload()
      this.route.navigateByUrl("project")
      this.snakBar.open(""," New Project Created SuccesFully",{
       duration:5000,
       verticalPosition:'top'
     });
    })
  }
}

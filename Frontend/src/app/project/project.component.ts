import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { NewprojectComponent } from './newproject/newproject.component';
import { ProjectService } from './project.service';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent implements OnInit {

  constructor(private pService:ProjectService,
              private route:Router,
              private snakBar:MatSnackBar,
              private dialog: MatDialog) { 
            this.getAllProject();
  }

  ngOnInit(): void {
  }

 

  openDialog() {
    this.dialog.open(NewprojectComponent);
  }

  projectList:any;

 getAllProject(){
   this.pService.getAllProjects().subscribe(response=>{
   this.projectList=response;
   console.log("Getting Project......");
   })

 }

 
 deleteProject(projId:any){
  this.pService.deleteProject(projId).subscribe(response=>{
    console.log(projId+"Deleted Project");
    
  })
   window.location.reload();
}

projectId:any
 openProject(project:any){
  localStorage.setItem("projId",project.projId);
  localStorage.setItem('projName',project.projName)
  console.log( "SELECTED Project :"+project.projId);
  this.route.navigateByUrl("task");
  // window.location.reload();
  window.location.replace('/task')
 }
}
function DialogElementsExampleDialog(DialogElementsExampleDialog: any) {
  throw new Error('Function not implemented.');
}


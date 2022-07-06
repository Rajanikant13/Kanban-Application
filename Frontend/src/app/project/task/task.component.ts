import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { TaskService } from './task.service';
import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import { MatDialog } from '@angular/material/dialog';
import { NewprojectComponent } from '../newproject/newproject.component';
import { AddtaskComponent } from './addtask/addtask.component';
import { EditTaskComponent } from './edit-task/edit-task.component';
@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {
  projectName:any;
  constructor(private bService:TaskService,
              private snakBar:MatSnackBar,
              private dialog: MatDialog) { 
    this.getAllTask();
    this.projectName=localStorage.getItem('projName');
  }

  ngOnInit(): void {
  }


  taskList:any;

  getAllTask(){
    this.bService.getAllTask().subscribe(response=>{
      this.taskList=response;
      console.log("GETTING DATA.......");
      this.arrangeTask();      
    })
  }
reqestedCount=0;
backlogCount=0;
inProcessCount=0;
completedCount=0;

arrangeTask(){
 for (let i = 0; i < this.taskList.length; i++) {

  if (this.taskList[i].taskStatus==='REQUESTED') {
    this.requested.push(this.taskList[i]);
    this.reqestedCount++;
  }
  if (this.taskList[i].taskStatus==='BACKLOG') {
    this.backlog.push(this.taskList[i]);
    this.backlogCount++;
  }
  if (this.taskList[i].taskStatus==='IN_PROCESS') {
    this.todo.push(this.taskList[i]);
    this.inProcessCount++;
  }
  if (this.taskList[i].taskStatus==='COMPLETED') {
    this.done.push(this.taskList[i]);
    this.completedCount++;
  }
 }
}



requested: any[]=[];

backlog: any[]=[];

todo: any[]= [];

done: any[] = [];


drop(event: CdkDragDrop<string[]>) {  
  
  if (event.previousContainer === event.container) {
    moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
  } else {
    console.log(event.container.id);
    let containerName=event.container.id;
    console.log( event.item.element.nativeElement.id);
    let taskId=event.item.element.nativeElement.id;

    if(containerName==='IN_PROCESS' && this.todo.length>=5 ){
      this.snakBar.open("Can't Add More Than 5 Task IN-PROCESS ","Error",{
        duration:5000,
        verticalPosition:'top'
      });
    }
    else if(containerName==='REQUESTED' || containerName==='BACKLOG' || containerName==='COMPLETED' ){

      transferArrayItem(event.previousContainer.data,
                        event.container.data,
                        event.previousIndex,
                        event.currentIndex);
      this.updateTaskStatus(taskId,containerName);
    }
    else{
      transferArrayItem(event.previousContainer.data,
        event.container.data,
        event.previousIndex,
        event.currentIndex);
      this.updateTaskStatus(taskId,containerName);
    }
  }
}

updateTaskStatus(taskId:string,taskStatus:string){
 this.bService.updatetaskStatus(taskId,taskStatus).subscribe(response=>{
      this.taskList=response;
      this.snakBar.open("Status Changed to :",taskStatus,{
        duration:5000,
        verticalPosition:'bottom'
      });
      console.log("Status Changed to :"+taskStatus);
      window.location.reload();
      this.arrangeTask();      
    })
}




deleteTask(task:any){
  console.log(task);
  this.bService.deleteTask(task.taskId).subscribe(response=>{
    this.snakBar.open(task.taskTitle +":","DELETED",{
      duration:5000,
      verticalPosition:'top'
    });
    window.location.reload();
    this.arrangeTask();      
  },err=>{
    this.snakBar.open(task.taskTitle +":","DELETED",{
      duration:5000,
      verticalPosition:'top'
    });
    window.location.reload();
    this.arrangeTask();      
  })
  
}

editTaskFrom =new FormGroup({
  taskId:new FormControl(""),
  taskTitle:new FormControl(""),
  taskDetails:new FormControl(""),
  taskStatus:new FormControl(""),
  taskAssignBy:new FormControl(""),
  taskPriority:new FormControl(""),
  startDate:new FormControl(""),
  endDate:new FormControl("")
})

onsubmit(){
  console.log(this.editTaskFrom.value);
  
}

openDialogAdd() {
  this.dialog.open(AddtaskComponent);
}

openDialogEdit(task:any) {
  sessionStorage.setItem("taskId",task.taskId)
  sessionStorage.setItem("taskTitle",task.taskTitle)
  sessionStorage.setItem("taskDetails",task.taskDetails)
  sessionStorage.setItem("taskAssignBy",task.taskAssignBy)
  sessionStorage.setItem("taskPriority",task.taskPriority)
  sessionStorage.setItem("taskStatus",task.taskStatus)
  sessionStorage.setItem("startDate",task.startDate)
  sessionStorage.setItem("endDate",task.endDate)
  this.dialog.open(EditTaskComponent);
}
}

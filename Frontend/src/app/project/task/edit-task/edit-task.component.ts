import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-edit-task',
  templateUrl: './edit-task.component.html',
  styleUrls: ['./edit-task.component.css']
})
export class EditTaskComponent implements OnInit {

  taskId:any;
  taskTitle: any;
  taskDetails: any;
  taskStatus: any;
  taskAssignBy: any;
  taskPriority: any;
  startDate: any;
  endDate: any;
  
constructor() { 
     this.taskId = sessionStorage.getItem("taskId")
     this.taskTitle = sessionStorage.getItem("taskTitle")
     this.taskDetails = sessionStorage.getItem("taskDetails")
     this.taskStatus = sessionStorage.getItem("taskAssignBy")
     this.taskAssignBy = sessionStorage.getItem("taskPriority")
     this.taskPriority = sessionStorage.getItem("taskStatus",)
     this.startDate = sessionStorage.getItem("startDate")
     this.endDate = sessionStorage.getItem("endDate",)
  
}

  ngOnInit(): void {
  }

  // editTaskFrom =new FormGroup({
  //   taskId:new FormControl(""),
  //   taskTitle:new FormControl(""),
  //   taskDetails:new FormControl(""),
  //   taskStatus:new FormControl(""),
  //   taskAssignBy:new FormControl(""),
  //   taskPriority:new FormControl(""),
  //   startDate:new FormControl(""),
  //   endDate:new FormControl("")
  // })
  
  // onsubmit(){
  //   console.log(this.editTaskFrom.value);
    
  // }
}

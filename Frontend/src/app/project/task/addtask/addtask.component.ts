import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TaskService } from '../task.service';

@Component({
  selector: 'app-addtask',
  templateUrl: './addtask.component.html',
  styleUrls: ['./addtask.component.css']
})
export class AddtaskComponent implements OnInit {

  constructor(private tService:TaskService,private route:Router) { }

  ngOnInit(): void {
  }
 
  newTaskFrom =new FormGroup({
    //taskId:new FormControl("",[Validators.required]),
    taskTitle:new FormControl("",[Validators.required]),
    taskDetails:new FormControl("",[Validators.required]),
    taskStatus:new FormControl("",[Validators.required]),
    taskAssignBy:new FormControl(""),
    taskPriority:new FormControl("",[Validators.required]),
    startDate:new FormControl(""),
    endDate:new FormControl("")
  })

onsubmit(){
  console.log(this.newTaskFrom.value);
  this.tService.addTask(this.newTaskFrom.value).subscribe(response=>{
    console.log("Task Added........");
    this.route.navigateByUrl("/task")
  })
}


}

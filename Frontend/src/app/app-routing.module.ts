import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from './about-us/about-us.component';
import { HomeComponent } from './home/home.component';
import { NewprojectComponent } from './project/newproject/newproject.component';
import { ProjectComponent } from './project/project.component';
import { AddtaskComponent } from './project/task/addtask/addtask.component';
import { EditTaskComponent } from './project/task/edit-task/edit-task.component';
import { TaskComponent } from './project/task/task.component';
import { LoginComponent } from './user/login/login.component';
import { RegisterComponent } from './user/register/register.component';

const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'home',component:HomeComponent},
  {path:'register',component:RegisterComponent},
  {path:'login',component:LoginComponent},
  {path:'project',component:ProjectComponent},
  {path:'newproject',component:NewprojectComponent},
  {path:'task',component:TaskComponent},
  {path:'addtask',component:AddtaskComponent},
  {path:'edittask',component:EditTaskComponent},
  {path:'aboutus',component:AboutUsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { HomeComponent } from './home/home.component';
import { ProjectComponent } from './project/project.component';
import { TaskComponent } from './project/task/task.component';
import { AddtaskComponent } from './project/task/addtask/addtask.component';
import { EditTaskComponent } from './project/task/edit-task/edit-task.component';
import { LoginComponent } from './user/login/login.component';
import { RegisterComponent } from './user/register/register.component';
import { FooterComponent } from './footer/footer.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { NewprojectComponent } from './project/newproject/newproject.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import {MatSidenavModule} from '@angular/material/sidenav';
import {MatIconModule} from '@angular/material/icon';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatListModule } from "@angular/material/list";
import { MatSnackBarModule } from '@angular/material/snack-bar';
import {MatCardModule} from '@angular/material/card';
import {MatDialogModule} from '@angular/material/dialog';
import { DragDropModule } from '@angular/cdk/drag-drop';
import { ProfileComponent } from './user/profile/profile.component';
import {MatMenuModule} from '@angular/material/menu';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ProjectComponent,
    TaskComponent,
    AddtaskComponent,
    LoginComponent,
    RegisterComponent,
    FooterComponent,
    AboutUsComponent,
    NewprojectComponent,
    EditTaskComponent,
    ProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,

    MatSidenavModule,
    MatIconModule,
    MatToolbarModule,
    MatListModule,
    MatSnackBarModule,
    MatCardModule,
    MatDialogModule,
    DragDropModule,
    MatMenuModule
    
    
  ],
  providers: [LoginComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }

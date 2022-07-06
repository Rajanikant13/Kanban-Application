package com.niit.project.controller;

import com.niit.project.model.Project;
import com.niit.project.model.Task;
import com.niit.project.model.TaskStatus;
import com.niit.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin("*")
@RestController
@RequestMapping("/kanban/v1")
public class ProjectController {
    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService){
        this.projectService=projectService;
    }

    @GetMapping("/project")
    public ResponseEntity<?> getAllProjects(){
        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
    }

    @PostMapping("/project")
    public ResponseEntity<?> addProjects(@RequestBody Project project){
        return new ResponseEntity<>(projectService.createProject(project), HttpStatus.OK);
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<?> getAllTask(@PathVariable int projectId){
        return new ResponseEntity<>(projectService.getAllTaskFromProject(projectId),HttpStatus.OK);
    }

    @PostMapping("/project/{projectId}")
    public ResponseEntity<?> addTask(@PathVariable int projectId , @RequestBody Task task){
        return new ResponseEntity<>(projectService.addTask(projectId,task),HttpStatus.OK);
    }

    @DeleteMapping("/project/{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable int projectId){
        return new ResponseEntity<>(projectService.deleteProject(projectId),HttpStatus.OK);
    }

    @PutMapping("/project/{projectId}/{taskId}")
    public ResponseEntity<?> updateTask(@PathVariable int projectId, @PathVariable int taskId, @RequestBody String taskStatus){

        TaskStatus ts1=TaskStatus.valueOf(taskStatus);

        return new ResponseEntity<>(projectService.updateTaskFromProject(projectId,taskId,ts1),HttpStatus.OK);
    }
    @PutMapping("/project/update/{projectId}/{taskId}")
    public ResponseEntity<?> updateWholeTask(@PathVariable int projectId, @PathVariable int taskId, @RequestBody Task task){



        return new ResponseEntity<>(projectService.updatewholeTaskFromProject(projectId,taskId,task),HttpStatus.OK);
    }
    @DeleteMapping("/project/{projectId}/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable int projectId, @PathVariable int taskId){
        return  new ResponseEntity<>(projectService.deleteTask(projectId,taskId),HttpStatus.OK);
    }
}

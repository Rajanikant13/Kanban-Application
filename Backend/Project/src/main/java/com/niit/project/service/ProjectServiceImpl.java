package com.niit.project.service;

import com.niit.project.model.Project;
import com.niit.project.model.Task;
import com.niit.project.model.TaskStatus;
import com.niit.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService{

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository){
        this.projectRepository=projectRepository;
    }


    @Override
    public Project createProject(Project project) {
        project.setProjId(this.idGenrator(10000,1));
        Task defaultTask=new Task();
        //Creating DefaultTask
        defaultTask.setTaskId(1);
        defaultTask.setTaskTitle("Default Task");
        List<Task> tlist=new ArrayList<>();
        tlist.add(defaultTask);
        project.setTaskList(tlist);

        return projectRepository.save(project);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(int projectId) {
       List<Project> projectList=getAllProjects();
        for ( Project project:projectList) {
            if(project.getProjId()==projectId){
                return project;
            }
        }
        return null;
    }

    @Override
    public Task addTask(int projectId, Task task) {
        task.setTaskId(this.idGenrator(100000,10000));
        Project project=getProjectById(projectId);
        project.getTaskList().add(task);

        projectRepository.save(project);

        return task;
    }

    @Override
    public List<Task> getAllTaskFromProject(int projectId) {
        Project project=getProjectById(projectId);
        return project.getTaskList();
    }

    @Override
    public Task getTaskFromProject(int projectId,int taskId) {
      Project project= getProjectById(projectId);

        for (Task task: project.getTaskList()) {
            if (task.getTaskId()==taskId){
                return task;
            }
        }

        return null;
    }

    @Override
    public Task updateTaskFromProject(int projectId, int taskId, TaskStatus taskStatus) {

        Project project=getProjectById(projectId);
        project.getTaskList().removeIf(t->t.getTaskId()==taskId);
        Task task=getTaskFromProject(projectId,taskId);
        task.setTaskStatus(taskStatus);
        projectRepository.save(project);
        return  addTask(projectId,task);
    }

    public Task updatewholeTaskFromProject(int projectId, int taskId, Task task) {

        Project project=getProjectById(projectId);
        project.getTaskList().removeIf(t->t.getTaskId()==taskId);
        Task task2=getTaskFromProject(projectId,taskId);
        task2.setTaskTitle(task.getTaskTitle());
        task2.setTaskAssignBy(task.getTaskAssignBy());
        task2.setTaskDetails(task.getTaskDetails());
        task2.setTaskPriority(task.getTaskPriority());
        task2.setTaskStatus(task.getTaskStatus());
        task2.setStartDate(task.getStartDate());
        task2.setEndDate(task.getEndDate());
        projectRepository.save(project);
        return  addTask(projectId,task);
    }

    @Override
    public String deleteTask(int projectId, int taskId) {

        Project project=getProjectById(projectId);
        project.getTaskList().removeIf(t->t.getTaskId()==taskId);
        projectRepository.save(project);
        return "Task :- "+taskId+" Deleted from Project ID "+projectId;
    }

    @Override
    public String deleteProject(int projectId) {
        projectRepository.deleteById(projectId);
        return "Project With Id "+ projectId +" Is Deleted";
    }


    private int idGenrator(int max,int min){
        int range = max - min + 1;
        int rand = (int)(Math.random() * range) + min;
        return rand;
    }
}

package com.niit.project.service;

import com.niit.project.model.Project;
import com.niit.project.model.Task;
import com.niit.project.model.TaskStatus;

import java.util.List;

public interface ProjectService {

    public Project createProject(Project project);
    public  List<Project> getAllProjects();
    public Project getProjectById(int projectId);

    public Task addTask(int projectId,Task task);
    public List<Task> getAllTaskFromProject(int projectId);
    public Task getTaskFromProject(int projectId,int taskId);
    public Task updateTaskFromProject(int projectId,int taskId, TaskStatus taskStatus);
    public Task updatewholeTaskFromProject(int projectId, int taskId, Task task);

    public String deleteTask(int projectId,int taskId);
    public String deleteProject(int projectId);
}

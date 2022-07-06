package com.niit.project.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Task {
    @Id
    private int taskId;
    private String taskTitle;
    private String taskDetails;
    private String taskAssignBy;
    private TaskStatus taskStatus;
    private TaskPriority taskPriority;
    private Date startDate;
    private Date endDate;
}


package com.niit.project;


import com.niit.project.model.Project;
import com.niit.project.model.Task;
import com.niit.project.repository.ProjectRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class ProjectRepositoryTest { }

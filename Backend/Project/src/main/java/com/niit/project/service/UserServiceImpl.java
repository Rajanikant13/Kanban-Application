package com.niit.project.service;

import com.niit.project.exception.NotFoundException;
import com.niit.project.model.User;
import com.niit.project.rabbitmq.Producer;
import com.niit.project.rabbitmq.UserDTO;
import com.niit.project.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    private UserRepo repo;
    private Producer producer;

    @Autowired
    public UserServiceImpl(UserRepo repo, Producer producer) {
        this.repo = repo;
        this.producer = producer;
    }

    @Override
    public User addUser(User user) {

        UserDTO userDTO=new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        try {
            producer.sendMessageToMq(userDTO);
            System.out.println(userDTO);
        }catch (Exception e){
            e.printStackTrace();
        }
        return repo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return repo.findAll();
    }

    @Override
    public boolean delUser(String name) throws NotFoundException {
        boolean isDeleted=false;
        User found=repo.findByName(name);
        try {
            repo.delete(found);
            isDeleted=true;
        }catch (Exception e){
            isDeleted=false;
        }
        return isDeleted;
    }

    @Override
    public User getUser(String email) {
        return repo.findByEmail(email);
    }
//
//    @Override
//    public UserDTO notifyUser(User user) {
//        UserDTO userDTO=new UserDTO();
//        userDTO.setName("DWaraka");
//        userDTO.setEmail(user.getEmail());
//        System.out.println(">>>"+userDTO);
//        try {
//            producer.sendMessageToMq(userDTO);
//        }catch (Exception e){}
//        return userDTO;
//    }
}

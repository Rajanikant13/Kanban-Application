package com.niit.authentication.service;

import com.niit.authentication.exception.UserNotFoundException;
import com.niit.authentication.model.User;
import com.niit.authentication.proxy.Messageprofile;
import com.niit.authentication.proxy.Userprofile;
import com.niit.authentication.repository.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAuthServiceImpl implements UserAuthService{



    private AuthRepo authRepo;
    private Userprofile userprofile;
    private Messageprofile messageprofile;

    @Autowired
    public UserAuthServiceImpl(AuthRepo authRepo, Userprofile userprofile, Messageprofile messageprofile) {
        this.authRepo = authRepo;
        this.userprofile = userprofile;
        this.messageprofile = messageprofile;
    }

    @Override
    public User addUser(User user) {

        User subject=null;
       try {
           subject = authRepo.save(user);
           messageprofile.sendDetails(user.getEmail(),"Your ID for KanbanAPP is "+Integer.toString(user.getId()));
       }catch (Exception e){
       }

        ResponseEntity<?> response = userprofile.insertUser(subject);
        System.out.println("response Feign >>>"+response.getBody());
        return subject;
    }

    @Override
    public User authenticateUser(String email, String password) throws UserNotFoundException {
        User found = authRepo.findByEmailAndPassword(email,password);
        System.out.println(">>>foundByEP>>>"+found);
        if (found!=null){
            try {
               // messageprofile.sendDetails(found.getEmail(),"Recent activity on ID "+Integer.toString(found.getId()));

            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("Response");
            return found;
        }else {
            throw new UserNotFoundException();
        }


    }

    @Override
    public boolean isEmailUnique(User user) {
        boolean add_anyway=false;
       try {
           User found=authRepo.findByEmail(user.getEmail());
           System.out.println(">>>found>>>"+found);
           if (found==null){
               return true;
           }else {
               return false;
           }
       }catch (Exception e){
           return true;
       }
    }

    @Override
    public List<User> getAllUsers() {
        return authRepo.findAll();
    }
}

package com.example.hw17.Service;

import com.example.hw17.Model.UsersManagement;
import com.example.hw17.Repository.UsersManagementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsersManagementService {
    private final UsersManagementRepository usersManagementRepository;

    public List<UsersManagement> getALlUsers(){
        return usersManagementRepository.findAll();
    }

    public void addUser(UsersManagement user){
        usersManagementRepository.save(user);
    }

    public Boolean updateUser(Integer id, UsersManagement user){
        UsersManagement oldUser= usersManagementRepository.getById(id);

        if(oldUser == null) {
            return false;
        }

        oldUser.setName(user.getName());
        oldUser.setRole(user.getRole());
        oldUser.setEmail(user.getEmail());
        oldUser.setUsername(user.getUsername());
        oldUser.setAge(user.getAge());
        oldUser.setPassword(user.getPassword());
        usersManagementRepository.save(oldUser);
        return true;
    }

    public Boolean deleteUser(Integer id){

        if(usersManagementRepository.getById(id) == null) {
            return false;
        }
        usersManagementRepository.deleteById(id);
        return true;
    }

}
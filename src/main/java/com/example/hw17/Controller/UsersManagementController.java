package com.example.hw17.Controller;

import com.example.hw17.ApiResponse.ApiResponse;
import com.example.hw17.Model.UsersManagement;
import com.example.hw17.Service.UsersManagementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usersManagement/")
@RequiredArgsConstructor
public class UsersManagementController {

    private final UsersManagementService usersManagementService;


    @GetMapping("get")
    public ResponseEntity getALlUsers(){
        return ResponseEntity.status(200).body(usersManagementService.getALlUsers());
    }

    @PostMapping("add")
    public ResponseEntity addUser(@RequestBody @Valid UsersManagement user, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        usersManagementService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User added"));
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id ,@RequestBody @Valid UsersManagement user, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isUpdated = usersManagementService.updateUser(id, user);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("User updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Id not found"));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        boolean isDeleted = usersManagementService.deleteUser(id);
        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("user deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Id not found"));
    }
}

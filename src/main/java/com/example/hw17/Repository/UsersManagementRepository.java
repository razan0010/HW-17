package com.example.hw17.Repository;

import com.example.hw17.Model.UsersManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersManagementRepository extends JpaRepository<UsersManagement,Integer> {
    }

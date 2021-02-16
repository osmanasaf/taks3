package com.example.codefirst.task3.Repository;



import com.example.codefirst.task3.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}

package com.asset.todo.repository;
import com.asset.todo.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByEmailAndPassword(String email,String password);
}

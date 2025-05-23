package com.priyanshuRaj.taskmanager.repository;
import com.priyanshuRaj.taskmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface userRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

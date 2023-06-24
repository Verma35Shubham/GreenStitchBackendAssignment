package com.example.GreenStitch_Backend_Assignment.Repository;

import com.example.GreenStitch_Backend_Assignment.Model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserData, Integer> {
    public Optional<UserData> findByEmail(String email);
}

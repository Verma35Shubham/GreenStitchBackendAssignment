package com.example.GreenStitch_Backend_Assignment.Repository;

import com.example.GreenStitch_Backend_Assignment.Model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserData, Integer> {
    UserData findByEmail(String username);
}

package com.fin.ExpenTrack.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fin.ExpenTrack.entities.Users;

public interface UsersRepo extends JpaRepository<Users, String>{
     
}

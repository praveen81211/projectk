package com.fin.ExpenTrack.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fin.ExpenTrack.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, String>{
     
}

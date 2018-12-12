package com.example.crm.repository;

import com.example.crm.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INoteRepo extends JpaRepository<Note, Integer> {


}

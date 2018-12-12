package com.example.crm.repository;

import com.example.crm.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactRepo extends JpaRepository<Contact, Integer> {


}

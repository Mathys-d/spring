package org.example.spring.dao;

import org.example.spring.modele.Client;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDao extends JpaRepository<Client, Integer>{
    List<Client> findAll();
    Client findById(int id);
    Client save(String firstName, String lastName, LocalDate dateOfBirth, String driving_license);
    Client update(Client client, String firstName, String lastName, LocalDate dateOfBirth);
    Client deleteById(int id);
    }

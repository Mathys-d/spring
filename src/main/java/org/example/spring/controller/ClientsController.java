package org.example.spring.controller;

import org.example.spring.modele.Client;
import org.example.spring.service.ServiceClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientsController {
    @Autowired
    ServiceClients serviceClients;

    @RequestMapping("/")
    public String index() {
        return "Hello World";
    }

    @RequestMapping("/Client")
    public List<Client> getClients() {
        return serviceClients.getClients();
    }

    @RequestMapping("/Client/{id}")
    public Client getClientsById(@PathVariable int id) {
        return serviceClients.getClientsById(id);
    }
}
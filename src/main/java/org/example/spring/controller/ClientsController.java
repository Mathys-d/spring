package org.example.spring.controller;

import org.example.spring.modele.Client;
import org.example.spring.service.ServiceClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ClientsController {
    @Autowired
    ServiceClients serviceClients;

    public ClientsController(ServiceClients serviceClients) {
        this.serviceClients = serviceClients;
    }

    @RequestMapping("/")
    public String index() {
        return "Hello World";
    }

    @RequestMapping("/Client")
    public List<Client> requestClients() {
        return serviceClients.findAll();
    }

    @RequestMapping("/Client/{id}")
    public Client requestClientsById(@PathVariable int id) {
        return serviceClients.findById(id);
    }

    @GetMapping("/Client")
    public List<Client> getClients() {
        return serviceClients.findAll();
    }

    @GetMapping("/Client/{id}")
    public Client getClientsById(@PathVariable int id) {
        return serviceClients.findById(id);
    }

    @PostMapping("/Client")
    public Client addClient(@RequestBody String firstName, String lastName, LocalDate dateOfBirth,String drivingLicense) {
        return serviceClients.save(firstName, lastName, dateOfBirth, drivingLicense);
    }

    @PutMapping("/Client")
    public Client updateClient(@RequestBody Client client,String firstName, String lastName, LocalDate dateOfBirth) {
        return serviceClients.update(client,firstName,lastName,dateOfBirth);
    }

    @DeleteMapping("/Client/{id}")
    public Client deleteClientsById(@PathVariable int id) {
        return serviceClients.deleteById(id);
    }
}
package org.example.spring.controller;

import org.example.spring.modele.Client;
import org.example.spring.service.ServiceClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

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

    @RequestMapping("/Clients")
    public List<Client> requestClients() {
        return serviceClients.findAll();
    }

    @RequestMapping("/Client/{id}")
    public Client requestClientsById(@PathVariable int id) {
        return serviceClients.findById(id);
    }

    @GetMapping("/Clients")
    public List<Client> getClients() {
        return serviceClients.findAll();
    }

    @GetMapping("/Clients/{id}")
    public Client getClientsById(@PathVariable int id) {
        return serviceClients.findById(id);
    }

    @PostMapping("/Clients")
    public Client addClient(@RequestBody Client client) {
        RestTemplate restTemplate = new RestTemplate();

        boolean result = restTemplate.getForObject("http://localhost:8081/licenses/" + client.getDrivingLicense(), boolean.class);
        if (result) {
            return serviceClients.save(client);
        }else {
            return null;
        }
    }

    @PutMapping("/Clients/{id}")
    Client replaceClient(@RequestBody Client newClient, @PathVariable int id) {
        return serviceClients.update(newClient, id);
    }

    @DeleteMapping("/Clients/{id}")
    public Client deleteClientsById(@PathVariable int id) {
        return serviceClients.deleteById(id);
    }
}
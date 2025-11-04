package org.example.spring.controller;

import org.example.spring.ClientRepository;
import org.example.spring.modele.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
public class ClientsController {
    @Autowired
    private ClientRepository clientRepository;

    public ClientsController() {
    }

    @RequestMapping("/")
    public String index() {
        return "Hello World";
    }

    /**
     * @RequestMapping("/Clients") public Iterable<Client> requestClients() {
     * return serviceClients.findAll();
     * }
     **/

    @RequestMapping("/Client/{id}")
    public Optional<Client> requestClientsById(@PathVariable int id) {
        return clientRepository.findById(id);
    }

    @GetMapping("/Clients")
    public Iterable<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/Clients/{id}")
    public Optional<Client> getClientsById(@PathVariable int id) {
        return clientRepository.findById(id);
    }


    @PostMapping("/Clients")
    public Client addClient(
            @RequestBody Client client
    ) throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        boolean result = restTemplate.getForObject("http://localhost:8081/licenses/" + client.getDrivingLicense(), boolean.class);
        if (result) {
            return clientRepository.save(client);
        } else {
            throw new Exception("Driving License is false");
        }
    }

    @PutMapping("/Clients/{id}")
    Client replaceClient(@RequestBody Client newClient, @PathVariable int id) {
        newClient.setId(id);
        return clientRepository.save(newClient);
    }

    @DeleteMapping("/Clients/{id}")
    public void deleteClientsById(@PathVariable int id) {
        clientRepository.deleteById(id);
    }
}
package org.example.spring.service;


import org.example.spring.modele.Client;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ServiceClients {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date dateNaissance = sdf.parse("12/05/1999");
    public ServiceClients() throws ParseException {
    }

    private List<Client> clients = Arrays.asList(new Client(0,"first","last",dateNaissance, "A0B1C2D3E"));

    public List<Client> getClients() {
        return clients;
    }
    public Client getClientsById(int id) {
        for  (Client client : clients) {
            if(client.getId() == id) {
                return client;
            }
        }
        return null;
    }

}

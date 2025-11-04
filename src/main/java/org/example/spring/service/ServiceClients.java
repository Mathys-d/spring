package org.example.spring.service;


import org.example.spring.dao.ClientDao;
import org.example.spring.modele.Client;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceClients implements ClientDao {


    public ServiceClients() throws ParseException {
    }

    public static List<Client> clients = new ArrayList<>();

    @Override
    public List<Client> findAll() {
        return clients;
    }

    @Override
    public Client findById(int id) {
        for  (Client client : clients) {
            if(client.getId() == id) {
                return client;
            }
        }
        return null;
    }

    @Override
    public Client save(Client client) {
        int lastId = clients.get(clients.size() - 1).getId();
        int nextId = lastId + 1;
        client.setId(nextId);
        clients.add(client);
        return client;
    }

    //recuperer le client pour l'update et
    @Override
    public Client update(Client client,int id) {
        for  (Client clientt : clients) {
            if(clientt.getId() == id) {
                clientt.setFirstName(client.getFirstName());
                clientt.setLastName(client.getLastName());
                clientt.setBirth(client.getBirth());
                clientt.setDrivingLicense(client.getDrivingLicense());
            }
        }
        return client;
    }

    @Override
    public Client deleteById(int id){
         clients.remove(findById(id));
         if(findById(id) == null){
             return null;
         }
         System.out.println("didnt find the client at id: " + id);
        return null;
    }
}

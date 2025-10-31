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

    static {


        clients.add(new Client(0,"first","last", LocalDate.of(1999,5,12), "A0B1C2D3E"));

        clients.add(new Client(1,"first","last",LocalDate.of(2000,01,10), "A0B1C2D3E"));

        clients.add(new Client(2,"first","last",LocalDate.of(2012,1,20), "A0B1C2D3E"));

    }

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
    public Client save(String firstName, String lastName, LocalDate dateOfBirth, String drivingLicense) {
        int lastId = clients.get(clients.size() - 1).getId();
        int nextId = lastId + 1;
        clients.add(new Client (nextId,firstName,lastName,dateOfBirth,drivingLicense));
        return  clients.get(nextId);
    }

    @Override
    public Client update(Client client,String firstName, String lastName, LocalDate dateOfBirth) {
        if (!client.getFirstName().equals(firstName)) {
            client.setFirstName(firstName);
        }
        if (!client.getLastName().equals(lastName)){
            client.setLastName(lastName);
        }
        if (!client.getBirth().equals(dateOfBirth.toString())){
            client.setBirth(dateOfBirth);
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

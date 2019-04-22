package com.example.demo.service;

import com.example.demo.domain.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();

    Client getClientById(Long id);

    Client addClient(Client client);

    Client modifyClient(Client client);

    void deleteClient(Long id);

    void deleteAllClients();
}

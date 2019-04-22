package com.example.demo.service.impl;

import com.example.demo.domain.Client;
import com.example.demo.domain.ClientRepository;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository cr;

    @Override
    public List<Client> getAllClients() {
        return cr.findAll();
    }

    @Override
    public Client getClientById(Long id) {
        return cr.findById(id).orElse(new Client());
    }

    @Override
    public Client addClient(Client client) {
        return cr.save(client);
    }

    @Override
    public Client modifyClient(Client client) {
        return cr.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        cr.deleteById(id);
    }

    @Override
    public void deleteAllClients() {
        cr.deleteAll();
    }
}

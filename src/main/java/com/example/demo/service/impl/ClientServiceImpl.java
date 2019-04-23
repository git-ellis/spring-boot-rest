package com.example.demo.service.impl;

import com.example.demo.domain.Client;
import com.example.demo.domain.ClientRepository;
import com.example.demo.execption.ClientNotFoundException;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Client> client = cr.findById(id);
        if (!client.isPresent())
            throw new ClientNotFoundException("查無該用戶");

        return client.get();
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

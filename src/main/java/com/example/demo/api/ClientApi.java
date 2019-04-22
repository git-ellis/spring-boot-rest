package com.example.demo.api;

import com.example.demo.domain.Client;
import com.example.demo.dto.ClientDTO;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClientApi {
    @Autowired
    private ClientService cs;

    @GetMapping("/client/{id}")
    public ResponseEntity<?> getClient(@PathVariable long id) {
        Client client = cs.getClientById(id);
        return new ResponseEntity<Object>(client, HttpStatus.OK);
    }


    @GetMapping("/client")
    public ResponseEntity<?> getAllClients() {
        List<Client> clients = cs.getAllClients();
        return new ResponseEntity<Object>(clients, HttpStatus.OK);
    }

    @PostMapping("/client")
    public ResponseEntity<?> addClient(@RequestBody Client client) {
        Client addedClient = cs.addClient(client);
        return new ResponseEntity<Object>(addedClient, HttpStatus.CREATED);
    }

    @PutMapping("/client/{id}")
    public ResponseEntity<?> modifyClient(@PathVariable long id, @RequestBody ClientDTO dto) {
        Client target = cs.getClientById(id);
        dto.copyPropsTo(target);
        Client modifiedClient = cs.modifyClient(target);

        return new ResponseEntity<Object>(modifiedClient, HttpStatus.OK);
    }

    @DeleteMapping("/client/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable long id) {
        cs.deleteClient(id);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/client")
    public ResponseEntity<?> deleteAllClients() {
        cs.deleteAllClients();
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }
}

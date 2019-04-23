package com.example.demo.api;

import com.example.demo.domain.Client;
import com.example.demo.dto.ClientDTO;
import com.example.demo.execption.ClientNotFoundException;
import com.example.demo.execption.InvalidRequestException;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1")
public class ClientApi {
    @Autowired
    private ClientService cs;

    @GetMapping("/client/{id}")
    public ResponseEntity<?> getClient(@PathVariable long id) {
        return new ResponseEntity<Object>(cs.getClientById(id), HttpStatus.OK);
    }


    @GetMapping("/client")
    public ResponseEntity<?> getAllClients() {
        List<Client> clients = cs.getAllClients();
        if (clients.size() == 0)
            throw new ClientNotFoundException("查無用戶");

        return new ResponseEntity<Object>(clients, HttpStatus.OK);
    }

    @PostMapping("/client")
    public ResponseEntity<?> addClient(@Valid @RequestBody ClientDTO dto, BindingResult br) {
        if (br.hasErrors())
            throw new InvalidRequestException("請求數據不合法", br);

        Client client = dto.convert();
        Client addedClient = cs.addClient(client);
        return new ResponseEntity<Object>(addedClient, HttpStatus.CREATED);
    }

    @PutMapping("/client/{id}")
    public ResponseEntity<?> modifyClient(@PathVariable long id, @Valid @RequestBody ClientDTO dto, BindingResult br) {
        if (br.hasErrors())
            throw new InvalidRequestException("請求數據不合法", br);

        Client client = cs.getClientById(id);
        dto.copyPropsTo(client);
        Client modifiedClient = cs.modifyClient(client);

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

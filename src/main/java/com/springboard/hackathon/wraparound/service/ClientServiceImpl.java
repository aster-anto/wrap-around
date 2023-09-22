package com.springboard.hackathon.wraparound.service;

import javax.inject.Singleton;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboard.hackathon.wraparound.beans.ClientBean;
import com.springboard.hackathon.wraparound.repo.ClientRepository;

@Singleton
public class ClientServiceImpl {

    @Autowired
    private ClientRepository clientRepository;

    public ClientBean findUserByLastName(String lastName) {
        clientRepository.findByLastName(lastName);
        throw new UnsupportedOperationException("Unimplemented method 'findUserByLastName'");
    }

    public void saveUser(ClientBean client) {
        clientRepository.saveClient(client);
        throw new UnsupportedOperationException("Unimplemented method 'saveUser'");
    }

}

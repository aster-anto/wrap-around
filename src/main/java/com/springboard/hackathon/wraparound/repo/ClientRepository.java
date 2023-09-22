package com.springboard.hackathon.wraparound.repo;

import com.springboard.hackathon.wraparound.entity.Client;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

import java.util.List;

@EnableScan
public interface ClientRepository {

    List<Client> findByLastName(String lastname);
}

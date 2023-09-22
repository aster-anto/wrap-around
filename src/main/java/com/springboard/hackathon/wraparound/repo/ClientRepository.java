package com.springboard.hackathon.wraparound.repo;

import com.springboard.hackathon.wraparound.beans.ClientBean;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableScan
@Repository("clientRepository")
public interface ClientRepository {

    List<ClientBean> findByLastName(String lastname);

    void saveClient(ClientBean client);
}

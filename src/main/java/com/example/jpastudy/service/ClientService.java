/*
 * Created by Sungkuk Ahn on 2022/01/20
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Dev Backend Team <sungkuk_ahn@bigin.io>, 2022/01/20
 */
package com.example.jpastudy.service;

import com.example.jpastudy.dto.ClientForm;
import com.example.jpastudy.domain.Client;
import com.example.jpastudy.dto.ClientResponse;
import com.example.jpastudy.repository.ClientRepository;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * create on 2022/01/20. create by IntelliJ IDEA.
 *
 * <p> 클래스 설명 </p>
 * <p> {@link } and {@link }관련 클래스 </p>
 *
 * @author Sungkuk Ahn
 * @version 1.0
 * @see
 * @since 지원하는 자바버전 (ex : 5+ 5이상)
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientService {
  private final ClientRepository clientRepository;

  @Transactional
  public void save(ClientForm form) {
    Client client = Client.create(form.getName(), form.getEmail(), form.getPhoneNumber());
    clientRepository.save(client);
  }

  public List<ClientResponse> findAll() {
    List<Client> clients = clientRepository.findAll();
    ModelMapper mapper = new ModelMapper();
    List<ClientResponse> clientResponses = clients.stream()
        .map( c -> mapper.map(c, ClientResponse.class)).toList();
    return clientResponses;
  }

  public Client findById(Long id) {
    return clientRepository.findById(id);
  }

  public void update(ClientForm form) {
    //Client client = Client.create(form.getName(), form.getEmail(), form.getPhoneNumber());
    //client.setId(form.getId());
    //clientRepository.save(client);

    Client client1 = clientRepository.findById(form.getId());
    client1.setId(form.getId());
  }
}

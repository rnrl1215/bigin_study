/*
 * Created by Sungkuk Ahn on 2022/01/20
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Dev Backend Team <sungkuk_ahn@bigin.io>, 2022/01/20
 */
package com.example.jpastudy.dto;

import com.example.jpastudy.domain.Client;
import com.example.jpastudy.service.ClientService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

@RestController
@Slf4j
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientApi {
  private final ClientService clientService;

  /**
   * Api for saving client
   * @param form
   * @return
   */
  @PostMapping("")
  public ResponseEntity save(@RequestBody ClientForm form) {
    log.info("form : {}", form);
    clientService.save(form);
    return ResponseEntity.status(HttpStatus.CREATED).body("sucess to save client data");
  }

  @GetMapping("/all")
  public ResponseEntity getAll() {
    List<ClientResponse> clients = clientService.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(clients);
  }

  @GetMapping("/{clientId}")
  public ResponseEntity getFindById(@PathVariable Long clientId) {
    Client client = clientService.findById(clientId);
    return ResponseEntity.status(HttpStatus.OK).body(client);
  }
  
  @PutMapping("")
  public ResponseEntity update(@RequestBody ClientForm form) {
    log.info("form : {}", form);
    clientService.update(form);
    return ResponseEntity.status(HttpStatus.ACCEPTED).body("success to update");
  }
}

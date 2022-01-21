/*
 * Created by Seokgyu Hwang on 2022/01/04
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Dev Backend Team <sghwang@bigin.io>, 2022/01/04
 */

package com.example.jpastudy.repository;

import com.example.jpastudy.domain.Client;
import java.util.List;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * create on 2022/01/04. create by IntelliJ IDEA.
 *
 * <p> 클래스 설명 </p>
 * <p> {@link } and {@link } 관련 클래스 </p>
 *
 * @author sghwang
 * @version 1.0
 * @see
 * @since 1.0
 */
@Repository
@RequiredArgsConstructor
@Transactional
public class ClientRepository {

  private final EntityManager em;

  public void save(Client client) {
    if (client.getId() == null) {
      em.persist(client);
    } else {
      em.merge(client);
    }
  }

  public Client findById(Long id) {
    return em.find(Client.class, id);
  }

  public List<Client> findAll() { return em.createQuery("select c from Client c", Client.class).getResultList(); }
}

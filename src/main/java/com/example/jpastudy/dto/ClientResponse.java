/*
 * Created by Seokgyu Hwang on 2022/01/04
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Dev Backend Team <sghwang@bigin.io>, 2022/01/04
 */

package com.example.jpastudy.dto;

import com.example.jpastudy.domain.Balance;
import com.example.jpastudy.domain.Card;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

@Getter
@NoArgsConstructor
public class ClientResponse {

  private Long id;

  private String name;
  private String email;
  private String phoneNumber;

  private List<Card> cards;
  private Balance balance;

  private ClientResponse(String name, String email, String phoneNumber) {
    this.name = name;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  public static ClientResponse create(String name, String email, String phoneNumber) {
    return new ClientResponse(name, email, phoneNumber);
  }
}

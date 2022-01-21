package com.example.jpastudy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "card")
public class Card {

  @Id
  @Column(name = "id", nullable = false)
  private Long id;

  private String name;
  private String alias;
  private String iamportId;

  @ManyToOne
  private Client client;

  public Card(String name, String alias, String iamportId) {
    this.name = name;
    this.alias = alias;
    this.iamportId = iamportId;
  }

}
/*
 * Created by Seokgyu Hwang on 2022/01/04
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Dev Backend Team <sghwang@bigin.io>, 2022/01/04
 */

package com.example.jpastudy.domain;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Balance {

  @Id
  @Column(name = "id", nullable = false)
  private Long id;

  private BigDecimal credit;
  private BigDecimal marketingCredit;

  @OneToOne(mappedBy = "balance")
  private Client client;

  public Balance(BigDecimal credit, BigDecimal marketingCredit) {
    this.credit = credit;
    this.marketingCredit = marketingCredit;
  }
}

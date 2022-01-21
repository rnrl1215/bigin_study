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

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

@Getter
@ToString
@NoArgsConstructor
public class ClientForm {
  private Long id;

  @NotBlank(message = "name field i=s empty")
  private String name;

  @NotBlank(message = "email field is empty")
  @Email
  private String email;

  @NotBlank(message = "phonenumber field is empty")
  private String phoneNumber;
}

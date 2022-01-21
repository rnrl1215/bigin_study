package com.example.jpastudy.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.jpastudy.domain.Client;
import com.example.jpastudy.test.RepositoryTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
@SpringBootTest
class ClientRepositoryTest extends RepositoryTest {

  @Autowired
  private ClientRepository repository;

  @Test
  void Giver_Client_when_Persist_Then_Success() throws Exception {
    // given
    String name = "skahn";
    String email = "skahn_ahn@bigin.io";
    String phoneNumber = "123";
    Client client = Client.create(name, email, phoneNumber);

    // when
    repository.save(client);
    Client foundClient = repository.findById(client.getId());

    // then
    assertThat(foundClient).isNotNull();
    assertThat(foundClient.getName()).isEqualTo(name);
  }
}
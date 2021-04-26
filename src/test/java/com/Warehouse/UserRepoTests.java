package com.Warehouse;

import static org.assertj.core.api.Assertions.assertThat;

import com.Warehouse.model.User;
import com.Warehouse.repositories.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepoTests {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setEmail("asap1@gmail.com");
        user.setPassword("asappunya1");
        user.setFirstName("asap1");
        user.setLastName("korni1");
        user.setAlamat("yogyakarta1");

        User savedUser = userRepo.save(user);

        User existUser = testEntityManager.find(User.class, savedUser.getId());

        assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    public void testFindUserByEmail(){
        String email = "asap@gmail.com";

        User user = userRepo.findByEmail(email);

        assertThat(user).isNotNull();
    }

}

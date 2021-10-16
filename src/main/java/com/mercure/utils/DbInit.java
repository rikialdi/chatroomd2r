package com.mercure.utils;

import com.mercure.entity.UserEntity;
import com.mercure.repository.UserRepository;
import com.mercure.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Class used to fill the database on startup if no data detected
 */
@Service
public class DbInit implements CommandLineRunner {

    static Logger log = LoggerFactory.getLogger(DbInit.class);

    private UserService userService;

    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository repoUser;

    public DbInit(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    private String[] users = new String[]{
            "riki:riki@gmail.com",
            "rahmat:rahmat@gmail.com",
            "dodi:dodi@gmail.com"
    };

    @Override
    public void run(String... args) {

        for (String mail: users) {
            String[] str = mail.split(":");
            String name = str[0];
            String email = str[1];

            UserEntity oldRole = repoUser.findOneByMail(email);
            if (null == oldRole) {
                UserEntity user = new UserEntity();
                user.setFirstName(name);
                user.setLastName("Doe" + name.toLowerCase());
                user.setPassword(passwordEncoder.encode("root"));
                user.setMail(email);
                user.setEnabled(true);
                user.setCredentialsNonExpired(true);
                user.setAccountNonLocked(true);
                user.setAccountNonExpired(true);
                user.setWsToken(UUID.randomUUID().toString());
                user.setRole(1L);
                userService.save(user);
            }


        }
////        if (userService.findAll().size() == 0) {
//            List<String> sourceList = Arrays.asList("Thibaut", "Mark", "John", "Luke", "Steve");
//
//            sourceList.forEach(val -> {
//                UserEntity user = new UserEntity();
//                user.setFirstName(val);
//                user.setLastName("Doe" + val.toLowerCase());
//                user.setPassword(passwordEncoder.encode("root"));
//                user.setMail(val.toLowerCase() + "@fastlitemessage.com");
//                user.setEnabled(true);
//                user.setCredentialsNonExpired(true);
//                user.setAccountNonLocked(true);
//                user.setAccountNonExpired(true);
//                user.setWsToken(UUID.randomUUID().toString());
//                user.setRole(1);
//                userService.save(user);
//            });
//            log.info("No entries detected in User table, data created");
////        } else {
////            log.info("Data already set in User table, skipping init step");
////        }
    }
}

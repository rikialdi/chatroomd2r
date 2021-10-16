package com.mercure.repository;

import com.mercure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long > {

    UserEntity getUserByFirstNameOrMail(String firstName, String mail);

    @Query(value = "SELECT u.firstname, u.lastname FROM userws u WHERE u.id = :userId", nativeQuery = true)
    String getUsernameByUserId(@Param(value = "userId") Long id);

    @Query(value = "SELECT u.firstname FROM userws u WHERE u.id = :userId", nativeQuery = true)
    String getFirstNameByUserId(@Param(value = "userId") Long id);

    @Query(value = "SELECT u.firstname FROM userws u WHERE u.wstoken = :token", nativeQuery = true)
    String getUsernameWithWsToken(@Param(value = "token") String token);

    @Query(value = "SELECT u.id FROM userws u WHERE u.wstoken = :token", nativeQuery = true)
    Long getUserIdWithWsToken(@Param(value = "token") String token);

    @Query(value = "SELECT * FROM userws u WHERE u.id NOT IN :ids", nativeQuery = true)
    List<UserEntity> getAllUsersNotAlreadyInConversation(@Param(value = "ids") int[] ids);

    Long countAllByFirstNameOrMail(String firstName, String mail);

    Long countAllByShortUrl(String shortUrl);

    @Query("FROM UserEntity u WHERE LOWER(u.mail) = LOWER(?1)")
    UserEntity findOneByMail(String mail);
}

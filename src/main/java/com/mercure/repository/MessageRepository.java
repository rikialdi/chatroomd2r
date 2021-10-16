package com.mercure.repository;

import com.mercure.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long > {

    @Query(value = "SELECT * FROM (SELECT * FROM message m WHERE m.msg_group_id=:id and ((:offset > 0 and m.id < :offset) or (:offset <= 0)) ORDER BY m.id DESC LIMIT 20)t order by id", nativeQuery = true)
    List<MessageEntity> findByGroupIdAndOffset(@Param(value = "id") Long id, @Param(value = "offset") Long offset);

//    @Query(value = "SELECT * FROM (SELECT * FROM message m WHERE m.msg_group_id=:id ORDER BY m.id DESC LIMIT 20)t ORDER BY id", nativeQuery = true)
//    List<MessageEntity> findAllByGroupId(@Param(value = "id") Long id, @Param(value = "offset") Long offset);

    @Query(value = "SELECT * FROM message m1 INNER JOIN (SELECT MAX(m.id) as id FROM message m GROUP BY m.msg_group_id) temp ON temp.id = m1.id WHERE msg_group_id = :idOfGroup", nativeQuery = true)
    MessageEntity findLastMessageByGroupId(@Param(value = "idOfGroup") Long groupId);

    @Query(value = "SELECT m1.id FROM message m1 INNER JOIN (SELECT MAX(m.id) as id FROM message m GROUP BY m.msg_group_id) temp ON temp.id = m1.id WHERE msg_group_id = :idOfGroup", nativeQuery = true)
    Long findLastMessageIdByGroupId(@Param(value = "idOfGroup") Long groupId);
}

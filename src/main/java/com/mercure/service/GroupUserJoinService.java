package com.mercure.service;

import com.mercure.entity.GroupRoleKey;
import com.mercure.entity.GroupUser;
import com.mercure.repository.GroupUserJoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupUserJoinService {

    @Autowired
    private GroupUserJoinRepository groupUserJoinRepository;

    public GroupUser save(GroupUser groupUser) {
        return groupUserJoinRepository.save(groupUser);
    }

    public Optional<GroupUser> findById(GroupRoleKey id) {
        return groupUserJoinRepository.findById(id);
    }

    public List<GroupUser> findAll() {
        return groupUserJoinRepository.findAll();
    }

    public List<GroupUser> findAllByGroupId(Long groupId) {
        return groupUserJoinRepository.getAllByGroupId(groupId);
    }

    public boolean checkIfUserIsAuthorizedInGroup(Long userId, Long groupId) {
        List<Long > ids = groupUserJoinRepository.getUsersIdInGroup(groupId);
        return ids.stream().noneMatch(id -> id == userId);
    }


    public GroupUser grantUserAdminInConversation(Long userId, Long groupId) {
        return executeActionOnGroupUser(userId, groupId, 1L);
    }

    public void removeUserAdminFromConversation(Long userIdToDelete, Long groupId) {
        executeActionOnGroupUser(userIdToDelete, groupId, 0L);
    }

    private GroupUser executeActionOnGroupUser(Long userId, Long groupId, Long role) {
        GroupRoleKey groupRoleKey = new GroupRoleKey(groupId, userId);
        Optional<GroupUser> optionalGroupUserToDelete = groupUserJoinRepository.findById(groupRoleKey);
        if (optionalGroupUserToDelete.isPresent()) {
            GroupUser groupUser = optionalGroupUserToDelete.get();
            groupUser.setRole(role);
            return groupUserJoinRepository.save(groupUser);
        }
        return null;
    }

    public void removeUserFromConversation(Long userIdToDelete, Long groupId) {
        GroupRoleKey groupRoleKey = new GroupRoleKey(groupId, userIdToDelete);
        Optional<GroupUser> optionalGroupUserToDelete = groupUserJoinRepository.findById(groupRoleKey);
        optionalGroupUserToDelete.ifPresent(groupUser -> groupUserJoinRepository.delete(groupUser));
    }
}

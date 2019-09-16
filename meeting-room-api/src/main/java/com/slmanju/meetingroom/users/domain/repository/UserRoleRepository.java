package com.slmanju.meetingroom.users.domain.repository;

import com.slmanju.meetingroom.users.domain.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserRoleRepository extends JpaRepository<UserRole, String> {

    Set<UserRole> findByUserId(String userId);

    void deleteByUserId(String userId);

}

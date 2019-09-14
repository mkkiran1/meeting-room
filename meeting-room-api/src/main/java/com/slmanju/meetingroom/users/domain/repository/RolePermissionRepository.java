package com.slmanju.meetingroom.users.domain.repository;

import com.slmanju.meetingroom.users.domain.model.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface RolePermissionRepository extends JpaRepository<RolePermission, String> {

    Set<RolePermission> findByRoleId(String roleId);

    void deleteByRoleId(String roleId);

}

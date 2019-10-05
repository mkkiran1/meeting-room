package com.slmanju.meetingroom.core.users.domain.repository;

import com.slmanju.meetingroom.core.users.domain.model.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface RolePermissionRepository extends JpaRepository<RolePermission, String> {

    Set<RolePermission> findByRoleId(String roleId);

    void deleteByRoleId(String roleId);

}

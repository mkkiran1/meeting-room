package com.slmanju.meetingroom.users.domain.repository;

import com.slmanju.meetingroom.users.domain.model.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolePermissionRepository extends JpaRepository<RolePermission, String> {

}

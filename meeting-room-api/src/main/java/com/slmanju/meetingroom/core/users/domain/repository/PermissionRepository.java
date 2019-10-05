package com.slmanju.meetingroom.core.users.domain.repository;

import com.slmanju.meetingroom.core.users.domain.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionRepository extends JpaRepository<Permission, String> {

    List<Permission> findByIdIn(List<String> ids);

}

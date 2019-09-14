package com.slmanju.meetingroom.users.domain.repository;

import com.slmanju.meetingroom.users.domain.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionRepository extends JpaRepository<Permission, String> {

    List<Permission> findByIdIn(List<String> ids);

}

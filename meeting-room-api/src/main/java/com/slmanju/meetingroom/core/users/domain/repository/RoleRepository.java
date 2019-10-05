package com.slmanju.meetingroom.core.users.domain.repository;

import com.slmanju.meetingroom.core.users.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, String> {

    List<Role> findByIdIn(List<String> ids);

}

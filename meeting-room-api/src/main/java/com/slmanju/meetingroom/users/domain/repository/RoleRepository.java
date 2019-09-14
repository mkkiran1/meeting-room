package com.slmanju.meetingroom.users.domain.repository;

import com.slmanju.meetingroom.users.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {

}

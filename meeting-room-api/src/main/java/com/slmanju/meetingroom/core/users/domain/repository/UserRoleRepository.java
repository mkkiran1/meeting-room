package com.slmanju.meetingroom.core.users.domain.repository;

import com.slmanju.meetingroom.core.users.domain.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface UserRoleRepository extends JpaRepository<UserRole, String> {

    Set<UserRole> findByUserId(String userId);

    void deleteByUserId(String userId);

}

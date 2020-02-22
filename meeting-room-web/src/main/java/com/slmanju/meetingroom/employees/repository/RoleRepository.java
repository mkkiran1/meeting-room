package com.slmanju.meetingroom.employees.repository;

import com.slmanju.meetingroom.employees.repository.entity.Role;
import com.slmanju.meetingroom.employees.service.transfer.dto.RoleSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

  @Query("SELECT role FROM Role role")
  Page<Role> search(@Param("searchRequest") RoleSearchRequest searchRequest, Pageable pageable);

}

package com.slmanju.meetingroom.core.users.domain.repository;

import com.slmanju.meetingroom.core.users.domain.model.User;
import com.slmanju.meetingroom.core.users.service.dto.UserSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT user FROM User user WHERE user.firstName LIKE %:#{#searchRequest.firstName}%")
    Page<User> search(@Param("searchRequest") UserSearchRequest searchRequest, Pageable pageable);

}

package com.slmanju.meetingroom.employees.service.transfer.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Data
public class EmployeeDto {

  private Long id;
  private String firstName;
  private String lastName;
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate dateOfBirth;
  private String username;
  private String password;
  private Long roleId;
}

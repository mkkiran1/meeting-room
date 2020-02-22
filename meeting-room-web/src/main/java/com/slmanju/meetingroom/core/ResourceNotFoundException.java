package com.slmanju.meetingroom.core;

import java.util.function.Supplier;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public class ResourceNotFoundException extends RuntimeException {

  private Integer resourceId;

  public ResourceNotFoundException(Integer resourceId, String message) {
    super(message);
    this.resourceId = resourceId;
  }

  public ResourceNotFoundException(String message) {
    super(message);
  }

  public static ResourceNotFoundException newInstance(String message) {
    return new ResourceNotFoundException(message);
  }

  public static ResourceNotFoundException newInstance(Integer resourceId, String message) {
    return new ResourceNotFoundException(resourceId, message);
  }

  public static Supplier<ResourceNotFoundException> of(String message) {
    return () -> new ResourceNotFoundException(message);
  }

}

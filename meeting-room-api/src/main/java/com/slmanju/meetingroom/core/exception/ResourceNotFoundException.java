package com.slmanju.meetingroom.core.exception;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public class ResourceNotFoundException extends RuntimeException {

    private String resourceId;

    public ResourceNotFoundException(String resourceId, String message) {
        super(message);
        this.resourceId = resourceId;
    }

}

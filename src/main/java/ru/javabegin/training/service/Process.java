package ru.javabegin.training.service;
import org.springframework.security.access.annotation.Secured;
public interface Process {
    @Secured("ROLE_ADMIN")
    String getMessage();
}

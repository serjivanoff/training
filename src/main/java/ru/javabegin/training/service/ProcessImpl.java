package ru.javabegin.training.service;

import org.springframework.stereotype.Service;

@Service
public class ProcessImpl implements Process {
    @Override
    public String getMessage() {
        return "Кесарю-кесарево, слесарю-слесарево!";
    }
}

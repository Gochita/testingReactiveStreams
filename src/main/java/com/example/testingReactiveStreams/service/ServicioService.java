package com.example.testingReactiveStreams.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class ServicioService {
    //Trae una sola persona
    public Mono<String> buscarUno() {
        return Mono.just("Pedro");
    }
    //Trae una varias personas
    public Flux<String> buscarTodos() {
        return Flux.just("Pedro", "Maria", "Jesus", "Carmen");
    }
    //Trae una varias personas con delay
    public Flux<String> buscarTodosLento() {
        return Flux.just("Pedro", "Maria", "Jesus", "Carmen").delaySequence(Duration.ofSeconds(20));
    }
}

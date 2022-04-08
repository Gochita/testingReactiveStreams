package com.example.testingReactiveStreams.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;


@SpringBootTest
class ServicioServiceTest {

    @Autowired
    ServicioService servicioService;

    @Test
    void buscarUno() {
        Mono<String> uno =servicioService.buscarUno();
        StepVerifier.create(uno).expectNext("Pedro").verifyComplete();

    }

    @Test
    void buscarTodos() {
        Flux<String> varios= servicioService.buscarTodos();
        StepVerifier.create(varios).expectNext("Pedro").expectNext("Maria").expectNext("Jesus").expectNext("Carmen").verifyComplete();
    }
    @Test
    void testVariosLento() {
        Flux<String> uno = servicioService.buscarTodosLento();
        StepVerifier.create(uno)
                .expectNext("Pedro")
                .thenAwait(Duration.ofSeconds(1))
                .expectNext("Maria")
                .thenAwait(Duration.ofSeconds(1))
                .expectNext("Jesus")
                .thenAwait(Duration.ofSeconds(1))
                .expectNext("Carmen")
                .thenAwait(Duration.ofSeconds(1)).verifyComplete();
    }

}
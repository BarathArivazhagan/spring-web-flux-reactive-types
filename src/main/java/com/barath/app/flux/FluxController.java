package com.barath.app.flux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * Created by barath.arivazhagan on 9/5/2017.
 */
@RestController
@RequestMapping("/flux")
public class FluxController {

    private FluxService fluxService;

    public FluxController(FluxService fluxService){
        this.fluxService=fluxService;
    }

    @GetMapping("/strings")
    public Flux<String> createFluxOfStrings(){

        return fluxService.createFluxOfStrings();
    }

    @GetMapping("/concat")
    public Flux<String> combineTwoFlux(){

        return fluxService.combineTwoFlux();
    }

    @GetMapping("/merge")
    public Flux<String> mergeTwoFlux(){

        return fluxService.mergeTwoFlux();
    }

    @GetMapping(value = "/fromArray")
    public Flux<String> fromArray(){
        return fluxService.fluxFromArray();
    }

    @GetMapping(value = "/fromIterable")
    public Flux<String> fromIterable(){
        return fluxService.fluxFromIterable();
    }
}

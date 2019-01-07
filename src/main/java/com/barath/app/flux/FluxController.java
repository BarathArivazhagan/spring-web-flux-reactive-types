package com.barath.app.flux;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

/**
 * @author barath
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

    @GetMapping(value = "/doOnError")
    public Flux<String> handleFluxWithError(){
        return fluxService.handleFluxWithError();

    }


}

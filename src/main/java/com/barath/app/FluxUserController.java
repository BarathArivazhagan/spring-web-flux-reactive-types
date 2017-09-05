package com.barath.app;

import com.barath.app.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * Created by barath.arivazhagan on 9/5/2017.
 */
@RestController
@RequestMapping(value = "/flux/user")
public class FluxUserController {


    private FluxUserService userService;

    public FluxUserController(FluxUserService userService){
        this.userService=userService;
    }


    @GetMapping(value="/one")
    public Flux<User> createSingleUser(){
        return userService.createSingleUser();
    }

    @GetMapping(value="/many",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Flux<User> createManyUsers(){

        return userService.createFluxOfUsers();
    }

    @GetMapping(value = "/names",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Flux<String> getUserNames(){

        return userService.getUserNames();
    }


}

package com.barath.app.flux;

import com.barath.app.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * Created by barath.arivazhagan on 9/5/2017.
 */
@RestController
@RequestMapping(value = "/flux/user")
public class FluxUserController {


    private final FluxUserService userService;

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

    @GetMapping(value = "/below/{age}")
    public Flux<User> getUsersBelowAge(@PathVariable Long age){
        return userService.getUsersBelowAge(age);
    }

    @GetMapping(value="/concat")
    public Flux<User>  concatTwoSets(){
        return userService.combineTwoFluxsIntoOne();
    }

    @GetMapping(value="/merge")
    public Flux<User>  mergeTwoSets(){
    	
        return Flux.empty();
    }


    @GetMapping(value="/zip")
    public Flux<User>  getZippedUsers(){
        return userService.zipUsers();
    }

}

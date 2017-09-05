package com.barath.app;

import com.barath.app.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.lang.invoke.MethodHandles;

/**
 * Created by barath.arivazhagan on 9/5/2017.
 */

@Service
public class FluxUserService {


    private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    public Flux<User> createSingleUser(){

        return Flux.just(new User(1L,"barath",25));

    }

    public Flux<User> createFluxOfUsers(){

        return getFluxOfUsers();
    }


    public Flux<String> getUserNames(){

        return getFluxOfUsers().map(user -> user.getUserName()).doOnNext( name -> System.out.println(" Name "+name));
    }

    public Flux<User> getUsersBelowAge(Long age){

        return getFluxOfUsers().filter( user ->  {
            if(user.getAge() < age ) {
                return true;
            }else{
                return false;
            }
        });
    }


    private Flux<User> getFluxOfUsers(){
        return Flux.just( new User(1L,"barath",25),
                new User(2L,"DHONI",35),
                new User(3L,"SACHIN",45),
                new User(4L,"VIRAT",28),
                new User(5L,"ROHIT",30),
                new User(6L,"DHAWAN",28),
                new User(7L,"KUMBLE",42),
                new User(8L,"JOSHI",46),
                new User(9L,"GAVASKAR",65),
                new User(10L,"KAPILDEV",55),
                new User(11L,"SRINATH",50),
                new User(12L,"SACHIN",45));
    }
}

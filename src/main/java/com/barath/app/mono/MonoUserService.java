package com.barath.app.mono;

import com.barath.app.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.lang.invoke.MethodHandles;

/**
 * Created by barath.arivazhagan on 9/5/2017.
 */
@Service
public class MonoUserService {

    private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public Mono<User> getMonoUser(){
        return  Mono.just(new User(1L,"barath",26));
    }

    public Mono<User> operatorOnUser(Mono<User> user){

        return user.log().doOnNext( user1 -> {
            logger.info("user name {}",user1.getUserName());
        });
    }
}

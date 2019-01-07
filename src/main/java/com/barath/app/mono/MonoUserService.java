package com.barath.app.mono;

import com.barath.app.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.lang.invoke.MethodHandles;
import java.util.function.Function;

/**
 * @author barath
 */
@Service
public class MonoUserService {

    private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public Mono<User> getMonoUser(){
        return  Mono.just(new User(1L,"barath",26));
    }

    public Mono<User> operatorOnUser(Mono<User> userMono){

        return userMono.log().doOnNext( user -> {
            logger.info("user name {}",user.getUserName());
        });
    }
    
    public Mono<User> operateOnUserName(Mono<User> userMono){
    	
    	return userMono.map( user -> {
    		user.setUserName(user.getUserName().toUpperCase());
    		return user;
    	});
    }
    
    public Mono<User> convertUserNameToUpperCase(Mono<User> userMono){

        return userMono.zipWith(userMono.map(user -> user.getUserName().toUpperCase()), (user, s) -> new User(user.getUserId(),s,user.getAge()));

    }


     

}

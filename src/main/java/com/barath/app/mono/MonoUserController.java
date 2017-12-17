package com.barath.app.mono;

import com.barath.app.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Created by barath on 17/12/17.
 */
@RestController
@RequestMapping(value = "/mono/user")
public class MonoUserController {

    private MonoUserService monoUserService;

    public MonoUserController(MonoUserService monoUserService) {
        this.monoUserService=monoUserService;
    }

    @GetMapping("/mono")
    public Mono<User> getMonoUser(){

        return monoUserService.getMonoUser();
    }
}

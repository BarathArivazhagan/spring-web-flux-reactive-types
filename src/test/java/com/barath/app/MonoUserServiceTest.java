package com.barath.app;


import com.barath.app.model.User;
import com.barath.app.mono.MonoUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MonoUserServiceTest {

    @Autowired
    private MonoUserService monoUserService;

    @Test
    public void testMonoUser(){


        StepVerifier.create(this.monoUserService.getMonoUser())
                .expectNext(new User(1L,"barath",26))
                .verifyComplete();
    }


}

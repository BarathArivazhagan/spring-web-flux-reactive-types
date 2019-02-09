package com.barath.app;

import com.sun.tools.javac.util.Pair;
import org.junit.Test;
import reactor.core.publisher.Flux;

public class FluxUserServiceTest {

    @Test
    public void testFluxPair(){

        Flux<String> a = Flux.just("foo", "bar", "baz", "foobar");
        Flux<Pair<String, Integer>> b= Flux.just(Pair.of("foo", 5), Pair.of("baz", 5));

        Flux<String> d = b.map(t -> t.fst );
        d.log().subscribe();
        Flux.merge(a,d).distinct().log().subscribe();

        Flux.merge(a,d).zip(a,b)
                .map( pair -> {
                    System.out.println("T1 "+pair.getT1());
                    System.out.println("T2 "+pair.getT2());
                    return pair;
                }).subscribe();


        Flux.from(a)
                .map(s -> {

                    return b.filter(strPair -> s.equals(strPair.fst)).switchIfEmpty(Flux.just(Pair.of(s,0)));
                }).flatMap(Flux::next).log().subscribe();
    }
}

# spring-web-flux-reactive-types
This repository breaks down learning of reactive types such as Mono and Flux. This repository contains examples using these reactive types in Spring5 Web Flux Framework

## Documentation:

#### What is a Reactor ? 

Reactor = single threaded event loop that receives and processes requests.

#### What is Reactor Pattern ? 

The reactor design pattern is an event handling pattern for handling service requests delivered concurrently to a service handler by one or more inputs. The service handler then demultiplexes the incoming requests and dispatches them synchronously to the associated request handlers.

#### What is event loop ?




## REST endpoint mappings:


<table>
  <tr>
    <th> Endpoint </th>
    <th> Description </th>
    <th> Result </th>
  </tr>
  <tr>
    <td>/flux/strings</td>
    <td>returns flux of strings created using Flux.just()</td>
    <td> "BARATH" </td>   
  </tr>
  <tr>
    <td>/flux/fromArray</td>
    <td>returns flux of strings created using Flux.just()</td>
    <td> "BARATH" </td>
   </tr>
   <tr>
     <td>/flux/concat</td>
      <td>returns flux of strings created using Flux.concat()</td>
      <td> "BARATH" </td>
   </tr>
   <tr>  
     <td>/flux/merge</td>
    <td>returns flux of strings created using Flux.just()</td>
    <td> "BARATH" </td>  
   </tr>
   <tr>
     <td>/mono/string</td>
     <td>returns mono of type string Mono.just()</td>
     <td> "BARATH" </td>   
   </tr>
   <tr>
    <td>/mono/string/delay</td>
    <td>returns flux of strings created using Flux.just()</td>
    <td> "BARATH" </td>
   
   </tr>
   <tr>
     <td>/mono/doOnNext</td>
    <td>returns flux of strings created using Mono.just().doOnNext()</td>
    <td> "BARATH" </td>   
   </tr>
   <tr>
     <td>/mono/int</td>
     <td>returns flux of strings created using Flux.just()</td>
     <td> "BARATH" </td>   
   </tr>
   <tr>  
    <td>/flux/user/one</td>
    <td>returns flux of strings created using Flux.just()</td>
    <td> "BARATH" </td>
  </tr>
  <tr>
    <td>/flux/fromIterable</td>
    <td>returns flux of strings created using Flux.just()</td>
    <td> "BARATH" </td>
  </tr>
  
  
  

</table>


### How to build and run the project? 

1) Clone the repository
2) Maven build 

```
./mvnw clean install

```

3) Run as spring boot app: 

```
./mvnw spring-boot:run

```

References: 

http://musigma.org/java/2016/11/21/reactor.html
http://javasampleapproach.com/reactive-programming/reactor/reactor-how-to-combine-flux-mono-reactive-programming

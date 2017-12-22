# spring-web-flux-reactive-types
This repository breaks down learning of reactive types such as Mono and Flux. This repository contains examples using these reactive types in Spring5 Web Flux Framework

## Documentation:

#### What is a Reactor ? 

Reactor = single threaded event loop that receives and processes requests.

#### What is Reactor Pattern ? 

The reactor design pattern is an event handling pattern for handling service requests delivered concurrently to a service handler by one or more inputs. The service handler then demultiplexes the incoming requests and dispatches them synchronously to the associated request handlers.






## REST endpoint mappings:


<table>
  <tr>
    <th> Endpoint </th>
    <th> Description </th>
    <th> Usage </th>
    <th> Result </th>
  </tr>
  <tr>
    <td>/flux/strings</td>
    <td>returns flux of strings created using Flux.just()</td>
    <td>Flux.just("DHONI","SACHIN","VIRAT")</td>
    <td> "DHONISACHINVIRAT" </td>   
  </tr>
  <tr>
    <td>/flux/fromArray</td>
    <td>returns flux of strings created using Flux.fromArray()</td>
    <td></td>
    <td> AMESHSURESHMAHESHBILLHAYDENSMITH </td>
   </tr>
   <tr>
     <td>/flux/concat</td>
      <td>returns flux of strings created using Flux.concat()</td>
     <td> "BARATH" </td>
      <td> "BARATH" </td>
   </tr>
   <tr>  
     <td>/flux/merge</td>
    <td>returns flux of strings created using Flux.merge()</td>
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
    <td>  Mono.justOrEmpty("company").doOnNext() </td>   
    <td> "BARATH" </td>   
   </tr>
   <tr>
     <td>/mono/int</td>
     <td>returns flux of strings created using Mono.just()</td>
     <td> Mono.just(1)</td>  
     <td> 1 </td>   
   </tr>
   <tr>  
    <td>/flux/user/one</td>
    <td>returns flux of one user created using Flux.just()</td>
    <td> Flux.just(new User(1L,"barath",25)</td>
    <td> [{"userId":1,"userName":"barath","age":25}] </td>
  </tr>
   <tr>  
    <td>/flux/user/many</td>
    <td>returns flux of many users created using Flux.just()</td>
    <td> Flux.just(new User(1L,"barath",25),...)</td>
    <td> [{"userId":1,"userName":"barath","age":25},{"userId":2,"userName":"DHONI","age":35},{"userId":3,"userName":"SACHIN","age":45},{"userId":4,"userName":"VIRAT","age":28},{"userId":5,"userName":"ROHIT","age":30},{"userId":6,"userName":"DHAWAN","age":28},{"userId":7,"userName":"KUMBLE","age":42},{"userId":8,"userName":"JOSHI","age":46},{"userId":9,"userName":"GAVASKAR","age":65},{"userId":10,"userName":"KAPILDEV","age":55},{"userId":11,"userName":"SRINATH","age":50},{"userId":12,"userName":"SACHIN","age":45}]</td>
  </tr>
  <tr>
    <td>/flux/fromIterable</td>
    <td>returns flux of strings created using Flux.fromIterable()</td>
  <td>Flux.fromArray( new String[]{"BARATH","DHONI"}</td>
    <td> "BARATH" </td>
  </tr>
  
  <tr>
    <td>/mono/user</td>
    <td>returns mono of user using Mono.just(new User())</td>
  <td>Mono.just(new User(1L,"barath",26))</td>
    <td> {"userId":1,"userName":"barath","age":26} </td>
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

* http://musigma.org/java/2016/11/21/reactor.html
* http://javasampleapproach.com/reactive-programming/reactor/reactor-how-to-combine-flux-mono-reactive-programming

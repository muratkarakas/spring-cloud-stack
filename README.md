# spring-cloud-stack
Spring Cloud Playground Application. Spring Cloud Netflix solutions to microservice architecture problems

## Problems:
### 1.Service Configuration:
Let's say you have 10(I guess you have more) microsservices and  3 or more environments(DEV-TEST-PROD) so it makes at least 30 configuration files.
By the service count,envenvironment and configuration item increase it gets more complex.

#### Solution:
Spring cloud configuration server centralizes all configuration separated by environment and service (sc-config-server).

### 2.Service Discovery:
Services should be discoverable by clients  and administrators in one place.IP address or hosts can change and clients shouldn't be effect by this.Only service name should be enough to communicate with it.

#### Solution:
Spring Cloud Netflix Eureka server is used as service registry like UDDI.Each microservice registers itself(also  different instances of same service). When another service needs to communicate with this service it lookups by name in "Eureka Discovery Server"(sc-eureka-server).Adminstrators can also monitor UP status of services from  Eureka Dashboard.


### 3.Service/Transaction Tracing:
Many processes need interaction with multiple microservices.Also there is a communication between microservice instances. Visibility of this service call chain is another requirement.

#### Solution:
Spring Cloud Netflix Zipkin enable reporting of this service calls (with context data and timing) to centralized server and provides user interface for tracing and searching service calls(sc-zipkin).

### 4.Service Security and Service Access by External Clients:
Inter-communication between microservices mostly does not need special security cause they are usually in secure private network (ex: DMZ ). Also username/password or similar auth method is not required. But when these services are open to world or to other external systems/applications they may need authentication , service forwarding mechanisms. It is also difficult to client systems to know the address and other details(port etc.) of each service.

#### Solution:
Spring Cloud Netflix Zuul servers acts as edge proxy server for these requirements.Clients only need to know proxy server address and name of the service. If it is necessary to add authentication mechanism you can add it to this proxy server for clients(sc-zuul-proxy).

### 5.Service down or slow response times:
One of the problem with services is what to do when service is down or what to do when service response time is too much then expected? These service problems will directly effect service clients, even it may cause client or server downs.Another problem is that how to get notified when such a problem occurred.

#### Solution:
Spring Cloud Hystrix provides "Circuit Breakers" for those situations. You can define fallback methods and SLA's for service executions. Hystrix dashboard enable users to monitor these Circuit Breakers at realtime(sc-hystrix-dashboard).


## How to run:
<ol>
  <li>Install docker container(<a href="https://docs.docker.com/engine/getstarted/step_one/">getting started guide</a>)
  </li>
  <br/>
  <li>git clone https://github.com/muratkarakas/spring-cloud-stack.git
  </li>
  <br/>
  <li>To build and run application run ./dockerRun.sh in the root directory.Before running script you should increase docker default memory settings
  <br/>
  <img src="https://i.stack.imgur.com/bjHNdl.png"></img>
  </li>
  <br/>
  <li>Discovery Server: <a href="http://localhost:8761/">http://localhost:8761/</a>
  </li>
  <br/>
  <li>Microservice  : <a href = "http://localhost:8083/ping">http://localhost:8083/ping</a>
  </li>
  <br/>
  <li>Microservice  (client with Load Balacing and Circuit Breaker ): <a href ="http://localhost:8081/greeting">http://localhost:8081/greeting</a>
  </li>
  <br/>
  <li>Microservice  over proxy: <a href="http://localhost:9999/sc-service-client/greeting">http://localhost:9999/sc-service-client/greeting</a>    acme/password
  </li>
  <br/>
  <li>Service Trace  with Zipkin: <a href="http://localhost:9411/">http://localhost:9411/</a>  
  </li>
  <br/>
  <li>Circuit Breakers Monitor: <a href="http://localhost:8082/hystrix/monitor?stream=http://localhost:8082/turbine.stream" >http://localhost:8082/hystrix/monitor?stream=http://localhost:8082/turbine.stream</a>
  </li>
  <br/>
</ol>

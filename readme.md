Spring framework provides set of libraries for creating microservices in Java. They are a part of Spring Cloud project. Today I’m going to show you how to create simple microservices using Spring Boot and following technologies:

Zuul –  gateway service that provides dynamic routing, monitoring, resiliency, security, and more
Ribbon – client side load balancer
Feign – declarative REST client
Eureka – service registration and discovery
Sleuth – distributed tracing via logs
Zipkin – distributed tracing system with request visualization.
Client calls endpoint available inside customer-service which stores basic customer data via Zuul gateway. This endpoint interacts with account-service to collect information about customer accounts served by endpoint in account-service. Each service registering itself on Eureka discovery service and sending its logs to Zipkin using spring-cloud-sleuth.

This is account-service controller. We use findByCustomer method for collecting customer accounts by his id.
This is customer-service controller. There is findById method which interacts with account-service using Feign client.

Like we see Zuul is configured to be available under its default port 8765 and it forwards requests from /api/account/ path to account-service and from /api/customer/ to customer-service. When URL http://localhost:8765/api/customer/customers/1 is call several times we’ll see its load balanced between two instances of each microservice. Also when we shut down one of microservice instance we can take o look that it is unregistered from Eureka server.


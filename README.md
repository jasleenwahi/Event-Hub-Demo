**random data generation using mockaroo and sending the data to event hub**

This application demontrates how we can use mockaroo to generate random data whenever required and send the generated data to azure event hub using spring boot kafka template.

**Table of Contents**
1. Pre-requisites
2. Getting Started
3. Kafka Configuration
4. Rest Endpoints
5. Dependencies

**Pre-requisites**
1. Java Development Kit (JDK) 11 or higher
2. Maven (for building and managing dependencies)
3. Azure Cloud account with appropriate credentials
4. An account on mockaroo

**Getting Started**
1. Clone the repository on your machine
2. Open the project in any IDE
3. Add required configurations in environment variables and integrate them in **application.yml**
4. build the application using maven: **mvn clean package**
5. run the application

**Kafka Configuration**

kafka.bootstrap-servers= ${KAFKA_SERVER}

kafka.properties.security.protocol = <KAFKA_SECURITY_PROTOCOL>

kafka.properties.sasl.mechanism = <SASL_MECHANISM>

kafka.properties.sasl.jaas.config = <JASS_CONFIG>

kafka.producer.key-serializer = <KEY_SERIALIZER>

kafka.producer.value-serializer = <VALUE_SERIALIZER>


**Rest Endpoints**
1. Push data to cloud Pub-sub
    Endpoint: /v1/data
    HTTP method: POST

**Dependencies**
The main dependencies used in this application are:

    1. Spring Boot Starter WebFlux: Provides the necessary components for building reactive web applications.
    2. Azure SDK: The SDK for the respective cloud provider is used to interact with the event hub service.

For a complete list of dependencies, please refer to the pom.xml file in the project.

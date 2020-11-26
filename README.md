# UI Automation Template

UI Automation project example.
This small project can help you to start with automation testing. 

Tools:

- Java 13
- Selenide
- TestNG
- Docker
- Selenoid
- Allure
- Log4j2

## How to run

To run project you have to do several steps:

* **Build the project**

```
mvn clean package -DskipTests=true
```

* **Pull browser images**

    * Manually:
   
        - go to **config/browsers.json**
        - pull listed images: 
        
      ```
      docker pull selenoid/vnc:chrome_84.0
      ```
        
   * Or, if you have **jq**:
    
        ```
        cat config/browsers.json | jq -r '..|.image?|strings' | xargs -I{} docker pull {}
        ```

* **Run test** 
```$bash
    docker-compose up --build
```

* **See report**

    1.  Generate a report (First step)
    http://localhost:5050/allure-docker-service/generate-report
    
    2. See the latest report (Second step)
    http://localhost:5050/allure-docker-service/latest-report
     
     ** For more documentation check here
     https://github.com/fescobar/allure-docker-service

* See your running test sessions (only if VNC is enabled)

    http://localhost:8080
    
* See browsers status 

    http://localhost:4444/status

* Finish tests
```$bash
    docker-compose down
```

### How to change xml suite to run
 
Go to docker-compose.yml. Change **SUITE** variable:

> args:
>
>  SUITE: test-suite.xml


### How to enable video

1. Pull image manually:
```bash
docker pull selenoid/video-recorder:latest-release
```

Go to `testConfig.properties` and change `enableVideo = true`

Run your test in containers and check folder config/video


### How to enable VNC

Go to `testConfig.properties` and change `enableVNC = true`
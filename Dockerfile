FROM openjdk:13-alpine

WORKDIR /app

ARG SUITE
ENV suitefile=$SUITE

# Add the project jar & copy dependencies
RUN  mkdir target && mkdir logs && mkdir target/allure-results
ADD  target/libs libs
ADD  config config
ADD  target/test-automation-template.jar test-automation-template.jar
ADD  target/test-automation-template-tests.jar test-automation-template-tests.jar

# Add the suite xmls
ADD src/test/resources/suites/$SUITE $SUITE

ENTRYPOINT java -cp test-automation-template.jar:test-automation-template-tests.jar:libs/* -DuseLocalDriver=false --enable-preview -javaagent:"libs/aspectjweaver-1.9.5.jar" org.testng.TestNG "/app/$suitefile"



FROM gradle:7.6-jdk17

WORKDIR /testTask

COPY ./ .

RUN gradle installDist

CMD build/install/testTask/bin/testTask
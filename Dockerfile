FROM maven:3.6.0-jdk-8

COPY ./. /

ENV TEST_TO_RUN1 none \
    TEST_TO_RUN2 none \
    TEST_TO_RUN3 none \
    TEST_TO_RUN4 none \
    TEST_TO_RUN5 none \
    TEST_TO_RUN6 none \
    TEST_TO_RUN7 none \
    TEST_TO_RUN8 none \
    TEST_TO_RUN9 none \
    TEST_TO_RUN10 none

CMD mvn test -DsuiteXmlFile=$TEST_TO_RUN1,$TEST_TO_RUN2,$TEST_TO_RUN3,$TEST_TO_RUN4,$TEST_TO_RUN5,$TEST_TO_RUN6,$TEST_TO_RUN7,$TEST_TO_RUN8,$TEST_TO_RUN9,$TEST_TO_RUN10 -pl web -am
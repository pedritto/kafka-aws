FROM openjdk:8u181-jre-alpine

RUN apk --update --no-cache add tar wget bash sed && rm -rf /var/cache/apk/*
RUN wget http://xenia.sote.hu/ftp/mirrors/www.apache.org/kafka/2.0.1/kafka_2.11-2.0.1.tgz -O /tmp/kafka.tar.gz && \
    tar -xzf /tmp/kafka.tar.gz && mv kafka_2.11-2.0.1 /kafka

ADD ./start_kafka.sh /kafka/start_kafka.sh
RUN chmod +x /kafka/start_kafka.sh

WORKDIR /kafka
EXPOSE 2181 9092

ENTRYPOINT ["/kafka/start_kafka.sh"]

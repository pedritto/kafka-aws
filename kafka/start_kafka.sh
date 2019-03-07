#!/usr/bin/env bash
sed -i -e '/broker.id=/c broker.id='"$KAFKA_BROKER_ID"'' /kafka/config/server.properties && \
sed -i -e '/zookeeper.connect/c zookeeper.connect='"$KAFKA_ZOOKEEPER_CONNECT"'' /kafka/config/server.properties && \
sed -i -e '/log.retention.hours=/c log.retention.hours='"$KAFKA_LOG_RETENTION_HOURS"'' /kafka/config/server.properties

exec /kafka/bin/kafka-server-start.sh /kafka/config/server.properties

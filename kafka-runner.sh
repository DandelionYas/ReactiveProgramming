#!/bin/bash

#Go to the Kafka bin directory
#You must change it based on your own Kafka path
cd ./kafka/kafka_2.12-3.9.1/bin

#If env variable not set, generate random one
#Large organizations might have multiple kafka clusters. Each cluster is expected to have an ID
clusterId=${KAFKA_CLUSTER_ID:-$(./kafka-storage.sh random-uuid)}
echo "Kafka Cluster ID: ${clusterId}"

# For the first time, format the storate. It would create couple of files.
# If it is already formatted, it would be ignored
echo "Formatting storage ..."
./kafka-storage.sh format -t $clusterId -c ../config/kraft/server.properties

echo "Starting Kafka ..."
exec ./kafka-server-start.sh ../config/kraft/server.properties

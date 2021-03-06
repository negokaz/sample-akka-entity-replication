# akka-entity-replication-sample

[![](https://img.shields.io/github/v/release/lerna-stack/akka-entity-replication-sample)](https://github.com/lerna-stack/akka-entity-replication-sample/releases/latest)

This is an example project showing how to use [akka-entity-replication](https://github.com/lerna-stack/akka-entity-replication).

## How to run this app

### 🐳 Run with docker-compose

Create this app docker image.

```bash
sbt --batch docker:publishLocal
```

To start cluster, run following a command.

```bash
docker-compose up -d
```

You can watch logs of running services.

```
docker-compose logs -f --tail=10 node1
```
```
docker-compose logs -f --tail=10 node2
```
```
docker-compose logs -f --tail=10 node3
```
```
docker-compose logs -f --tail=10 cassandra
```
```
docker-compose logs -f --tail=10 haproxy
```

You can run the following command to see application behavior.

```bash
bin/demo-request.sh 100 # An account No must be pass!
```

To stop the containers and remove all data, run the following command.

```bash
docker-compose down --volumes
```

### 🔧 Run with sbt

To start cluster, run following commands on separated terminals.

```bash
docker-compose up -d cassandra
```

```bash
sbt --batch runNode1
```

```bash
sbt --batch runNode2
```

```bash
sbt --batch runNode3
```

You can run the following command to see application behavior.

```bash
bin/demo-request.sh 100 # An account No must be pass!
```

To stop the cassandra container and remove all data, run the following command.

```bash
docker-compose down --volumes
```


## Versioning Strategy
We use the [Calendar Versioning](https://calver.org/) `YYYY.MM.MICRO`. 

## Changelog

You can see all the notable changes in [CHANGELOG](CHANGELOG.md).

## License

akka-entity-replication-sample is released under the terms of the [Apache License Version 2.0](LICENSE).

© 2021 TIS Inc.

# Instruções de acesso e implantação

## Versão acessível instalada no Google Cloud, usando Kubernetes:

```terminal
$ curl -i http://34.73.65.97:8080/api/v1/stats
```

## Instalação local via Docker

```terminal
$ git clone https://marceloweb@bitbucket.org/marceloweb1/identificator.git
$ cd identificator/
$ docker run -p 8080:8080 marceloweb/ml-identificator:1.0
```

ou

```terminal
$ docker-compose up -d
```

## Instalação local sem Docker

```terminal
$ git clone https://marceloweb@bitbucket.org/marceloweb1/identificator.git
$ cd identificator/
$ ./mvnw package && java -jar target/identificator-0.0.1-SNAPSHOT.jar
```

## Pontos a melhorar 

* Adicionar Secret manager
* Código Java: retornos JSON

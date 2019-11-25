# Instruções de acesso e implantação

## Versão acessível instalada no Google Cloud, usando Kubernetes:

### GET Consulta DNA's

```terminal
$ curl -i http://34.73.65.97:8080/api/v1/stats
```

### POST Cadastro de DNA's

```terminal
$ curl -i -H "Content-Type: application/json" -X POST http://34.73.65.97:8080/api/v1/simian -d '{"dna":[["D","C","C","C","C","Y"],["A","C","X","X","C","Y"],["B","A","Y","Y","Y","Y"],["A","C","Z","A","D","Y"],["C","D","X","A","A","Y"]]}'
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
* Cobertura e qualidade dos Testes

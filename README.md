# Prerequisities
* Docker >= 20.10.8
* docker-compose >= 1.29.2
* java 11
* bash/zsh

# Running it
1. Go to `api` directory and start build task
```bash
./gradlew clean build
```
2. Go back to the root directory and start `docker-compose`
```bash
docker-compose up --build
```
3. Paste `localhost:3000` to the browser

## Calling API
```bash
curl -H "Content-Type: application/json" -X POST "http://localhost:8080/order/create" -d '{"email":"konrad@example.com","quantity":5,"promoCode":"1234"}' | jq
```

# Tests
1. Go to `api` directory
2. Start gradle task
```bash
./gradlew clean check
```

# Technologies used:
## Backend
* java 11
* spring boot
* gradle
* spring jpa
* mysql db
* docker & docker-compose

utils:
* apache commons
* vavr
* lombok

testing:
* spock

## Frontend
* react ecosystem (with hooks)
* axios
* bootstrap
* node
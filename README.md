# spring boot 실행
```bash
./gradlew bootRun
```

# code formatting
```bash
./gradlew spotlessApply
```

# DB
## mysql 실행
```bash
docker-compose up -d
```

## mysql 중지
```bash
docker-compose down
```

## mysql 서버 접속
```bash
docker exec -it mysql bash
mysql -u root -p
```
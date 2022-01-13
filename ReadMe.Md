```
curl --location --request POST 'http://localhost:8080/idol/users' \
--header 'Content-Type: application/json' \
--data-raw '{
    "todo_id": 1,
    "real_name": "Real Name 1",
    "idol_name": "Idol Name 1",
    "address": "Sri Lanka",
    "idol_status": "Completed"
}'
```

```
curl --location --request GET 'http://localhost:8080/idol/users/1'
```

```
curl --location --request PUT 'http://localhost:8080/idol/users' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id" : 1,
    "todo_id": 1,
    "real_name": "Real Name 1",
    "idol_name": "Idol Name 1",
    "address": "Sri Lanka",
    "idol_status": "Completed"
}'
```

```
curl --location --request DELETE 'http://localhost:8080/idol/users/1'
```
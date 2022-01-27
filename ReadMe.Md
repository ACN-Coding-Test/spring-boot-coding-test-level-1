```
curl --location --request POST 'http://localhost:5054/idol/users' \
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
curl --location --request GET 'http://localhost:8080/idol/users/get/1'
```

```
curl --location --request PUT 'http://localhost:8080/idol/users/update' \
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
curl --location --request DELETE 'http://localhost:8080/idol/users/remove/1'
```
--------- mvc urls----------

Register idol info : http://localhost:8088/idol/users/register

save idol info : http://localhost:8088/idol/users/saveuser

all idol info : http://localhost:8088/idol/users/allusers


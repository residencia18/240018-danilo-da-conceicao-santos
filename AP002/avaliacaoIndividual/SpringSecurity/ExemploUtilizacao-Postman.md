# Exemplo de utilização - Postman

POST http://localhost:8080/api/auth/register
{
 "username":"Danilo",
 "password":"123",
 "email":"danilo@gmail.com"
}
POST http://localhost:8080/api/auth/login
{
 "username":"Danilo",
 "password":"123"
}

POST  http://localhost:8080/api/recover-password
BODY raw
{
   "email":"danilo@gmail.com"
}


POST  http://localhost:8080/api/reset-password
BODY raw
{
  "token": "8e0ad4b6-7e99-436b-9337-246245e86621",
  "new-Password": "1234"
  "new-Password": "1234"
  
}
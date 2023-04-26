# Project Title

A sample crud springboot project

## Description

CRUD operation of a customer entity is done in this project providing JWT authentication.

## Getting Started

### Dependencies

It needs jdk 17

### Executing program

1.After running the program on default port 8080, you need first to be authenticated via "127.0.0.1:8080/api/crud/auth/authenticate-customer" post request and body 
{
    "userName":"user",
    "password":"user"
} 
or 
{
    "userName":"admin",
    "password":"admin"
}

to get the token.

2.Then adding given token in the previous step to the header of other requests, i.e. "127.0.0.1:8080/api/crud/customer/add-customer"
```

## Authors

Nazanin Aminzadeh

**PSL Praxis 2018**

*Backend app*

Project created using react:
* Required
  * Docker


to build the image:
```
docker build -t praxis-app-back .
```

to run the ui-service (in 8080 port):
```
docker run --rm --name praxis-app-front-pod -it -p 8080:3000 praxis-app-front
```

references:
* https://www.reactboilerplate.com/

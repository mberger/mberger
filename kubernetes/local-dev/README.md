## Overview
This project contains code example for the articles 
1. [Getting started with Kind: quick start a multi-node local Kubernetes cluster][1]
2. [Getting started with Minikube: deploying application on local Kubernetes cluster][2]

The source code contains a microservice application, written in spring boot. This application exposes two end-points
1. `POST /products/`
2. `GET /products/{productId}`

To access end-points use curl

To save Product 
`curl --location --request POST 'localhost:81/products/' \
--header 'Content-Type: application/json' \
--header 'userId: abc@xyz.com' \
--data-raw '{
"name": "Apple iPhone 12",
"description": "Apple iPhone 12 Pro Max 128 GB, Pacific Blue",
"price": 1700
}'`

To get Product

`curl --location --request GET 'localhost:81/products/f02172fc-4bd6-44e1-869e-3bf3d0e35bd8' \
--data-raw ''`

## Kubernetes
kubernetes specific file can be found in deployments directory. You can use kubectl to create Kubernetes artifacts.
For example, to create a pod run command `kubectl apply -f deployments/pod.yaml` from root directory `local-dev`. 

## Build

1. To build, run command `gradlew clean build`. This will generate product-svc-1.0.0.jar in build/lib folder.
2. To run from command line - `java -jar build/libs/product-svc-1.0.0.jar` 
3. To run in IDE, import `kubernetes/local-dev` as a standalone project in the IDE and run main method of `ProductApplication`

To build Docker image
Run command `docker build . -t product:<tag>`

To push Docker image to the Dockerhub
```
docker tag local-image:tagname new-repo:tagname
docker push new-repo:tagname
```


[1]: https://techdozo.dev/2021/getting-started-with-kind-quick-start-a-multi-node-local-kubernetes-cluster/
[2]: https://techdozo.dev/2021/getting-started-with-minikube-deploy-a-local-kubernetes-cluster/

package com.yebali.template.grpc

import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.server.service.GrpcService

@GrpcService
class HelloService : HelloServiceGrpc.HelloServiceImplBase() {
    override fun sayHello(request: HelloRequest, responseObserver: StreamObserver<HelloResponse>) {
        responseObserver.onNext(
            HelloResponse.newBuilder()
                .setMessage("hello ${request.name}")
                .build(),
        )

        responseObserver.onCompleted()
    }
}

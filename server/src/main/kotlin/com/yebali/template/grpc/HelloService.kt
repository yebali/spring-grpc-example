package com.yebali.template.grpc

import com.yebali.template.grpc.HelloProto.HelloResponse
import net.devh.boot.grpc.server.service.GrpcService

@GrpcService
class HelloService : HelloServiceGrpcKt.HelloServiceCoroutineImplBase() {
    override suspend fun sayHello(request: HelloProto.HelloRequest): HelloResponse {
        return HelloResponse.newBuilder()
            .setMessage("Hello ${request.name}")
            .build()
    }
}

package io.piano.stackowerflow;

import io.piano.stackowerflow.feign.ApiCallerFeignClientSync;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(clients = {
        ApiCallerFeignClientSync.class
})
public class StackoverflowApplication {

    public static void main(String[] args) {
        SpringApplication.run(StackoverflowApplication.class, args);
    }

}

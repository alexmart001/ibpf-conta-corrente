package br.com.impacta.ibpf.contacorrente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class IbpfContaCorrenteApplication {

	public static void main(String[] args) {

		SpringApplication.run(IbpfContaCorrenteApplication.class, args);
	}

}

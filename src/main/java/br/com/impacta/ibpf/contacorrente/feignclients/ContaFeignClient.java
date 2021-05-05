package br.com.impacta.ibpf.contacorrente.feignclients;

import br.com.impacta.ibpf.contacorrente.entities.Conta;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "ibpf-conta", path = "/contas")
public interface ContaFeignClient {

	@GetMapping(value = "/{id}")
	ResponseEntity<Conta> findById(@PathVariable Long id);

	@GetMapping(value = "/search")
	ResponseEntity<Conta> findByAgenciaAndConta(@RequestParam String agencia, @RequestParam String conta);

}

package br.com.impacta.ibpf.contacorrente.feignclients;

import br.com.impacta.ibpf.contacorrente.entities.ContaSaldo;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "ibpf-conta-saldo", path = "/contassaldo")
public interface ContaSaldoFeignClient {

	@GetMapping(value = "/{id}")
	ResponseEntity<ContaSaldo> findById(@PathVariable Long id);

	@GetMapping(value = "/saldoContaData")
	ResponseEntity<ContaSaldo> findByContaData(@RequestParam Long conta, @RequestParam("dataEvento") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dataEvento);

	@GetMapping(value = "/saldoConta")
	ResponseEntity<ContaSaldo> findByConta(@RequestParam("contaId") Long conta);

	@GetMapping(value = "/saldoContaIni")
	ResponseEntity<ContaSaldo> findByContaIni(@RequestParam("contaId") Long conta);

	@PostMapping(value = "/lancaCredito")
	ResponseEntity<ContaSaldo> lancCre(@RequestParam("contaId") Long conta, @RequestParam("valor") BigDecimal valor);

	@PostMapping(value = "/lancaDebito")
	ResponseEntity<ContaSaldo> lancDeb(@RequestParam("contaId") Long conta, @RequestParam("valor") BigDecimal valor);

}

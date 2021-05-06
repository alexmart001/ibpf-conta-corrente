package br.com.impacta.ibpf.contacorrente.feignclients;

import java.math.BigDecimal;
import java.util.List;

import br.com.impacta.ibpf.contacorrente.entities.Lancamento;
import feign.Param;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "ibpf-lancamentos", path = "/lancamentos")
public interface LancamentoFeignClient {

	@GetMapping(value = "/search")
	ResponseEntity<List<Lancamento>> findByContaId(@RequestParam("contaId") Long contaId);

	@PostMapping(value = "/transferenciaDebito")
	public ResponseEntity<Lancamento> transfDeb(@RequestParam("contaId") Long contaOrigId, @RequestParam("valor") BigDecimal valor, @RequestParam("descricao") String descricao);

	@PostMapping(value = "/transferenciaCredito")
	public ResponseEntity<Lancamento> transfCre(@RequestParam("contaID") Long contaOrigId, @RequestParam("valor") BigDecimal valor, @RequestParam("descricao") String descricao);

}

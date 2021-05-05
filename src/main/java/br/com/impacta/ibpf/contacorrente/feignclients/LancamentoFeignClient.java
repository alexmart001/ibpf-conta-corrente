package br.com.impacta.ibpf.contacorrente.feignclients;

import java.util.List;

import br.com.impacta.ibpf.contacorrente.entities.Lancamento;
import feign.Param;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "ibpf-lancamentos", path = "/lancamentos")
public interface LancamentoFeignClient {

	@GetMapping(value = "/search")
	ResponseEntity<List<Lancamento>> findByContaId(@RequestParam("contaId") Long contaId);

}

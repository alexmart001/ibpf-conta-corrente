package br.com.impacta.ibpf.contacorrente.feignclients;

import java.util.List;

import br.com.impacta.ibpf.contacorrente.entities.Lancamento;
import feign.Param;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(name = "ibpf-lancamentos", path = "/lancamentos")
public interface LancamentoFeignClient {

	@GetMapping(value = "/search")
	List<Lancamento> findByContaId(@Param("contaId") Long contaId);

}

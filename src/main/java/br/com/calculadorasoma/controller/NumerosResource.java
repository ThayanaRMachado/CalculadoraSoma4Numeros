package br.com.calculadorasoma.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.calculadorasoma.event.RecursoCriadoEvent;
import br.com.calculadorasoma.model.Numeros;
import br.com.calculadorasoma.repository.NumerosRepository;

@RestController
@RequestMapping("/numeros")
public class NumerosResource {

	@Autowired
	private NumerosRepository numerosRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping
	public ResponseEntity<Numeros> criar(@Valid @RequestBody Numeros numeros, HttpServletResponse response) {
		Numeros numerosSalvos = numerosRepository.save(numeros);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, numerosSalvos.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(numerosSalvos);
	}
	
}

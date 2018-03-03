package br.com.maisVida.ws.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.maisVida.ws.model.Medico;
import br.com.maisVida.ws.service.MedicoService;

@RestController
public class MedicoController {
	
	@Autowired
	MedicoService medicoService;
	
	//End point cadastrar
	@RequestMapping(method=RequestMethod.POST, value="/cadastrar", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Medico> cadastrarMedico(@RequestBody Medico medico) {
		
		Medico medicoCadastrado = medicoService.cadastrar(medico);
		return new ResponseEntity<>(medicoCadastrado, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/medicos", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Medico>> buscarTodosMedicos() {
		
		Collection<Medico> medicosBuscados = medicoService.buscarTodos();
		return new ResponseEntity<>(medicosBuscados, HttpStatus.OK);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/excluir/{id}")
	public ResponseEntity<Medico> excluirMedico(@PathVariable Integer id) {
		
		Medico medicoEncontrado = medicoService.buscarPorId(id);
		if(medicoEncontrado==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		medicoService.excluir(medicoEncontrado);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/alterar/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Medico> alterarMedico(@RequestBody Medico medico, @PathVariable Integer id) {
		
		Medico medicoEncontrado = medicoService.buscarPorId(id);
		if(medicoEncontrado==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Medico medicoAlterado = medicoService.alterar(medico);
		return new ResponseEntity<>(medicoAlterado, HttpStatus.OK);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/medico/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Medico> buscarMedico(@PathVariable Integer id) {
		
		Medico medicoEncontrado = medicoService.buscarPorId(id);
		if(medicoEncontrado==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(medicoEncontrado, HttpStatus.OK);
		
	}
	
}

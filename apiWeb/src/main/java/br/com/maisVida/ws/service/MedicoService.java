package br.com.maisVida.ws.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.maisVida.ws.model.Medico;
import br.com.maisVida.ws.repository.MedicoRepository;

@Service
public class MedicoService {
	@Autowired
	MedicoRepository medicoRepository;
	
	//Negocios
	public Medico cadastrar(Medico medico) {
		return medicoRepository.save(medico);
	}
		
	public Collection<Medico> buscarTodos(){
		return medicoRepository.findAll();
	}
		
	public void excluir(Medico medico) {
		medicoRepository.delete(medico);
	}
		
	public Medico buscarPorId(Integer id) {
		return medicoRepository.findOne(id);
	}
		
	public Medico alterar(Medico medico) {
		return medicoRepository.save(medico);
	}
}

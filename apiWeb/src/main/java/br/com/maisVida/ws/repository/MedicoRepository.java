package br.com.maisVida.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.maisVida.ws.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico,Integer> {

}

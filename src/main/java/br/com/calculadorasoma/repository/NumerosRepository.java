package br.com.calculadorasoma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.calculadorasoma.model.Numeros;

public interface NumerosRepository extends JpaRepository<Numeros, Long>{

}

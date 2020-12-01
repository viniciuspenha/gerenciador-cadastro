package br.com.viniciuspenha.gerenciadorcadastro.repository;

import br.com.viniciuspenha.gerenciadorcadastro.model.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloRepository extends JpaRepository<Modelo, Integer> {

}
package br.com.viniciuspenha.gerenciadorcadastro.repository;

import br.com.viniciuspenha.gerenciadorcadastro.model.entity.Automovel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutomovelRepository extends JpaRepository<Automovel, Long> {

}
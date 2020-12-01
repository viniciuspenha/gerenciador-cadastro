package br.com.viniciuspenha.gerenciadorcadastro.repository;

import br.com.viniciuspenha.gerenciadorcadastro.model.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {

}
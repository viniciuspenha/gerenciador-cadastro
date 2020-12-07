package br.com.viniciuspenha.gerenciadorcadastro.unit;

import br.com.viniciuspenha.gerenciadorcadastro.model.dto.CadastroAutomovelDTO;
import br.com.viniciuspenha.gerenciadorcadastro.model.entity.Automovel;
import br.com.viniciuspenha.gerenciadorcadastro.model.entity.Marca;
import br.com.viniciuspenha.gerenciadorcadastro.model.entity.Modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class UtilsTest {

    public CadastroAutomovelDTO criaCadastroAutomovelDTO() {
        return new CadastroAutomovelDTO(1, new BigDecimal(100000));
    }

    public Modelo criaModeloComMarca() {
        Marca marca = Marca.builder()
                .id(1)
                .nome("Audi")
                .build();

        return Modelo.builder()
                .id(1)
                .nome("A4")
                .marca(marca)
                .build();
    }

    public Automovel criaAutomovel() {
        return Automovel.builder()
                .id(1L)
                .modelo(criaModeloComMarca())
                .valor(new BigDecimal(100000))
                .dataCadastro(LocalDateTime.now())
                .build();
    }
}
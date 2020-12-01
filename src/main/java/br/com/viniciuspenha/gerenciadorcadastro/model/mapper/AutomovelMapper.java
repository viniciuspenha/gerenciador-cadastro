package br.com.viniciuspenha.gerenciadorcadastro.model.mapper;

import br.com.viniciuspenha.gerenciadorcadastro.model.dto.CadastroAutomovelDTO;
import br.com.viniciuspenha.gerenciadorcadastro.model.dto.ResponseAutomovelDTO;
import br.com.viniciuspenha.gerenciadorcadastro.model.entity.Automovel;
import br.com.viniciuspenha.gerenciadorcadastro.model.entity.Modelo;
import org.springframework.stereotype.Component;

@Component
public class AutomovelMapper {

    public Automovel toAutomovel(CadastroAutomovelDTO cadastroAutomovelDTO, Modelo modelo) {
        return Automovel.builder()
                .modelo(modelo)
                .valor(cadastroAutomovelDTO.getValor())
                .build();
    }

    public ResponseAutomovelDTO toResponseAutomovelDTO(Automovel automovel) {
        return new ResponseAutomovelDTO(
                automovel.getModelo().getMarca().getNome(),
                automovel.getModelo().getNome(),
                automovel.getValor(),
                automovel.getDataCadastro()
        );
    }
}
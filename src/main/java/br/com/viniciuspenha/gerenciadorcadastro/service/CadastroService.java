package br.com.viniciuspenha.gerenciadorcadastro.service;

import br.com.viniciuspenha.gerenciadorcadastro.exception.AutomovelNotFoundException;
import br.com.viniciuspenha.gerenciadorcadastro.exception.ModeloNotFoundException;
import br.com.viniciuspenha.gerenciadorcadastro.model.dto.CadastroAutomovelDTO;
import br.com.viniciuspenha.gerenciadorcadastro.model.entity.Automovel;
import br.com.viniciuspenha.gerenciadorcadastro.model.entity.Modelo;
import br.com.viniciuspenha.gerenciadorcadastro.model.mapper.AutomovelMapper;
import br.com.viniciuspenha.gerenciadorcadastro.repository.AutomovelRepository;
import br.com.viniciuspenha.gerenciadorcadastro.repository.ModeloRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CadastroService {

    private final AutomovelRepository automovelRepository;
    private final AutomovelMapper automovelMapper;
    private final ModeloRepository modeloRepository;

    @Autowired
    public CadastroService(AutomovelRepository automovelRepository, AutomovelMapper automovelMapper,
                           ModeloRepository modeloRepository) {
        this.automovelRepository = automovelRepository;
        this.automovelMapper = automovelMapper;
        this.modeloRepository = modeloRepository;
    }

    public Automovel novoAutomovel(CadastroAutomovelDTO cadastroAutomovelDTO) throws ModeloNotFoundException {
        log.info("CadastroService.novoAutomovel - automovel {}", cadastroAutomovelDTO);

        Modelo modelo = modeloRepository.findById(cadastroAutomovelDTO.getModeloId())
                .orElseThrow(ModeloNotFoundException::new);

        return automovelRepository.save(automovelMapper.toAutomovel(cadastroAutomovelDTO, modelo));
    }

    public List<Automovel> getAutomoveis() {
        log.info("CadastroService.getAutomoveis");
        return automovelRepository.findAll();
    }

    public Automovel getAutomovelById(Long id) throws AutomovelNotFoundException {
        log.info("CadastroService.getAutomovelById - id {}", id);
        return automovelRepository.findById(id).orElseThrow(AutomovelNotFoundException::new);
    }
}
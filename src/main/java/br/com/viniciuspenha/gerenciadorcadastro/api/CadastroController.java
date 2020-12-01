package br.com.viniciuspenha.gerenciadorcadastro.api;

import br.com.viniciuspenha.gerenciadorcadastro.exception.AutomovelNotFoundException;
import br.com.viniciuspenha.gerenciadorcadastro.exception.ModeloNotFoundException;
import br.com.viniciuspenha.gerenciadorcadastro.model.dto.CadastroAutomovelDTO;
import br.com.viniciuspenha.gerenciadorcadastro.model.dto.ResponseAutomovelDTO;
import br.com.viniciuspenha.gerenciadorcadastro.model.mapper.AutomovelMapper;
import br.com.viniciuspenha.gerenciadorcadastro.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/automovel")
public class CadastroController {

    private final CadastroService cadastroService;
    private final AutomovelMapper automovelMapper;

    @Autowired
    public CadastroController(CadastroService cadastroService, AutomovelMapper automovelMapper) {
        this.cadastroService = cadastroService;
        this.automovelMapper = automovelMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseAutomovelDTO novoAutomovel(@Valid @RequestBody CadastroAutomovelDTO cadastroAutomovelDTO) throws ModeloNotFoundException {
        return automovelMapper.toResponseAutomovelDTO(cadastroService.novoAutomovel(cadastroAutomovelDTO));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ResponseAutomovelDTO> getAutomoveis() {
        return cadastroService.getAutomoveis()
                .stream()
                .map(automovelMapper::toResponseAutomovelDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseAutomovelDTO getAutomovelById(@PathVariable("id") Long id) throws AutomovelNotFoundException {
        return automovelMapper.toResponseAutomovelDTO(cadastroService.getAutomovelById(id));
    }
}
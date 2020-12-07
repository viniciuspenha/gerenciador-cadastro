package br.com.viniciuspenha.gerenciadorcadastro.unit;

import br.com.viniciuspenha.gerenciadorcadastro.exception.AutomovelNotFoundException;
import br.com.viniciuspenha.gerenciadorcadastro.exception.ModeloNotFoundException;
import br.com.viniciuspenha.gerenciadorcadastro.model.dto.CadastroAutomovelDTO;
import br.com.viniciuspenha.gerenciadorcadastro.model.entity.Automovel;
import br.com.viniciuspenha.gerenciadorcadastro.model.entity.Modelo;
import br.com.viniciuspenha.gerenciadorcadastro.model.mapper.AutomovelMapper;
import br.com.viniciuspenha.gerenciadorcadastro.repository.AutomovelRepository;
import br.com.viniciuspenha.gerenciadorcadastro.repository.ModeloRepository;
import br.com.viniciuspenha.gerenciadorcadastro.service.CadastroService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest extends UtilsTest {

    @InjectMocks
    private CadastroService cadastroService;

    @Mock
    private AutomovelRepository automovelRepository;

    @Mock
    private ModeloRepository modeloRepository;

    @Mock
    private AutomovelMapper automovelMapper;

    @Test
    public void testaCriacaoNovoAutomovel() throws ModeloNotFoundException {
        CadastroAutomovelDTO cadastroAutomovelDTO = criaCadastroAutomovelDTO();
        Modelo modelo = criaModeloComMarca();
        Automovel automovel = criaAutomovel();

        when(modeloRepository.findById(cadastroAutomovelDTO.getModeloId())).thenReturn(Optional.of(modelo));
        when(automovelMapper.toAutomovel(cadastroAutomovelDTO, modelo)).thenReturn(automovel);
        when(automovelRepository.save(automovel)).thenReturn(automovel);

        Automovel novoAutomovel = cadastroService.novoAutomovel(cadastroAutomovelDTO);

        assertEquals((Long) 1L, novoAutomovel.getId());
        assertEquals(cadastroAutomovelDTO.getValor(), novoAutomovel.getValor());
        assertEquals(modelo, novoAutomovel.getModelo());
    }

    @Test
    public void testaGetAutomoveis() {
        Automovel automovel1 = criaAutomovel();
        Automovel automovel2 = criaAutomovel();
        automovel2.setId(2L);

        List<Automovel> automoveis = new ArrayList<>();
        automoveis.add(automovel1);
        automoveis.add(automovel2);

        when(automovelRepository.findAll()).thenReturn(automoveis);

        List<Automovel> automoveisResponse = cadastroService.getAutomoveis();

        assertEquals(automoveis, automoveisResponse);
    }

    @Test
    public void testaGetAutomovelById() throws AutomovelNotFoundException {
        Automovel automovel = criaAutomovel();

        when(automovelRepository.findById(anyLong())).thenReturn(Optional.of(automovel));

        Automovel automovelById = cadastroService.getAutomovelById(1L);

        assertEquals(automovel, automovelById);
    }
}
package br.com.viniciuspenha.gerenciadorcadastro.unit;

import br.com.viniciuspenha.gerenciadorcadastro.model.dto.CadastroAutomovelDTO;
import br.com.viniciuspenha.gerenciadorcadastro.model.dto.ResponseAutomovelDTO;
import br.com.viniciuspenha.gerenciadorcadastro.model.entity.Automovel;
import br.com.viniciuspenha.gerenciadorcadastro.model.entity.Modelo;
import br.com.viniciuspenha.gerenciadorcadastro.model.mapper.AutomovelMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MapperTest extends UtilsTest {

    @Test
    public void testaConversaoDTOParaEntity() {
        AutomovelMapper automovelMapper = new AutomovelMapper();
        CadastroAutomovelDTO cadastroAutomovelDTO = criaCadastroAutomovelDTO();
        Modelo modelo = this.criaModeloComMarca();
        Automovel automovel = automovelMapper.toAutomovel(cadastroAutomovelDTO, modelo);
        assertEquals(modelo, automovel.getModelo());
        assertEquals(cadastroAutomovelDTO.getValor(), automovel.getValor());
    }

    @Test
    public void testaConversaoEntityParaDTO() {
        AutomovelMapper automovelMapper = new AutomovelMapper();
        Automovel automovel = this.criaAutomovel();
        ResponseAutomovelDTO responseAutomovelDTO = automovelMapper.toResponseAutomovelDTO(automovel);
        assertEquals(automovel.getId(), responseAutomovelDTO.getId());
        assertEquals(automovel.getModelo().getNome(), responseAutomovelDTO.getModelo());
        assertEquals(automovel.getModelo().getMarca().getNome(), responseAutomovelDTO.getMarca());
        assertEquals(automovel.getValor(), responseAutomovelDTO.getValor());
        assertEquals(automovel.getDataCadastro(), responseAutomovelDTO.getDataCadastro());
    }
}
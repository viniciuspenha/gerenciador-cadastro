package br.com.viniciuspenha.gerenciadorcadastro.integracao;

import br.com.viniciuspenha.gerenciadorcadastro.model.dto.CadastroAutomovelDTO;
import br.com.viniciuspenha.gerenciadorcadastro.model.dto.ResponseAutomovelDTO;
import br.com.viniciuspenha.gerenciadorcadastro.unit.UtilsTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class CadastroControllerTest extends UtilsTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TokenService tokenService;

    public static final String ENDPOINT = "/automovel";
    private String token;

    @Before
    public void setUp() {
        this.token = tokenService.getToken();
    }

    @Test
    public void testaNovoAutomovel() throws Exception {
        CadastroAutomovelDTO cadastroAutomovelDTO = criaCadastroAutomovelDTO();
        String json = objectMapper.writeValueAsString(cadastroAutomovelDTO);

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder =
                MockMvcRequestBuilders
                        .post(ENDPOINT)
                        .header("Authorization", token)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(json);

        ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilder);
        ResponseAutomovelDTO responseAutomovelDTO = objectMapper.readValue(resultActions.andReturn().getResponse().getContentAsString(), ResponseAutomovelDTO.class);

        assertEquals(cadastroAutomovelDTO.getValor(), responseAutomovelDTO.getValor());
    }

    @Test
    public void testaListAutomoveis() throws Exception {
        this.testaNovoAutomovel();

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder =
                MockMvcRequestBuilders
                        .get(ENDPOINT)
                        .accept(MediaType.APPLICATION_JSON);

        ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilder);
        List<ResponseAutomovelDTO> responseAutomovelDTO = objectMapper.readValue(resultActions.andReturn().getResponse().getContentAsString(), List.class);

        assertEquals(responseAutomovelDTO.size(), 1);
    }

    @Test
    public void testaGetAutomovelById() throws Exception {
        this.testaNovoAutomovel();

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder =
                MockMvcRequestBuilders
                        .get(ENDPOINT + "/1")
                        .accept(MediaType.APPLICATION_JSON);

        ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilder);
        ResponseAutomovelDTO responseAutomovelDTO = objectMapper.readValue(resultActions.andReturn().getResponse().getContentAsString(), ResponseAutomovelDTO.class);

        assertEquals(responseAutomovelDTO.getModelo(), "A1");
        assertEquals(responseAutomovelDTO.getMarca(), "Audi");
    }
}
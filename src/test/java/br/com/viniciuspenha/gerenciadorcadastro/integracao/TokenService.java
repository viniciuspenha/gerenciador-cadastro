package br.com.viniciuspenha.gerenciadorcadastro.integracao;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
@Data
public class TokenService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${token.url}")
    private String url;

    @Value("${token.authorization}")
    private String authorization;

    @Value("${token.username}")
    private String username;

    @Value("${token.password}")
    private String password;

    @Value("${token.scope}")
    private String scope;

    @Value("${token.grant_type}")
    private String grandType;

    public String getToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authorization);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("scope", scope);
        map.add("grant_type", grandType);
        map.add("username", username);
        map.add("password", password);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        TokenResponseDTO token = restTemplate.exchange(url, HttpMethod.POST, request, TokenResponseDTO.class).getBody();

        return token.getTokenType() + token.getAccessToken();
    }
}
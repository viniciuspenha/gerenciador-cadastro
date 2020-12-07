package br.com.viniciuspenha.gerenciadorcadastro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigTests {

    @Bean
    public RestTemplate criaRestTemplate() {
        return new RestTemplate();
    }
}
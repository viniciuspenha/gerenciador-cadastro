package br.com.viniciuspenha.gerenciadorcadastro.model.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseAutomovelDTO {

    private Long id;
    private String marca;
    private String modelo;
    private BigDecimal valor;
    private LocalDateTime dataCadastro;
}
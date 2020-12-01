package br.com.viniciuspenha.gerenciadorcadastro.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModeloDTO {

    @NotNull
    private Integer id;

    @NotNull
    private String nome;

    @NotNull
    @JsonProperty("marca")
    private MarcaDTO marcaDTO;
}
package br.com.viniciuspenha.gerenciadorcadastro.model.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarcaDTO {

    @NotNull
    private Integer id;

    @NotNull
    private String nome;
}
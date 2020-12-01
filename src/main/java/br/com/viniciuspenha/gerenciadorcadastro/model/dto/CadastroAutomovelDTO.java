package br.com.viniciuspenha.gerenciadorcadastro.model.dto;

import lombok.*;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CadastroAutomovelDTO {

    @NotNull
    private Integer modeloId;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private BigDecimal valor;
}
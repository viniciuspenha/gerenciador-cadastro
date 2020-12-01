package br.com.viniciuspenha.gerenciadorcadastro.model.dto;

import lombok.*;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CadastroAutomovelDTO {

    @NotNull(message = "Modelo nao pode ser nulo")
    private Integer modeloId;

    @NotNull(message = "Valor nao pode ser nulo")
    @Digits(integer = 10, fraction = 2, message = "Valor inválido. Seguir o padrão <10 dígitos>.<2 dígitos>")
    private BigDecimal valor;
}
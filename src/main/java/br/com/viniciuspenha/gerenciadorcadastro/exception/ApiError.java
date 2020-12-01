package br.com.viniciuspenha.gerenciadorcadastro.exception;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ApiError {

    private int status;
    private String error;
    private String message;
    private String path;
}
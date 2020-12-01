package br.com.viniciuspenha.gerenciadorcadastro.exception;

public class AutomovelNotFoundException extends Exception {

    public AutomovelNotFoundException() {
        super("Automovel nao encontrado!");
    }
}
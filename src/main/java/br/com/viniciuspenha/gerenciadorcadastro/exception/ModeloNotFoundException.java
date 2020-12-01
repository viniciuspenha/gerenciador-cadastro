package br.com.viniciuspenha.gerenciadorcadastro.exception;

public class ModeloNotFoundException extends Exception {

    public ModeloNotFoundException() {
        super("Modelo nao encontrado!");
    }
}
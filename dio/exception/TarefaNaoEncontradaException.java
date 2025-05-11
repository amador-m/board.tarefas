package br.com.dio.exception;

public class TarefaNaoEncontradaException extends RuntimeException {
    public TarefaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}

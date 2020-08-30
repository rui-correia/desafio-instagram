package br.com.braz.rui.desafioinstagram.services.exceptions;

public class NullValueException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public NullValueException(String mensagem){
        super(mensagem);
    }

    public NullValueException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}

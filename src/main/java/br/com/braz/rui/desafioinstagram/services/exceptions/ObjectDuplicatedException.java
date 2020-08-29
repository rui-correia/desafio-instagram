package br.com.braz.rui.desafioinstagram.services.exceptions;

public class ObjectDuplicatedException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ObjectDuplicatedException(String mensagem){
        super(mensagem);
    }

    public ObjectDuplicatedException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}

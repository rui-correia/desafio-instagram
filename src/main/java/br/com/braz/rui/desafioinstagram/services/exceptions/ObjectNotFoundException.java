package br.com.braz.rui.desafioinstagram.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String mensagem){
        super(mensagem);
    }

    public ObjectNotFoundException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}

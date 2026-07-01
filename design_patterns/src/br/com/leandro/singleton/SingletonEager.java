package br.com.leandro.singleton;

/*
 * Singleton Apressada
 * @author LeandroMenoci
 * */

public class SingletonEager {

    private static SingletonEager instancia = new SingletonEager();

    private SingletonEager() {
        super();
    }

    public static  SingletonEager getInstancia() {
        return instancia;
    }
}

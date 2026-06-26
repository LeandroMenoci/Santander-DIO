package br.com.leandro;

import br.com.leandro.model.Person;
import br.com.leandro.model.User;
import br.com.leandro.processor.SerializerProcessor;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        var processor = new SerializerProcessor();
        System.out.println(processor.serializer(new Person(1, "Joao da Silva", 26)));
        System.out.println(processor.serializer(new User(2, "Maria do Carmo", 32, 3222.23)));

    }
}

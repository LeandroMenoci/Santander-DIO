package br.com.leandro;

import br.com.leandro.model.PersonBuilder;

public class Main {
    public static void main(String[] args) {
        var person = new PersonBuilder()
                .id(1)
                .name("Joao")
                .build();

        System.out.println(person);
    }
}

package br.com.leandro.model;

import br.com.leandro.annotation.FieldFormatEnum;
import br.com.leandro.annotation.SerializerType;

@SerializerType
public record User(long id,
                   String fullName,
                   int age,
                   double salary) {

}

package br.com.leandro.model;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
public class UserModel {

    private int code;
    private String userName;
    private LocalDate birthday;
}

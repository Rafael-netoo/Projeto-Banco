package com.example.projetobanco;

import models.*;
import negocio.ServidorBanco;

import java.time.LocalDate;

public class main {

    public static void main(String[] args) {
        ServidorBanco servidor = ServidorBanco.getInstance();

        Usuario adm = new Administrador("Marcos",LocalDate.of(1970,03,04),"657123987","001", "M","marcos@gmail.com", "adm123");
        Usuario cliente1 = new Cliente("Maria", LocalDate.of(1998,05,19),"123456789","01","F","maria@gmail.com","123456","Jornalista",3000,"Recife");
        Usuario cliente2 = new Cliente("José", LocalDate.of(1980,07,10),"567891234","02","M","rafael@gmail.com","456123","Policial",6000,"Abreu");
        Usuario cliente3 = new Cliente("Camila", LocalDate.of(2002,01,30),"127834569","03","F","camila@gmail.com","124563","Juíza",15000,"Paulista");

        //Conta conta1 = new ContaCorrente(cliente1,"123-4","001", "corrente",);
        //Conta conta2 = new ContaCorrente(cliente2,"231-4","001", "corrente",);
        //Conta conta3 = new ContaCorrente(cliente3,"123-4","237", "corrente",);
        //Conta conta4 = new ContaPoupanca(cliente1,"123-4","001", "poupanca",);
        //Conta conta5 = new ContaPoupanca(cliente2,"231-4","001", "poupanca",);

        //Cartao cartao1 = new Cartao(conta1, LocalDate.of(2020,06,20),"23458765","564",LocalDate.of(2024,06,20));
        //Cartao cartao2 = new Cartao(conta2, LocalDate.of(2021,07,15),"23458765","123",LocalDate.of(2025,12,03));
        //Cartao cartao3 = new Cartao(conta3, LocalDate.of(2022,02,10),"23458765","321",LocalDate.of(2024,01,9));
    }
}

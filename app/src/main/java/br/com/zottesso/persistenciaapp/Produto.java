package br.com.zottesso.persistenciaapp;

import com.orm.SugarRecord;

import java.text.DecimalFormat;

/*
 É necessário colocar o extends SugarRecord para que os métodos
 de manipulação do objeto no banco sejam herdados de SugarRecord
*/
public class Produto extends SugarRecord {


    private String nome;
    private double valor;
    private DecimalFormat df;

    // Sugar ORM precisa de um construtor vazio
    // Sem isso, o framework não funciona

    public Produto() {

    }

    @Override
    public String toString() {
        return ("Nome Produto: " + nome + '\n' + "Preço: R$" + (valor));

    }
    // Gets e sets para manipular os atributos privados

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}

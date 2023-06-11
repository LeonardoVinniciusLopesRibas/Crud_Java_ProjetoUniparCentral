/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.unipar.central.exceptions;

public class SaldoZeradoException extends Exception{

    public SaldoZeradoException(String campo) {
        super("O campo "+campo+" tem que ser iniciado em 0");
    }
    
}

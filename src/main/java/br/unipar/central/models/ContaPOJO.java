package br.unipar.central.models;

import br.unipar.central.enums.TipoContaEnum;

public class ContaPOJO {

    private int id;
    private String numero;
    private String digito;
    private double saldo;
    private TipoContaEnum tipoConta;
    private String ra;
    private AgenciaPOJO agencia;
    private PessoaPOJO pessoa;

    public ContaPOJO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDigito() {
        return digito;
    }

    public void setDigito(String digito) {
        this.digito = digito;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public TipoContaEnum getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoContaEnum tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public AgenciaPOJO getAgencia() {
        return agencia;
    }

    public void setAgencia(AgenciaPOJO agencia) {
        this.agencia = agencia;
    }

    public PessoaPOJO getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaPOJO pessoa) {
        this.pessoa = pessoa;
    }

    public void message(){
        System.out.println("---------------------------------DADOS----------------------------------");
    }
    
    @Override
    public String toString() {
        return "\nid=" + id + ", numero=" + numero + ", digito=" + digito + ", saldo=" + saldo + ", tipoConta=" + tipoConta + ", ra=" + ra + ", agencia=" + agencia + ", pessoa=" + pessoa + '}';
    }

}

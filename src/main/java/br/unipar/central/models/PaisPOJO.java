package br.unipar.central.models;

public class PaisPOJO {

    private int id;
    private String nome;
    private String sigla;
    private String ra;

    public PaisPOJO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }
    
    public void message(){
        System.out.println("---------------------------------DADOS----------------------------------");
    }

    @Override
    public String toString() {
        return "\nid=" + id + ", nome=" + nome + ", sigla=" + sigla + ", ra=" + ra + '}';
    }
    
    

}

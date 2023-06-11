package br.unipar.central.models;

public class PessoaJuridicaPOJO {

    private String razaoSocial;
    private String nomeFantasia;
    private String CNPJ;
    private String cnaePrincipal;
    private PessoaPOJO pessoa;

    public PessoaJuridicaPOJO() {
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getCnaePrincipal() {
        return cnaePrincipal;
    }

    public void setCnaePrincipal(String cnaePrincipal) {
        this.cnaePrincipal = cnaePrincipal;
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
        return "\nRazaoSocial=" + razaoSocial + ", nomeFantasia=" + nomeFantasia + ", CNPJ=" + CNPJ + ", cnaePrincipal=" + cnaePrincipal + ", pessoa=" + pessoa + '}';
    }

}

package br.unipar.central.services;

import br.unipar.central.DAO.PessoaJuridicaDAO;
import br.unipar.central.exceptions.CampoEspecificoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeOuClasseEmBrancoOuNaoInformadaException;
import br.unipar.central.exceptions.TamanhoMaximoDoCampoExcedidoException;
import br.unipar.central.exceptions.ValorInvalidoException;
import br.unipar.central.models.PessoaJuridicaPOJO;
import java.sql.SQLException;
import java.util.List;

public class PessoaJuridicaService {

    public void validar(PessoaJuridicaPOJO PJPJ) throws
            EntidadeOuClasseEmBrancoOuNaoInformadaException,
            CampoEspecificoNaoInformadoException,
            TamanhoMaximoDoCampoExcedidoException,
            ValorInvalidoException {

        if (PJPJ == null) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("pais");
        }

        if (PJPJ.getRazaoSocial() == null
                || PJPJ.getRazaoSocial().isEmpty()
                || PJPJ.getRazaoSocial().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("razão social");
        }

        if ((PJPJ.getRazaoSocial().length() > 60)) {
            throw new TamanhoMaximoDoCampoExcedidoException("razão social", 60);
        }
        
        if (PJPJ.getCNPJ()== null
                || PJPJ.getCNPJ().isEmpty()
                || PJPJ.getCNPJ().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("cpf");
        }
//08.482.400/0001-92
        if ((PJPJ.getCNPJ().length() > 18)) {
            throw new TamanhoMaximoDoCampoExcedidoException("cpf", 18);
        }

        if (PJPJ.getNomeFantasia() == null
                || PJPJ.getNomeFantasia().isEmpty()
                || PJPJ.getNomeFantasia().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("nome fantasia");
        }

        if ((PJPJ.getNomeFantasia().length() > 60)) {
            throw new TamanhoMaximoDoCampoExcedidoException("nome fantasia", 60);
        }

        if (PJPJ.getCnaePrincipal() == null
                || PJPJ.getCnaePrincipal().isEmpty()
                || PJPJ.getCnaePrincipal().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("cnae");
        }

        if ((PJPJ.getCnaePrincipal().length() > 100)) {
            throw new TamanhoMaximoDoCampoExcedidoException("cnae", 100);
        }

        if (PJPJ.getPessoa() == null) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("pessoa");
        }

    }

    public List<PessoaJuridicaPOJO> findAll() throws SQLException {

        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        List<PessoaJuridicaPOJO> resultado = pessoaJuridicaDAO.findAll();

        return resultado;
    }

    public PessoaJuridicaPOJO findById(String cnpj) throws SQLException, TamanhoMaximoDoCampoExcedidoException, Exception {

        if (cnpj.length() <= 0) {
            throw new TamanhoMaximoDoCampoExcedidoException("cnpj", 1);
        }

        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        PessoaJuridicaPOJO retorno = pessoaJuridicaDAO.findById(cnpj);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar um país com o id: " + cnpj + " informado");
        }

        return pessoaJuridicaDAO.findById(cnpj);
    }

    public void insert(PessoaJuridicaPOJO pessoaJuridica) throws SQLException, EntidadeOuClasseEmBrancoOuNaoInformadaException, CampoEspecificoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException {
        validar(pessoaJuridica);
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        pessoaJuridicaDAO.insert(pessoaJuridica);
    }

    public void update(PessoaJuridicaPOJO pessoaJuridica) throws SQLException, EntidadeOuClasseEmBrancoOuNaoInformadaException, CampoEspecificoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException {
        validar(pessoaJuridica);
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        pessoaJuridicaDAO.update(pessoaJuridica);
    }

    public void delete(String cnpj) throws SQLException {
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        pessoaJuridicaDAO.delete(cnpj);

    }
}

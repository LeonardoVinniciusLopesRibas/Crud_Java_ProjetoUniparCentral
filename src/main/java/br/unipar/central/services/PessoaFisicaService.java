package br.unipar.central.services;

import br.unipar.central.DAO.PessoaFisicaDAO;
import br.unipar.central.exceptions.CampoEspecificoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeOuClasseEmBrancoOuNaoInformadaException;
import br.unipar.central.exceptions.TamanhoMaximoDoCampoExcedidoException;
import br.unipar.central.exceptions.ValorInvalidoException;
import br.unipar.central.models.PessoaFisicaPOJO;
import java.sql.SQLException;
import java.util.List;

public class PessoaFisicaService {

    public void validar(PessoaFisicaPOJO pessoaFP) throws
            EntidadeOuClasseEmBrancoOuNaoInformadaException,
            CampoEspecificoNaoInformadoException,
            TamanhoMaximoDoCampoExcedidoException,
            ValorInvalidoException {

        if (pessoaFP == null) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("pessoa física");
        }

        if (pessoaFP.getNome() == null
                || pessoaFP.getNome().isEmpty()
                || pessoaFP.getNome().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("nome");
        }

        if ((pessoaFP.getNome().length() > 60)) {
            throw new TamanhoMaximoDoCampoExcedidoException("nome", 60);
        }

        if (pessoaFP.getCpf() == null
                || pessoaFP.getCpf().isEmpty()
                || pessoaFP.getCpf().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("cpf");
        }

        if ((pessoaFP.getCpf().length() > 11)) {
            throw new TamanhoMaximoDoCampoExcedidoException("cpf", 11);
        }

        if (pessoaFP.getRg() == null
                || pessoaFP.getRg().isEmpty()
                || pessoaFP.getRg().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("rg");
        }

        if ((pessoaFP.getRg().length() == 15)) {
            throw new TamanhoMaximoDoCampoExcedidoException("rg", 15);
        }
        
        if (pessoaFP.getPessoa() == null) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("pessoa");
        }
    }

    public List<PessoaFisicaPOJO> findAll() throws SQLException {

        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        List<PessoaFisicaPOJO> resultado = pessoaFisicaDAO.findAll();

        return resultado;
    }

    public PessoaFisicaPOJO findById(String cpf) throws SQLException, TamanhoMaximoDoCampoExcedidoException, Exception {

        if (cpf.length() <= 0) {
            throw new TamanhoMaximoDoCampoExcedidoException("cpf", 1);
        }

        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        PessoaFisicaPOJO retorno = pessoaFisicaDAO.findById(cpf);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar um país com o id: " + cpf + " informado");
        }

        return pessoaFisicaDAO.findById(cpf);
    }

    public void insert(PessoaFisicaPOJO pessoaFisica) throws SQLException, EntidadeOuClasseEmBrancoOuNaoInformadaException, CampoEspecificoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException {
        validar(pessoaFisica);
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.insert(pessoaFisica);
    }

    public void update(PessoaFisicaPOJO pessoaFisica) throws SQLException, EntidadeOuClasseEmBrancoOuNaoInformadaException, CampoEspecificoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException {
        validar(pessoaFisica);
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.update(pessoaFisica);
    }

    public void delete(String cpf) throws SQLException {
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.delete(cpf);

    }
}

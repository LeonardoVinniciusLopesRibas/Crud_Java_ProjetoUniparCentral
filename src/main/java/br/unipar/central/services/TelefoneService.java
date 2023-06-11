package br.unipar.central.services;

import br.unipar.central.DAO.TelefoneDAO;
import br.unipar.central.exceptions.CampoEspecificoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeOuClasseEmBrancoOuNaoInformadaException;
import br.unipar.central.exceptions.TamanhoMaximoDoCampoExcedidoException;
import br.unipar.central.exceptions.ValorInvalidoException;
import br.unipar.central.models.TelefonePOJO;
import br.unipar.central.models.TelefonePOJO;
import java.sql.SQLException;
import java.util.List;

public class TelefoneService {

    public void validar(TelefonePOJO telefone) throws
            EntidadeOuClasseEmBrancoOuNaoInformadaException,
            CampoEspecificoNaoInformadoException,
            TamanhoMaximoDoCampoExcedidoException,
            ValorInvalidoException {

        String idStr = String.valueOf(telefone.getId());

        if (telefone == null) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("telefone");
        }

        if (telefone.getId() == 0) {
            throw new CampoEspecificoNaoInformadoException("id");
        }

        if (!idStr.matches("\\d+")) {
            throw new ValorInvalidoException("id");
        }

        if (telefone.getNumero() == null
                || telefone.getNumero().isEmpty()
                || telefone.getNumero().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("numero do telefone");
        }

        if ((telefone.getNumero().length() > 8)) {
            throw new TamanhoMaximoDoCampoExcedidoException("numero do telefone", 8);
        }

        if (telefone.getOperadora() == null) {
            throw new CampoEspecificoNaoInformadoException("operadora");
        }

        if (telefone.getRa() == null
                || telefone.getRa().isEmpty()
                || telefone.getRa().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("ra");
        }

        if ((telefone.getRa().length() > 8)) {
            throw new TamanhoMaximoDoCampoExcedidoException("ra", 8);
        }

        if (telefone.getAgencia() == null) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("agencia");
        }

        if (telefone.getPessoa() == null) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("pessoa");
        }

    }

    public List<TelefonePOJO> findAll() throws SQLException {

        TelefoneDAO telefoneDAO = new TelefoneDAO();
        List<TelefonePOJO> resultado = telefoneDAO.findAll();

        return resultado;
    }

    public TelefonePOJO findById(int id) throws SQLException, TamanhoMaximoDoCampoExcedidoException, Exception {

        if (id <= 0) {
            throw new TamanhoMaximoDoCampoExcedidoException("id", 1);
        }

        TelefoneDAO telefoneDAO = new TelefoneDAO();
        TelefonePOJO retorno = telefoneDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar um país com o id: " + id + " informado");
        }

        return telefoneDAO.findById(id);
    }

    public void insert(TelefonePOJO telefone) throws SQLException, EntidadeOuClasseEmBrancoOuNaoInformadaException, CampoEspecificoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException {
        validar(telefone);
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        telefoneDAO.insert(telefone);
    }

    public void update(TelefonePOJO telefone) throws SQLException, EntidadeOuClasseEmBrancoOuNaoInformadaException, CampoEspecificoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException {
        validar(telefone);
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        telefoneDAO.update(telefone);
    }

    public void delete(int id) throws SQLException {
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        telefoneDAO.delete(id);

    }
}

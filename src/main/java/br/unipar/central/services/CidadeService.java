package br.unipar.central.services;

import br.unipar.central.DAO.CidadeDAO;
import br.unipar.central.DAO.PaisDAO;
import br.unipar.central.exceptions.CampoEspecificoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeOuClasseEmBrancoOuNaoInformadaException;
import br.unipar.central.exceptions.TamanhoMaximoDoCampoExcedidoException;
import br.unipar.central.exceptions.ValorInvalidoException;
import br.unipar.central.models.CidadePOJO;
import br.unipar.central.models.PaisPOJO;
import java.sql.SQLException;
import java.util.List;

public class CidadeService {

    public void validar(CidadePOJO cidade) throws
            EntidadeOuClasseEmBrancoOuNaoInformadaException,
            CampoEspecificoNaoInformadoException,
            TamanhoMaximoDoCampoExcedidoException,
            ValorInvalidoException {

        String idStr = String.valueOf(cidade.getId());

        if (cidade == null) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("cidade");
        }

        if (cidade.getId() == 0) {
            throw new CampoEspecificoNaoInformadoException("id");
        }

        if (!idStr.matches("\\d+")) {
            throw new ValorInvalidoException("id");
        }

        if (cidade.getNome() == null
                || cidade.getNome().isEmpty()
                || cidade.getNome().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("nome da cidade");
        }

        if ((cidade.getNome().length() > 30)) {
            throw new TamanhoMaximoDoCampoExcedidoException("nome da cidade", 30);
        }

        if (cidade.getRa() == null
                || cidade.getRa().isEmpty()
                || cidade.getRa().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("ra");
        }

        if ((cidade.getRa().length() > 8)) {
            throw new TamanhoMaximoDoCampoExcedidoException("ra", 8);
        }

    }

    public List<CidadePOJO> findAll() throws SQLException {

        CidadeDAO cidadeDAO = new CidadeDAO();
        List<CidadePOJO> resultado = cidadeDAO.findAll();

        return resultado;
    }

    public CidadePOJO findById(int id) throws SQLException, TamanhoMaximoDoCampoExcedidoException, Exception {

        if (id <= 0) {
            throw new TamanhoMaximoDoCampoExcedidoException("id", 1);
        }

        CidadeDAO cidadeDAO = new CidadeDAO();
        CidadePOJO retorno = cidadeDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar um país com o id: " + id + " informado");
        }

        return cidadeDAO.findById(id);
    }

    public void insert(CidadePOJO cidade) throws SQLException, EntidadeOuClasseEmBrancoOuNaoInformadaException, CampoEspecificoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException {
        validar(cidade);
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.insert(cidade);
    }

    public void update(CidadePOJO cidade) throws SQLException, EntidadeOuClasseEmBrancoOuNaoInformadaException, CampoEspecificoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException {
        validar(cidade);
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.update(cidade);
    }

    public void delete(int id) throws SQLException {
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.delete(id);

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.services;

import br.unipar.central.DAO.TransacaoDAO;
import br.unipar.central.exceptions.CampoEspecificoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeOuClasseEmBrancoOuNaoInformadaException;
import br.unipar.central.exceptions.TamanhoMaximoDoCampoExcedidoException;
import br.unipar.central.exceptions.ValorInvalidoException;
import br.unipar.central.models.TransacaoPOJO;
import br.unipar.central.models.TelefonePOJO;
import br.unipar.central.models.TransacaoPOJO;
import java.sql.SQLException;
import java.util.List;

public class TransacaoService {

    public void validar(TransacaoPOJO transacao) throws
            EntidadeOuClasseEmBrancoOuNaoInformadaException,
            CampoEspecificoNaoInformadoException,
            TamanhoMaximoDoCampoExcedidoException {
        if (transacao == null) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("transacao");
        }

        if (transacao.getId() == 0) {
            throw new CampoEspecificoNaoInformadoException("id");
        }

        if (transacao.getValor() == 0) {
            throw new CampoEspecificoNaoInformadoException("saldo em conta");
        }

        if (transacao.getDatahora()== null) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("Data e Hora da transação");
        }
        
        if ((transacao.getRa().length() > 8)) {
            throw new TamanhoMaximoDoCampoExcedidoException("ra", 8);
        }

        if (transacao.getTipo() == null) {
            throw new CampoEspecificoNaoInformadoException("tipo da transação");
        }

        if (transacao.getRa() == null
                || transacao.getRa().isEmpty()
                || transacao.getRa().isBlank()) {
            throw new CampoEspecificoNaoInformadoException("ra");
        }

        if ((transacao.getRa().length() > 8)) {
            throw new TamanhoMaximoDoCampoExcedidoException("ra", 8);
        }

        if (transacao.getConta_destino() == 0) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("agencia");
        }


        if (transacao.getConta_origem() == 0) {
            throw new EntidadeOuClasseEmBrancoOuNaoInformadaException("pessoa");
        }

    }

    public List<TransacaoPOJO> findAll() throws SQLException {

        TransacaoDAO transacaoDAO = new TransacaoDAO();
        List<TransacaoPOJO> resultado = transacaoDAO.findAll();

        return resultado;
    }

    public TransacaoPOJO findById(int id) throws SQLException, TamanhoMaximoDoCampoExcedidoException, Exception {

        if (id <= 0) {
            throw new TamanhoMaximoDoCampoExcedidoException("id", 1);
        }

        TransacaoDAO transacaoDAO = new TransacaoDAO();
        TransacaoPOJO retorno = transacaoDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar um país com o id: " + id + " informado");
        }

        return transacaoDAO.findById(id);
    }

    public void insert(TransacaoPOJO transacao) throws SQLException, EntidadeOuClasseEmBrancoOuNaoInformadaException, CampoEspecificoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException {
        validar(transacao);
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        transacaoDAO.insert(transacao);
    }

    public void update(TransacaoPOJO transacao) throws SQLException, EntidadeOuClasseEmBrancoOuNaoInformadaException, CampoEspecificoNaoInformadoException, TamanhoMaximoDoCampoExcedidoException, ValorInvalidoException {
        validar(transacao);
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        transacaoDAO.update(transacao);
    }

    public void delete(int id) throws SQLException {
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        transacaoDAO.delete(id);

    }
}

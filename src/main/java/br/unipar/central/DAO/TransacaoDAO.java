package br.unipar.central.DAO;

import br.unipar.central.enums.TipoTransacaoEnum;
import br.unipar.central.models.TransacaoPOJO;
import br.unipar.central.util.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDAO {

    private static final String INSERT = "INSERT INTO transacao(id, valor, datahora, tipo, ra, conta_origem, conta_destino) VALUES(?, ?, ?, ?::INTEGER, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT id, datahora, valor, tipo, ra, conta_origem, conta_destino FROM transacao ";

    private static final String FIND_BY_ID = "SELECT id, datahora, valor, tipo, ra, conta_origem, conta_destino FROM transacao WHERE id = ? ";

    private static final String DELETE_BY_ID = "DELETE FROM transacao WHERE id = ?";

    private static final String UPDATE = "UPDATE transacao SET valor = ?, datahora = ?, tipo = ?, ra = ?, conta_origem = ?, conta_destino = ? WHERE id = ?";

    public List<TransacaoPOJO> findAll() throws SQLException {
        ArrayList<TransacaoPOJO> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            conn = new DataBase().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                TransacaoPOJO transacao = new TransacaoPOJO();
                transacao.setId(rs.getInt("id"));
                transacao.setValor(Double.parseDouble(rs.getString("valor")));
                transacao.setDatahora(rs.getTimestamp("datahora"));
                transacao.setTipo(TipoTransacaoEnum.paraEnum(rs.getInt("tipo")));
                transacao.setRa(rs.getString("ra"));
                transacao.setConta_origem(rs.getInt("conta_origem"));
                transacao.setConta_destino(rs.getInt("conta_destino"));

                retorno.add(transacao);
            }
        } finally {

            if (conn != null) {
                conn.close();
            }

            if (conn != null) {
                pstmt.close();
            }
        }

        return retorno;
    }

    public TransacaoPOJO findById(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        TransacaoPOJO retorno = null;

        try {
            conn = new DataBase().getConnection();

            pstmt = conn.prepareStatement(FIND_BY_ID);

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new TransacaoPOJO();
                retorno.setId(rs.getInt("id"));
                retorno.setValor(Double.parseDouble(rs.getString("valor")));
                retorno.setDatahora(rs.getTimestamp("datahora"));
                retorno.setTipo(TipoTransacaoEnum.paraEnum(rs.getInt("tipo")));
                retorno.setRa(rs.getString("ra"));
                retorno.setConta_origem(rs.getInt("conta_origem"));
                retorno.setConta_destino(rs.getInt("conta_destino"));

            }
        } finally {

            if (rs != null) {
                rs.close();
            }

            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return retorno;
    }

    public void insert(TransacaoPOJO transacao) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(INSERT);

            pstmt.setInt(1, transacao.getId());
            pstmt.setDouble(2, transacao.getValor());
            pstmt.setTimestamp(3, transacao.getDatahora());
            pstmt.setInt(4, mapearTipoConta(transacao.getTipo()));
            pstmt.setString(5, transacao.getRa());
            pstmt.setInt(6, transacao.getConta_origem());
            pstmt.setInt(7, transacao.getConta_destino());
            pstmt.executeUpdate();
        } finally {

            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

    public void update(TransacaoPOJO transacao) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

            pstmt.setDouble(1, transacao.getValor());
            pstmt.setTimestamp(2, transacao.getDatahora());
            pstmt.setInt(3, mapearTipoConta(transacao.getTipo()));
            pstmt.setString(4, transacao.getRa());
            pstmt.setInt(5, transacao.getConta_origem());
            pstmt.setInt(6, transacao.getConta_destino());
            pstmt.setInt(7, transacao.getId());

            pstmt.executeUpdate();

        } finally {

            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

    public void delete(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(DELETE_BY_ID);

            pstmt.setInt(1, id);

            pstmt.executeUpdate();

        } finally {

            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
    private int mapearTipoConta(TipoTransacaoEnum tipoOp) {
        if (tipoOp == TipoTransacaoEnum.CREDITO) {
            return 1;
        } else if (tipoOp == TipoTransacaoEnum.DEBITO) {
            return 2;
        } else if (tipoOp == TipoTransacaoEnum.OUTROS) {
            return 0;
        } else if (tipoOp == TipoTransacaoEnum.PIX) {
            return 3;
        } else {
            throw new IllegalArgumentException("Tipo de operadora inválido: " + tipoOp);
        }
    }
}

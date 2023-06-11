package br.unipar.central.DAO;

import br.unipar.central.enums.TipoContaEnum;
import br.unipar.central.enums.TipoOperadoraEnum;
import br.unipar.central.models.ContaPOJO;
import br.unipar.central.models.TelefonePOJO;
import br.unipar.central.util.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelefoneDAO {

    private static final String INSERT = "INSERT INTO telefone(id, numero, operadora, ra, agencia_id, pessoa_id) VALUES(?, ?, ?::INTEGER, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT id, numero, operadora, ra, agencia_id, pessoa_id FROM telefone ";

    private static final String FIND_BY_ID = "SELECT id, numero, operadora, ra, agencia_id, pessoa_id FROM telefone WHERE id = ? ";

    private static final String DELETE_BY_ID = "DELETE FROM telefone WHERE id = ?";

    private static final String UPDATE = "UPDATE telefone SET  numero = ?, operadora = ?, ra = ?, agencia_id = ?, pessoa_id = ? WHERE id = ?";

    public List<TelefonePOJO> findAll() throws SQLException {
        ArrayList<TelefonePOJO> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            conn = new DataBase().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                TelefonePOJO telefone = new TelefonePOJO();
                telefone.setId(rs.getInt("id"));
                telefone.setNumero(rs.getString("numero"));
                telefone.setOperadora(TipoOperadoraEnum.paraEnum(rs.getInt("operadora")));
                telefone.setRa(rs.getString("ra"));
                telefone.setAgencia(new AgenciaDAO().findById(rs.getInt("agencia_id")));
                telefone.setPessoa(new PessoaDAO().findById(rs.getInt("pessoa_id")));
                retorno.add(telefone);
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

    public TelefonePOJO findById(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        TelefonePOJO retorno = null;

        try {
            conn = new DataBase().getConnection();

            pstmt = conn.prepareStatement(FIND_BY_ID);

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new TelefonePOJO();
                retorno.setId(rs.getInt("id"));
                retorno.setNumero(rs.getString("numero"));
                retorno.setOperadora(TipoOperadoraEnum.paraEnum(rs.getInt("operadora")));
                retorno.setRa(rs.getString("ra"));
                retorno.setAgencia(new AgenciaDAO().findById(rs.getInt("agencia_id")));
                retorno.setPessoa(new PessoaDAO().findById(rs.getInt("pessoa_id")));

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

    public void insert(TelefonePOJO telefone) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(INSERT);

            pstmt.setInt(1, telefone.getId());
            pstmt.setString(2, telefone.getNumero());
            pstmt.setInt(3, mapearTipoConta(telefone.getOperadora()));
            pstmt.setString(4, telefone.getRa());
            pstmt.setInt(5, telefone.getAgencia().getId());
            pstmt.setInt(6, telefone.getPessoa().getId());

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

    public void update(TelefonePOJO telefone) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

            
            pstmt.setString(1, telefone.getNumero());
            pstmt.setInt(2, mapearTipoConta(telefone.getOperadora()));
            pstmt.setString(3, telefone.getRa());
            pstmt.setInt(4, telefone.getAgencia().getId());
            pstmt.setInt(5, telefone.getPessoa().getId());
            pstmt.setInt(6, telefone.getId());
            pstmt.executeUpdate();
//UPDATE telefone SET  numero = ?, operadora = ?, ra = ?, agencia_id = ?, pessoa_id = ? WHERE id = ?
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

    private int mapearTipoConta(TipoOperadoraEnum tipoOp) {
        if (tipoOp == TipoOperadoraEnum.TIM) {
            return 1;
        } else if (tipoOp == TipoOperadoraEnum.CLARO) {
            return 2;
        } else if (tipoOp == TipoOperadoraEnum.VIVO) {
            return 3;
        } else if (tipoOp == TipoOperadoraEnum.OI) {
            return 4;
        } else if (tipoOp == TipoOperadoraEnum.CORREIOS) {
            return 5;
        } else if (tipoOp == TipoOperadoraEnum.LARICELL) {
            return 6;
        } else if (tipoOp == TipoOperadoraEnum.TESLA) {
            return 7;
        } else if (tipoOp == TipoOperadoraEnum.IPHONE) {
            return 8;
        } else if (tipoOp == TipoOperadoraEnum.OUTROS) {
            return 9;
        } else if (tipoOp == TipoOperadoraEnum.VALOR44) {
            return 44;
        } else if (tipoOp == TipoOperadoraEnum.VALOR21) {
            return 21;
        } else if (tipoOp == TipoOperadoraEnum.VALOR45) {
            return 45;
        } else if (tipoOp == TipoOperadoraEnum.VALOR11) {
            return 11;
        } else if (tipoOp == TipoOperadoraEnum.VALOR34) {
            return 34;

        } else {
            throw new IllegalArgumentException("Tipo de operadora inválido: " + tipoOp);
        }
    }
}

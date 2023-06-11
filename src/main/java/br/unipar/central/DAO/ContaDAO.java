package br.unipar.central.DAO;

import br.unipar.central.enums.TipoContaEnum;
import br.unipar.central.models.ContaPOJO;
import br.unipar.central.util.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO {

    private static final String INSERT = "INSERT INTO conta(id, numero, digito, saldo, tipo, ra, agencia_id, pessoa_id) VALUES(?, ?, ?, ?, ?::INTEGER, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT id, numero, digito, saldo, tipo, ra, agencia_id, pessoa_id FROM conta ";

    private static final String FIND_BY_ID = "SELECT id, numero, digito, saldo, tipo, ra, agencia_id, pessoa_id FROM conta WHERE id = ? ";

    private static final String DELETE_BY_ID = "DELETE FROM conta WHERE id = ?";

    private static final String UPDATE = "UPDATE conta SET  numero = ?, digito = ?, saldo = ?, tipo = ?, ra = ?, agencia_id = ?, pessoa_id = ? WHERE id = ?";
    

    public List<ContaPOJO> findAll() throws SQLException {
        ArrayList<ContaPOJO> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            conn = new DataBase().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                ContaPOJO conta = new ContaPOJO();
                conta.setId(rs.getInt("id"));
                conta.setNumero(rs.getString("numero"));
                conta.setDigito(rs.getString("digito"));
                conta.setSaldo(Double.parseDouble(rs.getString("saldo")));
                conta.setTipoConta(TipoContaEnum.paraEnum(rs.getInt("tipo")));
                conta.setRa(rs.getString("ra"));
                conta.setAgencia(new AgenciaDAO().findById(rs.getInt("agencia_id")));
                conta.setPessoa(new PessoaDAO().findById(rs.getInt("pessoa_id")));

                retorno.add(conta);
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
    public ContaPOJO findById(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ContaPOJO retorno = null;

        try {
            conn = new DataBase().getConnection();

            pstmt = conn.prepareStatement(FIND_BY_ID);

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new ContaPOJO();
                retorno.setId(rs.getInt("id"));
                retorno.setNumero(rs.getString("numero"));
                retorno.setDigito(rs.getString("digito"));
                retorno.setSaldo(Double.parseDouble(rs.getString("saldo")));
                retorno.setTipoConta(TipoContaEnum.paraEnum(rs.getInt("tipo")));
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
    
    public void insert(ContaPOJO conta) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(INSERT);

            pstmt.setInt(1, conta.getId());
            pstmt.setString(2, conta.getNumero());
            pstmt.setString(3, conta.getDigito());
            pstmt.setDouble(4, conta.getSaldo());
            pstmt.setInt(5, mapearTipoConta(conta.getTipoConta()));
            pstmt.setString(6, conta.getRa());
            pstmt.setInt(7, conta.getAgencia().getId());
            pstmt.setInt(8, conta.getPessoa().getId());

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


    public void update(ContaPOJO conta) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

            
            pstmt.setString(1, conta.getNumero());
            pstmt.setString(2, conta.getDigito());
            pstmt.setDouble(3, conta.getSaldo());
            pstmt.setInt(4, mapearTipoConta(conta.getTipoConta()));
            pstmt.setString(5, conta.getRa());
            pstmt.setInt(6, conta.getAgencia().getId());
            pstmt.setInt(7, conta.getPessoa().getId());
            pstmt.setInt(8, conta.getId());

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

    private int mapearTipoConta(TipoContaEnum tipoConta) {
    if (tipoConta == TipoContaEnum.CORRENTE) {
        return 1;
    } else if (tipoConta == TipoContaEnum.POUPANCA) {
        return 2;
    } else if (tipoConta == TipoContaEnum.SALARIO){
        return 3;
    } else {
        throw new IllegalArgumentException("Tipo de conta inválido: " + tipoConta);
    }
}

    
}


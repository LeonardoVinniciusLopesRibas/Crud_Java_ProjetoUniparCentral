package br.unipar.central.DAO;

import br.unipar.central.models.PessoaJuridicaPOJO;
import br.unipar.central.util.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaDAO {

    private static final String INSERT = "INSERT INTO pessoajuridica(razaosocial, cnpj, cnaeprincipal, fantasia, pessoa_id) VALUES(?, ?, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT razaosocial, cnpj, cnaeprincipal, fantasia, pessoa_id FROM pessoajuridica ";

    private static final String FIND_BY_ID = "SELECT razaosocial, cnpj, cnaeprincipal, fantasia, pessoa_id FROM pessoajuridica WHERE cnpj = ? ";

    private static final String DELETE_BY_ID = "DELETE FROM pessoajuridica WHERE cnpj = ?";

    private static final String UPDATE = "UPDATE pessoajuridica SET razaosocial = ?, cnaeprincipal = ?, fantasia = ?, pessoa_id = ? WHERE cnpj = ?";

    public List<PessoaJuridicaPOJO> findAll() throws SQLException {
        ArrayList<PessoaJuridicaPOJO> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            conn = new DataBase().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                PessoaJuridicaPOJO pessoaJuridica = new PessoaJuridicaPOJO();
                pessoaJuridica.setRazaoSocial(rs.getString("razaosocial"));
                pessoaJuridica.setNomeFantasia(rs.getString("fantasia"));
                pessoaJuridica.setCNPJ(rs.getString("cnpj"));
                pessoaJuridica.setCnaePrincipal(rs.getString("cnaeprincipal"));
                pessoaJuridica.setPessoa(new PessoaDAO().findById(rs.getInt("pessoa_id")));
                retorno.add(pessoaJuridica);
            }
        } finally {

            if (rs != null) {
                rs.close();
            }

            if (conn != null) {
                conn.close();
            }

            if (pstmt != null) {
                pstmt.close();
            }
        }

        return retorno;
    }

    public PessoaJuridicaPOJO findById(String cnpj) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PessoaJuridicaPOJO retorno = null;

        try {
            conn = new DataBase().getConnection();

            pstmt = conn.prepareStatement(FIND_BY_ID);

            pstmt.setString(1, cnpj);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new PessoaJuridicaPOJO();
                retorno.setRazaoSocial(rs.getString("razaosocial"));
                retorno.setNomeFantasia(rs.getString("fantasia"));
                retorno.setCNPJ(rs.getString("cnpj"));
                retorno.setCnaePrincipal(rs.getString("cnaeprincipal"));
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

    public void insert(PessoaJuridicaPOJO pessoaJuridica) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(INSERT);

            pstmt.setString(1, pessoaJuridica.getRazaoSocial());
            pstmt.setString(2, pessoaJuridica.getCNPJ());
            pstmt.setString(3, pessoaJuridica.getCnaePrincipal());
            pstmt.setString(4, pessoaJuridica.getNomeFantasia());
            pstmt.setInt(5, pessoaJuridica.getPessoa().getId());

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

    public void update(PessoaJuridicaPOJO pessoaJuridica) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

            pstmt.setString(1, pessoaJuridica.getRazaoSocial());
            pstmt.setString(2, pessoaJuridica.getCnaePrincipal());
            pstmt.setString(3, pessoaJuridica.getNomeFantasia());
            pstmt.setInt(4, pessoaJuridica.getPessoa().getId());
            pstmt.setString(5, pessoaJuridica.getCNPJ());

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

    public void delete(String cnpj) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(DELETE_BY_ID);

            pstmt.setString(1, cnpj);

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
}

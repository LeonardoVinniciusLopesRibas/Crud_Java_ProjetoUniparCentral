/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.DAO;

import br.unipar.central.models.CidadePOJO;
import br.unipar.central.models.ContaPOJO;
import br.unipar.central.models.EstadoPOJO;
import br.unipar.central.util.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAO {

    private static final String INSERT = "INSERT INTO estado(id, nome, sigla, ra, pais_id) VALUES(?, ?, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT id, nome, sigla, ra, pais_id FROM estado ";

    private static final String FIND_BY_ID = "SELECT id, nome, sigla, ra, pais_id FROM estado WHERE id = ?";

    private static final String DELETE_BY_ID = "DELETE FROM estado WHERE id = ?";

    private static final String UPDATE = "UPDATE estado SET nome = ?, SIGLA = ?, RA = ?, pais_id = ? WHERE ID = ?";

    public List<EstadoPOJO> findAll() throws SQLException {
        ArrayList<EstadoPOJO> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            conn = new DataBase().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                EstadoPOJO estado = new EstadoPOJO();
                estado.setId(rs.getInt("id"));
                estado.setNome(rs.getString("nome"));
                estado.setRa(rs.getString("ra"));
                estado.setSigla(rs.getString("sigla"));
                estado.setPais(new PaisDAO().findById(rs.getInt("pais_id")));
                retorno.add(estado);
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
    
    //    public List<PessoaPOJO> findAll() throws SQLException {
//        ArrayList<PessoaPOJO> retorno = new ArrayList<>();
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//
//        try {
//
//            conn = new DataBase().getConnection();
//
//            pstmt = conn.prepareStatement(FIND_ALL);
//
//            rs = pstmt.executeQuery();
//
//            while (rs.next()) {
//                PessoaPOJO pessoa = new PessoaPOJO();
//                pessoa.setId(rs.getInt("id"));
//                pessoa.setEmail(rs.getString("email"));
//                pessoa.setRa(rs.getString("ra"));
//                retorno.add(pessoa);
//            }
//        } finally {
//
//            if (rs != null) {
//                rs.close();
//            }
//
//            if (conn != null) {
//                conn.close();
//            }
//
//            if (conn != null) {
//                pstmt.close();
//            }
//        }

    public EstadoPOJO findById(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        EstadoPOJO retorno = null;

        try {
            conn = new DataBase().getConnection();

            pstmt = conn.prepareStatement(FIND_BY_ID);

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new EstadoPOJO();
                retorno.setId(rs.getInt("id"));
                retorno.setNome(rs.getString("nome"));
                retorno.setSigla(rs.getString("sigla"));
                retorno.setRa(rs.getString("ra"));
                retorno.setPais(new PaisDAO().findById(rs.getInt("pais_id")));

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

    public void insert(EstadoPOJO estado) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(INSERT);

            pstmt.setInt(1, estado.getId());
            pstmt.setString(2, estado.getNome());
            pstmt.setString(3, estado.getSigla());
            pstmt.setString(4, estado.getRa());
            pstmt.setInt(5, estado.getPais().getId());

            pstmt.executeUpdate();
//id, nome, sigla, ra, pais_id
        } finally {

            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

    public void update(EstadoPOJO estado) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

            pstmt.setInt(1, estado.getId());
            pstmt.setString(2, estado.getNome());
            pstmt.setString(3, estado.getSigla());
            pstmt.setString(4, estado.getRa());
            pstmt.setInt(5, estado.getPais().getId());
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

}

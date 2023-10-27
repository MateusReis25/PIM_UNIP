package com.example.folhapagamento.dao;

import com.example.folhapagamento.connection.ConnectionSQL;
import com.example.folhapagamento.model.Fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {

    Connection conn = null;

    public void cadastrarFornecedor(Fornecedor fornecedor) throws SQLException, ClassNotFoundException {
        conn = ConnectionSQL.connectionClass();

        if (conn != null){
            String sql = "INSERT INTO fornecedores (" +
                    "cnpj, " +
                    "nomeFantasia, " +
                    "razaoSocial, " +
                    "inscricaoEstadual, " +
                    "email, " +
                    "telefone, " +
                    "endereco, " +
                    "cidade, " +
                    "uf, " +
                    "banco, " +
                    "agencia, " +
                    "conta) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, fornecedor.getCnpj());
            preparedStatement.setString(2, fornecedor.getNomeFantasia());
            preparedStatement.setString(3, fornecedor.getRazaoSocial());
            preparedStatement.setString(4, fornecedor.getInscricaoEstadual());
            preparedStatement.setString(5, fornecedor.getEmail());
            preparedStatement.setString(6, fornecedor.getTelefone());
            preparedStatement.setString(7, fornecedor.getEndereco());
            preparedStatement.setString(8, fornecedor.getCidade());
            preparedStatement.setString(9, fornecedor.getUf());
            preparedStatement.setString(10, fornecedor.getBanco());
            preparedStatement.setString(11, fornecedor.getAgencia());
            preparedStatement.setString(12, fornecedor.getConta());

            preparedStatement.executeUpdate();
        }
        conn.close();
    }

    public void atualizarFornecedor(Fornecedor fornecedor) throws SQLException, ClassNotFoundException {
        conn = ConnectionSQL.connectionClass();

        if (conn != null) {
            String sql = "UPDATE fornecedores SET " +
                    "cnpj = ?," +
                    "nomeFantasia = ?, " +
                    "razaoSocial = ?, " +
                    "inscricaoEstadual = ?, " +
                    "email = ?, " +
                    "telefone = ?, " +
                    "endereco = ?, " +
                    "cidade = ?, " +
                    "uf = ?, " +
                    "banco = ?, " +
                    "agencia = ?, " +
                    "conta = ? " +
                    "WHERE id = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, fornecedor.getCnpj());
            preparedStatement.setString(2, fornecedor.getNomeFantasia());
            preparedStatement.setString(3, fornecedor.getRazaoSocial());
            preparedStatement.setString(4, fornecedor.getInscricaoEstadual());
            preparedStatement.setString(5, fornecedor.getEmail());
            preparedStatement.setString(6, fornecedor.getTelefone());
            preparedStatement.setString(7, fornecedor.getEndereco());
            preparedStatement.setString(8, fornecedor.getCidade());
            preparedStatement.setString(9, fornecedor.getUf());
            preparedStatement.setString(10, fornecedor.getBanco());
            preparedStatement.setString(11, fornecedor.getAgencia());
            preparedStatement.setString(12, fornecedor.getConta());
            preparedStatement.setLong(13, fornecedor.getId());

            preparedStatement.executeUpdate();
        }
        conn.close();
    }

    public void deletarFornecedor(Long id) throws SQLException, ClassNotFoundException {
        conn = ConnectionSQL.connectionClass();

        if (conn != null){
            String sql = "DELETE FROM fornecedores WHERE id = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
            conn.close();
        }
    }

    public Fornecedor carregaFornecedorPorId(Long id) {
        try {
            conn = ConnectionSQL.connectionClass();
            if (conn != null) {
                String sql = "SELECT * FROM fornecedores WHERE id = ?";

                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setLong(1, id);

                ResultSet rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    Fornecedor fornecedor = new Fornecedor();
                    fornecedor.setId(rs.getLong("id"));
                    fornecedor.setCnpj(rs.getString("cnpj"));
                    fornecedor.setNomeFantasia(rs.getString("nomeFantasia"));
                    fornecedor.setRazaoSocial(rs.getString("razaoSocial"));
                    fornecedor.setInscricaoEstadual(rs.getString("inscricaoEstadual"));
                    fornecedor.setEmail(rs.getString("email"));
                    fornecedor.setTelefone(rs.getString("telefone"));
                    fornecedor.setEndereco(rs.getString("endereco"));
                    fornecedor.setCidade(rs.getString("cidade"));
                    fornecedor.setUf(rs.getString("uf"));
                    fornecedor.setBanco(rs.getString("banco"));
                    fornecedor.setAgencia(rs.getString("agencia"));
                    fornecedor.setConta(rs.getString("conta"));

                    conn.close();
                    return fornecedor;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private List<Fornecedor> getFornecedores(String sql) throws SQLException {
        List<Fornecedor> lista = new ArrayList<>();

        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setId(rs.getLong("id"));
            fornecedor.setCnpj(rs.getString("cnpj"));
            fornecedor.setNomeFantasia(rs.getString("nomeFantasia"));
            fornecedor.setRazaoSocial(rs.getString("razaoSocial"));
            fornecedor.setInscricaoEstadual(rs.getString("inscricaoEstadual"));
            fornecedor.setEmail(rs.getString("email"));
            fornecedor.setTelefone(rs.getString("telefone"));
            fornecedor.setEndereco(rs.getString("endereco"));
            fornecedor.setCidade(rs.getString("cidade"));
            fornecedor.setUf(rs.getString("uf"));
            fornecedor.setBanco(rs.getString("banco"));
            fornecedor.setAgencia(rs.getString("agencia"));
            fornecedor.setConta(rs.getString("conta"));

            lista.add(fornecedor);
        }
        return lista;
    }

    public List<Fornecedor> getAllFornecedores() {
        List<Fornecedor> lista = new ArrayList<Fornecedor>();

        try {
            conn = ConnectionSQL.connectionClass();
            if (conn != null) {
                String sql = "SELECT * FROM fornecedores";
                lista = getFornecedores(sql);

                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public List<Fornecedor> getFornecedoresByNome(String busca) {
        List<Fornecedor> lista = new ArrayList<Fornecedor>();

        try {
            conn = ConnectionSQL.connectionClass();
            if (conn != null) {
                String sql = "SELECT * FROM fornecedores WHERE nomeFantasia LIKE '%" + busca + "%' OR cnpj LIKE '%" + busca + "%'";
                lista = getFornecedores(sql);

                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }



}

package com.example.folhapagamento.dao;

import com.example.folhapagamento.connection.ConnectionSQL;
import com.example.folhapagamento.model.Funcionario;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.xml.transform.Result;

public class FuncionarioDAO {

    Connection conn = null;

    public void cadastrar(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        conn = ConnectionSQL.connectionClass();

        if (conn != null) {
            String sql = "INSERT INTO funcionarios (" +
                    "nome, " +
                    "dataNascimento, " +
                    "nomeMae, " +
                    "sexo, " +
                    "naturalidade, " +
                    "nacionalidade, " +
                    "escolaridade, " +
                    "email, " +
                    "telefone, " +
                    "endereco, " +
                    "cidade, " +
                    "uf, " +
                    "numeroPis, " +
                    "numeroCTPS, " +
                    "cpf, " +
                    "rg, " +
                    "numeroReservista, " +
                    "numeroTituloEleitor, " +
                    "zonaTituloEleitor, " +
                    "secaoTituloEleitor, " +
                    "banco, " +
                    "agencia, " +
                    "conta, " +
                    "cargo, " +
                    "area, " +
                    "dataAdmissao, " +
                    "horario, " +
                    "escala, " +
                    "salario, " +
                    "horaMes, " +
                    "tipoContrato, " +
                    "opatanteSindical) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, funcionario.getNome());
            preparedStatement.setDate(2, (Date) funcionario.getDataNascimento());
            preparedStatement.setString(3, funcionario.getNomeMae());
            preparedStatement.setString(4, funcionario.getSexo());
            preparedStatement.setString(5, funcionario.getNaturalidade());
            preparedStatement.setString(6, funcionario.getNacionalidade());
            preparedStatement.setString(7, funcionario.getEscolaridade());
            preparedStatement.setString(8, funcionario.getEmail());
            preparedStatement.setString(9, funcionario.getTelefone());
            preparedStatement.setString(10, funcionario.getEndereco());
            preparedStatement.setString(11, funcionario.getCidade());
            preparedStatement.setString(12, funcionario.getUf());
            preparedStatement.setString(13, funcionario.getNumeroPis());
            preparedStatement.setString(14, funcionario.getNumeroCTPS());
            preparedStatement.setString(15, funcionario.getCpf());
            preparedStatement.setString(16, funcionario.getRg());
            preparedStatement.setString(17, funcionario.getNumeroReservista());
            preparedStatement.setString(18, funcionario.getNumeroTituloEleitor());
            preparedStatement.setString(19, funcionario.getZonaTituloEleitor());
            preparedStatement.setString(20, funcionario.getSecaoTituloEleitor());
            preparedStatement.setString(21, funcionario.getBanco());
            preparedStatement.setInt(22, funcionario.getAgencia());
            preparedStatement.setInt(23, funcionario.getConta());
            preparedStatement.setString(24, funcionario.getCargo());
            preparedStatement.setString(25, funcionario.getArea());
            preparedStatement.setDate(26, (Date) funcionario.getDataAdmisão());
            preparedStatement.setInt(27, funcionario.getHorario());
            preparedStatement.setString(28, funcionario.getEscala());
            preparedStatement.setDouble(29, funcionario.getSalario());
            preparedStatement.setInt(30, funcionario.getHoraMes());
            preparedStatement.setString(31, funcionario.getTipoContrato());
            preparedStatement.setString(32, funcionario.getOpatanteSindical());

            preparedStatement.executeUpdate();

        }
        conn.close();
    }
    public void atualizar(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        conn = ConnectionSQL.connectionClass();

        if (conn != null) {
            String sql = "UPDATE funcionarios SET " +
                    "nome = ?, " +
                    "dataNascimento = ?, " +
                    "nomeMae = ?, " +
                    "sexo = ?, " +
                    "naturalidade = ?, " +
                    "nacionalidade = ?, " +
                    "escolaridade = ?, " +
                    "email = ?, " +
                    "telefone = ?, " +
                    "endereco = ?, " +
                    "cidade = ?, " +
                    "uf = ?, " +
                    "numeroPis = ?, " +
                    "numeroCTPS = ?, " +
                    "cpf = ?, " +
                    "rg = ?, " +
                    "numeroReservista = ?, " +
                    "numeroTituloEleitor = ?, " +
                    "zonaTituloEleitor = ?, " +
                    "secaoTituloEleitor = ?, " +
                    "banco = ?, " +
                    "agencia = ?, " +
                    "conta = ?, " +
                    "cargo = ?, " +
                    "area = ?, " +
                    "dataAdmissao = ?, " +
                    "horario = ?, " +
                    "escala = ?, " +
                    "salario = ?, " +
                    "horaMes = ?, " +
                    "tipoContrato = ?, " +
                    "opatanteSindical = ? " +
                    "WHERE matricula = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, funcionario.getNome());
            preparedStatement.setDate(2, new java.sql.Date(funcionario.getDataNascimento().getTime()));
            preparedStatement.setString(3, funcionario.getNomeMae());
            preparedStatement.setString(4, funcionario.getSexo());
            preparedStatement.setString(5, funcionario.getNaturalidade());
            preparedStatement.setString(6, funcionario.getNacionalidade());
            preparedStatement.setString(7, funcionario.getEscolaridade());
            preparedStatement.setString(8, funcionario.getEmail());
            preparedStatement.setString(9, funcionario.getTelefone());
            preparedStatement.setString(10, funcionario.getEndereco());
            preparedStatement.setString(11, funcionario.getCidade());
            preparedStatement.setString(12, funcionario.getUf());
            preparedStatement.setString(13, funcionario.getNumeroPis());
            preparedStatement.setString(14, funcionario.getNumeroCTPS());
            preparedStatement.setString(15, funcionario.getCpf());
            preparedStatement.setString(16, funcionario.getRg());
            preparedStatement.setString(17, funcionario.getNumeroReservista());
            preparedStatement.setString(18, funcionario.getNumeroTituloEleitor());
            preparedStatement.setString(19, funcionario.getZonaTituloEleitor());
            preparedStatement.setString(20, funcionario.getSecaoTituloEleitor());
            preparedStatement.setString(21, funcionario.getBanco());
            preparedStatement.setInt(22, funcionario.getAgencia());
            preparedStatement.setInt(23, funcionario.getConta());
            preparedStatement.setString(24, funcionario.getCargo());
            preparedStatement.setString(25, funcionario.getArea());
            preparedStatement.setDate(26, new java.sql.Date(funcionario.getDataNascimento().getTime()));
            preparedStatement.setInt(27, funcionario.getHorario());
            preparedStatement.setString(28, funcionario.getEscala());
            preparedStatement.setDouble(29, funcionario.getSalario());
            preparedStatement.setInt(30, funcionario.getHoraMes());
            preparedStatement.setString(31, funcionario.getTipoContrato());
            preparedStatement.setString(32, funcionario.getOpatanteSindical());
            preparedStatement.setLong(33, funcionario.getMatricula());

            preparedStatement.executeUpdate();
            conn.close();
        }
    }
    public void deletar( Long matricula) throws SQLException, ClassNotFoundException {
        conn = ConnectionSQL.connectionClass();

        if (conn != null) {
            String sql = "DELETE FROM funcionarios WHERE matricula = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setLong(1, matricula);

            preparedStatement.executeUpdate();
            conn.close();
        }
    }

    public Funcionario carregaPorId(Long matricula){

        try {
            conn = ConnectionSQL.connectionClass();
            if (conn != null) {
                String sql = "SELECT * FROM funcionarios WHERE matricula = " + matricula;

                Statement st = conn.createStatement();

                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                   Funcionario funcionario = new Funcionario();
                    funcionario.setMatricula(rs.getLong(1));
                    funcionario.setNome(rs.getString(2));
                    funcionario.setDataNascimento(rs.getDate(3));
                    funcionario.setNomeMae(rs.getString(4));
                    funcionario.setSexo(rs.getString(5));
                    funcionario.setNaturalidade(rs.getString(6));
                    funcionario.setNacionalidade(rs.getString(7));
                    funcionario.setEscolaridade(rs.getString(8));
                    funcionario.setEmail(rs.getString(9));
                    funcionario.setTelefone(rs.getString(10));
                    funcionario.setEndereco(rs.getString(11));
                    funcionario.setCidade(rs.getString(12));
                    funcionario.setUf(rs.getString(13));
                    funcionario.setNumeroPis(rs.getString(14));
                    funcionario.setNumeroCTPS(rs.getString(15));
                    funcionario.setCpf(rs.getString(16));
                    funcionario.setRg(rs.getString(17));
                    funcionario.setNumeroReservista(rs.getString(18));
                    funcionario.setNumeroTituloEleitor(rs.getString(19));
                    funcionario.setZonaTituloEleitor(rs.getString(20));
                    funcionario.setSecaoTituloEleitor(rs.getString(21));
                    funcionario.setBanco(rs.getString(22));
                    funcionario.setAgencia(rs.getInt(23));
                    funcionario.setConta(rs.getInt(24));
                    funcionario.setCargo(rs.getString(25));
                    funcionario.setArea(rs.getString(26));
                    funcionario.setDataAdmisão(rs.getDate(27));
                    funcionario.setHorario(rs.getInt(28));
                    funcionario.setEscala(rs.getString(29));
                    funcionario.setSalario(rs.getDouble(30));
                    funcionario.setHoraMes(rs.getInt(31));
                    funcionario.setTipoContrato(rs.getString(32));
                    funcionario.setOpatanteSindical(rs.getString(33));

                    conn.close();
                    return funcionario;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private List<Funcionario> getFuncionario(String sql) throws SQLException {
        List<Funcionario> lista = new ArrayList<Funcionario>();

        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery(sql);

        while (rs.next()){
            Funcionario funcionario = new Funcionario();
            funcionario.setMatricula(rs.getLong(1));
            funcionario.setNome(rs.getString(2));
            funcionario.setDataNascimento(rs.getDate(3));
            funcionario.setNomeMae(rs.getString(4));
            funcionario.setSexo(rs.getString(5));
            funcionario.setNaturalidade(rs.getString(6));
            funcionario.setNacionalidade(rs.getString(7));
            funcionario.setEscolaridade(rs.getString(8));
            funcionario.setEmail(rs.getString(9));
            funcionario.setTelefone(rs.getString(10));
            funcionario.setEndereco(rs.getString(11));
            funcionario.setUf(rs.getString(13));
            funcionario.setNumeroPis(rs.getString(14));
            funcionario.setNumeroCTPS(rs.getString(15));
            funcionario.setCpf(rs.getString(16));
            funcionario.setRg(rs.getString(17));
            funcionario.setNumeroReservista(rs.getString(18));
            funcionario.setNumeroTituloEleitor(rs.getString(19));
            funcionario.setZonaTituloEleitor(rs.getString(20));
            funcionario.setSecaoTituloEleitor(rs.getString(21));
            funcionario.setBanco(rs.getString(22));
            funcionario.setAgencia(rs.getInt(23));
            funcionario.setConta(rs.getInt(24));
            funcionario.setCargo(rs.getString(25));
            funcionario.setArea(rs.getString(26));
            funcionario.setDataAdmisão(rs.getDate(27));
            funcionario.setHorario(rs.getInt(28));
            funcionario.setEscala(rs.getString(29));
            funcionario.setSalario(rs.getDouble(30));
            funcionario.setHoraMes(rs.getInt(31));
            funcionario.setTipoContrato(rs.getString(32));
            funcionario.setOpatanteSindical(rs.getString(33));

            lista.add(funcionario);
        }
        return lista;
    }

    public List<Funcionario> getAllFuncionarios() {
        List<Funcionario> lista = new ArrayList<Funcionario>();

            try {
                conn = ConnectionSQL.connectionClass();
                if (conn != null) {
                    String sql = "SELECT * FROM funcionarios";
                    lista = getFuncionario(sql);

                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
        }
        return lista;
    }

    public List<Funcionario> getAllFuncionarios(String busca) {
        List<Funcionario> lista = new ArrayList<Funcionario>();

        try {
             conn = ConnectionSQL.connectionClass();
            if (conn != null) {
                String sql = "SELECT * FROM funcionarios where nome like '%" + busca + "%'";
                lista = getFuncionario(sql);

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

package com.example.folhapagamento.dao;

import com.example.folhapagamento.connection.ConnectionSQL;
import com.example.folhapagamento.model.User;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {
    Connection conn = null;
    public User selectUser(String usuario, String senha) {
        try {
            try (Connection conn = ConnectionSQL.connectionClass()) {
                if (conn != null) {
                    String sql = "SELECT * FROM usuario WHERE usuario = ?";
                    try (PreparedStatement ps = conn.prepareStatement(sql)) {
                        ps.setString(1, usuario);
                        try (ResultSet rs = ps.executeQuery()) {
                            if (rs.next()) {
                                String hashedSenhaArmazenada = rs.getString("senha");

                                if (BCrypt.checkpw(senha, hashedSenhaArmazenada)) {
                                    User user = new User();
                                    user.setId(rs.getInt("id"));
                                    user.setUsuario(rs.getString("usuario"));
                                    user.setSenha(hashedSenhaArmazenada);
                                    return user;
                                }
                            }
                        }
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public boolean userExists(String usuario) {
        try {
            conn = ConnectionSQL.connectionClass();
            if (conn != null) {
                String sql = "SELECT COUNT(*) FROM usuario WHERE usuario = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, usuario);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0;
                }
                conn.close();
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public void createUser(String usuario, String senha) {
        try {
            try (Connection conn = ConnectionSQL.connectionClass()) {

                String senhaCriptografada = BCrypt.hashpw(senha, BCrypt.gensalt());

                if (conn != null) {
                    String sql = "INSERT INTO usuario (usuario, senha) VALUES (?, ?)";
                    try (PreparedStatement ps = conn.prepareStatement(sql)) {
                        ps.setString(1, usuario);
                        ps.setString(2, senhaCriptografada);
                        ps.executeUpdate();
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

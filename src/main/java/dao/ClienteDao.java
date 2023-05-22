package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.PessoaFisicaReferencia;

public class ClienteDao {
    private Connection connection;
    
    public ClienteDao() {
        SqLiteConnection dbConnection = new SqLiteConnection();
        connection = dbConnection.getConnection();
    }

    public void insertCliente(PessoaFisicaReferencia cliente) {
        String sql = "INSERT INTO cliente VALUES (null, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getSaldo());
            statement.setString(3, cliente.getCpf());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PessoaFisicaReferencia> getAllClientes() {
        List<PessoaFisicaReferencia> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                String nome = resultSet.getString("nome");
                String saldo = resultSet.getString("saldo");
                String cpf = resultSet.getString("cpf");
                PessoaFisicaReferencia cliente = new PessoaFisicaReferencia(codigo, nome, saldo, cpf);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public void updateCliente(PessoaFisicaReferencia cliente) {
        String sql = "UPDATE cliente SET nome = ?, saldo = ?, cpf = ? WHERE codigo = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getSaldo());
            statement.setString(3, cliente.getCpf());
            statement.setInt(4, cliente.getCodigo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteCliente(int codigo) {
        String sql = "DELETE FROM cliente WHERE codigo = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, codigo);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public PessoaFisicaReferencia getClientById(int codigo) {
        String sql = "SELECT * FROM cliente WHERE codigo = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, codigo);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String nome = resultSet.getString("nome");
                    String saldo = resultSet.getString("saldo");
                    String cpf = resultSet.getString("cpf");
                    return new PessoaFisicaReferencia(codigo, nome, saldo, cpf);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Retorna null caso nenhum cliente seja encontrado com o código especificado
    }
}
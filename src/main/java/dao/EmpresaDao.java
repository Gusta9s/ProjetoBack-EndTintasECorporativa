package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.PessoaJuridicaReferencia;

public class EmpresaDao {
    private Connection connection;
    
    public EmpresaDao() {
        SqLiteConnection dbConnection = new SqLiteConnection();
        connection = dbConnection.getConnection();
    }

    public void insertEmpresa(PessoaJuridicaReferencia empresa) {
        String sql = "INSERT INTO empresa VALUES (null, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, empresa.getRazaoSocial());
            statement.setString(2, empresa.getSaldo());
            statement.setString(3, empresa.getCnpj());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PessoaJuridicaReferencia> getAllEmpresas() {
        List<PessoaJuridicaReferencia> empresas = new ArrayList<>();
        String sql = "SELECT * FROM empresa";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                String razaoSocial = resultSet.getString("razaoSocial");
                String saldo = resultSet.getString("saldo");
                String cnpj = resultSet.getString("cnpj");
                PessoaJuridicaReferencia empresa = new PessoaJuridicaReferencia(codigo, razaoSocial, saldo, cnpj);
                empresas.add(empresa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empresas;
    }

    public void updateEmpresa(PessoaJuridicaReferencia empresa) {
        String sql = "UPDATE empresa SET razaoSocial = ?, saldo = ?, cnpj = ? WHERE codigo = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, empresa.getRazaoSocial());
            statement.setString(2, empresa.getSaldo());
            statement.setString(3, empresa.getCnpj());
            statement.setInt(4, empresa.getCodigo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteEmpresa(int codigo) {
        String sql = "DELETE FROM empresa WHERE codigo = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, codigo);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public PessoaJuridicaReferencia getEmpresaById(int codigo) {
        String sql = "SELECT * FROM empresa WHERE codigo = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, codigo);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String razaoSocial = resultSet.getString("razaoSocial");
                    String saldo = resultSet.getString("saldo");
                    String cnpj = resultSet.getString("cnpj");
                    return new PessoaJuridicaReferencia(codigo, razaoSocial, saldo, cnpj);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Retorna null caso nenhum cliente seja encontrado com o código especificado
    }
}

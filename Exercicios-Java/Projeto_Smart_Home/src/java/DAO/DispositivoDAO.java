/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Dispositivo;
import util.Conexao;

/**
 *
 * @author User
 */
public class DispositivoDAO {
    public void cadastrar(Dispositivo d) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("INSERT INTO dispositivos (nome, comodo, marca, potencia, horas_uso, voltagem, status, consumo_mensal, observacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        comando.setString(1, d.getNome());
        comando.setString(2, d.getComodo());
        comando.setString(3, d.getMarca());
        comando.setDouble(4, d.getPotencia());
        comando.setDouble(5, d.getHorasUso());
        comando.setInt(6, d.getVoltagem());
        comando.setString(7, d.getStatus());
        comando.setDouble(8, d.getConsumoMensal());
        comando.setString(9, d.getObservacao());
        comando.execute();
        con.close();
    }

    public void deletar(Dispositivo d) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("DELETE FROM dispositivos WHERE id = ?");
        comando.setInt(1, d.getId());
        comando.execute();
        con.close();
    }

    public void atualizar(Dispositivo d) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("UPDATE dispositivos SET nome=?, comodo=?, marca=?, potencia=?, horas_uso=?, voltagem=?, status=?, consumo_mensal=?, observacao=? WHERE id=?");
        comando.setString(1, d.getNome());
        comando.setString(2, d.getComodo());
        comando.setString(3, d.getMarca());
        comando.setDouble(4, d.getPotencia());
        comando.setDouble(5, d.getHorasUso());
        comando.setInt(6, d.getVoltagem());
        comando.setString(7, d.getStatus());
        comando.setDouble(8, d.getConsumoMensal());
        comando.setString(9, d.getObservacao());
        comando.setInt(10, d.getId());
        comando.execute();
        con.close();
    }

    public List<Dispositivo> consultarTodos() throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("SELECT * FROM dispositivos");
        ResultSet rs = comando.executeQuery();
        List<Dispositivo> lista = new ArrayList<>();
        while (rs.next()) {
            Dispositivo d = new Dispositivo();
            d.setId(rs.getInt("id"));
            d.setNome(rs.getString("nome"));
            d.setComodo(rs.getString("comodo"));
            d.setMarca(rs.getString("marca"));
            d.setPotencia(rs.getDouble("potencia"));
            d.setHorasUso(rs.getDouble("horas_uso"));
            d.setVoltagem(rs.getInt("voltagem"));
            d.setStatus(rs.getString("status"));
            d.setConsumoMensal(rs.getDouble("consumo_mensal"));
            d.setObservacao(rs.getString("observacao"));
            lista.add(d);
        }
        con.close();
        return lista;
    }
    
    public Dispositivo consultarById(Dispositivo d) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("SELECT * FROM dispositivos WHERE id = ?");
        comando.setInt(1, d.getId());
        ResultSet rs = comando.executeQuery();
        
        Dispositivo disp = new Dispositivo();
        if (rs.next()) {
            disp.setId(rs.getInt("id"));
            disp.setNome(rs.getString("nome"));
            disp.setComodo(rs.getString("comodo"));
            disp.setMarca(rs.getString("marca"));
            disp.setPotencia(rs.getDouble("potencia"));
            disp.setHorasUso(rs.getDouble("horas_uso"));
            disp.setVoltagem(rs.getInt("voltagem"));
            disp.setStatus(rs.getString("status"));
            disp.setConsumoMensal(rs.getDouble("consumo_mensal"));
            disp.setObservacao(rs.getString("observacao"));
        }
        con.close();
        return disp;
    }
}

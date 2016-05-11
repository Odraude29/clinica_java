/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eduardo
 */
public class PacienteDao {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public void cadastrar(Paciente paciente) throws ClassNotFoundException, SQLException{
        String sql = "INSERT INTO paciente(cpf, nome,dataNascimento, sexo, telefone, convenio, empresa) VALUES(?,?,?,?,?,?,?)";
        con = ConnectionFactory.conexao();
        ps = con.prepareStatement(sql);
        ps.setString(1, paciente.getCpf());
        ps.setString(2, paciente.getNome());
        ps.setString(3, paciente.getDataNasc());
        ps.setString(4, paciente.getSexo());
        ps.setString(5, paciente.getTelefone());
        ps.setString(6, paciente.getConvenio());
        ps.setString(7, paciente.getEmpresa());
        ps.execute();
        ps.close();
        con.close();
        
    }
    
    public void editar(Paciente paciente) throws ClassNotFoundException, SQLException{
         String sql = "UPDATE paciente SET cpf = ?, nome = ?, dataNascimento = ?, sexo = ?,telefone = ?, convenio = ?, empresa = ? WHERE idpaciente = ?";
         con = ConnectionFactory.conexao();
         ps = con.prepareStatement(sql);
         ps.setString(1, paciente.getCpf());
         ps.setString(2, paciente.getNome());
         ps.setString(3, paciente.getDataNasc());
         ps.setString(4, paciente.getSexo());
         ps.setString(5, paciente.getTelefone());
         ps.setString(6, paciente.getConvenio());
         ps.setString(7, paciente.getEmpresa());
         ps.execute();
        
         ps.close();
         con.close();
    }
    
    public void excluir(Paciente paciente) throws ClassNotFoundException, SQLException{
        String sql = "DELETE FROM paciente WHERE idpaciente = ?";
        con = ConnectionFactory.conexao();
        ps = con.prepareStatement(sql);
        ps.setInt(1, paciente.getIdPaciente());
        ps.execute();
        ps.close();
        con.close();
        
    }
    
    public List<Paciente>consultar() throws ClassNotFoundException, SQLException{
        String sql = "SELECT * FROM paciente";
        List<Paciente> list = new ArrayList<Paciente>();
        con = ConnectionFactory.conexao();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next()){
            Paciente paciente = new Paciente();
            paciente.setIdPaciente(rs.getInt("idpaciente"));
            paciente.setCpf(rs.getString("cpf"));
            paciente.setNome(rs.getString("nome"));
            paciente.setDataNasc(rs.getString("dataNascimento"));
            paciente.setConvenio(rs.getString("convenio"));
            paciente.setTelefone(rs.getString("telefone"));
            paciente.setSexo(rs.getString("sexo"));
            list.add(paciente);
        }
        ps.close();
        con.close();
        return list;
        
    }
    
}

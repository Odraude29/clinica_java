/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Medico;
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
public class MedicoDao {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public void cadastrar(Medico medico) throws ClassNotFoundException, SQLException{
        String sql = "INSERT INTO medico(crm, nome,especialidade, telefone, horario) VALUES(?,?,?,?,?)";
        con = ConnectionFactory.conexao();
        ps = con.prepareStatement(sql);
        ps.setString(1, medico.getCrm());
        ps.setString(2, medico.getNome());
        ps.setString(3, medico.getEspecialidade());
        ps.setString(4, medico.getTelefone());
        ps.setString(5, medico.getHorario());
        ps.execute();
        ps.close();
        con.close();
        
    }
    
    public void editar(Medico medico) throws ClassNotFoundException, SQLException{
         String sql = "UPDATE medico SET crm = ?, nome = ?, especialidade = ?, telefone = ?, horario = ? WHERE idmedico = ?";
         con = ConnectionFactory.conexao();
         ps = con.prepareStatement(sql);
         ps.setString(1, medico.getCrm());
         ps.setString(2, medico.getNome());
         ps.setString(3, medico.getEspecialidade());
         ps.setString(4, medico.getTelefone());
         ps.setString(5, medico.getHorario());
         ps.setInt(6, medico.getIdMedico());
         ps.execute();
        
         ps.close();
         con.close();
    }
    
    public void excluir(Medico medico) throws ClassNotFoundException, SQLException{
        String sql = "DELETE FROM medico WHERE idmedico = ?";
        con = ConnectionFactory.conexao();
        ps = con.prepareStatement(sql);
        ps.setInt(1, medico.getIdMedico());
        ps.execute();
        ps.close();
        con.close();
        
    }
    
    public List<Medico>consultar() throws ClassNotFoundException, SQLException{
        String sql = "SELECT * FROM medico";
        List<Medico> list = new ArrayList<Medico>();
        con = ConnectionFactory.conexao();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next()){
            Medico medico = new Medico();
            medico.setIdMedico(rs.getInt("idmedico"));
            medico.setCrm(rs.getString("crm"));
            medico.setEspecialidade(rs.getString("especialidade"));
            medico.setNome(rs.getString("nome"));
            medico.setTelefone(rs.getString("telefone"));
            medico.setHorario(rs.getString("horario"));
            list.add(medico);
        }
        ps.close();
        con.close();
        return list;
        
    }
    
}

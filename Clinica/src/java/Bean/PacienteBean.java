/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.PacienteDao;
import Entity.Paciente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author eduardo
 */
@ManagedBean(name = "PacienteBean")
@SessionScoped
public class PacienteBean {
    
    private Paciente paciente = null;
    private PacienteDao dao = null;

    public PacienteBean() {
        paciente = new Paciente();
        dao = new PacienteDao();
    }
    
    
    
    public String cadastrar() throws ClassNotFoundException, SQLException{
        if(getPaciente().getIdPaciente()== 0){
            this.getDao().cadastrar(getPaciente());
            this.setPaciente(new Paciente());
        }else{
            this.getDao().editar(getPaciente());
            this.setPaciente(new Paciente());
        }
        
        return "CadastrarPaciente.xhtml";
        
    }
    
    public List<Paciente> consultar() throws ClassNotFoundException, SQLException{
        List<Paciente>list = new ArrayList<Paciente>();
        list = this.getDao().consultar();
        
        return list;
        
    }
    
    public String excluir(Paciente paciente) throws ClassNotFoundException, SQLException{
        this.setPaciente(paciente);
        this.getDao().excluir(this.getPaciente());
        
        return "CadastrarPaciente.xhtml";
        
    }
    
    public String editar(Paciente paciente){
        this.setPaciente(paciente);
        return "CadastrarPaciente.xhtml";
        
    }

    /**
     * @return the paciente
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * @param paciente the paciente to set
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     * @return the dao
     */
    public PacienteDao getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(PacienteDao dao) {
        this.dao = dao;
    }

    

}

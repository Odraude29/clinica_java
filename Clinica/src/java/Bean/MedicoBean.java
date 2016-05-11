/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.MedicoDao;
import Entity.Medico;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author eduardo
 */
@ManagedBean(name = "MedicoBean")
@SessionScoped
public class MedicoBean {
    
    private Medico medico = null;
    private MedicoDao dao = null;

    public MedicoBean() {
        medico = new Medico();
        dao = new MedicoDao();
    }
    
    
    
    public String cadastrar() throws ClassNotFoundException, SQLException{
        if(getMedico().getIdMedico()== 0){
            this.getDao().cadastrar(getMedico());
            this.setMedico(new Medico());
        }else{
            this.getDao().editar(getMedico());
            this.setMedico(new Medico());
        }
        
        return "CadastrarMedico.xhtml";
        
    }
    
    public List<Medico> consultar() throws ClassNotFoundException, SQLException{
        List<Medico>list = new ArrayList<Medico>();
        list = this.getDao().consultar();
        
        return list;
        
    }
    
    public String excluir(Medico medico) throws ClassNotFoundException, SQLException{
        this.setMedico(medico);
        this.getDao().excluir(this.getMedico());
        
        return "CadastrarMedico.xhtml";
        
    }
    
    public String editar(Medico medico){
        this.setMedico(medico);
        return "CadastrarMedico.xhtml";
        
    }

    /**
     * @return the medico
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     * @param medico the medico to set
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    /**
     * @return the dao
     */
    public MedicoDao getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(MedicoDao dao) {
        this.dao = dao;
    }

}

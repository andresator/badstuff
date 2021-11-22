/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion.EstudianteGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import modelo.Estudiante;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Andres
 */
@Named(value = "estudianteController")
@SessionScoped
public class EstudianteController extends Estudiante implements Serializable {

    public EstudianteController() {
    }
    
    public List<Estudiante> getEstudiantes(){
        return EstudianteGestion.getEstudiantes();
    }
    
    public String inserta(){
        if(EstudianteGestion.insertar(this)){
            return "list.xhtml";
        } else{
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error",
            "Posible identidad duplicada");
            FacesContext.getCurrentInstance().addMessage("crudEstudianteForm:identificacion", mensaje);
            return "crud.xhtml";
        }
    }
    
    public String modifica(){
        if(EstudianteGestion.actualizar(this)){
            return "list.xhtml";
        } else{
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error",
            "Posible identidad duplicada");
            FacesContext.getCurrentInstance().addMessage("crudEstudianteForm:identificacion", mensaje);
            return "crud.xhtml";
        }
    }
    
    public String edita(String id){
        Estudiante estudiante = EstudianteGestion.getEstudiante(id);
        if(estudiante !=null){
            this.setIdEstudiante(estudiante.getIdEstudiante());
            this.setNombre(estudiante.getNombre());
            this.setApellido1(estudiante.getApellido1());
            this.setApellido2(estudiante.getApellido2());
            this.setFechaNaci(estudiante.getFechaNaci());
            this.setFechaIngr(estudiante.getFechaIngr());
            this.setGenero(estudiante.getGenero());
            return "crud.xhtml";                        
        
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error",
            "ID no existe");
            FacesContext.getCurrentInstance().addMessage("listForm", mensaje);
            return "list.xhtml";
        }
    }
    
    public String elimina (){
        
        if (EstudianteGestion.eliminar(this)){
            return "list.xhtml";
        }else{
            FacesMessage mensaje= new FacesMessage (FacesMessage.SEVERITY_ERROR,
            "Error", "Posible que el id no exista");
            FacesContext.getCurrentInstance().addMessage("crudEstudianteForm:identificacion", mensaje);
            return "crud.xhtml";
        }
        
    }
    
}

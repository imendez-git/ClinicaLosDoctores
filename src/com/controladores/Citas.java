/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controladores;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "citas", catalog = "clinicaLosDoctores", schema = "")
@NamedQueries({
    @NamedQuery(name = "Citas.findAll", query = "SELECT c FROM Citas c")
    , @NamedQuery(name = "Citas.findByIdCita", query = "SELECT c FROM Citas c WHERE c.idCita = :idCita")
    , @NamedQuery(name = "Citas.findByIdUsuario", query = "SELECT c FROM Citas c WHERE c.idUsuario = :idUsuario")
    , @NamedQuery(name = "Citas.findByMotivo", query = "SELECT c FROM Citas c WHERE c.motivo = :motivo")
    , @NamedQuery(name = "Citas.findByDiaCita", query = "SELECT c FROM Citas c WHERE c.diaCita = :diaCita")
    , @NamedQuery(name = "Citas.findByHoraCita", query = "SELECT c FROM Citas c WHERE c.horaCita = :horaCita")
    , @NamedQuery(name = "Citas.findByIdEstado", query = "SELECT c FROM Citas c WHERE c.idEstado = :idEstado")})
public class Citas implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCita")
    private Integer idCita;
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Column(name = "motivo")
    private String motivo;
    @Column(name = "diaCita")
    @Temporal(TemporalType.DATE)
    private Date diaCita;
    @Column(name = "horaCita")
    @Temporal(TemporalType.TIME)
    private Date horaCita;
    @Column(name = "idEstado")
    private Integer idEstado;

    public Citas() {
    }

    public Citas(Integer idCita) {
        this.idCita = idCita;
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        Integer oldIdCita = this.idCita;
        this.idCita = idCita;
        changeSupport.firePropertyChange("idCita", oldIdCita, idCita);
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        Integer oldIdUsuario = this.idUsuario;
        this.idUsuario = idUsuario;
        changeSupport.firePropertyChange("idUsuario", oldIdUsuario, idUsuario);
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        String oldMotivo = this.motivo;
        this.motivo = motivo;
        changeSupport.firePropertyChange("motivo", oldMotivo, motivo);
    }

    public Date getDiaCita() {
        return diaCita;
    }

    public void setDiaCita(Date diaCita) {
        Date oldDiaCita = this.diaCita;
        this.diaCita = diaCita;
        changeSupport.firePropertyChange("diaCita", oldDiaCita, diaCita);
    }

    public Date getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(Date horaCita) {
        Date oldHoraCita = this.horaCita;
        this.horaCita = horaCita;
        changeSupport.firePropertyChange("horaCita", oldHoraCita, horaCita);
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        Integer oldIdEstado = this.idEstado;
        this.idEstado = idEstado;
        changeSupport.firePropertyChange("idEstado", oldIdEstado, idEstado);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCita != null ? idCita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citas)) {
            return false;
        }
        Citas other = (Citas) object;
        if ((this.idCita == null && other.idCita != null) || (this.idCita != null && !this.idCita.equals(other.idCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vistas.Citas[ idCita=" + idCita + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

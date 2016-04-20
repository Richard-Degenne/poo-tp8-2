/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author richou
 */
@Entity
@Table(name = "Mission")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mission.findAll", query = "SELECT m FROM Mission m"),
    @NamedQuery(name = "Mission.findByIdMission", query = "SELECT m FROM Mission m WHERE m.idMission = :idMission"),
    @NamedQuery(name = "Mission.findByNameMission", query = "SELECT m FROM Mission m WHERE m.nameMission = :nameMission"),
    @NamedQuery(name = "Mission.findByLocalization", query = "SELECT m FROM Mission m WHERE m.localization = :localization"),
    @NamedQuery(name = "Mission.findByDate", query = "SELECT m FROM Mission m WHERE m.date = :date"),
    @NamedQuery(name = "Mission.findByCost", query = "SELECT m FROM Mission m WHERE m.cost = :cost"),
    @NamedQuery(name = "Mission.findByDone", query = "SELECT m FROM Mission m WHERE m.done = :done")})
public class Mission implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mission")
    private Integer id;
    @Size(max = 50)
    @Column(name = "name_mission")
    private String name;
    @Size(max = 50)
    @Column(name = "localization")
    private String localization;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cost")
    private Float cost;
    @Column(name = "done")
    private Boolean done;

    public Mission() {
    }

    public Mission(Integer idMission) {
        this.id = idMission;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if(!(object instanceof Mission)) {
            return false;
        }
        Mission other = (Mission) object;
        if((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Mission[ idMission=" + id + " ]";
    }
    
}

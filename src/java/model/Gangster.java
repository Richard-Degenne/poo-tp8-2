/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author richou
 */
@Entity
@Table(name = "Gangster")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gangster.findAll", query = "SELECT g FROM Gangster g"),
    @NamedQuery(name = "Gangster.findByIdGangster", query = "SELECT g FROM Gangster g WHERE g.idGangster = :idGangster"),
    @NamedQuery(name = "Gangster.findByFirstName", query = "SELECT g FROM Gangster g WHERE g.firstName = :firstName"),
    @NamedQuery(name = "Gangster.findByLastName", query = "SELECT g FROM Gangster g WHERE g.lastName = :lastName"),
    @NamedQuery(name = "Gangster.findByBirthDate", query = "SELECT g FROM Gangster g WHERE g.birthDate = :birthDate"),
    @NamedQuery(name = "Gangster.findByLevel", query = "SELECT g FROM Gangster g WHERE g.level = :level")})
public class Gangster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_gangster")
    private Integer id;
    @Size(max = 50)
    @Column(name = "firstName")
    private String firstName;
    @Size(max = 50)
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "birthDate")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column(name = "level")
    private Integer level;
    
    @JoinColumn(name = "id_organization_manager", referencedColumnName = "id_organization")
    @ManyToOne
    private Organization managedOrganization;
    
    @JoinColumn(name = "id_organization_member", referencedColumnName = "id_organization")
    @ManyToOne
    private Organization organization;

    public Gangster() {
    }

    public Gangster(Integer idGangster) {
        this.id = idGangster;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
    
    public Organization getManagedOrganization() {
        return managedOrganization;
    }

    public void setManagedOrganization(Organization managedOrganization) {
        if(this.managedOrganization != null)
            this.managedOrganization.setManager(null);
        this.managedOrganization = managedOrganization;
        this.managedOrganization.setManager(this);
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
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
        if(!(object instanceof Gangster)) {
            return false;
        }
        Gangster other = (Gangster) object;
        if((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Gangster[ idGangster=" + id + " ]";
    }
    
}

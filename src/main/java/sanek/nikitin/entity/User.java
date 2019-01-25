/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sanek.nikitin.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Cascade;

/**
 * @author Sanek
 * @date 25.01.2019 12:34:21
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USER_ID")
    private Long userId;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 36)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 128)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
//    @NotNull
    @Column(name = "ENABLED")
    private boolean enabled;
    
    //@Cascade({org.hibernate.annotations.CascadeType.ALL}) 
    @JoinTable(name = "user_role", joinColumns = {
        @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")})
    @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//    @ManyToMany(mappedBy = "userSet", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<Role> roleSet;

    public User() {
    }

    public User(Long userId) {
        this.userId = userId;
    }

    public User(Long userId, String name, String password, boolean enabled) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.enabled = enabled;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @XmlTransient
    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sanek.nikitin.entity.User[ userId=" + userId + " ]";
    }

}

package org.regeneration.sample.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class User {
    private Long id;
    private String username;
    private String pwd;
    private Citizen citizenById;
    private Doctor doctorById;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 32)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "pwd", nullable = false, length = 32)
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    //nice to have
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(username, user.username) &&
                Objects.equals(pwd, user.pwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, pwd);
    }

    @OneToOne(mappedBy = "userById")
    public Citizen getCitizenById() {
        return citizenById;
    }

    public void setCitizenById(Citizen citizenById) {
        this.citizenById = citizenById;
    }

    @OneToOne(mappedBy = "userById")
    public Doctor getDoctorById() {
        return doctorById;
    }

    public void setDoctorById(Doctor doctorById) {
        this.doctorById = doctorById;
    }
}

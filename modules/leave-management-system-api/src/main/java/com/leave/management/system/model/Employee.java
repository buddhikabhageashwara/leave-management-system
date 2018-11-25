package com.leave.management.system.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by buddika on 11/3/18.
 */

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @Column(name="employeeid", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(length = 25,nullable = false)
    private String name;

    @Column(length = 25,nullable = false)
    private String country;

    @OneToMany(mappedBy = "employee")
    private Set<Leave> leave = new HashSet<Leave>(
            0);

    public void setLeave(Set<Leave> leave) {
        this.leave = leave;
    }

    public Set<Leave> getLeave() {
        return leave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString(){
        return "id="+ id +", name="+name+", country="+country;
    }



}

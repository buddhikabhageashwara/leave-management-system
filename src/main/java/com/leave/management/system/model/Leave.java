package com.leave.management.system.model;

import javax.persistence.*;

/**
 * Created by buddika on 11/5/18.
 */
@Entity
@Table(name = "employee_leave")
public class Leave {

    @Id
    @Column(name="leaveID", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int leaveID;

    @ManyToOne
    @JoinColumn(name = "leave_employeeid", foreignKey = @ForeignKey(name = "fk_leave_employeeid"), referencedColumnName = "employeeid")
    private  Employee employee;


    public int getLeaveID() {
        return leaveID;
    }

    public void setLeaveID(int leaveID) {
        this.leaveID = leaveID;
    }



    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

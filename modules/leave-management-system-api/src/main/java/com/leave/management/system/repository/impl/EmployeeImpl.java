package com.leave.management.system.repository.impl;

import com.leave.management.system.model.Employee;
import com.leave.management.system.model.Leave;
import com.leave.management.system.repository.EmployeeService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by buddika on 11/3/18.
 */
public class EmployeeImpl implements EmployeeService{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Employee employee) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(employee);

        tx.commit();

        session.close();

        Leave leave=new Leave();


        leave.setEmployee(employee);

        Session session2 = this.sessionFactory.openSession();
        Transaction tx2 = session2.beginTransaction();
        session2.persist(leave);
        tx2.commit();

        session2.close();

    }

    @SuppressWarnings("unchecked")
    public List<Employee> retrieve() {
        Session session = this.sessionFactory.openSession();
        List<Employee> employeeList = session.createQuery("from Employee").list();
        session.close();
        return employeeList;
    }

}

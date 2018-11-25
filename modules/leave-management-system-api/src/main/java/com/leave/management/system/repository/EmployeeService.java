package com.leave.management.system.repository;

import com.leave.management.system.model.Employee;

import java.util.List;

/**
 * Created by buddika on 11/3/18.
 */
public interface EmployeeService {
    void save(Employee employee);

    @SuppressWarnings("unchecked")
    List<Employee> retrieve();
}

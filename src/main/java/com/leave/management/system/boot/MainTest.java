package com.leave.management.system.boot;

import com.leave.management.system.model.Employee;
import com.leave.management.system.repository.EmployeeService;
import com.leave.management.system.repository.impl.EmployeeImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by buddika on 11/4/18.
 */
public class MainTest {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("leave-management-system-spring-context.xml");

        EmployeeImpl employeeImpl = context.getBean(EmployeeImpl.class);


        Employee person = new Employee();
        person.setName("Pankaj"); person.setCountry("India");

        employeeImpl.save(person);

        System.out.println("Person::"+person);

        List<Employee> list = employeeImpl.retrieve();

        for(Employee p : list){
            System.out.println("Employee List::"+p);
        }
        //close resources
        context.close();
    }

}

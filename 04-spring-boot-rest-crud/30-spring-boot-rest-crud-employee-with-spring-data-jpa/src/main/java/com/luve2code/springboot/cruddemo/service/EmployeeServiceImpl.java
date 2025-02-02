package com.luve2code.springboot.cruddemo.service;

import com.luve2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luve2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        /*Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee = null;

        if (result.isPresent()){
            theEmployee = result.get();
        }
        else {
            throw new RuntimeException("Employee id not found - " + theId);
        }
        return theEmployee;*/

        return employeeRepository.findById(theId)
                .orElseThrow(() -> new RuntimeException("Employee id not found - " + theId));
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {

        employeeRepository.deleteById(theId);
    }
}

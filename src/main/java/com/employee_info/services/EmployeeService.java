package com.employee_info.services;

import com.employee_info.entities.EmployeeRole;
import com.employee_info.exceptions.EmployeeNotFoundException;
import com.employee_info.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

                    @Autowired
                    private EmployeeRepo employeeRepo;

                    public EmployeeRole saveEmployee(EmployeeRole employee)
                    {

                        return employeeRepo.save(employee);

                    }

                    public List<EmployeeRole> getAllEmployees()
                    {
                        return employeeRepo.findAll();
                    }

                    public Optional<EmployeeRole> getEmployeeById(Integer id)
                    {
                        Optional<EmployeeRole> emp = employeeRepo.findById(id);
                        if(emp.isEmpty())
                        {
                            throw new EmployeeNotFoundException("Employee Id does not exist"+emp.get().getBemsId());
                        }
                        return emp;

                    }

                    public EmployeeRole updateEmployee(EmployeeRole employee) {
                        Optional<EmployeeRole> emp = employeeRepo.findById(employee.getBemsId());
                        if (emp.isEmpty())
                        {
                            throw new EmployeeNotFoundException("Employee Id does not exist" + emp.get().getBemsId());
                        }
                        else
                        {
                            EmployeeRole e = EmployeeRole.builder()
                                    .bemsId(employee.getBemsId())
                                    .firstName(employee.getFirstName())
                                    .lastName(employee.getLastName())
                                    .role(employee.getRole())
                                    .program(employee.getProgram())
                                    .services(employee.getServices())
                                    .build();

                            return employeeRepo.save(e);
                        }
                    }


                    public void deleteEmployeeById(Integer id)
                    {
                        Optional<EmployeeRole> emp = employeeRepo.findById(id);
                        if(emp.isEmpty())
                        {
                            throw new EmployeeNotFoundException("Employee Id does not exist"+emp.get().getBemsId());
                        }
                        employeeRepo.deleteById(id);

                    }

}

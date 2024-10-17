package com.employee_info.controllors;

import com.employee_info.entities.EmployeeRole;
import com.employee_info.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/employees")
public class EmployeeControllor {
                    @Autowired
                    private EmployeeService employeeService;


                    @GetMapping("/list")
                    public List<EmployeeRole> allEmployeeList()
                    {
                        return employeeService.getAllEmployees();
                    }

                    @GetMapping("/{id}")
                    public ResponseEntity<EmployeeRole> getEmployeeFromId(@PathVariable Integer id)
                   {
                       return new ResponseEntity<>(employeeService.getEmployeeById(id).get(), HttpStatus.FOUND);

                   }

                   @PostMapping("/addEmployee")
                   public ResponseEntity<EmployeeRole> addNewEmployee(@RequestBody EmployeeRole employee)
                   {
                      return new ResponseEntity<>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
                   }

                  @PutMapping("/update")
                  public ResponseEntity<EmployeeRole> updateExistingEmployee(@RequestBody EmployeeRole employee)
                   {
                       return new ResponseEntity<>(employeeService.updateEmployee(employee),HttpStatus.OK);

                   }

                 @DeleteMapping("/delete/{id}")
                 public ResponseEntity<EmployeeRole> deleteEmployee(@PathVariable  Integer id)
                   {
                       employeeService.deleteEmployeeById(id);
                       return new ResponseEntity<>(HttpStatus.GONE);

                   }


}

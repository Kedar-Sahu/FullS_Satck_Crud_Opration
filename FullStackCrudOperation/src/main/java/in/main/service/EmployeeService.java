package in.main.service;

import java.util.List;

import in.main.entity.Employee;

public interface EmployeeService {
	
	Employee create(Employee employee);
    Employee getEmployee(long id);
    List<Employee> getAll();
    Employee update(long id,Employee employee);
    Boolean delete(long id);
}

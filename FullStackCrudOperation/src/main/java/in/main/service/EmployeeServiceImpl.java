package in.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.main.entity.Employee;
import in.main.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository repository;

	@Override
	public Employee create(Employee employee) {
		return repository.save(employee);
	}

	@Override
	public Employee getEmployee(long id) {
		Employee employee=repository.findById(id).orElseThrow(()->new RuntimeException("Employee id not found"));
		return employee;
	}

	@Override
	public List<Employee> getAll() {
		return repository.findAll();
	}

	@Override
	public Employee update(long id, Employee employee) {
		Employee emp=repository.findById(id).orElseThrow(()->new RuntimeException("Employee id not found"));
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setEmail(employee.getEmail());
		Employee emp1=repository.save(emp);
		return emp1;
	}

	@Override
	public Boolean delete(long id) {
		Employee employee=repository.findById(id).orElseThrow(()->new RuntimeException("Employee id not found"));
		if(employee!=null) {
			repository.delete(employee);
			return true;
		}
		return false;
	}

}

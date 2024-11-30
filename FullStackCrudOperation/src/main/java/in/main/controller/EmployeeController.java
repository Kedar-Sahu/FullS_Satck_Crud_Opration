package in.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.main.entity.Employee;
import in.main.service.EmployeeService;

@CrossOrigin(origins="http://localhost:4200/")
@RestController
@RequestMapping("/api/")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;

	@PostMapping("/save")
	public ResponseEntity<Employee> save(@RequestBody Employee employee){
		return new ResponseEntity<>(empService.create(employee),HttpStatus.CREATED);
	}
	
	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
		return new ResponseEntity<>(empService.getEmployee(id),HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAll(){
		return new ResponseEntity<>(empService.getAll(),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> update(@PathVariable Long id,@RequestBody Employee employee){
		return new ResponseEntity<>(empService.update(id, employee),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		empService.delete(id);
		return new ResponseEntity<>("employee delete success",HttpStatus.OK);
	}
	
}

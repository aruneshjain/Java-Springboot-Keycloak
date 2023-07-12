package com.example.springbootkeycloak;

import com.example.springbootkeycloak.entity.Employee;
import com.example.springbootkeycloak.service.EmployeeService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@SpringBootApplication
@RequestMapping("/employees")
public class SpringbootKeycloakApplication {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/{employeeId")
	@RolesAllowed("user")
	public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId){
		return ResponseEntity.ok(employeeService.getEmployee(employeeId));
	}

	@GetMapping("/{employeeId")
	@RolesAllowed("admin")
	public ResponseEntity<List<Employee>> findAllEmployees(){
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootKeycloakApplication.class, args);
	}

}

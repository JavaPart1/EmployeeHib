package be.vdabbeele.Employee.Services;

import be.vdabbeele.Employee.Domain.Employee;
import be.vdabbeele.Employee.Domain.Profession;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public int addEmployee(Employee employee);

    public Employee findById(int id);

    public void update(Employee employee);

    public void deleteById(int id);

    public List<Profession> getProfessions();

}

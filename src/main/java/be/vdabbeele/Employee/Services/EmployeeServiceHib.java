package be.vdabbeele.Employee.Services;

import be.vdabbeele.Employee.Domain.Employee;
import be.vdabbeele.Employee.Domain.Profession;
import be.vdabbeele.Employee.Repositories.EmployeeDAO;
import be.vdabbeele.Employee.Repositories.EmployeeHib;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier(value = "empService")
public class EmployeeServiceHib {
    @Autowired
    EmployeeHib e;

    public List<Employee> getAllEmployees(){
        return e.getAllEmployees();
    }

    public void addEmployee(Employee employee) {
        e.addEmp(employee);
    }

    public Employee findById(int id) {
        return e.findById(id);
    }

    public void update(Employee employee) {
        e.update(employee);
    }

    public void deleteById(int id) {
        e.deleteById(id);
    }

    public List<Profession> getProfessions() {
        return e.getProfessions();
    }


}

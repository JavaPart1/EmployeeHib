package be.vdabbeele.Employee.Services;

import be.vdabbeele.Employee.Domain.Employee;
import be.vdabbeele.Employee.Domain.Profession;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier(value = "hrService")
public class HRServiceImpl implements EmployeeService{
    @Override
    public List<Employee> getAllEmployees() {
        System.out.println("in hr service");
        return null;
    }

    @Override
    public int addEmployee(Employee employee) {
        System.out.println("not implemented");
        int i = 0;
        return i;
    }

    @Override
    public Employee findById(int id) {
        System.out.println("not implemented");
        return null;
    }

    @Override
    public void update(Employee employee) {
        System.out.println("not implemented");
    }

    @Override
    public void deleteById(int id) {
        System.out.println("not implemented");
    }

    @Override
    public List<Profession> getProfessions() {
        System.out.println("not implemented");
        return null;
    }
}

package be.vdabbeele.Employee.Services;

import be.vdabbeele.Employee.Domain.Employee;
import be.vdabbeele.Employee.Domain.Profession;
import be.vdabbeele.Employee.Repositories.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier(value = "empService")
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeDAO dao;

    public List<Employee> getAllEmployees(){
        return dao.getAllEmployees();
    }

    @Override
    public int addEmployee(Employee employee) {
        return dao.addEmployee(employee);
    }

    @Override
    public Employee findById(int id) {
        return dao.findById(id);
    }


    @Override
    public void update(Employee employee) {
        dao.update(employee);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public List<Profession> getProfessions() {
        return dao.getProfessions();
    }


}

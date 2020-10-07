package be.vdabbeele.Employee.Repositories;

import be.vdabbeele.Employee.Domain.Employee;
import be.vdabbeele.Employee.Domain.Profession;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeHib {

    public void addEmp(Employee employee){
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            // Domain creations
            System.out.println(employee.toString());
            tx.begin();
            em.persist(employee);
            tx.commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }

    public List<Employee> getAllEmployees() {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        List<Employee> employees = new ArrayList<>();

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx =em.getTransaction();
            TypedQuery<Employee> query = em.createNamedQuery("getAllEmployees", Employee.class);

            tx.begin();
            employees = query.getResultList();
            tx.commit();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
            return employees;
        }

    }

    public List<Profession> getProfessions() {
        return Arrays.stream(Profession.values()).collect(Collectors.toList());

    }

    public Employee findById(int id) {
        return null;
    }

    public void deleteById(int id) {
        return;
    }

    public void update(Employee employee) {
    }
}

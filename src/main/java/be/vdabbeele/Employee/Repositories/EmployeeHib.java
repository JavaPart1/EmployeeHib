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

    public void deleteById(int id) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            // Get employee by ID
            TypedQuery<Employee> queryEmp = em.createNamedQuery("getEmployeeById", Employee.class);
            queryEmp.setParameter("empid",id);
            tx.begin();
            Employee employee = queryEmp.getSingleResult();
            tx.commit();
            // Remove employee
            tx.begin();
            em.remove(employee);
            tx.commit();
        } catch (Exception exception){
            System.out.println(exception.getMessage().toString());
            System.out.println("Delete is not executed");
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }

    public List<Profession> getProfessions() {
        return Arrays.stream(Profession.values()).collect(Collectors.toList());

    }

    public Employee findById(int id) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Employee employee = new Employee();

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            // Get employee by ID
            TypedQuery<Employee> queryEmp = em.createNamedQuery("getEmployeeById", Employee.class);
            queryEmp.setParameter("empid",id);
            tx.begin();
            employee = queryEmp.getSingleResult();
            tx.commit();
        } catch (Exception exception){
            System.out.println(exception.getMessage().toString());
            System.out.println("Delete is not executed");
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
            return employee;
        }
    }

    public void update(Employee newemployee) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            System.out.println("Entering update Hib");
            System.out.println("New employee: " + newemployee.toString());
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            // Get employee by ID
            TypedQuery<Employee> queryEmp = em.createNamedQuery("getEmployeeById", Employee.class);
            queryEmp.setParameter("empid",newemployee.getId());
            tx.begin();
            Employee oldemployee = queryEmp.getSingleResult();
            tx.commit();
            System.out.println("Old employee: " + oldemployee.toString());
            // Update employee in persistence area
            tx.begin();
            oldemployee.setFirstName(newemployee.getFirstName());
            oldemployee.setLastName(newemployee.getLastName());
            oldemployee.setProfession(newemployee.getProfession());
            tx.commit();
            System.out.println("Update executed");
        } catch (Exception exception){
            System.out.println(exception.getMessage().toString());
            System.out.println("Update is not executed");
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}

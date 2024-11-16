package com.papillon.rhmanagement.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String surname;
    private String position;
    private double salary;
    private String departement;

    
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        result = prime * result + ((position == null) ? 0 : position.hashCode());
        long temp;
        temp = Double.doubleToLongBits(salary);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((departement == null) ? 0 : departement.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (surname == null) {
            if (other.surname != null)
                return false;
        } else if (!surname.equals(other.surname))
            return false;
        if (position == null) {
            if (other.position != null)
                return false;
        } else if (!position.equals(other.position))
            return false;
        if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
            return false;
        if (departement == null) {
            if (other.departement != null)
                return false;
        } else if (!departement.equals(other.departement))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + ", position=" + position + ", salary="
                + salary + ", departement=" + departement + "]";
    }
    public Employee() {
    }
    public Employee(String name, String surname, String position, double salary, String departement) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.salary = salary;
        this.departement = departement;
    }
    public Employee(UUID id, String name, String surname, String position, double salary, String departement) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.salary = salary;
        this.departement = departement;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getDepartement() {
        return departement;
    }
    public void setDepartement(String departement) {
        this.departement = departement;
    }

    
}

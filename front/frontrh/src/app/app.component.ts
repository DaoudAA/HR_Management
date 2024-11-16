import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { EmployeeCardComponent } from './employee-card/employee-card.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { EmpoyeeControllerService } from './services/services/empoyee-controller.service';
import { AddEmployee$Params } from './services/fn/empoyee-controller/add-employee';
import { Employee } from './services/models/employee';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule, EmployeeCardComponent,FormsModule,HttpClientModule],     
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit  {
  employees: Employee[] = [];
  showAddEmployeeForm = false;
  newEmployee: Employee = {
    id: '',
    name: '',
    surname: '',
    position: '',
    departement: '',
    salary: 0
  };

  constructor(private employeeService: EmpoyeeControllerService) {}
  

  ngOnInit(): void {
    this.loadEmployees();
  }
 
  toggleAddEmployeeForm() {
    this.showAddEmployeeForm = !this.showAddEmployeeForm;
  }

  addEmployee() { 
    const emp: Employee = {
      id:this.newEmployee.id,
      name: this.newEmployee.name,
      surname: this.newEmployee.surname,
      position: this.newEmployee.position,
      departement: this.newEmployee.departement,
      salary: this.newEmployee.salary
    };

    const employeeData: AddEmployee$Params = {
      employee: emp
    };

    this.employeeService.addEmployee(employeeData).subscribe({
      next: (employee) => {
       
        this.resetNewEmployeeForm();
      },
      error: (err) => console.error('Error adding employee:', err)
    });
    this.employees.push(emp);
    console.log(emp)
  }

  loadEmployees() {
    this.employeeService.getEmployees().subscribe({
      next: (employees) => {
        console.log('API response:', employees);
        this.employees = employees;
      },
      error: (err) => console.error('Error fetching employees:', err)
    });
  }
  onEmployeeDeleted(id: String) {
    this.employees = this.employees.filter(employee => employee.id !== id);   
  } 

  onEmployeeUpdated(emp: Employee) {
    this.employees.map(employee => {
      if(employee.id==emp.id){
        employee.departement=emp.departement;
        employee.name=emp.name;
        employee.surname=emp.surname;
        employee.salary=emp.salary;
        employee.position=emp.position;
    
      }
    });   
  }

  private resetNewEmployeeForm() {
    this.newEmployee = { id: '', name: '', surname: '', position: '', departement: '', salary: 0 };
    this.showAddEmployeeForm = false;
  }
}
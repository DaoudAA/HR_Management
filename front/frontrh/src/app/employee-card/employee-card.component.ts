import { Component, EventEmitter, Input, Output } from '@angular/core';

import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { EmpoyeeControllerService } from '../services/services';
import { AddEmployee$Params } from '../services/fn/empoyee-controller/add-employee';
import { UpdateEmployee$Params } from '../services/fn/empoyee-controller/update-employee';
import { Employee } from '../services/models/employee';
 

@Component({
  selector: 'app-employee-card',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './employee-card.component.html',
  styleUrls: ['./employee-card.component.css']
})
export class EmployeeCardComponent {
  @Input() employee!: Employee;
  @Output() employeeDeleted = new EventEmitter<String>(); 
  @Output() employeeUpdated = new EventEmitter<Employee>();
  showForm = false;
  editableEmployee: Employee = { ...this.employee };

  constructor(private employeeService: EmpoyeeControllerService) {}

  toggleEditForm(): void {
    this.showForm = !this.showForm;
    if (!this.showForm) {
       
      this.editableEmployee = { ...this.employee };
    }
  }

  updateEmployee(): void {
    const updateParams = {
      id: this.employee.id!,
      name: this.editableEmployee.name,
      surname: this.editableEmployee.surname,
      position: this.editableEmployee.position,
      departement: this.editableEmployee.departement,
      salary: this.editableEmployee.salary
    };
    const employeeData: UpdateEmployee$Params = {
      id: updateParams.id,
      body: updateParams
    };

    this.employeeService.updateEmployee(employeeData).subscribe({
      next: (updatedEmployee) => {
        Object.assign(this.employee, updatedEmployee);
        this.toggleEditForm();
        console.log('Employee updated:', updatedEmployee);
      },
      error: (err) => console.error('Error updating employee:', err)
    }); 
    this.employeeUpdated.emit(updateParams)
  }

  deleteEmployee(): void {
    this.employeeService.deleteEmployee({ id: this.employee.id ?? ''}).subscribe({
      next: () => {
        console.log('Employee deleted:', this.employee);
         
      },
      error: (err) => console.error('Error deleting employee:', err)
    }); 
    this.employeeDeleted.emit(this.employee.id);
  } 


  
}

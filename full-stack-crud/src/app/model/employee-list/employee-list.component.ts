import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { EmployeeService } from '../../service/employee.service';
import { Employee } from '../employee';
import { error } from 'console';

@Component({
  selector: 'app-employee-list',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './employee-list.component.html',
  styleUrl: './employee-list.component.css'
})
export class EmployeeListComponent{

  employeeForm: FormGroup=new FormGroup({});
  employeeObj:Employee=new Employee();
  employeeList:Employee[]=[];


  constructor(private employeeService:EmployeeService){
    this.createForm();
    this.getEmployees();
  }


  createForm(){
    this.employeeForm=new FormGroup({
      id:new FormControl(this.employeeObj.id),
      firstName:new FormControl(this.employeeObj.firstName),
      lastName:new FormControl(this.employeeObj.lastName),
      email:new FormControl(this.employeeObj.email)
    });
  }


  private getEmployees(){
    this.employeeService.getEmployeeList().subscribe((data=>{
      this.employeeList=data;
    }));
  }

  onSubmit(){
    // debugger;
    this.employeeObj=this.employeeForm.value;
    this.employeeService.postEmployee(this.employeeObj).subscribe((data:Employee)=>{
      // debugger
    },error=>{
      console.log(error);
    });
    this.onReset();
  }

  onEdit(item:Employee){
    this.employeeObj=item;
    this.createForm();
  }

  onUpdate(id:number){
    // debugger;
    this.employeeObj=this.employeeForm.value;
    this.employeeService.updateEmployee(id,this.employeeObj).subscribe((data:Employee)=>{
  
    },error=>{
      console.log(error);
    });
    this.onReset();
  }


  onDelete(id:number){
    const isDelete=confirm("are you want to delete this employee !");
    if(isDelete){
      this.employeeService.deleteEmployee(id).subscribe((data:Employee)=>{
       
      },error=>{
        console.log(error);
      });
    }
  }

  onReset(){
    this.employeeObj=new Employee();
    this.createForm();
  }

}

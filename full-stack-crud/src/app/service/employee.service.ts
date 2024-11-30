import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../model/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseURL="http://localhost:8080/";


  constructor(private httpClient:HttpClient) { }

  getEmployeeList():Observable<Employee[]>{
        return this.httpClient.get<Employee[]>(`${this.baseURL}`+"api/getAll");
  }

  postEmployee(obj:Employee):Observable<Employee>{
    return this.httpClient.post<Employee>(`${this.baseURL}`+"api/save",obj);
  }

  updateEmployee(id:number,obj:Employee):Observable<Employee>{
    return this.httpClient.put<Employee>(`${this.baseURL}`+ "api/update/" +id,obj);
  }


  deleteEmployee(id:number):Observable<Employee>{
    return this.httpClient.delete<Employee>(`${this.baseURL}`+"api/delete/"+id);
  }
}

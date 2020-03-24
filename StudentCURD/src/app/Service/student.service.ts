import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import { StudentVM } from '../Class/student-vm';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

   Url = 'http://localhost:8091/services';
  constructor(private http:HttpClient) { }
  getStudent():Observable<StudentVM[]>
  {
    return this.http.get<StudentVM[]>(this.Url + '/student');
  }
  CreateStudent(OutletVM:StudentVM):Observable<StudentVM[]>
  {
   const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) };
    return this.http.post<StudentVM[]>(this.Url + '/student/save', OutletVM, httpOptions)
  }
  UpdateStudent(StudentId: string,OutletVM:StudentVM):Observable<StudentVM[]>
  {
   const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) };
    return this.http.post<StudentVM[]>(this.Url+'/student/update/'+StudentId, OutletVM, httpOptions)
  }
  DeleteStudentDetail(StudentId:string):Observable<number>
  {
    return this.http.get<number>(this.Url + '/student/delete/'+StudentId);
  }
  getStudentById(StudentId: string): Observable<StudentVM>
   {
    return this.http.get<StudentVM>(this.Url + '/student/' + StudentId);
  }
}

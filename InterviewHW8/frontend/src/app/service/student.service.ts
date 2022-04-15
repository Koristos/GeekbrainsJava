import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Student} from "./student";

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(public http: HttpClient) { }

  public findAll() {
    return this.http.get<Student[]>("api/v1/student/all");
  }

  public findById(id: number) {
    return this.http.get<Student>(`api/v1/student/${id}`);
  }

  public delete(id: number) {
    const params = new HttpParams()
      .set('id', id);
    return this.http.delete<boolean>(`api/v1/student/delete`, {params});
  }

  public add(student: Student) {
        console.log(`add ${student.firstName} ${student.lastName}`);
       return this.http.post<boolean>(`api/v1/student/add`, student);
  }

  public update(student: Student) {
    console.log(`add ${student.firstName} ${student.lastName}`);
    return this.http.put<boolean>(`api/v1/student/update`, student);
  }
}

import { Component, OnInit } from '@angular/core';
import {StudentService} from "../service/student.service";
import {Student} from "../service/student";

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.less']
})
export class StudentListComponent implements OnInit {

  students: Student[] = [];

  constructor(public studentService: StudentService) { }

  ngOnInit(): void {
    this.retrieveAllStudents();
  }

  private retrieveAllStudents() {
    this.studentService.findAll().subscribe(students => {
      console.log(`New data from server! ${students}`);
      this.students = students;
    }, error => {
      console.log(`Error ${error}`);
    });
  }

  delete(id: number) {
    console.log("Trying to delete!");
    this.studentService.delete(id).subscribe(responce =>{
      console.log(`Delete result: ${responce}`);
      this.retrieveAllStudents();
    }, error => {
      console.log(`Error ${error}`);
    });
  }
}

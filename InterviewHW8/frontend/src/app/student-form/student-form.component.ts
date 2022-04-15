import { Component, OnInit } from '@angular/core';
import {StudentService} from "../service/student.service";
import {Student} from "../service/student";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-student-form',
  templateUrl: './student-form.component.html',
  styleUrls: ['./student-form.component.less']
})
export class StudentFormComponent implements OnInit {

  public student = new Student(-1, "", "",0);

  constructor(public studentService: StudentService,
              public route: ActivatedRoute,
              public router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(({id}) => {
      if (id == "new") {
        this.student = new Student(-1, "", "",0);
      }
      this.studentService.findById(id)
        .subscribe(student => {
          this.student = student;
        }, error => {
          console.log(`Error ${error}`);
        });
    });
  }

  save() {
    if (this.student.id == -1){
      this.studentService.add(this.student).subscribe( res => {
        this.router.navigate(['/student']);
      }, error => {
        console.log(`Error ${error}`);
      });
    }else {
      this.studentService.update(this.student).subscribe( res => {
        this.router.navigate(['/student']);
      }, error => {
        console.log(`Error ${error}`);
      });
    }
  }
}

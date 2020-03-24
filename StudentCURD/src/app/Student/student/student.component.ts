import { Component, OnInit } from '@angular/core';
import { StudentVM } from '../../Class/student-vm';
import { StudentService } from '../../Service/student.service';
import { Observable } from 'rxjs';
import { NgForm, FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { AddressVm } from 'src/app/Class/address-vm';
import { TelephoneVm } from 'src/app/Class/telephone-vm';
import { StudentUI } from 'src/app/Class/student-ui';
@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  dataSaved = false;
  massage:string;
  FromStudent: any;
  StudentId:string="0";
  allStudent:Observable<StudentVM[]>;
  //student:StudentVM;
  address:AddressVm;
  telephones:TelephoneVm[];
  constructor(private formbulider: FormBuilder,private StudentService:StudentService) { }
  GetStudent( )
  {
   // debugger;
    this.allStudent=this.StudentService.getStudent();
  }
  Reset()
  {
    this.FromStudent.reset();
  }
  AddStudent(StudentUIModel:StudentUI)
  {
    //debugger;
   // StudentUIModel.studentid=this.StudentId;
console.log("test",StudentUIModel);
//alert(StudentUIModel.studentid);
var student: StudentVM ;


student.studentid=StudentUIModel.studentid;
student.firstname=StudentUIModel.firstname;
student.lastname=StudentUIModel.lastname;
student.studentclass=StudentUIModel.studentclass;


student.address.id=StudentUIModel.addressid;
student.address.city=StudentUIModel.addresscity;
student.address.no=StudentUIModel.addressno;
student.address.street=StudentUIModel.addressstreet;
student.address.town=StudentUIModel.addresstown;

student.telephones[0].id=StudentUIModel.telephones_id1;
student.telephones[0].no=StudentUIModel.telephones_no1;
student.telephones[1].id=StudentUIModel.telephones_id2;
student.telephones[1].no=StudentUIModel.telephones_no2;
console.log("test123",student);

// __proto__: Object
// studentid: 1
// addressid: 10
// telephones_id: 1
// firstname: "shaya12"
// lastname: "saya"
// studentclass: "6"
// addressno: "3"
// addressstreet: "sangam lane"
// addresstown: "wellawatta"
// addresscity: "Colombo"
// telephones_no1: 123456789
// telephones_no2: 980765432

    if(student.studentid=="0"){
      this.StudentService.CreateStudent(student).subscribe(
        ()=> {
         this.dataSaved = true;
         this.massage = 'Record saved Successfully';
         this.GetStudent();
         this.Reset();
         this.StudentId="0";
         } );
    }
  
else{
  this.StudentService.UpdateStudent(student.studentid.toString(),student).subscribe(
    ()=> {
     this.dataSaved = true;
     this.massage = 'Record Update Successfully';
     this.GetStudent();
     this.Reset();
    this.StudentId="0";
     } );
}
    
  }
  DeleteStudent(StudentId:string)
  {
    if(confirm("Are You Sure To Delete this Informations"))
    {
      this.StudentService.DeleteStudentDetail(StudentId).subscribe(
        ()=>
        {
          this.dataSaved = true;
          this.massage="Deleted Successfully";
          this.GetStudent();
        }
      );
    }
  }
  StudentEdit(StudentId: string) {
    //debugger;
    this.StudentService.getStudentById(StudentId).subscribe(Response => {
      this.massage = null;
      this.dataSaved = false;
     // debugger;
    this.StudentId = Response.studentid;
    this.FromStudent.controls['studentid'].setValue(Response.studentid);
     this.FromStudent.controls['firstname'].setValue(Response.firstname);
     this.FromStudent.controls['lastname'].setValue(Response.lastname);
     this.FromStudent.controls['studentclass'].setValue(Response.studentclass);
     this.FromStudent.controls['addressid'].setValue(Response.address.id);
     this.FromStudent.controls['addressno'].setValue(Response.address.no);
     this.FromStudent.controls['addressstreet'].setValue(Response.address.street);
     this.FromStudent.controls['addresstown'].setValue(Response.address.town);
     this.FromStudent.controls['addresscity'].setValue(Response.address.city);
     this.FromStudent.controls['telephonesid'].setValue(Response.telephones[0].id);
     this.FromStudent.controls['telephonesno1'].setValue(Response.telephones[0].no);
     this.FromStudent.controls['telephonesno2'].setValue(Response.telephones[1].no);
    // this.FromStudent.controls['telephones_no2'].setValue(Response.telephones[1].no);
    });
  }
  ngOnInit(): void {
    this.FromStudent = this.formbulider.group({
      studentid: ['', ''],
      addressid: ['', ''],
      telephonesid: ['', ''],
      firstname: ['', [Validators.required]],
      lastname: ['', [Validators.required]],
      studentclass: ['', [Validators.required]],
      addressno: ['', [Validators.required]],
      addressstreet: ['', [Validators.required]],
      addresstown: ['', [Validators.required]],
      addresscity: ['', [Validators.required]],
      telephonesno1: ['', [Validators.required]],
      telephonesno2: ['', [Validators.required]],
      

  });
  this.GetStudent();


}
}

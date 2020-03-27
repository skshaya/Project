import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentComponent } from './Student/student/student.component';
import { HttpClientModule } from "@angular/common/http";
import { VehicleComponent } from './Vehicle/vehicle/vehicle.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentComponent,
    VehicleComponent
  ],
  imports: [
    BrowserModule,HttpClientModule,
    AppRoutingModule,ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClient} from '@angular/common/http';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app.routes';
import { HomeComponent } from './home/home.component';
import { CommonModule } from '@angular/common';


@NgModule({
  declarations: [AppComponent,HomeComponent],
  imports: [BrowserModule, FormsModule, HttpClient, AppRoutingModule,ReactiveFormsModule,CommonModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}

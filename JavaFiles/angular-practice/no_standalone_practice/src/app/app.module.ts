import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './home/home.component';
import { CommonModule } from '@angular/common';



@NgModule({
  declarations: [AppComponent,HomeComponent],
  imports: [BrowserModule, FormsModule, HttpClientModule, AppRoutingModule,ReactiveFormsModule,CommonModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
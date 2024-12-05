import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClient} from '@angular/common/http';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app.routes';
import { HomeComponent } from './home/home.component';
import { CommonModule } from '@angular/common';
import { MainComponent } from './component/main/main.component';


@NgModule({
  declarations: [AppComponent,HomeComponent,MainComponent],
  imports: [BrowserModule, FormsModule, HttpClient, AppRoutingModule,ReactiveFormsModule,CommonModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}

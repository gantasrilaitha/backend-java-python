import { Component } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { MainComponent } from './component/main/main.component';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { AppRoutingModule } from './app.routes';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'crud_angular';
}

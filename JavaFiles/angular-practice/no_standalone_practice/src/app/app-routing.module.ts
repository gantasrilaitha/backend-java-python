import { RouterModule, Routes } from '@angular/router';

import { NgModule } from '@angular/core';
import { HomeComponent } from './home/home.component';
import { BrowserModule } from '@angular/platform-browser';

export const routes: Routes = [
    {
        path: '',
        component: HomeComponent,
      },
      
];

@NgModule({
    imports: [BrowserModule,RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
export class AppRoutingModule { }


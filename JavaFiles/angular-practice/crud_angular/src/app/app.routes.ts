import { RouterModule, Routes } from '@angular/router';
import { MainComponent } from './component/main/main.component';
import { NgModule } from '@angular/core';
import { HomeComponent } from './home/home.component';
import { BrowserModule } from '@angular/platform-browser';

export const routes: Routes = [
    {
        path: '',
        component: HomeComponent,
      },
      {
        path: 'main',
        component: MainComponent,
      },
];

@NgModule({
    imports: [BrowserModule,RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
export class AppRoutingModule { }


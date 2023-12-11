import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ContactComponent } from './components/contact/contact.component';
import { ServicesComponent } from './components/services/services.component';
import { AboutUsComponent } from './components/about-us/about-us.component';

export const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', title: 'Home', component: HomeComponent },
  { path: 'contact', title: 'Contact', component: ContactComponent},
  { path: 'services/:id', title: 'Services', component: ServicesComponent},
  { path: 'about', title: 'About', component: AboutUsComponent}
];  

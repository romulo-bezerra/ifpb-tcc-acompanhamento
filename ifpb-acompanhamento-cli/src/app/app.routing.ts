import { Routes, ActivatedRoute } from '@angular/router'
import { HomeComponent } from './home/home.component';
import { DefesaComponent } from './defesa/defesa.component';
import { MaterialApoioComponent } from './material-apoio/material-apoio.component';

export const ROUTES : Routes = [
    {path: "", component: HomeComponent},
    {path: "teste", component: HomeComponent},
    {path: "material-apoio", component: MaterialApoioComponent},
    {path: "defesa", component: DefesaComponent}
];
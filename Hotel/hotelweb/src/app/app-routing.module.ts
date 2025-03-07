import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { WorkspaceComponent } from './pages/workspace/workspace.component';

const routes: Routes = [
  {path:'workspace', component:WorkspaceComponent},
  {path:'home', component:HomeComponent},
  {path:'**', component:HomeComponent},
  {path:' ', component:HomeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

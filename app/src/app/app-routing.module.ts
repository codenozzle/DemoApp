import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerComponent } from './customer/customer.component';
import { AccountComponent } from './account/account.component';
import { TransactionComponent } from './transaction/transaction.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import {CustomerOverviewComponent} from "./customer-overview/customer-overview.component";

const routes: Routes = [
  { path: 'customer-overview/:id', component: CustomerOverviewComponent },
  { path: 'customers', component: CustomerComponent },
  { path: 'accounts', component: AccountComponent },
  { path: 'transactions', component: TransactionComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { enableTracing: true })],
  exports: [RouterModule]
})
export class AppRoutingModule {}

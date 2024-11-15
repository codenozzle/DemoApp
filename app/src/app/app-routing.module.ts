import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerComponent } from './customer/customer.component';
import { AccountComponent } from './account/account.component';
import { TransactionComponent } from './transaction/transaction.component';

const routes: Routes = [
  { path: 'customers', component: CustomerComponent },
  { path: 'accounts', component: AccountComponent },
  { path: 'transactions', component: TransactionComponent },
  { path: '', redirectTo: '/customers', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}

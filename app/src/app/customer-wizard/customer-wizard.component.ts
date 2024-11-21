import {Component, inject} from '@angular/core';
import {FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {MatStep, MatStepLabel, MatStepper, MatStepperNext, MatStepperPrevious} from "@angular/material/stepper";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {MatButton} from "@angular/material/button";
import {MatCard, MatCardContent, MatCardHeader} from "@angular/material/card";
import {NgIf} from "@angular/common";
import {CustomerWizardModel} from "../models/customerWizard.model";
import {ApiService} from "../api.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-customer-wizard',
  standalone: true,
  imports: [
    MatStep,
    ReactiveFormsModule,
    MatFormField,
    MatInput,
    MatStepLabel,
    MatStepperPrevious,
    MatStepperNext,
    MatButton,
    MatStepper,
    FormsModule,
    MatCard,
    MatCardContent,
    MatCardHeader,
    MatLabel,
    NgIf
  ],
  templateUrl: './customer-wizard.component.html',
  styleUrl: './customer-wizard.component.scss'
})
export class CustomerWizardComponent {
  private _formBuilder = inject(FormBuilder);

  nameFormGroup = this._formBuilder.group({
    nameCtrl: ['', Validators.required],
  });
  creditCardFormGroup = this._formBuilder.group({
    creditCardCtrl: ['', Validators.required],
  });
  typeFormGroup = this._formBuilder.group({
    typeCtrl: ['', Validators.required],
  });
  spendingLimitFormGroup = this._formBuilder.group({
    spendingLimitCtrl: [10000, Validators.required],
  });

  isLinear = true;
  newCustomer: CustomerWizardModel = {customerId: null, balance: 0, creditCardNumber: "", creditCardType: "", name: "", spendingLimit: 0};

  constructor(private apiService: ApiService, private router: Router) {}

  createCustomerWithAccount() {
    this.newCustomer = {
      name: this.nameFormGroup.value.nameCtrl,
      creditCardNumber: this.creditCardFormGroup.value.creditCardCtrl,
      creditCardType: this.typeFormGroup.value.typeCtrl,
      spendingLimit: this.spendingLimitFormGroup.value.spendingLimitCtrl,
      customerId: null,
      balance: 0
    };
    this.apiService.createCustomerWizard(this.newCustomer).subscribe(customer => {
      this.router.navigate(['/customer-overview/', customer.customerId]);
    });
  }
}

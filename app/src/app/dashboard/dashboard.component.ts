import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import {ChartData} from 'chart.js';
import {TransactionAmountHistory} from "../models/transactionAmountHistory.model";
import {TransactionCountHistory} from "../models/transactionCountHistory.model";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  transactionAmountHistory: TransactionAmountHistory[] = [];
  transactionCountHistory: TransactionCountHistory[] = [];
  public transactionAmountHistoryChartData: ChartData<'bar'>;
  public transactionCountHistoryChartData: ChartData<'bar'>;
  public barChartType = 'bar' as const;
  public chartOptions = {
    responsive: true,
  };

  constructor(private apiService: ApiService) {
    this.transactionAmountHistoryChartData = {
      labels: [],
      datasets: [{ data: [] }]
    };

    this.transactionCountHistoryChartData = {
      labels: [],
      datasets: [{ data: [] }]
    };
  }

  ngOnInit(): void {
    this.getCustomerAmountHistory();
    this.getCustomerCountHistory();
  }

  getCustomerAmountHistory(): void {
    this.apiService.getTransactionAmountHistory().subscribe(transactionAmountHistory => {
      this.transactionAmountHistory = transactionAmountHistory;
      this.transactionAmountHistoryChartData = {
        labels: transactionAmountHistory.map(history => history.creditCardType),
        datasets: [{ data: transactionAmountHistory.map(history => history.amount), label: 'Spend by Card Type', backgroundColor: ['#66BB6A'] }]
      };
    })
  }

  getCustomerCountHistory(): void {
    this.apiService.getTransactionCountHistory().subscribe(transactionCountHistory => {
      this.transactionCountHistory = transactionCountHistory;
      this.transactionCountHistoryChartData = {
        labels: transactionCountHistory.map(history => history.creditCardType),
        datasets: [{ data: transactionCountHistory.map(history => history.transactionCount), label: 'Number of Transactions by Card Type', backgroundColor: ['#a366bb'] }]
      };
    })
  }



}

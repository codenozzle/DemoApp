package com.example.demo.dashboard;

import com.example.demo.customer.CustomerDAO;
import com.example.demo.customer.CustomerHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {
    @Autowired
    private CustomerDAO dashboardDAO;

    public List<CustomerHistory> getCustomerHistory() {
        return dashboardDAO.getCustomerHistory();
    }
}

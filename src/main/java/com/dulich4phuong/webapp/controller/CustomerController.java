package com.dulich4phuong.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dulich4phuong.Constants;
import com.dulich4phuong.dao.SearchException;
import com.dulich4phuong.service.CustomerManager;

@Controller
@RequestMapping("/admin/customers*")
public class CustomerController {

	private CustomerManager customerManager = null;
	
	@Autowired
    public void setCustomerManager(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }
	
	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest(@RequestParam(required = false, value = "q") String query) throws Exception {
        Model model = new ExtendedModelMap();
        try {
            model.addAttribute(Constants.CUSTOMER_LIST, customerManager.search(query));
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(customerManager.getCustomers());
        }
        return new ModelAndView("admin/customerList", model.asMap());
    }
}

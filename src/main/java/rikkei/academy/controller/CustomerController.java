package rikkei.academy.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rikkei.academy.model.Customer;
import rikkei.academy.model.Province;
import rikkei.academy.service.customer.ICustomerService;
import rikkei.academy.service.province.IProvinceService;

@Controller
@RequestMapping(value = {"/", "/customer"})
public class CustomerController {
    @Autowired
    private IProvinceService provinceService;
    @Autowired
    private ICustomerService customerService;

    @ModelAttribute("listProvince")
    public Iterable<Province> listProvince() {
        return provinceService.findALl();
    }

    @GetMapping
    public String showListCustomer(Model model) {
       Iterable<Customer> customerList = customerService.findALl();
       model.addAttribute("customerList", customerList);
        return "customer/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer/create";
    }

    @PostMapping("/create")
    public String actionCreateCustomer(@ModelAttribute("customer") Customer customer, Model model) {
        System.out.println("customer--->" + customer);
        customerService.save(customer);
        return "redirect:/";
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.controllers;

import com.company.pojo.User;
import com.company.service.UserService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HP
 */
@Controller
public class UserController {
     @Autowired
    private UserService UserDetailsService;
    
    @GetMapping("/register")
    public String registerView(Model model) {   
         model.addAttribute("user", new User());

        return "register";
    }
    @PostMapping("/register")
    public String register(Model model, @ModelAttribute(value = "user") User user) {
        String errMsg = "";
        if (user.getPassword().equals(user.getConfirmpassword())) {
            if (this.UserDetailsService.addUser(user) == true) {
                return "redirect:/login";
            } else {
                model.addAttribute("errMsg", "Đã xảy ra lỗi!");
            }
        } else {
            errMsg = "Mat khau khong khop!";
        }
        model.addAttribute("errMsg", errMsg);

        return "register";
    }
    @GetMapping("/admin/employee")
    public String employeeView(Model model, @RequestParam(required = false) Map<String, String> params) {
        model.addAttribute("user", new User());
        String un = params.getOrDefault("un", null);
        model.addAttribute("employee", this.UserDetailsService.getEmployee(un));
        return "employee";
    }

    @PostMapping("/admin/employee")
    public String employee(Model model, @ModelAttribute(value = "user") User user) {
        String errMsg = "";
        if (user.getPassword().equals(user.getConfirmpassword())) {
            if (this.UserDetailsService.addEmployee(user) == true) {
                return "redirect:/admin/stats";
            } else {
                model.addAttribute("errMsg", "Đã xảy ra lỗi!");
            }
        } else {
            errMsg = "Mat khau khong khop!";
        }
        model.addAttribute("errMsg", errMsg);

        return "employee";
    }

    @DeleteMapping("/admin/employee/{id}")
    public String deleteEmployee(@PathVariable(value="id") int id  ){
        this.UserDetailsService.deleteEmployee(id);
        return "employee";
    }
    
    //    cập nhật thông tin sảnh
    @GetMapping("/admin/updateEmployee/{id}")
    public String viewUpdate(Model model, @PathVariable(value="id") int id){
         model.addAttribute("employee", new User());
         model.addAttribute("employeeId", id);
        return "updateEmployee";
    }
    
    @PostMapping(value= "/api/updateEmployee/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getEmployee(@PathVariable(value="id") int id ) {
        return new ResponseEntity<>(this.UserDetailsService.getUserById(id), HttpStatus.OK);
    }
    @PostMapping("/admin/updateEmployee/{id}")
    public String UpdateEmployee(@ModelAttribute(value = "employee") @Valid User e, BindingResult rs){
       

        if (this.UserDetailsService.updateEmployee(e) == true) {
            return "redirect:/admin/stats";
        }

        return "updateEmployee";
    }
}

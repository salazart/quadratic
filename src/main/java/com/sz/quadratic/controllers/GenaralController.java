package com.sz.quadratic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sz.quadratic.exception.QuadraticException;
import com.sz.quadratic.service.QuadraticService;

@Controller
public class GenaralController {
	private static final String IS_NUMBER_EXP = "-?\\d+(\\.\\d+)?";
    @RequestMapping("/result")
    public String result(
    		@RequestParam(value="a", required=true) double aValue,
    		@RequestParam(value="b", required=true) double bValue,
    		@RequestParam(value="c", required=true) double cValue, Model model) {
        
//    	double a = str.matches(IS_NUMBER_EXP) ? Double.parseDouble(aValue) : throw new QuadraticException(); 
//    	double b = str.matches(IS_NUMBER_EXP) ? Double.parseDouble(bValue); 
//    	double c = str.matches(IS_NUMBER_EXP) ? Double.parseDouble(cValue); 
    	
    	QuadraticService quadraticService = new QuadraticService(aValue, bValue, cValue);
    	
    	if(quadraticService.isResult()){
    		double result1 = quadraticService.getFirstResult();
    		double result2 = quadraticService.getSecondResult();
    		model.addAttribute("coefficients", "Коэффициенты: A=" + aValue + ", B=" + bValue + ", C=" + cValue);
    		model.addAttribute("result", "X1=" + result1 + ", X2=" + result2);
    	} else {
    		model.addAttribute("result", "Дискриминант меньше нуля");
    	}
    	
        return "result";
    }

}
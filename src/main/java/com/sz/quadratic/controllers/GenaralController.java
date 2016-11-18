package com.sz.quadratic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sz.quadratic.exception.QuadraticException;
import com.sz.quadratic.models.Quadratic;
import com.sz.quadratic.service.QuadraticService;

@Controller
public class GenaralController {
	
    @RequestMapping("/result")
    public String result(
    		@RequestParam(value="a", required=true) String aValue,
    		@RequestParam(value="b", required=true) String bValue,
    		@RequestParam(value="c", required=true) String cValue, Model model) {
    	
		try {
			QuadraticService quadraticService = new QuadraticService(aValue, bValue, cValue);
			if(quadraticService.isResult()){
				Quadratic quadratic = quadraticService.getResult();
	    		model.addAttribute("coefficients", "Коэффициенты: A=" + aValue + ", B=" + bValue + ", C=" + cValue);
	    		model.addAttribute("result", "X1=" + quadratic.getResult1() + ", X2=" + quadratic.getResult2());
			} else {
				model.addAttribute("result", "Дискриминант меньше нуля");
			}
		} catch (QuadraticException e) {
			model.addAttribute("result", e.getMessage());
		}

        return "result";
    }

}
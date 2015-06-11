package com.food.pos.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mkyong.common.model.Foods;
import com.mkyong.common.model.Status;

@Controller
@RequestMapping("/food")
public class FoodController {

	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public Foods query() {
		return new Foods();
	}

	@RequestMapping(value = "/modify/{id}", method = RequestMethod.POST)
	public Status modify(@PathVariable String id, HttpServletRequest request) {
		return new Status();
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public Status delete(@PathVariable String id, HttpServletRequest request) {
		return new Status();
	}
}

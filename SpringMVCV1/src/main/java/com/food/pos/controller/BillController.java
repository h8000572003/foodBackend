package com.food.pos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.food.pos.json.Bill;

@Controller
@RequestMapping("/bill")
public class BillController {

	@Autowired
	private BillCompent billCompent;

	@RequestMapping(value = "/query/unBuy/today", method = RequestMethod.GET)
	public @ResponseBody List<Bill> query() {

		return billCompent.getTodayUnBuyBill();

	}
}

package com.food.pos.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.food.pos.json.Bill;
import com.google.gson.Gson;
import com.mkyong.common.model.Status;

@Controller
@RequestMapping("/bill")
public class BillController {

	private Logger LOG = LoggerFactory.getLogger(BillController.class);

	@Autowired
	private BillCompent billCompent;

	@RequestMapping(value = "/query/unBuy/today", method = RequestMethod.GET)
	public @ResponseBody Status query() {

		Status status = new Status();
		try {

			status.setContent(billCompent.getTodayUnBuyBill());
			status.successful();
		} catch (Exception e) {
			LOG.error("e:{}", e);
			status.fail(e);
		}
		return status;
	}

	@RequestMapping(value = "/update/{txid}/isPay", method = RequestMethod.GET)
	public @ResponseBody Status update2Pay(@PathVariable String txid) {
		Status status = new Status();
		try {
			billCompent.update2Pay(txid);
			status.setContent("");
			status.successful();
		} catch (Exception e) {
			LOG.error("e:{}", e);
			status.fail(e);
		}
		return status;
	}
}

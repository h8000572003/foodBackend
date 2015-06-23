package com.food.pos.controller;

import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.food.pos.domain.GCMDTO;
import com.food.pos.domain.GCMPo;
import com.food.pos.json.Bill;
import com.food.pos.service.GCMService;
import com.food.pos.util.POST2GCM;
import com.google.gson.Gson;
import com.mkyong.common.model.Status;

@Controller
@RequestMapping("/bill")
public class BillController {

	private Logger LOG = LoggerFactory.getLogger(BillController.class);

	@Autowired
	private BillCompent billCompent;

	@Autowired
	private GCMService gCMService;

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

			GCMDTO gCMDTO = new GCMDTO();
			List<GCMPo> gcms = gCMService.queryAll(gCMDTO);

			for (GCMPo po : gcms) {
				POST2GCM.post(po.getId(), "test");
			}

			status.setContent("");
			status.successful();
		} catch (Exception e) {
			LOG.error("e:{}", e);
			status.fail(e);
		}
		return status;
	}

	@RequestMapping(value = "/delete/today", method = RequestMethod.GET)
	public @ResponseBody Status deleteTotal() {
		Status status = new Status();
		try {
			billCompent.deleteTotal();

			

			
			status.setContent("");
			status.successful();
		} catch (Exception e) {
			LOG.error("e:{}", e);
			status.fail(e);
		}
		return status;
	}

	@RequestMapping(value = "/insert/newOne", method = RequestMethod.POST)
	public @ResponseBody Status insertOne(HttpServletRequest request) {
		Status status = new Status();
		try {
			request.setCharacterEncoding("UTF-8");// 客戶端網頁我們控制為UTF-8
			String message = request.getParameter("message");

			LOG.info("message={}", message);

			Bill bill = new Gson().fromJson(message, Bill.class);
			billCompent.insert(bill);

			GCMDTO gCMDTO = new GCMDTO();
			List<GCMPo> gcms = gCMService.queryAll(gCMDTO);

			for (GCMPo po : gcms) {
				POST2GCM.post(po.getId(), "ADD");
			}
			status.setContent("");
			status.successful();

		} catch (Exception e) {
			LOG.error("e:{}", e);
			status.fail(e);
		}
		return status;
	}
}

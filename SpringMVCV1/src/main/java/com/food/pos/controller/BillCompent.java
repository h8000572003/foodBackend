package com.food.pos.controller;

import java.util.List;

import com.food.pos.json.Bill;

public interface BillCompent {
	/**
	 * 取得今日尚未結帳與出菜完成清單
	 * 
	 * @return
	 */
	public List<Bill> getTodayUnBuyBill();
}

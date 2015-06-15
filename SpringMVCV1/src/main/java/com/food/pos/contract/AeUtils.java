package com.food.pos.contract;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AeUtils {
	public static String getNowTime() {
		return new SimpleDateFormat("yyyyMMdd").format(new Date());
	}
}

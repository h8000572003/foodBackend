package com.food.pos.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mkyong.common.model.Status;

@Controller
@RequestMapping("/ip")
public class IpController {

	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println(address);
			System.out.printf("HostName: %s%n", address.getHostName());
			System.out.printf("HostAddress: %s%n", address.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody Status query() {
		Status status = new Status();
		try {

			InetAddress address = InetAddress.getLocalHost();
			System.out.println(address);
			System.out.printf("HostName: %s%n", address.getHostName());
			System.out.printf("HostAddress: %s%n", address.getHostAddress());
			status.setContent(address.getHostAddress());
			status.successful();
		} catch (Exception e) {
			status.fail();
		}
		return status;
	}

}

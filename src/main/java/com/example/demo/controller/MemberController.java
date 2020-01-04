package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.MemberAccount;

@Controller
public class MemberController {

	@Autowired
	StringEncryptor encryptor;
	
	@Value("${server.servlet.session.timeout}")
	int sessionTimeoutInMinuts;

	@GetMapping("/addMember")
	public String addMemberPage() {
		System.out.println("HOT SWAP");
		return "register";
	}

	@GetMapping("/login")
	public String login() throws InterruptedException {
		String name = encryptor.encrypt("sa");
		String password = encryptor.encrypt("P@ssw0rd");
		System.out.println(name);
		System.out.println(password);
		return "login2";
	}

	/*
	 * @PostMapping("/doLogin") public String doLogin(@ModelAttribute
	 * FanMemberAccount fanMemberAccount){
	 * System.out.println(memberService.CheckMemberAccount(fanMemberAccount.getEmail
	 * (), fanMemberAccount.getPassword()));
	 * 
	 * return "welcome"; }
	 */

	@PostMapping("/doLogin")
	public String doLogin() {

		return "welcome";

	}

}

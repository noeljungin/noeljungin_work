package com.spring.daily.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.daily.domain.Journal;
import com.spring.daily.repository.JournalRepository;

@Controller
public class JournalController {
	
	@Autowired
	JournalRepository repo;
	
	// /경로로 오면 model에 repo의 모든 정보를 담고 있는 index.html로 보
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("journal", repo.findAll());
		return "index";
	}
	
	//Journal 경로로 오면 JSON 형식으로 repo의 모든 정보를 전송
	@RequestMapping(value = "/journal", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody List <Journal> getJournal(){
		return repo.findAll();
	}
}

package kr.ac.readingbetter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.readingbetter.service.SchoolService;
import kr.ac.readingbetter.vo.SchoolVo;

// 학교 관리
@Controller
@RequestMapping("/admin/schoollist")
public class AdminSchoolController {
	
	@Autowired
	private SchoolService schoolService;
	
	@RequestMapping("")
	public String schoolList(Model model, @RequestParam(value="kwd", required=false, defaultValue="") String kwd) {
		if(kwd == null){
			kwd = "";
		}
		
		List<SchoolVo> list = schoolService.getList(kwd);
		
		model.addAttribute("list", list);
		
		return "admin/schoollist";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insertSchool(@RequestParam(value="add", required=false, defaultValue="") String title){
		schoolService.insertSchool(title);
		
		return "redirect:/admin/schoollist";
	}
}

package multi.campus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import multi.campus.domain.DailyBoxOffice;
import multi.campus.service.MovieInfoService;
import multi.campus.util.DateCalculator;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	MovieInfoService movieInfoService;
	
	@GetMapping("/")
	public String getAdminHome(Model model) throws Exception {
		DateCalculator dc = new DateCalculator();
		String yesterday = dc.getYesterday();
		
		// DB�� ���� �ڽ����ǽ� ������ ����
		movieInfoService.getKobisDailyMovieList(yesterday);
		
		List<DailyBoxOffice> dailyList = movieInfoService.getAllDailyBoxOffice();
		
		for(DailyBoxOffice dailyMovie : dailyList) {
			System.out.println(dailyMovie);
		}
		
		model.addAttribute("dailyList", dailyList);
		model.addAttribute("yesterday", yesterday);
		
		return "admin/index";
	}
	
	@GetMapping("/delete")
	public String getDelete(Model model) throws Exception {
		int result = movieInfoService.deleteAllBoxOffce();
		System.out.println("���� ��� : " + result);
		return "admin/index";
	}
}

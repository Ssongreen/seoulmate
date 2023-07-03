package seoulmate.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import seoulmate.project.domain.Member;
import seoulmate.project.service.MemberService;

@Controller
public class AdminController {
	private final MemberService memberService;
	
	public AdminController(MemberService memberService) {
		this.memberService = memberService;
		
	}
	@GetMapping("/member/signup")
	public String signupForm() {
		return "member/signup";
	}

	@PostMapping("/member/signup")
	public String signupAdd(@ModelAttribute Member member) {
		memberService.saveMember(member);
		return "redirect:/member/login";

	}

	@GetMapping("/member/login")
	public String loginForm(Model model) {
		model.addAttribute("member", new Member());
		return "member/login";
	}

	@PostMapping("/member/login")
	public String login(@ModelAttribute Member member, HttpSession session, Model model) {
		Member foundMember = memberService.getMemberByEmail(member.getEmail());

		if (foundMember != null && foundMember.getPassword().equals(member.getPassword())) {
			session.setAttribute("loggedInMember", foundMember);
			return "redirect:/";
		} else {
			model.addAttribute("error", "이메일 또는 비밀번호가 잘못되었습니다.");
			return "member/login";
		}
	}

}

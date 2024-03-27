package ca.sheridancollege.patemitm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ca.sheridancollege.patemitm.repository.AccountRepository;
import ca.sheridancollege.patemitm.repository.StudentRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class StudentController {
	private StudentRepository studentRepository;
	private AccountRepository accountRepository;
	
	@GetMapping("/")
	public String index(Model model)
	{
		model.addAttribute("studentList",studentRepository.findByAccount_IdIsNotNull());
		return "index";
	}

}

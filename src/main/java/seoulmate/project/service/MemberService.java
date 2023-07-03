package seoulmate.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import seoulmate.project.domain.Member;
import seoulmate.project.repository.JdbcTemplateRepository;


@Service
@RequiredArgsConstructor
public class MemberService {
	@Autowired
	private final JdbcTemplateRepository repository;

	public JdbcTemplateRepository getRepository() {
		return repository;
	}

	public Member saveMember(Member member) {
		return repository.saveMember(member);
		
	}

	public Member getMemberByEmail(String email) {
		return repository.findByNameEmail(email);
	}

	
}

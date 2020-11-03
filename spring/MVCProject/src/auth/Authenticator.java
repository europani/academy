package auth;

import member.MemberInfo;
import member.MemberService;

public class Authenticator {

	private MemberService memberService;
	
	public Authenticator(MemberService memberService) {
		this.memberService = memberService;
	}

	public Auth authenticate(String email, String password) {
		MemberInfo mi = memberService.getMemberInfoByEmail(email);
		if (mi == null) {
			throw new AuthenticationException();
		}
		if (!mi.matchPassWord(password)) {
			throw new AuthenticationException();
		}
		return new Auth(mi.getId(), mi.getName());
	}
}

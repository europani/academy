package ch07.member;

public class MemberServiceImpl implements MemberService {
	
	@Override
	public void regist(MemberRequest memberRegReq) {
		System.out.println("MemberSergiceImpl.regist() 호출");
	}

	@Override
	public boolean update(String id, UpdateInfo updateInfo) {
		System.out.println("MemberSergiceImpl.update() 호출");
		return true;
	}
	
	
}

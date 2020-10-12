package ch07.member;

public interface MemberService {
	public void regist(MemberRequest memberRegReq);
	
	public boolean update(String id, UpdateInfo updateInfo);

}

package member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class MemberService {
	private int nextMemberId = 0;
	private Map<String, MemberInfo> memberMap = new HashMap<>();
	
	public MemberService() {
		memberMap.put("m1", new MemberInfo("m1", "이상화", "sanghwa@sanghwa.com", "sanghwa", false, new Address()));
		memberMap.put("m2", new MemberInfo("m2", "김연아", "yuna@yuna.com", "yuna", false, new Address()));
		nextMemberId = 3;
	}
	
	public void registNewMember(MemberRegistRequest memRegReq) {
		MemberInfo mi = new MemberInfo("m" + nextMemberId, memRegReq.getName(), memRegReq.getEmail(), memRegReq.getPassword(), memRegReq.isAllowNoti(), memRegReq.getAddress());
		
		memberMap.put(mi.getId(), mi);
	}

	public List<MemberInfo> getMembers() {
		return new ArrayList<MemberInfo>(memberMap.values());
	}

	public MemberInfo getMemberInfo(String memberId) {
		return memberMap.get(memberId);
	}
	

}

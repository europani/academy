package ch07.anno;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import ch07.member.UpdateInfo;

@Aspect
public class UpdateMemberInfoTraceAspect {

	@AfterReturning(pointcut = "args(memberId,info)", returning = "result", argNames = "joinPoint,memberId,info,result")
	public void traceReturn(JoinPoint joinPoint, String memberId, UpdateInfo info, boolean result) {
		System.out.printf("[TA] 정보 수정 : 대상회원=%s, 수정정보=%s, 결과=%s\n", memberId, info, result);
	}
}

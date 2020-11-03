package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("AI: postHandle()");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("AI: afterCompletion()");
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("AI: preHandle()");
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("auth") == null) {
			response.sendRedirect(request.getContextPath() + "/auth/login");
			return false;
		}
		return true;
	}
}

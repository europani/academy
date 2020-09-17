package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Action;

public class MemberAction extends Action {
	
	public String hello(HttpServletRequest request, HttpServletResponse response) throws Throwable { 
	 	 return "/view/member/hello.jsp";
	} 

}

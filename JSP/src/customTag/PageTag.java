package customTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PageTag extends SimpleTagSupport{
	private int from;
	private int to;
	
	public void setFrom(int from) {
		this.from = from;
	}
	public void setTo(int to) {
		this.to = to;
	}
		@Override
		public void doTag() throws JspException, IOException {
			int start = from;
			int end = to;
			
			JspWriter out = getJspContext().getOut();
			out.println("page &nbsp");
			for (int i = start; i <= end; i++) {
				out.print("<a href=/jsp/customTag/pageTag.jsp?nowPage=" + i + ">");
				out.print("[" + i + "]");
				out.print("</a>&nbsp");
			}
		}
	
}

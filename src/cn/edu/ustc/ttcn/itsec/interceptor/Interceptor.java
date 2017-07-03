package cn.edu.ustc.ttcn.itsec.interceptor;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Interceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		Object user = session.get("user");
		
//		HttpServletRequest request = (HttpServletRequest) arg0;
//		HttpServletResponse response = (HttpServletResponse) arg1;
//		PrintWriter out = response.getWriter();
		
		if(user == null){
//			out.print("<script>alert('Sorry,Please Login'); window.document.location.href='index.jsp';</script>");
			return "login";
		}
		return invocation.invoke();
	}

}

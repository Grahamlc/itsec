package cn.edu.ustc.ttcn.itsec.actions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.edu.ustc.ttcn.itsec.model.Menu_Priv;
import cn.edu.ustc.ttcn.itsec.model.Privilege;
import cn.edu.ustc.ttcn.itsec.model.User;
import cn.edu.ustc.ttcn.itsec.service.LoginService;

import com.opensymphony.xwork2.ActionContext;

/**
 * @author ZYZ
 * ע��
 * (1)
 * ʵ��ServletRequestAware������ͨ��IoC�ķ�ʽ��Struts��ܻ��HttpServletRequest����
 * ʵ��ServletResponseAware������ͨ��IoC�ķ�ʽ��Struts��ܻ��HttpServletResponse����
 * ʵ��SessionAware������ͨ��IoC�ķ�ʽ��Struts��ܻ��Session����
 * ʵ��ServletContextAware������ͨ��IoC�ķ�ʽ��Struts��ܻ��ServletContext����
 * ʵ��ApplicationAware������ͨ��IoC�ķ�ʽ��Struts��ܻ��Application����
 * ��Ҫ�ĸ�����ʵ���ĸ��ӿ�
 * (2)
 * Action�е�execute()������Ҫ�����ǽ���ǰ�����󣬵�����Ӧ��Service������ý��������
 * (3)
 * һ������£���service�������صĽ����֯��json��ʽ���ַ���,ͨ��returnResultҳ�淵�ص�Android�ͻ���
 * �����������Ҳ�����������������ؽ��
 * (4)
 * ��ͬ��ҵ������ʵ����Ӧ��Action
 */
public class LoginAction implements ServletRequestAware, ServletResponseAware {
	
	private LoginService loginService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String resultJson;
	private Set<Menu_Priv> it ;
	private int corId;
	
	
	public int getCorId() {
		return corId;
	}
	public void setCorId(int corId) {
		this.corId = corId;
	}
	public Set<Menu_Priv> getIt() {
		return it;
	}
	public void setIt(Set<Menu_Priv> it) {
		this.it = it;
	}
	public String getResultJson() {
		return resultJson;
	}
	public void setResultJson(String resultJson) {
		this.resultJson = resultJson;
	}	
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}


	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}


	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
		
	}
	
	public String login() throws Exception{
	
		
		/*get userId userPasswd from client
		 * */
		try{
			String userId = request.getParameter("userId");
			String userPasswd = request.getParameter("password");

			User tempUser = new User();;
			it = new HashSet<Menu_Priv>();
			
			tempUser = loginService.query(userId);	
			
			/*��鷵�����ݶ����Ƿ�Ϊ��* */	
			if(tempUser!=null){
				int Privilege = tempUser.getLevel().getAutoId();
				String Passwd = tempUser.getPasswd();	
				it = tempUser.getLevel().getMenuPriv();
							
				if(Passwd.equals(userPasswd)){
					//���û�������λId
//						corId = tempUser.getAccount().getCorId();
					corId = tempUser.getTester().getCompany().getCorId();
					
					//session�����½��Ϣ
//						request.getSession().setAttribute("realName", realName);
					//����session��ʱʱ�䣬Ҳ������web.xml������
				//	request.getSession().setMaxInactiveInterval(30*60);
					
				
					ActionContext ctx = ActionContext.getContext();
					Map<String, Object> session = ctx.getSession();
					session.put("user", tempUser);
					session.put("role", Privilege);
					session.put("corId", corId);
					session.put("menuPriv", it);
					
					//myWorks  ���˻�������ı���ϵͳ
					session.put("myWorks", tempUser.getTester().getTesterToSystem());

					if(Privilege==5 ) //5������������Ա
					{
						return "super";
					}
//						if(Privilege==4){ //4��������ʦ
//							return "tester";		
//						}
					if(Privilege == 4|| Privilege==3 || Privilege==2){ //2��������3��������
						return "Main";		
					}
					if(Privilege==1){ //1�����ͻ���λ
						return "guest";
					}
				}
					
				else return "fail";
			}
				
			/*���������ݶ���Ϊ�գ��ض��򵽵�½����*/
			return "fail";
		}catch(Exception e){
			return "fail";
		}
		
	}
	
	public String logout() throws Exception{
		Map session = ActionContext.getContext().getSession();
//		Map session = (Map) request.getSession();
//		session.clear() �������session
		session.clear();
		
//		����ʹ��session.remove(key) ȥ��session�е�����
//		session.remove("realName");
				
		return "logout";
	}
	
}
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import java.util.*;

import cn.edu.ustc.ttcn.itsec.model.User;


public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration cfg = new Configuration().configure();
		
		SchemaExport export = new SchemaExport(cfg);
		
		export.create(true, true);
		/**
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = null;
		
		try {
			session = factory.openSession();
			
			session.beginTransaction();
			
			User user = new User();
			user.setUserName("zyz");
			user.setPassword("zyz713");
			user.setRegisterDate(new Date());
			
			session.save(user);
			
			session.getTransaction().commit();
			
		} catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				if (session.isOpen()) {
					session.close();
				}
			}
			
		}
		**/

	}

}

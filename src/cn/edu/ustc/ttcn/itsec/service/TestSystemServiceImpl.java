package cn.edu.ustc.ttcn.itsec.service;

import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.edu.ustc.ttcn.itsec.dao.ShowSystemInfoDao;
import cn.edu.ustc.ttcn.itsec.dao.SystemTesterDao;
import cn.edu.ustc.ttcn.itsec.dao.TestSystemDao;
import cn.edu.ustc.ttcn.itsec.dao.TesterDao;
import cn.edu.ustc.ttcn.itsec.model.Role;
import cn.edu.ustc.ttcn.itsec.model.Systems;
import cn.edu.ustc.ttcn.itsec.model.TestSystem;
import cn.edu.ustc.ttcn.itsec.model.Tester;
import cn.edu.ustc.ttcn.itsec.model.TesterOfSystem;

public class TestSystemServiceImpl implements TestSystemService{
	private TestSystemDao testSystemDao;
	private ShowSystemInfoDao showSystemInfoDao; 
	private SystemTesterDao systemTesterDao; 
	private TesterDao testerDao;
	
	public TesterDao getTesterDao() {
		return testerDao;
	}
	public void setTesterDao(TesterDao testerDao) {
		this.testerDao = testerDao;
	}
	public TestSystemDao getTestSystemDao() {
		return testSystemDao;
	}
	public void setTestSystemDao(TestSystemDao testSystemDao) {
		this.testSystemDao = testSystemDao;
	}
	
	public ShowSystemInfoDao getShowSystemInfoDao(){
		return showSystemInfoDao;
	}
	public void setShowSystemInfoDao (ShowSystemInfoDao showSystemInfoDao){
		this.showSystemInfoDao = showSystemInfoDao;
	}
	
	
	public SystemTesterDao getSystemTesterDao() {
		return systemTesterDao;
	}
	public void setSystemTesterDao(SystemTesterDao systemTesterDao) {
		this.systemTesterDao = systemTesterDao;
	}
	

	public void writeTestSys(int id,String str_1,String str_2,Map<String,String> maps ) {
		// TODO Auto-generated method stub
		
		TestSystem it = new TestSystem();
		it = testSystemDao.selMTestSystem(id).get(0) ;
		
		Iterator tmpMap = maps.entrySet().iterator();
		while(tmpMap.hasNext()){
			
			Role tmpRole = new Role();
			Tester tmpTester = new Tester();
			TesterOfSystem tmpTos = new TesterOfSystem();
			
			Map.Entry<String,String> temp = (Map.Entry<String, String>) tmpMap.next();
			tmpRole.setRoleId(Integer.valueOf(temp.getKey()));
			tmpTester.setUserId(Integer.valueOf(temp.getValue()));
	
			tmpTos.setTestSys(it);
			tmpTos.setRole(tmpRole);
			tmpTos.setTester(tmpTester);
			
			systemTesterDao.writeSysTester(tmpTos);
			
		}
		/**
		Date time = new java.sql.Date(new java.util.Date().getTime());
		
		it.setCpState(1);
		it.setStartDate(String.valueOf(time));
		testSystemDao.saveTestSys(it);
		*/
	}
		
	@Override
	public void saveTestSys(TestSystem it) {
		// TODO Auto-generated method stub
		testSystemDao.saveTestSys(it);
	}
	@Override
	public void delTestSys(TestSystem it) {
		// TODO Auto-generated method stub
		testSystemDao.delTestSys(it);
	}
	@Override
	public List<TestSystem> showTestSys(int sysId) {
		// TODO Auto-generated method stub
		return testSystemDao.selAllTestSys(sysId);
	}
	@Override
	public List<TestSystem> queryMTestSys(int testSysId) {
		// TODO Auto-generated method stub
		return testSystemDao.selMTestSystem(testSysId);
	}
	@Override
	public void setManager(int testSysId, int userId, int roleID) {
		// TODO Auto-generated method stub
		
		TestSystem testSystem = testSystemDao.selMTestSystem(testSysId).get(0);
		
		Tester tester = testerDao.selTester(userId).get(0);
		
		Role role = new Role();
		int roleId = roleID;
		role.setRoleId(roleId);
		
		TesterOfSystem tos = new TesterOfSystem();
		Set<TesterOfSystem> tmp = testSystem.getSysTester();
		
		if(tmp.size()>0){
			//更新项目经理
			for(TesterOfSystem it : tmp){
				if(it.getRole().getRoleId() == roleID){
					tos = it;
				}
			}
						
		}
		else{
			//第一次指定项目经理
			tos.setRole(role);
			
			tos.setTestSys(testSystem);	
			
			Date time = new java.sql.Date(new java.util.Date().getTime());
			
			testSystem.setCpState(1);
			testSystem.setStartDate(String.valueOf(time));
			testSystemDao.saveTestSys(testSystem);
		}
		tos.setTester(tester);
						
		systemTesterDao.writeSysTester(tos); 
		
		//更改被测系统的状态值
		
	}

}

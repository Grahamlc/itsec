package cn.edu.ustc.ttcn.itsec.service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.edu.ustc.ttcn.itsec.dao.ProjectsDao;
import cn.edu.ustc.ttcn.itsec.dao.SystemDao;
import cn.edu.ustc.ttcn.itsec.dao.ShowSystemInfoDao;
import cn.edu.ustc.ttcn.itsec.dao.TestSystemDao;
import cn.edu.ustc.ttcn.itsec.model.Projects;
import cn.edu.ustc.ttcn.itsec.model.Systems;
import cn.edu.ustc.ttcn.itsec.model.TestSystem;

public class MOServiceImpl implements MOService {

	private SystemDao systemDao;
	private TestSystemDao testSystemDao;
	private ShowSystemInfoDao showSystemInfoDao;
	private ProjectsDao projectsDao; 
	
	
	public ProjectsDao getProjectsDao() {
		return projectsDao;
	}

	public void setProjectsDao(ProjectsDao projectsDao) {
		this.projectsDao = projectsDao;
	}

	public SystemDao getSystemDao() {
		return systemDao;
	}

	public void setSystemDao(SystemDao systemDao) {
		this.systemDao = systemDao;
	}

	public TestSystemDao getTestSystemDao() {
		return testSystemDao;
	}

	public void setTestSystemDao(TestSystemDao testSystemDao) {
		this.testSystemDao = testSystemDao;
	}
	
	public ShowSystemInfoDao getShowSystemInfoDao() {
		return showSystemInfoDao;
	}

	public void setShowSystemInfoDao(ShowSystemInfoDao showSystemInfoDao) {
		this.showSystemInfoDao = showSystemInfoDao;
	}

	
	@Override
	public void Distribute(int sysId, int proId) {
		// TODO Auto-generated method stub
		Systems sys = showSystemInfoDao.ShowSysteminfo(sysId).get(0);
		Projects pro = projectsDao.selMProject(proId).get(0);
		
		TestSystem tsys = new TestSystem(); 
		tsys.setSystem(sys);
		tsys.setCpState(0);
		tsys.setMark(1);
		tsys.setProject(pro);
		
		testSystemDao.saveTestSys(tsys);	
		
		sys.setState(1);
		systemDao.addSystem(sys);
	
	}

	@Override
	public String Undo(int testSysId) {
		// TODO Auto-generated method stub
		/*
		Systems sys = showSystemInfoDao.ShowSysteminfo(sysId).get(0);
		
		Iterator<TestSystem> it = sys.getTestSystem().iterator();
		
		while(it.hasNext()){
			TestSystem ts = it.next();
			if(ts.getMark() == 1){
				testSystemDao.delTestSys(ts);
			}
		}
		*/	
		TestSystem testSys = testSystemDao.selMTestSystem(testSysId).get(0);
		
		int proId = testSys.getProject().getAutoId(); 		
		Projects project = projectsDao.selMProject(proId).get(0); //该被测系统所属的项目
		
		Set<TestSystem> testSyses = project.getTestSystems();//项目下的所有被测系统
		
		//修改系统表的信息
		Systems sys = testSys.getSystem();
		sys.setState(0);
		systemDao.addSystem(sys);
		
		//若即将被删除的被测系统 是该项目的最后一个系统，则在删除系统的同时删除该项目 
		if(testSyses.size() == 1){
			projectsDao.delete(project);
			return "noPro";
			
		}else{
			testSystemDao.delTestSys(testSys);
			return String.valueOf(project.getAutoId());
		}
			
		
	}

	@Override
	public void finishTest(int testSysId) {
		// TODO Auto-generated method stub
		TestSystem testSys = testSystemDao.selMTestSystem(testSysId).get(0);
		
		int proId = testSys.getProject().getAutoId(); 		
		Projects project = projectsDao.selMProject(proId).get(0); //该被测系统所属的项目
		
		Set<TestSystem> testSyses = project.getTestSystems();//项目下的所有被测系统
		
		int num = 0; //用来记录该项目下未完成的被测系统的个数
		for(TestSystem it : testSyses){
			if(it.getCpState() !=10){
				num++;
			}
		}
		
		Systems sys = testSys.getSystem();
		sys.setState(0); //系统 回到最初状态  等待下次的测评   0表示未下单， 1表示已经下单
		systemDao.addSystem(sys);
		
		if(num == 1){
			//num = 1 表示当前要结束的系统是该项目下最后一个系统
			project.setState(1); //  1 表示该项目已结束  0 表示该项目在进行过程中
			projectsDao.save(project);
			
		}else{
			testSys.setCpState(10);
			testSystemDao.saveTestSys(testSys);
		}
	}

}

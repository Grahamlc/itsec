package cn.edu.ustc.ttcn.itsec.service;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.dao.TesterDao;
import cn.edu.ustc.ttcn.itsec.model.Tester;

public class TesterServiceImpl implements TesterService{

	private TesterDao testerDao;
	
	public TesterDao getTesterDao() {
		return testerDao;
	}

	public void setTesterDao(TesterDao testerDao) {
		this.testerDao = testerDao;
	}

	@Override
	public void saveTester(Tester tester) {
		// TODO Auto-generated method stub
		testerDao.save(tester);
	}

	@Override
	public void delTester(Tester tester) {
		// TODO Auto-generated method stub
		testerDao.delete(tester);
	}

	@Override
	public void updateTester(Tester tester) {
		// TODO Auto-generated method stub
		testerDao.update(tester);
	}

	@Override
	public List<Tester> queryMTester(int userId) {
		// TODO Auto-generated method stub
		return testerDao.selTester(userId);
	}

	@Override
	public List<Tester> queryAll() {
		// TODO Auto-generated method stub
		return testerDao.selAllTester();
	}

	@Override
	public List<Tester> queryMTesters(int testSysId) {
		// TODO Auto-generated method stub
		return testerDao.selMTesters(testSysId);
	}

}

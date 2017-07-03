package cn.edu.ustc.ttcn.itsec.service;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.dao.ConScoreDao;
import cn.edu.ustc.ttcn.itsec.dao.ItemConDao;
import cn.edu.ustc.ttcn.itsec.dao.ScoreDao;
import cn.edu.ustc.ttcn.itsec.dao.SelectObjectDao;
import cn.edu.ustc.ttcn.itsec.dao.TestObjectDao;
import cn.edu.ustc.ttcn.itsec.dao.WriteItemDao;
import cn.edu.ustc.ttcn.itsec.model.ConScore;
import cn.edu.ustc.ttcn.itsec.model.Item;
import cn.edu.ustc.ttcn.itsec.model.ItemCon;
import cn.edu.ustc.ttcn.itsec.model.Score;
import cn.edu.ustc.ttcn.itsec.model.TestObject;
import cn.edu.ustc.ttcn.itsec.model.TestSystem;

public class TestObjectServiceImpl implements TestObjectService{

	private TestObjectDao testObjectDao;
	private WriteItemDao writeItemDao;
	private SelectObjectDao selectObjectDao;
	private ScoreDao scoreDao;
	private ConScoreDao conScoreDao;
	private ItemConDao itemConDao;
	
	private static int num = 1; 
	
	public TestObjectDao getTestObjectDao() {
		return testObjectDao;
	}
	public void setTestObjectDao(TestObjectDao testObjectDao) {
		this.testObjectDao = testObjectDao;
	}
	public WriteItemDao getWriteItemDao() {
		return writeItemDao;
	}
	public void setWriteItemDao(WriteItemDao writeItemDao) {
		this.writeItemDao = writeItemDao;
	}
	public SelectObjectDao getSelectObjectDao() {
		return selectObjectDao;
	}
	public void setSelectObjectDao(SelectObjectDao selectObjectDao) {
		this.selectObjectDao = selectObjectDao;
	}
	
	public ScoreDao getScoreDao() {
		return scoreDao;
	}
	public void setScoreDao(ScoreDao scoreDao) {
		this.scoreDao = scoreDao;
	}
	
	public ConScoreDao getConScoreDao() {
		return conScoreDao;
	}
	public void setConScoreDao(ConScoreDao conScoreDao) {
		this.conScoreDao = conScoreDao;
	}
	public static int getNum() {
		return num;
	}
	public static void setNum(int num) {
		TestObjectServiceImpl.num = num;
	}
	
	public ItemConDao getItemConDao() {
		return itemConDao;
	}
	public void setItemConDao(ItemConDao itemConDao) {
		this.itemConDao = itemConDao;
	}
	@Override
	public void newObject(int testSysId, String name, String s, String a,
			String g, int objectId) {
		// TODO Auto-generated method stub
		//写入testobject
		TestObject it = testObjectDao.newTestObject(testSysId, name, objectId);
		//筛选出测评项
		List<Item> item = selectObjectDao.SelectObject(s, a, g, objectId);           
		//写入itemselres
		writeItemDao.writeItem(it, item);
		
		//一次性写入score表  测评对象的所有测评层面的 测评项的综合表
//		if(num ==1){
		List<Score> scores = scoreDao.selAll(testSysId);
		if(scores.size()==0){
			TestSystem testSystem = it.getPro();
			for(int i=0;i<11;i++){
				item = selectObjectDao.SelectObject(s, a, g, i);  
				for(Item temp : item ){
					Score score = new Score();
					score.setItem(temp);
					score.setTestSystem(testSystem);
					
					scoreDao.save(score);
				}
			}
			
			//将所有的控制点一次性写入到数据库中
			List<ConScore> cstmp = conScoreDao.selAll(testSysId);
						
			List<ItemCon> tmp = itemConDao.showAll();
			
			if(cstmp.size()==0){
				for(ItemCon itemCon : tmp){
					
					ConScore conScore = new ConScore();
					
					conScore.setItemCon(itemCon);
					conScore.setTestSystem(testSystem);
					
					conScoreDao.save(conScore);
				}			
			}
//			}
			
			
//			num--;
			
		}
	}
	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		testObjectDao.delete(id);
		
	}
	@Override
	public List<TestObject> showTestObject(int testSysId) {
		// TODO Auto-generated method stub
		return testObjectDao.showObject(testSysId);
	}


}

package cn.edu.ustc.ttcn.itsec.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.edu.ustc.ttcn.itsec.dao.ConScoreDao;
import cn.edu.ustc.ttcn.itsec.dao.ItemConDao;
import cn.edu.ustc.ttcn.itsec.dao.ReportDao;
import cn.edu.ustc.ttcn.itsec.dao.ScoreDao;
import cn.edu.ustc.ttcn.itsec.dao.ShowItemDao;
import cn.edu.ustc.ttcn.itsec.dao.ShowObjectDao;
import cn.edu.ustc.ttcn.itsec.dao.ShowSystemInfoDao;
import cn.edu.ustc.ttcn.itsec.dao.TestSystemDao;
import cn.edu.ustc.ttcn.itsec.model.ConScore;
import cn.edu.ustc.ttcn.itsec.model.Device;
import cn.edu.ustc.ttcn.itsec.model.Item;
import cn.edu.ustc.ttcn.itsec.model.ItemCon;
import cn.edu.ustc.ttcn.itsec.model.ItemSelRes;
import cn.edu.ustc.ttcn.itsec.model.Reports;
import cn.edu.ustc.ttcn.itsec.model.Score;
import cn.edu.ustc.ttcn.itsec.model.Systems;
import cn.edu.ustc.ttcn.itsec.model.TestObject;
import cn.edu.ustc.ttcn.itsec.model.TestSystem;

public class ReportServiceImpl implements ReportService {

	private ShowObjectDao showObjectDao;
	private ShowSystemInfoDao showSystemInfoDao;
	private ShowItemDao showItemDao;
	private ReportDao reportDao;
	private ScoreDao scoreDao;
	private ConScoreDao conScoreDao;
	private ItemConDao itemConDao;
	private TestSystemDao testSystemDao;

	
	private List<Device> device;

	private List<ItemSelRes> itemselres;

	private List<TestObject> testobject;// 等待数据库查询
	
	
	public ItemConDao getItemConDao() {
		return itemConDao;
	}
	
	public TestSystemDao getTestSystemDao() {
		return testSystemDao;
	}

	public void setTestSystemDao(TestSystemDao testSystemDao) {
		this.testSystemDao = testSystemDao;
	}

	public void setItemConDao(ItemConDao itemConDao) {
		this.itemConDao = itemConDao;
	}

	public List<Device> getDevice() {
		return device;
	}

	public void setDevice(List<Device> device) {
		this.device = device;
	}

	public List<ItemSelRes> getItemselres() {
		return itemselres;
	}

	public void setItemselres(List<ItemSelRes> itemselres) {
		this.itemselres = itemselres;
	}

	public List<TestObject> getTestobject() {
		return testobject;
	}

	public void setTestobject(List<TestObject> testobject) {
		this.testobject = testobject;
	}

	public ShowObjectDao getShowObjectDao() {
		return showObjectDao;
	}

	public void setShowObjectDao(ShowObjectDao showObjectDao) {
		this.showObjectDao = showObjectDao;
	}

	public ShowSystemInfoDao getShowSystemInfoDao() {
		return showSystemInfoDao;
	}

	public void setShowSystemInfoDao(ShowSystemInfoDao showSystemInfoDao) {
		this.showSystemInfoDao = showSystemInfoDao;
	}

	public ShowItemDao getShowItemDao() {
		return showItemDao;
	}

	public void setShowItemDao(ShowItemDao showItemDao) {
		this.showItemDao = showItemDao;
	}

	public ReportDao getReportDao() {
		return reportDao;
	}

	public void setReportDao(ReportDao reportDao) {
		this.reportDao = reportDao;
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

	public Systems systemInfo(int id) {

		return showSystemInfoDao.ShowSysteminfo(id).get(0);
	}

	public List<TestObject> testObjectItem(int proId, int objectId) {

		return showObjectDao.showObject(proId, objectId);
	}

	@Override
	public List<ItemSelRes> showItem(int testObjectId) {
		// TODO Auto-generated method stub
		return showItemDao.showItem(testObjectId);
	}

	public Map<String, String> countResult(int testObjectId) {
		/**
		 * 1、从数据库输出某系统的某测评对象的所有测评项、符合、不符合、基本符合的测评项个数 2、将四个数据放入Map对象中
		 */
		String countAll = String.valueOf(showItemDao.showItem(testObjectId)
				.size());
		String countYes = String.valueOf(showItemDao.showMItem(testObjectId,
				"符合").size());
		String countYesOrNo = String.valueOf(showItemDao.showMItem(
				testObjectId, "基本符合").size());
		String countNo = String.valueOf(showItemDao.showMItem(testObjectId,
				"不符合").size());

		Map<String, String> it = new LinkedHashMap();
		it.put("All", countAll);
		it.put("Yes", countYes);
		it.put("YesOrNo", countYesOrNo);
		it.put("No", countNo);

		return it;
	}

	@Override
	public void saveReport(Reports it) {
		// TODO Auto-generated method stub
		reportDao.saveReport(it);
	}

	@Override
	public List<Reports> showAllReport(int sysId) {
		// TODO Auto-generated method stub
		return reportDao.showAllReport(sysId);
	}

	public String score_to_meetlevel(int score) {
		String str = null;
		if (score == 0) {
			str = "不符合";
		} else if (score == 5) {
			str = "符合";
		} else {
			str = "部分符合";
		}
		return str;
	}

	/**
	 * 
	 * @param testobject  某一测评层面对应的所有测评对象 
	 * @param cpLevelId  测评层面Id
	 * @param control_point_num  测评层面中控制点的个数
	 * @return
	 */
	public Map<String, Object> report_Result_Record(
			List<TestObject> testobject, int cpLevelId, int control_point_num) {
		// TODO Auto-generated method stub
		
		float dontmatch = -100;// 不适用

		Map<String, Object> return_map = new HashMap<String, Object>();// 函数返回此Map

		int deviceNum = testobject.size(); //测评对象的个数
		
		int result_total_alalyse[][][] = new int[deviceNum][4][control_point_num];
		
		// 结果汇总表所需数据结构：1个三维数组，3个map对象
		
		Map<String, Object> map411 = new HashMap<String, Object>();
		map411.put("符合", 0);
		map411.put("部分符合", 1);
		map411.put("不符合", 2);
		map411.put("不适用", 3);
		
		Map<String, Object> map412 = new HashMap<String, Object>();
		
		String[] phy_sec = { "物理位置的选择", "物理访问控制", "防盗窃和防破坏", "防雷击", "防火",
				"防水和防潮", "防静电", "温湿度控制", "电力供应", "电磁防护" };
		String[] net_sec = { "结构安全", "访问控制", "安全审计", "边界完整性检查", "入侵防范",
				"恶意代码防范", "网络设备防护" };
		String[] host_sec = { "身份鉴别", "访问控制", "安全审计", "剩余信息保护", "入侵防范",
				"恶意代码防范", "资源控制" };
		String[] app_sec = { "身份鉴别", "访问控制", "安全审计", "剩余信息保护", "通信完整性",
				"通信保密性", "抗抵赖", "软件容错", "资源控制" };
		String[] data_sec = { "数据完整性", "数据保密性", "备份和恢复" };
		String[] manage_zhidu = { "管理制度", "制定和发布", "评审和修订" };
		String[] manage_jigou = { "岗位设置", "人员配备", "授权和审批", "沟通和合作", "审核和检查" };
		String[] person_sec = { "人员录用", "人员离岗", "人员考核", "安全意识教育和培训", "外部人员访问管理" };
		String[] system_construction = { "系统定级", "安全方案设计", "产品采购和使用", "自行软件开发",
				"外包软件开发", "工程实施", "测试验收", "系统交付", "系统备案", "等级测评", "安全服务商选择" };
		String[] system_run_manage = { "环境管理", "资产管理", "介质管理", "设备管理",
				"监控管理和安全管理中心", "网络安全管理", "系统安全管理", "恶意代码防范管理", "密码管理", "变更管理",
				"备份与恢复管理", "安全事件处置", "应急预案管理" };
		
		switch (cpLevelId) {
		
		//把安全控制点  映射到自然序列 0,1,2,3,4...
		case 0:
			for (int i = 0; i < control_point_num; i++) {
				map412.put(phy_sec[i], i);
			}
			break;
		case 1:
			for (int i = 0; i < control_point_num; i++) {
				map412.put(net_sec[i], i);
			}
			break;
		case 2:
			for (int i = 0; i < control_point_num; i++) {
				map412.put(host_sec[i], i);
			}
			break;
		case 3:
			for (int i = 0; i < control_point_num; i++) {
				map412.put(app_sec[i], i);
			}
			break;
		case 4:
			for (int i = 0; i < control_point_num; i++) {
				map412.put(data_sec[i], i);
			}
			break;
		case 5:
			for (int i = 0; i < control_point_num; i++) {
				map412.put(manage_zhidu[i], i);
			}
			break;
		case 6:
			for (int i = 0; i < control_point_num; i++) {
				map412.put(manage_jigou[i], i);
			}
			break;
		case 7:
			for (int i = 0; i < control_point_num; i++) {
				map412.put(person_sec[i], i);
			}
			break;
		case 8:
			for (int i = 0; i < control_point_num; i++) {
				map412.put(system_construction[i], i);
			}
			break;
		case 9:
			for (int i = 0; i < control_point_num; i++) {
				map412.put(system_run_manage[i], i);
			}
			break;
		}

		

		/** 模板标签 附录A等级测评结果记录
		
		 test_object  附件中  测评对象标签
		
		sec_control  安全控制点
		
		test_index   测评项
		
		 result_record  测评结果记录 
		 
		 meet_level   结果判定   符合程度  0-5分
		 
		 serial_number4  序列号
		 
		 test_object4   第4章 测评对象标签
		 
		 num4  对符合，不符合的统计
				
		*/
		// 结果记录表内层循环
		String[] list_inner = { "list_inner0", "list_inner1", "list_inner2",
				"list_inner3", "list_inner4", "list_inner5", "list_inner6",
				"list_inner7", "list_inner8", "list_inner9" };

		List<Map<String, Object>> Table_list = new ArrayList<Map<String, Object>>();// return
																					// Table_list
		int AutoId[] = new int[deviceNum];
		String[] device_name = new String[deviceNum];
		
		for (int k = 0; k < deviceNum; k++) {
			AutoId[k] = testobject.get(k).getAutoId();
			device_name[k] = testobject.get(k).getName();
		}
		
		for (int j = 0; j < deviceNum; j++) {
			List<Map<String, Object>> list411 = new ArrayList<Map<String, Object>>();
			Map<String, Object> table_map = new HashMap<String, Object>();
			
			//AutoId 数据记录了  所有测评对象的主键
			int autoid = AutoId[j];
			
			itemselres = new ArrayList<ItemSelRes>();
			itemselres = showItem(autoid);
			
			String testObjectName = itemselres.get(0).getItemToObject().getName(); //测评对象的 名称
			
			// 将 结果记录 ，测评项分数 与模板标签对应
			for (int i = 0; i < itemselres.size(); i++) {

				Map<String, Object> map = new HashMap<String, Object>();
				
				String itemResult;//测评项结果记录
				String itemScore;//测评项得分
				String cpDian = itemselres.get(i).getItem().getCpZhBiao(); //控制点
				String conItem = itemselres.get(i).getItem().getCpxCon(); //测评项 内容
				if(itemselres.get(i).getResult() == null){
					itemResult = " ";
				}else{
					itemResult = itemselres.get(i).getResult(); //测评项结果记录
				}
				
				if(itemselres.get(i).getNotice() == null){
					itemScore = " ";
				}else{
					itemScore = itemselres.get(i).getNotice(); //测评项得分
				}
				 			
				
				if(i==0){
					map.put("test_object"+cpLevelId, testObjectName);
				}else{
					map.put("test_object"+cpLevelId, " ");  //测评对象
				}
				

				map.put("result_record"+cpLevelId, itemResult);//测评项结果记录

				map.put("meet_level"+cpLevelId, itemScore);//测评项得分

				map.put("test_index"+cpLevelId, conItem);//将测评项放入标签

				map.put("sec_control"+cpLevelId, cpDian); //将控制点放入标签
				
				list411.add(map);
				

				/**
				 * 统计 符合，不符合，部分符合 的个数
				 * 用三维数组   标记
				 */

				
				if (itemselres.get(i).getNotice() != null
						&& itemselres.get(i).getNotice().isEmpty() == false) {

					if (itemScore.equals("不适用")) {
						result_total_alalyse[j][3][(Integer) map412.get(cpDian)]++;
					} else {
						result_total_alalyse[j][(Integer) map411.get(score_to_meetlevel(Integer.valueOf(itemScore)))]
												[(Integer) map412.get(cpDian)]++;
					}
					
					// System.out.println("hh" + itemselres.get(i).getNotice());

				}

			}
			
			table_map.put(list_inner[cpLevelId], list411);  //遍历某个测评层面（物理安全） 的某个测评对象table_map<标签，测评表内容>
			
			//Table_list 存放了  某一测评层面的所有 测评对象
			Table_list.add(table_map);//将同一个测评层面的测评对象放在Table_list<老机房，中央机房>

		}
				
		return_map.put("one", Table_list);// 结果记录
		
		List<Map<String, Object>> list_result = new ArrayList<Map<String, Object>>();// return

		// 将测评结果与报告标签对应 // list412
		for (int i = 0; i < deviceNum; i++) {
			
			Map<String, Object> map_412 = new HashMap<String, Object>();  //String 代表 报告中标签  
			
			map_412.put("serial_number4"+cpLevelId, i + 1); //序列号
			
			map_412.put("test_object4"+cpLevelId, device_name[i]);// 测评对象名称
			
			for (int m = 0; m < 4; m++)
				for (int k = 0; k < control_point_num; k++)
					map_412.put("num4"+cpLevelId + m + k, result_total_alalyse[i][m][k]);
			
			list_result.add(map_412);
//			System.out.println("for" + i);
		}
		return_map.put("two", list_result);// 统计符合，不符合，部分符合，不适应的 个数

		return return_map;
		
	}// hanxu up

	@Override
	public String exportReport(Map<String, Object> dataMap, int testSysId) {
		// TODO Auto-generated method stub
		int[] control_point_num = { 10, 7, 9, 11, 3, 3, 5, 5, 11, 13 };
		String[] lable4 = { "list40", "list41", "list42", "list43", "list44",
				"list45", "list46", "list47", "list48", "list49" };
		String[] lable_a = { "lista0", "lista1", "lista2", "lista3", "lista4",
				"lista5", "lista6", "lista7", "lista8", "lista9" };
		// 韩旭添加

		testobject = new ArrayList<TestObject>();

		for (int i = 0; i < 10; i++) {

			//将网络全局  与网络设备的 测评对象合并在一起
			if(i==1){
				testobject = testObjectItem(testSysId, i);
				List<TestObject>netDevice = new ArrayList<TestObject>();
				netDevice = testObjectItem(testSysId, 10);
				testobject.addAll(netDevice);
			}else{
				testobject = testObjectItem(testSysId, i);
			}
			
			// 遍历整个数据库
			Map<String, Object> map = new HashMap<String, Object>();
			
			map = (Map<String, Object>) report_Result_Record(testobject, i,
					control_point_num[i]);

		
		
			dataMap.put(lable_a[i], map.get("one")); //将测评结果放入  标签中

			dataMap.put(lable4[i], map.get("two")); //将统计结果 放入  标签中

			
		}
		
		
		/**
		 * 计算 分数 	
		 */
		//遍历一遍把得分数据写入数据库
			int tsId = testobject.get(0).getPro().getAutoId();
			List<Score> scores= new ArrayList<Score>();
			
			scores=scoreDao.selAll(tsId);  //根据被测系统Id 查询出  所有基本测评项的平均分
			
			calConScore(scores); //计算测评控制点的分
				
			List<ConScore> conscoreAll= new ArrayList<ConScore>();
			
			conscoreAll=conScoreDao.selAll(tsId); //查询 某被测系统  所有控制点的分
			
			calResult(conscoreAll); //计算被测系统总体 得分
			
		
			/**
			 * 计算  控制点得分
			 */
			calculateScore(dataMap , tsId , conscoreAll);
			
			
			
		
		// 将导出的报告信息写入数据库
			TestSystem testSystem = new TestSystem();
			
			if(testobject.size() > 0){
				testSystem = testobject.get(0).getPro();
				
				return reportTODb(testSystem);
			}else{
				return "fail";
			}
		

	}

	/**
	 * 导出报告成功后 ，将报告信息写入数据库
	 * @param testobject
	 * @return
	 */
	public String reportTODb(TestSystem testSystem){
			
		Date time = new java.sql.Date(new java.util.Date().getTime());

		Reports report = new Reports();
		report.setTestSystem(testSystem);
		report.setTime(String.valueOf(time));
		report.setName(testSystem.getSystem().getSysName());

		String pattern = "yyyyMMddHHmmss";
		java.text.DateFormat df = new java.text.SimpleDateFormat(pattern);
		String timeStr = df.format(time);

		report.setFileName(timeStr);
		saveReport(report);
		return timeStr;
		
	}
	/**
	 * 
	 * @param dataMap 
	 * @param tsId 被测系统Id
	 */
	public void calculateScore(Map<String, Object> dataMap , int tsId ,List<ConScore> conscoreAll){
		
		String[] sec_level={"物理安全","网络安全","主机安全","应用安全","数据安全及备份恢复","安全管理制度",
				"安全管理机构","人员安全管理","系统建设管理","系统运维管理"};//安全层面常量数组
		
		Map<String,Object> sec_level_to_index=new HashMap<String,Object>();
		for(int i=0;i<sec_level.length;i++){
			sec_level_to_index.put(sec_level[i], i);
		}
		
		float[] score_level=new float[10];//安全层面得分存放在此数组
		
		for(int i=0;i<sec_level.length;i++){
			List<ConScore> conscoreLevel=new ArrayList<ConScore>();
			conscoreLevel=conScoreDao.selMAll(tsId, sec_level[i]);
			
			float sec_level_score=0; //某一测评层面的  所有控制点得分 之和
			
			int length=conscoreLevel.size();
			int num = length; //记录有效控制点的个数
			
			for(int j=0; j<length; j++){
				if(conscoreLevel.get(j).getWeighs()==0){//如果权重为0，则表示不适用，求平均值的分母减1
					num--;
				}else{//否则，累加安全控制点得分
					sec_level_score += conscoreLevel.get(j).getItemConScore();
				}					
			}
			if(num != 0){
				sec_level_score=sec_level_score/num;
						
				score_level[i]=sec_level_score*20;   //控制层面 百分制得分  存入 数组中
			}
							
		}//此段代码计算各个安全层面得分
		
		
		//报告4.12章 6.1章
		List<Map<String,Object>> list_412=new ArrayList<Map<String,Object>>();//list_412对应模板标签list
		List<Map<String,Object>> list_61=new ArrayList<Map<String,Object>>();//list_61对应相应模板标签list
		
		String tempVariable="TempDemo";//临时变量，无意义
		
		for(int i=0;i<conscoreAll.size();i++){
			Map<String,Object> map=new HashMap<String,Object>();
			//map放入<key,value>对
			String secLevel=conscoreAll.get(i).getItemCon().getSecConLaySN(); //安全层面内容
			
			map.put("sec_control_point", conscoreAll.get(i).getItemCon());//控制点内容
			
			float score=conscoreAll.get(i).getItemConScore();//控制点得分
			map.put("sec_control_point_score",score);
			map.put("sys_sec_asure_num", i); //序号
			
			if(tempVariable.equals(secLevel)==false){
				
				map.put("sec_level", secLevel);	 //安全层面内容
				map.put("sec_level_score", score_level[(int) sec_level_to_index.get(sec_level)]); //安全层面得分
				tempVariable=secLevel;
				
			}else{
				map.put("sec_level", " ");
				map.put("sec_level_score", " ");
			}
			list_61.add(map);
			
			map.remove("sys_sec_asure_num");
			map.remove("sec_level_score");
			
			map.put("unit_test_num", i);
			
			rightSymbol(map,score); //画  √
			
			list_412.add(map);
			
			
		}
		dataMap.put("list_61", list_61);
		dataMap.put("list_412", list_412);
	}
	/**
	 * 计算某被测系统  某测评项的平均分 并存入数据库score中
	 * 被测系统@param tsId
	 */
	private void calAverScore(int tsId,ItemSelRes itemSelRes){
		Item item = itemSelRes.getItem();
		
		float score = Float.valueOf(itemSelRes.getNotice());
		
		Score tmp = scoreDao.selM(tsId, item.getItemId()).get(0);
		int num = tmp.getNum();
		
		score += tmp.getScore()*num;
		
		num++;
		score /= num;
		
		tmp.setScore(score);
		tmp.setNum(num);
		scoreDao.update(tmp);		
	}
	
	/**
	 * 根据安全控制点得分画√
	 */
	private void rightSymbol(Map<String,Object> map,float score){
		if(score==0){
			map.put("not_coincidence", "√");
			map.put("coincidence", " ");
			map.put("part_coincidence", " ");
			map.put("not_suitable", " ");
		}else if(score==5){
			map.put("not_coincidence", " ");
			map.put("coincidence", "√");
			map.put("part_coincidence", " ");
			map.put("not_suitable", " ");
		}else if(score>0&&score<5){
			map.put("not_coincidence", " ");
			map.put("coincidence", " ");
			map.put("part_coincidence", "√");
			map.put("not_suitable", " ");
		}else{
			map.put("not_coincidence", " ");
			map.put("coincidence", " ");
			map.put("part_coincidence", " ");
			map.put("not_suitable", "√");
		}
	}
	
	/**
	 * 计算测评控制点 分数， 及控制点的所有测评项权重和
	 * 某被测系统所有不重复测评项的表    @List<Score> scores
	 * 内容包括 平均分、有效测评对象的个数 
	 */
	private void calConScore(List<Score> scores){
		
		//将所有的控制点写入ConScore表中
		
		TestSystem testSystem = scores.get(0).getTestSystem();
		
		List<ItemCon> tmp = itemConDao.showAll();
		List<ConScore> cstmp = conScoreDao.selAll(testSystem.getAutoId());
		if(cstmp.size()>0){
			for(ItemCon it : tmp){
				
				ConScore conScore = new ConScore();
				
				conScore.setItemCon(it);
				conScore.setTestSystem(testSystem);
				
				conScoreDao.save(conScore);
			}			
		}
		//根据测评项的得分  计算控制点的得分
		for(Score it:scores){
			String CpZhiBiao = it.getItem().getCpZhBiao();
			
			float weigh = it.getItem().getWeigh();
			float score = it.getScore()*weigh;
			
			ConScore conScore = conScoreDao.selMAll(testSystem.getAutoId(), CpZhiBiao).get(0);
			
			float tmpscore = conScore.getItemConScore()*conScore.getWeighs();
			
			score += tmpscore;
			weigh += conScore.getWeighs();
			score /=weigh;
			
			conScore.setItemConScore(score);
			conScore.setWeighs(weigh);
			
			conScoreDao.save(conScore);
		}
		
	}
	
	/**
	 * 得到最后被测系统的最终得分，并写入数据库
	 * 
	 * 某被测系统所有不重复测评控制点的表    @conScores
	 * 内容包括控制点得分、控制点下所有测评项权重和 
	 *
	 */
	private void calResult(List<ConScore> conScores){
		
		float result = 0;
		float weighs = 0;
		
		for(ConScore it : conScores){
			float score = it.getItemConScore();
			float weigh = it.getWeighs();
			
			result +=score*weigh;
			weighs +=weigh;
		}
		result /= weighs;
		result *=20;
		
		TestSystem testSystem = conScores.get(0).getTestSystem();
		
		testSystem.setTestResult(String.valueOf(result));
		
		testSystemDao.saveTestSys(testSystem);
	}

	@Override
	public List<Reports> showMReport(int testSysId) {
		// TODO Auto-generated method stub
		return reportDao.showMReport(testSysId);
	}
	
}

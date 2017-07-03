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

	private List<TestObject> testobject;// �ȴ����ݿ��ѯ
	
	
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
		 * 1�������ݿ����ĳϵͳ��ĳ������������в�������ϡ������ϡ��������ϵĲ�������� 2�����ĸ����ݷ���Map������
		 */
		String countAll = String.valueOf(showItemDao.showItem(testObjectId)
				.size());
		String countYes = String.valueOf(showItemDao.showMItem(testObjectId,
				"����").size());
		String countYesOrNo = String.valueOf(showItemDao.showMItem(
				testObjectId, "��������").size());
		String countNo = String.valueOf(showItemDao.showMItem(testObjectId,
				"������").size());

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
			str = "������";
		} else if (score == 5) {
			str = "����";
		} else {
			str = "���ַ���";
		}
		return str;
	}

	/**
	 * 
	 * @param testobject  ĳһ���������Ӧ�����в������� 
	 * @param cpLevelId  ��������Id
	 * @param control_point_num  ���������п��Ƶ�ĸ���
	 * @return
	 */
	public Map<String, Object> report_Result_Record(
			List<TestObject> testobject, int cpLevelId, int control_point_num) {
		// TODO Auto-generated method stub
		
		float dontmatch = -100;// ������

		Map<String, Object> return_map = new HashMap<String, Object>();// �������ش�Map

		int deviceNum = testobject.size(); //��������ĸ���
		
		int result_total_alalyse[][][] = new int[deviceNum][4][control_point_num];
		
		// ������ܱ��������ݽṹ��1����ά���飬3��map����
		
		Map<String, Object> map411 = new HashMap<String, Object>();
		map411.put("����", 0);
		map411.put("���ַ���", 1);
		map411.put("������", 2);
		map411.put("������", 3);
		
		Map<String, Object> map412 = new HashMap<String, Object>();
		
		String[] phy_sec = { "����λ�õ�ѡ��", "������ʿ���", "�����Ժͷ��ƻ�", "���׻�", "����",
				"��ˮ�ͷ���", "������", "��ʪ�ȿ���", "������Ӧ", "��ŷ���" };
		String[] net_sec = { "�ṹ��ȫ", "���ʿ���", "��ȫ���", "�߽������Լ��", "���ַ���",
				"����������", "�����豸����" };
		String[] host_sec = { "��ݼ���", "���ʿ���", "��ȫ���", "ʣ����Ϣ����", "���ַ���",
				"����������", "��Դ����" };
		String[] app_sec = { "��ݼ���", "���ʿ���", "��ȫ���", "ʣ����Ϣ����", "ͨ��������",
				"ͨ�ű�����", "������", "����ݴ�", "��Դ����" };
		String[] data_sec = { "����������", "���ݱ�����", "���ݺͻָ�" };
		String[] manage_zhidu = { "�����ƶ�", "�ƶ��ͷ���", "������޶�" };
		String[] manage_jigou = { "��λ����", "��Ա�䱸", "��Ȩ������", "��ͨ�ͺ���", "��˺ͼ��" };
		String[] person_sec = { "��Ա¼��", "��Ա���", "��Ա����", "��ȫ��ʶ��������ѵ", "�ⲿ��Ա���ʹ���" };
		String[] system_construction = { "ϵͳ����", "��ȫ�������", "��Ʒ�ɹ���ʹ��", "�����������",
				"����������", "����ʵʩ", "��������", "ϵͳ����", "ϵͳ����", "�ȼ�����", "��ȫ������ѡ��" };
		String[] system_run_manage = { "��������", "�ʲ�����", "���ʹ���", "�豸����",
				"��ع���Ͱ�ȫ��������", "���簲ȫ����", "ϵͳ��ȫ����", "��������������", "�������", "�������",
				"������ָ�����", "��ȫ�¼�����", "Ӧ��Ԥ������" };
		
		switch (cpLevelId) {
		
		//�Ѱ�ȫ���Ƶ�  ӳ�䵽��Ȼ���� 0,1,2,3,4...
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

		

		/** ģ���ǩ ��¼A�ȼ����������¼
		
		 test_object  ������  ���������ǩ
		
		sec_control  ��ȫ���Ƶ�
		
		test_index   ������
		
		 result_record  ���������¼ 
		 
		 meet_level   ����ж�   ���ϳ̶�  0-5��
		 
		 serial_number4  ���к�
		 
		 test_object4   ��4�� ���������ǩ
		 
		 num4  �Է��ϣ������ϵ�ͳ��
				
		*/
		// �����¼���ڲ�ѭ��
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
			
			//AutoId ���ݼ�¼��  ���в������������
			int autoid = AutoId[j];
			
			itemselres = new ArrayList<ItemSelRes>();
			itemselres = showItem(autoid);
			
			String testObjectName = itemselres.get(0).getItemToObject().getName(); //��������� ����
			
			// �� �����¼ ����������� ��ģ���ǩ��Ӧ
			for (int i = 0; i < itemselres.size(); i++) {

				Map<String, Object> map = new HashMap<String, Object>();
				
				String itemResult;//����������¼
				String itemScore;//������÷�
				String cpDian = itemselres.get(i).getItem().getCpZhBiao(); //���Ƶ�
				String conItem = itemselres.get(i).getItem().getCpxCon(); //������ ����
				if(itemselres.get(i).getResult() == null){
					itemResult = " ";
				}else{
					itemResult = itemselres.get(i).getResult(); //����������¼
				}
				
				if(itemselres.get(i).getNotice() == null){
					itemScore = " ";
				}else{
					itemScore = itemselres.get(i).getNotice(); //������÷�
				}
				 			
				
				if(i==0){
					map.put("test_object"+cpLevelId, testObjectName);
				}else{
					map.put("test_object"+cpLevelId, " ");  //��������
				}
				

				map.put("result_record"+cpLevelId, itemResult);//����������¼

				map.put("meet_level"+cpLevelId, itemScore);//������÷�

				map.put("test_index"+cpLevelId, conItem);//������������ǩ

				map.put("sec_control"+cpLevelId, cpDian); //�����Ƶ�����ǩ
				
				list411.add(map);
				

				/**
				 * ͳ�� ���ϣ������ϣ����ַ��� �ĸ���
				 * ����ά����   ���
				 */

				
				if (itemselres.get(i).getNotice() != null
						&& itemselres.get(i).getNotice().isEmpty() == false) {

					if (itemScore.equals("������")) {
						result_total_alalyse[j][3][(Integer) map412.get(cpDian)]++;
					} else {
						result_total_alalyse[j][(Integer) map411.get(score_to_meetlevel(Integer.valueOf(itemScore)))]
												[(Integer) map412.get(cpDian)]++;
					}
					
					// System.out.println("hh" + itemselres.get(i).getNotice());

				}

			}
			
			table_map.put(list_inner[cpLevelId], list411);  //����ĳ���������棨����ȫ�� ��ĳ����������table_map<��ǩ������������>
			
			//Table_list �����  ĳһ������������� ��������
			Table_list.add(table_map);//��ͬһ����������Ĳ����������Table_list<�ϻ������������>

		}
				
		return_map.put("one", Table_list);// �����¼
		
		List<Map<String, Object>> list_result = new ArrayList<Map<String, Object>>();// return

		// ����������뱨���ǩ��Ӧ // list412
		for (int i = 0; i < deviceNum; i++) {
			
			Map<String, Object> map_412 = new HashMap<String, Object>();  //String ���� �����б�ǩ  
			
			map_412.put("serial_number4"+cpLevelId, i + 1); //���к�
			
			map_412.put("test_object4"+cpLevelId, device_name[i]);// ������������
			
			for (int m = 0; m < 4; m++)
				for (int k = 0; k < control_point_num; k++)
					map_412.put("num4"+cpLevelId + m + k, result_total_alalyse[i][m][k]);
			
			list_result.add(map_412);
//			System.out.println("for" + i);
		}
		return_map.put("two", list_result);// ͳ�Ʒ��ϣ������ϣ����ַ��ϣ�����Ӧ�� ����

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
		// �������

		testobject = new ArrayList<TestObject>();

		for (int i = 0; i < 10; i++) {

			//������ȫ��  �������豸�� ��������ϲ���һ��
			if(i==1){
				testobject = testObjectItem(testSysId, i);
				List<TestObject>netDevice = new ArrayList<TestObject>();
				netDevice = testObjectItem(testSysId, 10);
				testobject.addAll(netDevice);
			}else{
				testobject = testObjectItem(testSysId, i);
			}
			
			// �����������ݿ�
			Map<String, Object> map = new HashMap<String, Object>();
			
			map = (Map<String, Object>) report_Result_Record(testobject, i,
					control_point_num[i]);

		
		
			dataMap.put(lable_a[i], map.get("one")); //�������������  ��ǩ��

			dataMap.put(lable4[i], map.get("two")); //��ͳ�ƽ�� ����  ��ǩ��

			
		}
		
		
		/**
		 * ���� ���� 	
		 */
		//����һ��ѵ÷�����д�����ݿ�
			int tsId = testobject.get(0).getPro().getAutoId();
			List<Score> scores= new ArrayList<Score>();
			
			scores=scoreDao.selAll(tsId);  //���ݱ���ϵͳId ��ѯ��  ���л����������ƽ����
			
			calConScore(scores); //����������Ƶ�ķ�
				
			List<ConScore> conscoreAll= new ArrayList<ConScore>();
			
			conscoreAll=conScoreDao.selAll(tsId); //��ѯ ĳ����ϵͳ  ���п��Ƶ�ķ�
			
			calResult(conscoreAll); //���㱻��ϵͳ���� �÷�
			
		
			/**
			 * ����  ���Ƶ�÷�
			 */
			calculateScore(dataMap , tsId , conscoreAll);
			
			
			
		
		// �������ı�����Ϣд�����ݿ�
			TestSystem testSystem = new TestSystem();
			
			if(testobject.size() > 0){
				testSystem = testobject.get(0).getPro();
				
				return reportTODb(testSystem);
			}else{
				return "fail";
			}
		

	}

	/**
	 * ��������ɹ��� ����������Ϣд�����ݿ�
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
	 * @param tsId ����ϵͳId
	 */
	public void calculateScore(Map<String, Object> dataMap , int tsId ,List<ConScore> conscoreAll){
		
		String[] sec_level={"����ȫ","���簲ȫ","������ȫ","Ӧ�ð�ȫ","���ݰ�ȫ�����ݻָ�","��ȫ�����ƶ�",
				"��ȫ�������","��Ա��ȫ����","ϵͳ�������","ϵͳ��ά����"};//��ȫ���泣������
		
		Map<String,Object> sec_level_to_index=new HashMap<String,Object>();
		for(int i=0;i<sec_level.length;i++){
			sec_level_to_index.put(sec_level[i], i);
		}
		
		float[] score_level=new float[10];//��ȫ����÷ִ���ڴ�����
		
		for(int i=0;i<sec_level.length;i++){
			List<ConScore> conscoreLevel=new ArrayList<ConScore>();
			conscoreLevel=conScoreDao.selMAll(tsId, sec_level[i]);
			
			float sec_level_score=0; //ĳһ���������  ���п��Ƶ�÷� ֮��
			
			int length=conscoreLevel.size();
			int num = length; //��¼��Ч���Ƶ�ĸ���
			
			for(int j=0; j<length; j++){
				if(conscoreLevel.get(j).getWeighs()==0){//���Ȩ��Ϊ0�����ʾ�����ã���ƽ��ֵ�ķ�ĸ��1
					num--;
				}else{//�����ۼӰ�ȫ���Ƶ�÷�
					sec_level_score += conscoreLevel.get(j).getItemConScore();
				}					
			}
			if(num != 0){
				sec_level_score=sec_level_score/num;
						
				score_level[i]=sec_level_score*20;   //���Ʋ��� �ٷ��Ƶ÷�  ���� ������
			}
							
		}//�˶δ�����������ȫ����÷�
		
		
		//����4.12�� 6.1��
		List<Map<String,Object>> list_412=new ArrayList<Map<String,Object>>();//list_412��Ӧģ���ǩlist
		List<Map<String,Object>> list_61=new ArrayList<Map<String,Object>>();//list_61��Ӧ��Ӧģ���ǩlist
		
		String tempVariable="TempDemo";//��ʱ������������
		
		for(int i=0;i<conscoreAll.size();i++){
			Map<String,Object> map=new HashMap<String,Object>();
			//map����<key,value>��
			String secLevel=conscoreAll.get(i).getItemCon().getSecConLaySN(); //��ȫ��������
			
			map.put("sec_control_point", conscoreAll.get(i).getItemCon());//���Ƶ�����
			
			float score=conscoreAll.get(i).getItemConScore();//���Ƶ�÷�
			map.put("sec_control_point_score",score);
			map.put("sys_sec_asure_num", i); //���
			
			if(tempVariable.equals(secLevel)==false){
				
				map.put("sec_level", secLevel);	 //��ȫ��������
				map.put("sec_level_score", score_level[(int) sec_level_to_index.get(sec_level)]); //��ȫ����÷�
				tempVariable=secLevel;
				
			}else{
				map.put("sec_level", " ");
				map.put("sec_level_score", " ");
			}
			list_61.add(map);
			
			map.remove("sys_sec_asure_num");
			map.remove("sec_level_score");
			
			map.put("unit_test_num", i);
			
			rightSymbol(map,score); //��  ��
			
			list_412.add(map);
			
			
		}
		dataMap.put("list_61", list_61);
		dataMap.put("list_412", list_412);
	}
	/**
	 * ����ĳ����ϵͳ  ĳ�������ƽ���� ���������ݿ�score��
	 * ����ϵͳ@param tsId
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
	 * ���ݰ�ȫ���Ƶ�÷ֻ���
	 */
	private void rightSymbol(Map<String,Object> map,float score){
		if(score==0){
			map.put("not_coincidence", "��");
			map.put("coincidence", " ");
			map.put("part_coincidence", " ");
			map.put("not_suitable", " ");
		}else if(score==5){
			map.put("not_coincidence", " ");
			map.put("coincidence", "��");
			map.put("part_coincidence", " ");
			map.put("not_suitable", " ");
		}else if(score>0&&score<5){
			map.put("not_coincidence", " ");
			map.put("coincidence", " ");
			map.put("part_coincidence", "��");
			map.put("not_suitable", " ");
		}else{
			map.put("not_coincidence", " ");
			map.put("coincidence", " ");
			map.put("part_coincidence", " ");
			map.put("not_suitable", "��");
		}
	}
	
	/**
	 * ����������Ƶ� ������ �����Ƶ�����в�����Ȩ�غ�
	 * ĳ����ϵͳ���в��ظ�������ı�    @List<Score> scores
	 * ���ݰ��� ƽ���֡���Ч��������ĸ��� 
	 */
	private void calConScore(List<Score> scores){
		
		//�����еĿ��Ƶ�д��ConScore����
		
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
		//���ݲ�����ĵ÷�  ������Ƶ�ĵ÷�
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
	 * �õ���󱻲�ϵͳ�����յ÷֣���д�����ݿ�
	 * 
	 * ĳ����ϵͳ���в��ظ��������Ƶ�ı�    @conScores
	 * ���ݰ������Ƶ�÷֡����Ƶ������в�����Ȩ�غ� 
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

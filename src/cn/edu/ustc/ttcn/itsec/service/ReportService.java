package cn.edu.ustc.ttcn.itsec.service;

import java.util.List;
import java.util.Map;

import cn.edu.ustc.ttcn.itsec.model.ItemSelRes;
import cn.edu.ustc.ttcn.itsec.model.Reports;
import cn.edu.ustc.ttcn.itsec.model.Systems;
import cn.edu.ustc.ttcn.itsec.model.TestObject;

public interface ReportService {
	/**
	 * ���ݱ���ϵͳId �õ�ϵͳ������Ϣ
	 * 
	 * @param id
	 *            ϵͳId
	 * @return ����ϵͳ��Ϣ
	 */
	public Systems systemInfo(int id);

	/*
	 * ���ĳĳ�����豸�ľ�������� �� itemselres ���и��� ObjectId ����ѡ��
	 */
	public List<ItemSelRes> showItem(int testObjectId);

	/**
	 * ���ݿ��testobject ����ϵͳId������������� ��ѯ ����ϵͳId@param proId �����������@param objectId
	 * List<TestObject>@return
	 */
	public List<TestObject> testObjectItem(int proId, int objectId);

/**
	 * ͳ�Ʋ������С�������������ϡ������������ϡ����������ϡ�����
	 * ��������Id@param testObjectId
	 * Map
	 * <'All':'';'Yes':'';'YesOrNo':'';'No':''>@return
	 * @return 
	 */
	public Map<String, String> countResult(int testObjectId);

	/**
	 * ���� ���������Ϣ
	 * 
	 * @param it
	 */
	public void saveReport(Reports it);

	/**
	 * ���ĳ����ϵͳ�����б���
	 * 
	 * ����ϵͳ��Id @param testSysId
	 * @return
	 */
	public List<Reports> showMReport(int testSysId);

	/**
	 * ��ѯĳϵͳ���ɵĽ�ֹĿǰ�� ���е� ����
	 * @param sysId
	 * @return
	 */
	
	public List<Reports> showAllReport(int sysId);
	/**
	 * 1���ͻ��˴�����Ҫ��������� ����ϵͳid
	 * 
	 * 2���������� ���� ���������
	 * 
	 * @param testSysId
	 * @return
	 */
	public String exportReport(Map<String, Object> map, int testSysId);

	// �������� �����¼
	// public Map<String, Object> report_Result_Record(int ProId, int
	// ObjectId,int control_point_num);
}

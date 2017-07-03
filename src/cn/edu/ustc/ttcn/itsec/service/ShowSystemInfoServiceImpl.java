package cn.edu.ustc.ttcn.itsec.service;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.dao.ShowSystemInfoDao;
import cn.edu.ustc.ttcn.itsec.model.Systems;
import cn.edu.ustc.ttcn.itsec.model.TestSystem;

public class ShowSystemInfoServiceImpl implements ShowSystemInfoService{
	private ShowSystemInfoDao showSystemInfoDao;

	
	public ShowSystemInfoDao getShowSystemInfoDao() {
		return showSystemInfoDao;
	}

	public void setShowSystemInfoDao(ShowSystemInfoDao showSystemInfoDao) {
		this.showSystemInfoDao = showSystemInfoDao;
	}

	public List<Systems> ShowSysteminfo(int id){
		return showSystemInfoDao.ShowSysteminfo(id);
	}
}

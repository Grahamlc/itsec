package cn.edu.ustc.ttcn.itsec.service;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.Systems;
import cn.edu.ustc.ttcn.itsec.model.TestSystem;

public interface ShowSystemInfoService {
	/**
	 * 数据库中systems表
	 * 根据AutoId主键查询整条数据项，得到系统的信息
	 * @param id
	 * @return
	 */
	public List<Systems> ShowSysteminfo(int id);
}

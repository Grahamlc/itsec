package cn.edu.ustc.ttcn.itsec.service;

import cn.edu.ustc.ttcn.itsec.dao.WriteItemDao;
import cn.edu.ustc.ttcn.itsec.model.ItemSelRes;

public class WriteItemServiceImpl implements WriteItemService {

	private WriteItemDao writeItemDao;
	
	public WriteItemDao getWriteItemDao() {
		return writeItemDao;
	}

	public void setWriteItemDao(WriteItemDao writeItemDao) {
		this.writeItemDao = writeItemDao;
	}

	public void submitItem(ItemSelRes it) {
		// TODO Auto-generated method stub
		writeItemDao.updateItem(it);
	}
}

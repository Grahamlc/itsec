package cn.edu.ustc.ttcn.itsec.service;

import java.util.List;

import cn.edu.ustc.ttcn.itsec.model.Device;

public interface DeviceService {
	/*输出静态知识库中（device）表中所有的测评设备
	 * */
	public List<Device> showAllDevice();
}

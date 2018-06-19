package com.cetccity.queue.dao;

import java.util.Date;
import java.util.List;

public interface QueueDao {

	/**
	 * 取得客户级别 即客户打电话进来的次数和电话号码
	 * @param lastWaitBegin
	 * @param waitBegin
	 * @return
	 */
	public List<Object[]> getCallCount(Date lastWaitBegin,Date waitBegin );
	
	/**
	 * 更改客户级别
	 * @param userid
	 * @param callerno
	 * @return
	 */
	public int updateTSpecialCustomer(String userid,String callerno);

	/**
	 * 插入客户级别
	 * @param userid
	 * @param callerno
	 * @return
	 */
	public int insertTSpecialCustomer(String userid, String callerno);

	/**
	 * 更改客户级别后查询出需要重置的客户级别
	 * @param waitBegin
	 * @param lastWaitBegin
	 * @return
	 */
	public List<Object[]> getUserForNeedBegin(Date waitBegin, Date lastWaitBegin);

	public int delectTSpecialCustomer(String callerno);

	public int updateSysCong(Date date);

	/**
	 * 取得数据的最新时间
	 * 这个时间和配置表的时间对应可取得查信息的时间范围
	 * 配置表的时间<时间<数据的最新时间
	 * @return
	 */
	public List<String> getNewBeginDate();
	
}

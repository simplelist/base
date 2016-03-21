package com.jack.utils;

import java.util.Map;

public interface IPager {
	public abstract Integer getLimit();

	/**
	 * current page
	 * @return
	 */
	public Integer getCurrentPage();

	/**
	 * desc or asc
	 * 正序或倒序
	 * @return
	 */
	public String getSortAscOrDesc();

	/**
	 * 根据哪个字段来排序
	 * @return
	 */
	public String getOrderByField();

	/**
	 * 查询条件
	 * @return
	 */
	public Map<Object,Object> getParams();

	public Integer getStart();

	public void setPage(Integer currentPage);

	public void setLimit(Integer max);

	public void setAscOrDesc(String desc);

	public void setOrderByField(String field);

	public void setParams(Map<Object, Object> map);

}

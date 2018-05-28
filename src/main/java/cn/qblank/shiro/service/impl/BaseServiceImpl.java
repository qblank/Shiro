package cn.qblank.shiro.service.impl;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.qblank.shiro.service.BaseService;
import tk.mybatis.mapper.common.Mapper;

public abstract class BaseServiceImpl<T> implements BaseService<T> {
	protected abstract Mapper<T> getMapper();

	public void save(T t) {
		getMapper().insert(t);
	}

	public void update(T t) {
		getMapper().updateByPrimaryKeySelective(t);
	}

	public void deleteById(Serializable id) {
		getMapper().deleteByPrimaryKey(id);
	}

	public T getById(Serializable id) {
		return getMapper().selectByPrimaryKey(id);
	}

	public List<T> getList() {
		return getMapper().selectAll();
	}

	public PageInfo<T> getListByPage(int currentNum, int pageSize) {
		PageHelper.startPage(currentNum, pageSize);
		List<T> list = this.getList();
		return new PageInfo<T>(list);
	}

}

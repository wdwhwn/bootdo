package com.bootdo.law.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.law.dao.ExpertrecommendDao;
import com.bootdo.law.domain.ExpertrecommendDO;
import com.bootdo.law.service.ExpertrecommendService;



@Service
public class ExpertrecommendServiceImpl implements ExpertrecommendService {
	@Autowired
	private ExpertrecommendDao expertrecommendDao;
	
	@Override
	public ExpertrecommendDO get(Integer id){
		return expertrecommendDao.get(id);
	}
	
	@Override
	public List<ExpertrecommendDO> list(Map<String, Object> map){
		return expertrecommendDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return expertrecommendDao.count(map);
	}
	
	@Override
	public int save(ExpertrecommendDO expertrecommend){
		return expertrecommendDao.save(expertrecommend);
	}
	
	@Override
	public int update(ExpertrecommendDO expertrecommend){
		return expertrecommendDao.update(expertrecommend);
	}
	
	@Override
	public int remove(Integer id){
		return expertrecommendDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return expertrecommendDao.batchRemove(ids);
	}
	
}

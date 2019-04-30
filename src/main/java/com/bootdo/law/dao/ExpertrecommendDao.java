package com.bootdo.law.dao;

import com.bootdo.law.domain.ExpertrecommendDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 稳评专家推荐表
 * @author suhai
 * @email 1992lcg@163.com
 * @date 2019-04-27 16:00:53
 */
@Mapper
public interface ExpertrecommendDao {

	ExpertrecommendDO get(Integer id);
	
	List<ExpertrecommendDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ExpertrecommendDO expertrecommend);
	
	int update(ExpertrecommendDO expertrecommend);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

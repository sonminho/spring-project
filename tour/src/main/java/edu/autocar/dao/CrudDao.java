package edu.autocar.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.autocar.domain.Member;

public interface CrudDao<M, K> {
	int count() throws Exception;

	List<M> getPage(@Param("start") int start, @Param("end") int end) throws Exception;
	
	M findById(K userId) throws Exception;

	int insert(M m) throws Exception;

	int update(M m) throws Exception;

	int delete(K k) throws Exception;
}
package com.example.list_task.mapper;

import com.example.list_task.model.UserEntity;
import com.example.list_task.model.UserEntityExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserEntityMapper {

	long countByExample(UserEntityExample example);

	int deleteByExample(UserEntityExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(UserEntity row);

	int insertSelective(UserEntity row);

	List<UserEntity> selectByExample(UserEntityExample example);

	UserEntity selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("row") UserEntity row, @Param("example") UserEntityExample example);

	int updateByExample(@Param("row") UserEntity row, @Param("example") UserEntityExample example);

	int updateByPrimaryKeySelective(UserEntity row);

	int updateByPrimaryKey(UserEntity row);
}
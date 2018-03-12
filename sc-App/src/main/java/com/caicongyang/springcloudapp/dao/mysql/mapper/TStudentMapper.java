package com.caicongyang.springcloudapp.dao.mysql.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Qualifier;

import com.caicongyang.springcloudapp.dao.mysql.entities.TStudent;
import com.caicongyang.springcloudapp.dao.mysql.entities.TStudentExample;

/**
 * student
 */
@Qualifier("mysqlSessionFactory")
public interface TStudentMapper {
    /**
     * 获取符合条件的记录数
     * student
     */
    int countByExample(TStudentExample example);

    /**
     * 删除符合条件的记录
     * student
     */
    int deleteByExample(TStudentExample example);

    /**
     * 删除指定主键的记录
     * student
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增记录
     * student
     */
    int insert(TStudent record);

    /**
     * 选择性字段新增记录
     * student
     */
    int insertSelective(TStudent record);

    /**
     * 获取指定条件的记录
     * student
     */
    List<TStudent> selectByExample(TStudentExample example);

    /**
     * 获取指定主键的记录
     * student
     */
    TStudent selectByPrimaryKey(Integer id);

    /**
     * 选择性字段更新指定条件的记录
     * student
     */
    int updateByExampleSelective(@Param("record") TStudent record, @Param("example") TStudentExample example);

    /**
     * 更新指定条件的记录
     * student
     */
    int updateByExample(@Param("record") TStudent record, @Param("example") TStudentExample example);

    /**
     * 选择性字段更新指定主键的记录
     * student
     */
    int updateByPrimaryKeySelective(TStudent record);

    /**
     * 更新指定主键的记录
     * student
     */
    int updateByPrimaryKey(TStudent record);
}
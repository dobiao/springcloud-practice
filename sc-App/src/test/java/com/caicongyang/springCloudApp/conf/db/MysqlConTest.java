/**
 * caicongyang.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.caicongyang.springCloudApp.conf.db;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.caicongyang.springCloudApp.conf.BaseCaseTest;
import com.caicongyang.springcloudapp.dao.mysql.entities.TStudent;
import com.caicongyang.springcloudapp.dao.mysql.entities.TStudentExample;
import com.caicongyang.springcloudapp.dao.mysql.mapper.TStudentMapper;

/**
 * @author caicongyang1
 * @version id: MysqlConTest, v 0.1 17/8/26 下午8:23 caicongyang1 Exp $$
 */
public class MysqlConTest extends BaseCaseTest {

    @Autowired
    TStudentMapper mapper;


    @Test
    public void mysqlTest() {
        TStudent student = new TStudent();
        student.setAge(11);
        student.setName("jack");
        mapper.insert(student);

        TStudentExample example = new TStudentExample();
        example.createCriteria().andNameEqualTo("jack");
        List<TStudent> tStudents = mapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(tStudents)) {
            Assert.assertEquals(tStudents.get(0).getAge(), new Integer(11));

        }
        //删除数据
        example.createCriteria().andAgeEqualTo(11);
        mapper.deleteByExample(example);

    }


}

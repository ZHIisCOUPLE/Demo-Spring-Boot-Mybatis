package com.zcy.hello.springboot.mybatis;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zcy.hello.springboot.mybatis.entity.TbUser;
import com.zcy.hello.springboot.mybatis.mapper.TbUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =HelloSpringbootMybatisApplication.class)
@Transactional
@Rollback
public class HelloSpringbootMybatisApplicationTests {

    @Autowired
    private TbUserMapper tbUserMapper;

    /**
     * 测试查找到所有用户名
     */
    @Test
    public void testuser(){
        List<TbUser> tbUsers = tbUserMapper.selectAll();
        for ( TbUser user :tbUsers) {
            System.out.println(user.getUsername());
        }
    }


    /**
     * 测试分页查询
     */
    @Test
    public void testPage() {
        // PageHelper 使用非常简单，只需要设置页码和每页显示笔数即可

        PageHelper.startPage(0, 2);

// 设置分页查询条件
        Example example = new Example(TbUser.class);
 //根据条件查到需要显示的所有用户
        PageInfo<TbUser> pageInfo = new PageInfo<>(tbUserMapper.selectByExample(example));

// 获取查询结果
        List<TbUser> tbUsers = pageInfo.getList();

        for (TbUser tbUser : tbUsers) {
            System.out.println(tbUser.getUsername());
        }
    }

}

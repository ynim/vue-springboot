package com.example.carbon.mapper;


import com.example.carbon.domain.User;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/*加了这个注解 就表示了 这是一个Mybatis的mapper类
就相当于之前使用的spring整合mybatis接口 也可以使用@MapperScan("com.kuang.mapper")*/
@Mapper
@Repository
public interface UserMapper {

    User queryUserById(int id);

    User queryUserByUserName(@Param("userName") String userName);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);



}

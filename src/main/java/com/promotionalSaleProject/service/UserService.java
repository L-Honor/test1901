package com.promotionalSaleProject.service;

import com.promotionalSaleProject.dataobject.UserDO;
import com.promotionalSaleProject.service.UserModel.UserModel;
import org.springframework.stereotype.Service;


public interface UserService {
    //通过用户id获取对象用户的方法
    UserModel getUserById(Integer id);
}

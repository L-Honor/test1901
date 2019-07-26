package com.promotionalSaleProject.controller;

import com.promotionalSaleProject.controller.viewobject.UserVO;
import com.promotionalSaleProject.error.BusinessException;
import com.promotionalSaleProject.error.EmBusinessError;
import com.promotionalSaleProject.response.CommonReturnType;
import com.promotionalSaleProject.service.UserModel.UserModel;
import com.promotionalSaleProject.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;

    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name="id") Integer id) throws BusinessException {
        //调用service服务获取对应id的用户对象并返回给前端
        UserModel userModel = userService.getUserById(id);

        //若获取的对应用户信息不存在
        if(userModel == null){
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }

        //将核心领域模型用户对象转换为可供UI使用的VIEWOBJECT.
        UserVO userVO = convertFromModel(userModel);

        //返回通用对象
        return CommonReturnType.create(userVO);
    }
        private UserVO convertFromModel(UserModel userModel){
        if(userModel == null){
            return null;
        }
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(userModel,userVO);
            return userVO;
        }




}

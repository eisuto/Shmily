package com.shmily.apiuser.service.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.poi.base.TempCache;
import com.poi.domain.ShyArticle;
import com.poi.domain.ShyUser;
import com.poi.mapper.ShyUserMapper;
import com.poi.uitls.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shmily.apiuser.service.ShyUserService;
import com.poi.uitls.DateUtils;

/**
 * 用户Service业务层处理
 * 
 * @author eisuto
 * @date 2021-07-14
 */
@Service
public class ShyUserServiceImpl implements ShyUserService
{
    @Autowired
    private ShyUserMapper shyUserMapper;

    /**
     * 登录
     *
     * @param user
     * @return
     */
    @Override
    public ShyUser login(ShyUser user) {
//        LinkedList api = new LinkedList();
//        api.add
        return shyUserMapper.login(user);
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @Override
    public ShyUser register(ShyUser user) throws Exception {
        // 验证码校验
        String verifyCode =  user.getVerifyCode();
        if(StringUtils.isNotEmpty(verifyCode)){
            String trueCode = TempCache.codeCacheMap.get(user.getEmail());
            if(!verifyCode.equals(trueCode)){
                throw new Exception("验证码不正确");
            }
        }
        // 用户重复校验
        ShyUser shyUser = new ShyUser();
        shyUser.setEmail(user.getEmail());
        List<ShyUser> userList = shyUserMapper.selectShyUserList(shyUser);
        if(userList.size() == 0){
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            user.setNikeName(user.getEmail());
            shyUserMapper.insertShyUser(user);
            shyUserMapper.follow(user.getId(),user.getId(),3);
            return user;
        }else{
            throw new Exception("此邮箱已被注册");
        }
    }

}

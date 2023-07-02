package com.ymsd.service.impl;

import com.ymsd.dto.UserLoginDTO;
import com.ymsd.dto.UserRegisterDTO;
import com.ymsd.entity.User;
import com.ymsd.dao.UserDao;
import com.ymsd.exception.CustomException;
import com.ymsd.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2023-07-01 17:14:07
 */
@Service("userService")
@Log4j2
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Long id) {
        return this.userDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<User> queryByPage(User user, PageRequest pageRequest) {
        long total = this.userDao.count(user);
        return new PageImpl<>(this.userDao.queryAllByLimit(user, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.userDao.deleteById(id) > 0;
    }

    @Override
    public User login(UserLoginDTO loginDTO) {
        return userDao.login(loginDTO.getUtell(),loginDTO.getUpwd());
    }

    @Override
    public Boolean register(UserRegisterDTO registerDTO) {
        User user=userDao.queryByUTell(registerDTO.getUtell());
        //   log.info("查询结果为:"+user.toString());
        if(user==null){
            //可注册
            User user1=new User();
            BeanUtils.copyProperties(registerDTO,user1);
            int insert=userDao.insert(user1);
            log.info("当前xml返回结果为："+insert);
            return insert>0;
        }else{
            //手机号重复
            throw new CustomException("用户手机号重复");
        }
    }


}

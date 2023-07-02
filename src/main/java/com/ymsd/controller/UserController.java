package com.ymsd.controller;

import com.ymsd.common.Result;
import com.ymsd.dto.UserLoginDTO;
import com.ymsd.dto.UserRegisterDTO;
import com.ymsd.entity.User;
import com.ymsd.exception.CustomException;
import com.ymsd.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2023-07-01 17:14:07
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<User>> queryByPage(User user, PageRequest pageRequest) {
        return ResponseEntity.ok(this.userService.queryByPage(user, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<User> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.userService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<User> add(User user) {
        return ResponseEntity.ok(this.userService.insert(user));
    }

    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<User> edit(User user) {
        return ResponseEntity.ok(this.userService.update(user));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.userService.deleteById(id));
    }

    @PostMapping("/login")
    public Result login(@Validated @RequestBody  UserLoginDTO loginDTO){

        User user =  userService.login(loginDTO);
        //未找到
        if(user == null){
            //错误提示要模糊
//            return new Result<>().error(500,"用户手机号或密码输入错误");
  //          throw new CustomException("用户手机号或密码输入错误");
            throw new CustomException(500,"用户手机号或密码输入错误");
        }else{
            return new Result<>().success(user);
        }
    }


    @PostMapping("/register")
    public Result register(@Validated @RequestBody UserRegisterDTO registerDTO){
        //手机号不能重复
        Boolean flag=userService.register(registerDTO);
        if(flag){
            return  new Result<>().success();
        }else{
            return new Result<>().error();
        }
    }



}


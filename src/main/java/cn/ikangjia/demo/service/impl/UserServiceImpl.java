package cn.ikangjia.demo.service.impl;

import cn.ikangjia.demo.api.model.UserDTO;
import cn.ikangjia.demo.entity.UserDO;
import cn.ikangjia.demo.mapper.UserMapper;
import cn.ikangjia.demo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2022/6/1 17:33
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO queryDetail(Long id) {
        UserDO userDO = userMapper.selectById(id);
        UserDTO res = new UserDTO();
        BeanUtils.copyProperties(userDO, res);
        return res;
    }
}

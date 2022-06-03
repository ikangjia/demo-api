package cn.ikangjia.demo.service.impl;

import cn.ikangjia.demo.api.model.UserDTO;
import cn.ikangjia.demo.api.model.UserSelectDTO;
import cn.ikangjia.demo.api.model.UserSelectPageDTO;
import cn.ikangjia.demo.entity.UserDO;
import cn.ikangjia.demo.mapper.UserMapper;
import cn.ikangjia.demo.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public UserSelectPageDTO queryUsers(UserSelectDTO userSelectDTO) {
        int pageNum = userSelectDTO.getPageNum();
        int pageSize = userSelectDTO.getPageSize();
        Page<UserDO> page = new Page<>(pageNum, pageSize);

        String username = userSelectDTO.getUsername();
        String nickname = userSelectDTO.getNickname();
        String address = userSelectDTO.getAddress();

        QueryWrapper<UserDO> wrapper = new QueryWrapper<>();
        wrapper.like(StringUtils.hasText(username), "username", username);
        wrapper.like(StringUtils.hasText(nickname), "nickname", nickname);
        wrapper.like(StringUtils.hasText(address), "address", address);

        Page<UserDO> selectPage = userMapper.selectPage(page, wrapper);
        // 不知道为啥下面这行取不到数据
        long total = selectPage.getTotal();
//        long total = userMapper.selectCount(null);
        List<UserDO> userDOList = selectPage.getRecords();

        // userDOList -->  userDTOList
        List<UserDTO> userDTOList = new ArrayList<>();

        userDOList.forEach(userDO -> {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(userDO, userDTO);
            userDTOList.add(userDTO);
        });

        UserSelectPageDTO result = new UserSelectPageDTO();
        result.setTotal(total);
        result.setUserDTOList(userDTOList);
        return result;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userDTO, userDO);

        UserDTO res = new UserDTO();
        if (userDTO.getId() == null) {
            // 新增
            userMapper.insert(userDO);
            BeanUtils.copyProperties(userDO, res);
        } else {
            // 修改
            userMapper.updateById(userDO);
            BeanUtils.copyProperties(userMapper.selectById(userDTO.getId()), res);
        }
        return res;
    }

    @Override
    public Integer deleteUser(Long id) {
        return userMapper.deleteById(id);
    }
}

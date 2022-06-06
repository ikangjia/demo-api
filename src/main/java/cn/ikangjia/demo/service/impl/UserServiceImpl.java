package cn.ikangjia.demo.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
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

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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

    @Override
    public Integer deleteUserBatch(List<Long> idList) {
        return userMapper.deleteBatchIds(idList);
    }

    @Override
    public Boolean exportUserDetail(HttpServletResponse response, Long id) {
        UserDO userDO = userMapper.selectById(id);
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.addHeaderAlias("id", "编号");
        writer.addHeaderAlias("username", "用户名");
        writer.addHeaderAlias("nickname", "昵称");
        writer.addHeaderAlias("password", "密码");
        writer.addHeaderAlias("email", "邮件");
        writer.addHeaderAlias("phone", "手机号");
        writer.addHeaderAlias("address", "地址");
        writer.addHeaderAlias("createTime", "创建时间");
        writer.addHeaderAlias("updateTime", "更新时间");
        writer.addHeaderAlias("operator", "操作人");
        writer.addHeaderAlias("deleted", "是否逻辑删除");

        List<UserDO> userDOList = CollUtil.newArrayList(userDO);
        writer.write(userDOList, true);

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        //test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
        String fileName = URLEncoder.encode("用户信息", StandardCharsets.UTF_8);
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            writer.flush(out, true);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭writer，释放内存
            writer.close();
        }
        //此处记得关闭输出Servlet流
        IoUtil.close(out);
        return true;
    }
}

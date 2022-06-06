package cn.ikangjia.demo.service;

import cn.ikangjia.demo.api.model.UserDTO;
import cn.ikangjia.demo.api.model.UserSelectDTO;
import cn.ikangjia.demo.api.model.UserSelectPageDTO;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2022/6/1 17:32
 */
public interface UserService {
    UserDTO queryDetail(Long id);

    UserSelectPageDTO queryUsers(UserSelectDTO userSelectDTO);

    UserDTO save(UserDTO userDTO);

    Integer deleteUser(Long id);

    Integer deleteUserBatch(List<Long> idList);

    Boolean exportUserDetail(HttpServletResponse response, Long id);

    Boolean exportUserDetail(HttpServletResponse response);
}

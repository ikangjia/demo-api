package cn.ikangjia.demo.service;

import cn.ikangjia.demo.api.model.UserDTO;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2022/6/1 17:32
 */
public interface UserService {
    UserDTO queryDetail(Long id);
}

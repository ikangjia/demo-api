package cn.ikangjia.demo.api.controller;

import cn.ikangjia.demo.api.model.UserDTO;
import cn.ikangjia.demo.api.rest.ResultVO;
import cn.ikangjia.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2022/6/1 17:33
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResultVO<UserDTO> queryDetail(@PathVariable Long id) {
        return ResultVO.success(userService.queryDetail(id));
    }
}

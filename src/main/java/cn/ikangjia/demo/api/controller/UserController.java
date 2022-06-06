package cn.ikangjia.demo.api.controller;

import cn.ikangjia.demo.api.model.UserDTO;
import cn.ikangjia.demo.api.model.UserSelectDTO;
import cn.ikangjia.demo.api.model.UserSelectPageDTO;
import cn.ikangjia.demo.api.rest.ResultVO;
import cn.ikangjia.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

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

    @GetMapping
    public ResultVO<UserSelectPageDTO> queryUserListPage(UserSelectDTO userSelectDTO) {
        return ResultVO.success(userService.queryUsers(userSelectDTO));
    }

    @PostMapping
    public ResultVO<UserDTO> save(@RequestBody UserDTO userDTO) {
        return ResultVO.success(userService.save(userDTO));
    }

    @DeleteMapping("/{id}")
    public ResultVO<Integer> deleteUser(@PathVariable Long id) {
        return ResultVO.success(userService.deleteUser(id));
    }

    @DeleteMapping("/del/batch")
    public ResultVO<Integer> deleteUserBatch(String ids) {
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return ResultVO.success(userService.deleteUserBatch(idList));
    }

    /**
     * 用户详情页面导出数据
     *
     * @param response response
     * @param id       id
     */
    @GetMapping("/export/{id}")
    public void exportUserDetail(HttpServletResponse response, @PathVariable Long id) {
        userService.exportUserDetail(response, id);
    }

    /**
     * 导出所有用户信息
     * @param response response
     */
    @GetMapping("/export")
    public void exportUserDetail(HttpServletResponse response) {
        userService.exportUserDetail(response);
    }
}

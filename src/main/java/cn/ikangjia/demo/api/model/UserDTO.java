package cn.ikangjia.demo.api.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2022/6/2 9:44
 */
@Data
@Accessors(chain = true)
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String phone;

    private String address;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String operator;

    /**
     * 逻辑删除标识
     * 1：删除
     * 0：未删除
     */
    private boolean deleted;
}

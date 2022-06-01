package cn.ikangjia.demo.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2022/6/1 17:29
 */
@Data
public class UserDO {
    private long id;

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

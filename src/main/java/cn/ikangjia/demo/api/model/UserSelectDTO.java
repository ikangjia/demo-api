package cn.ikangjia.demo.api.model;

import lombok.Data;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2022/6/3 9:54
 */
@Data
public class UserSelectDTO {
    private String username;
    private String nickname;
    private String address;

    private int pageNum;
    private int pageSize;
}

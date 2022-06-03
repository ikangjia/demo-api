package cn.ikangjia.demo.api.model;

import lombok.Data;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2022/6/3 9:56
 */
@Data
public class UserSelectPageDTO {
    private long total;
    private List<UserDTO> userDTOList;
}

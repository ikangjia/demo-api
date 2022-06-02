package cn.ikangjia.demo.mapper;

import cn.ikangjia.demo.entity.UserDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2022/6/1 17:32
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
}

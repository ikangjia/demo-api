package cn.ikangjia.demo.infra.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2022/5/20 13:38
 */
@Component
@ConfigurationProperties(prefix = "demo")
@Data
public class DemoParam {
    private String title;
    private String description;
    private String author;
    private String homepage;
    private String netName;
    private String email;
    private String version;
    private String copyrightYear;

}

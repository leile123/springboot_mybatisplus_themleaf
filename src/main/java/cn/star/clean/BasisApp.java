package cn.star.clean;


import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import javax.servlet.MultipartConfigElement;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *@Description TODO
 *@Author g2
 *@Date 2019/3/28 上午9:30
 */
@SpringBootApplication
@MapperScan("cn.star.clean.mapper")
@EnableSwagger2
public class BasisApp {
    private static final Logger logger = LoggerFactory.getLogger(BasisApp.class);
    public static void main(String[] args) {
        SpringApplication.run(BasisApp.class, args);
        logger.info("BasisApp Start Success !!!");
    }
    /**
     * mybatis-plus分页插件<br>
     *
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
    /**
     * mybatis-plus SQL执行效率插件【生产环境可以关闭】
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

    /**
     * 上传文件临时目录
     *
     */
    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation("/data/tmp/");
        return factory.createMultipartConfig();
    }
}
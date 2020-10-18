package onion.tinyboard.config;


import com.navercorp.lucy.security.xss.servletfilter.XssEscapeServletFilter;
import lombok.RequiredArgsConstructor;
import onion.tinyboard.interceptor.MaintenanceInterceptor;
import onion.tinyboard.interceptor.ManageInterceptor;
import onion.tinyboard.interceptor.PostingInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by uhwGhGFaJd@protonmail.com on 2020/10/17
 * Github : https://github.com/uhwGhGFaJd
 */
@RequiredArgsConstructor
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/"
    };


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(maintenanceInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/403")
                .excludePathPatterns("/maintenance")
                .excludePathPatterns("/manage/**")
                .excludePathPatterns("/admin_page/**")
                .excludePathPatterns("/captcha");
        registry.addInterceptor(manageInterceptor())
                .addPathPatterns("/manage/index/**")
                .excludePathPatterns("/manage");
    }

    @Bean
    public ManageInterceptor manageInterceptor() {
        return new ManageInterceptor();
    }

    @Bean
    public MaintenanceInterceptor maintenanceInterceptor() {
        return new MaintenanceInterceptor();
    }

    @Bean
    public PostingInterceptor postingInterceptor() {
        return new PostingInterceptor();
    }

    // XSS Filter
    @Bean
    public FilterRegistrationBean<XssEscapeServletFilter> filterRegistrationBean() {
        FilterRegistrationBean<XssEscapeServletFilter> filterRegistration = new FilterRegistrationBean<>();
        filterRegistration.setFilter(new XssEscapeServletFilter());
        filterRegistration.setOrder(1);
        filterRegistration.addUrlPatterns("/*");
        return filterRegistration;
    }


}

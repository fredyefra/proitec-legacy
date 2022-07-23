package br.com.proitec.legacy.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }

	/*
	 * @Override public void addViewControllers(ViewControllerRegistry
	 * viewControllerRegistry) {
	 * viewControllerRegistry.addViewController("/").setViewName(
	 * "redirect:/pages/dashboard"); }
	 */
}

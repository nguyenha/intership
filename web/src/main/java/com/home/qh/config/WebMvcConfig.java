package com.home.qh.config;

import javax.servlet.jsp.jstl.fmt.LocalizationContext;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.tiles2.TilesView;
import org.springframework.web.servlet.view.tiles2.TilesViewResolver;
import org.springmodules.validation.commons.DefaultBeanValidator;
import org.springmodules.validation.commons.DefaultValidatorFactory;
import org.springmodules.validation.commons.ValidatorFactory;

@Configuration
@ComponentScan(basePackages = { "com.home.qh.web", "com.home.qh.web.admin" })
@ImportResource("classpath:validation*.xml")
public class WebMvcConfig extends WebMvcConfigurationSupport {
	
	private static final String MESSAGE_SOURCE = "/WEB-INF/classes/ApplicationResources";
	private static final String TILES = "/WEB-INF/tiles/tiles.xml";
	private static final String VIEWS = "/WEB-INF/views/**/views.xml";
	
	private static final String RESOURCES_HANDLER = "/resources/";
	private static final String RESOURCES_LOCATION = RESOURCES_HANDLER + "**";
	
	@Override
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
		RequestMappingHandlerMapping requestMappingHandlerMapping = super.requestMappingHandlerMapping();
		requestMappingHandlerMapping.setUseSuffixPatternMatch(false);
		requestMappingHandlerMapping.setUseTrailingSlashMatch(false);
		return requestMappingHandlerMapping;
	}
	
	@Bean
  public ReloadableResourceBundleMessageSource messageSource()
  {
      ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
      messageSource.setBasename( "/WEB-INF/resources/ApplicationResources" );
      messageSource.setCacheSeconds( 0 );
      return messageSource;
  }

	
	@Bean(name = "messageSource")
	public MessageSource configureMessageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename(MESSAGE_SOURCE);
		messageSource.setCacheSeconds(5);
		return messageSource;
	}
	
	@Bean
	public UrlBasedViewResolver configureTilesViewResolver() {
		UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();
		tilesViewResolver.setViewClass(TilesView.class);
		return tilesViewResolver;
	}
	
	@Bean
	public TilesConfigurer configureTilesConfigurer() {
		TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions(new String[] {TILES, VIEWS});
		return configurer;
	}
	
	@Bean(name = "ApplicationResources")
	public LocalizationContext getLocalizationContext() {
		return new LocalizationContext();
	}
	
	@Override
	public Validator getValidator() {

		LocalValidatorFactoryBean localValidator = new LocalValidatorFactoryBean();
		localValidator.setValidationMessageSource(configureMessageSource());
		return localValidator;
	}
	
	/*
	 *                 <value>/WEB-INF/validation.xml</value>
                <value>/WEB-INF/validator-rules.xml</value>
                <value>/WEB-INF/validator-rules-custom.xml</value>

	 */
	@Bean
	public ValidatorFactory getValidatorFactory() {
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource[] resources = {resourceLoader.getResource("classpath:validation.xml"),
				resourceLoader.getResource("classpath:validator-rules.xml"),
				resourceLoader.getResource("classpath:validator-rules-custom.xml")};
		
		DefaultValidatorFactory validatorFactory = new DefaultValidatorFactory();
		validatorFactory.setValidationConfigLocations(resources);
		return validatorFactory;
	}
	
	@Bean
	public DefaultBeanValidator getBeanValidator() {
		DefaultBeanValidator beanValidator = new DefaultBeanValidator();
		beanValidator.setValidatorFactory(getValidatorFactory());
		return beanValidator;
	}
 	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(RESOURCES_HANDLER).addResourceLocations(RESOURCES_LOCATION);
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}

package com.home.qh.config;

import java.util.EnumSet;
import java.util.Set;

import javax.servlet.*;

import net.sf.navigator.menu.MenuContextListener;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(RootConfig.class);

		FilterRegistration.Dynamic securityFilter = servletContext.addFilter("securityFilter", new DelegatingFilterProxy(
		    "springSecurityFilterChain"));
		securityFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

		FilterRegistration.Dynamic siteMeshFilter = servletContext.addFilter("sitemesh", new SiteMeshFilter());
		siteMeshFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

		servletContext.addListener(new ContextLoaderListener(rootContext));
		servletContext.addListener(MenuContextListener.class);
		servletContext.setInitParameter("defaultHtmlEscape", "true");

		AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
		mvcContext.register(WebMvcConfig.class);

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("intership", new DispatcherServlet(mvcContext));
		if (dispatcher != null) {
			dispatcher.setLoadOnStartup(1);
			Set<String> mappingConflicts = dispatcher.addMapping("/");
			if (!mappingConflicts.isEmpty()) {
				throw new IllegalStateException("'appServlet' cannot be mapped to '/' under Tomcat versions <= 7.0.14");
			}
		}

		ServletRegistration.Dynamic appServlet = servletContext.addServlet("appServlet", new DispatcherServlet(mvcContext));
		appServlet.setLoadOnStartup(1);
	}
}
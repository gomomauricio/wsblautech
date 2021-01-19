package com.udemy.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter//cada que peticion que nos hagan entra por estos metodos
{
	private static final Log LOG = LogFactory.getLog(ExampleComponent.class);
	
     /* Se ejecuta ANTES de entrar en el metodo del controlador */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		request.setAttribute("startTime", System.currentTimeMillis()); //guardamos el tiempo actual en milisegundos
//		return super.preHandle(request, response, handler);
		return true;
	}

	/* Se ejecuta ANTES de mostrar la VISTA en el navegador */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		long startTime = (long)request.getAttribute("startTime");
				
		LOG.info(" REQUEST URL: " + request.getRequestURL().toString() + " -- TOTAL TIME: " + (System.currentTimeMillis() - startTime) + "ms" );
		
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

}

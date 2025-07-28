/*
 * จะทำการ print path ที่เรา mapping ออกมาทั้งหมดตอน startup spring boot
 */
package com.pcc;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Component
public class EndpointsListener implements ApplicationListener<ApplicationReadyEvent> {

	static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	
    private final RequestMappingHandlerMapping handlerMapping;

    public EndpointsListener(RequestMappingHandlerMapping handlerMapping) {
        this.handlerMapping = handlerMapping;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        handlerMapping.getHandlerMethods()
                      .forEach((requestMappingInfo, handlerMethod) -> 
                          logger.info(requestMappingInfo + " " + handlerMethod));
    }
}

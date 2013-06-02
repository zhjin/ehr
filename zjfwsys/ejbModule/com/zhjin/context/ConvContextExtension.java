/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.context;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.Extension;

public class ConvContextExtension implements Extension {
	
	public void afterBeanDiscovery(@Observes AfterBeanDiscovery event, BeanManager manager) {
		event.addContext(new ConvContext());
	}
	
}

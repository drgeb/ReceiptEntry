package com.drgeb.login.client.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import(ScreensConfiguration.class)
@ImportResource("classpath:applicationContext-security.xml")
public class ReceiptEntrySpringAppConfiguration {

}

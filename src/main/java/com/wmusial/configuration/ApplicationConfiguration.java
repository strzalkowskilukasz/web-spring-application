package com.wmusial.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({HibernateConfiguration.class, WebConfiguration.class})
public class ApplicationConfiguration {
}

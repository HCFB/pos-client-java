package ru.homecredit.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

/**
 * Created by RRybasov on 08.09.2016.
 */
@Configuration
public class DozerConfiguration {

    @Bean
    DozerBeanMapper dozerBeanMapper() {
        List<String> mappingFiles = Collections.singletonList("dozerJdk8Converters.xml");
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.setMappingFiles(mappingFiles);
        return dozerBeanMapper;
    }
}

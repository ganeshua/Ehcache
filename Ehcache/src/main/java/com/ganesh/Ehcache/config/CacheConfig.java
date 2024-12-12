package com.ganesh.Ehcache.config;

import com.ganesh.Ehcache.dto.Student;
import net.sf.ehcache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

    @Bean("StudentCacheBean")
    public CacheService<Student, Student> getSudentCache() {

        //Same Name fom ehcache.xml
        CacheService<Student, Student> cacheService = new CacheServiceImpl("studentCache", CacheManager.getInstance());
        return cacheService;
    }
}

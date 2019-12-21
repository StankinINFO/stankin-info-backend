package org.visapps.universityschedule.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.visapps.universityschedule.entity.User;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/** Пока логика такая
 *  1.Есть некий класс APIKeyAuthFilter, в котором реализована возможность не только добавить Key, но и присвоить ему имя
 *  2.Выполняем вторым порядком после проверки пользователя на админа, что ключ пришел
 *  3.Берем опять пользователя, смотрим, что такой пользователь есть в БД, возвращаем его ключ
 *  4. Если ключ не соответствует, то генерим экзепшн
 *  5. Если соответствуем, то все норм
 */

@Configuration
@EnableWebSecurity
@Order(2)
public class APISecurityConfig extends WebSecurityConfigurerAdapter {

    private final MongoTemplate mongoTemplate;

    @Value("KEY")
    private String principalRequestHeader;

    @Value("VALUE")
    private String principalRequestValue;

    @Autowired
    public APISecurityConfig(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        APIKeyAuthFilter filter = new APIKeyAuthFilter(principalRequestHeader);
        filter.setAuthenticationManager(authentication -> {
            String key = authentication.getName();
            User user = mongoTemplate.findOne(query(where("key").is(key)), User.class);
            if(user!= null){
                String principal = user.getKey();
                if (!principalRequestValue.equals(principal))
                {
                    throw new BadCredentialsException("The API key was not found or not the expected value.");
                }
                else authentication.setAuthenticated(true);
            }
            return authentication;
        });
        httpSecurity.
                antMatcher("/api/**").
                csrf().disable().
                sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
                and().addFilter(filter).authorizeRequests().anyRequest().authenticated();
    }

}

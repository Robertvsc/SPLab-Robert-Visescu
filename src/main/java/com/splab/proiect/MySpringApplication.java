package com.splab.proiect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableAsync
@SpringBootApplication
public class MySpringApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MySpringApplication.class, args);

        // --- Codul tău pentru testarea componentelor (din laboratoarele trecute) ---
        // L-am pus într-un try-catch pentru a nu opri aplicația dacă ceva nu merge la ele
        try {
            TransientComponent transientBean = context.getBean(TransientComponent.class);
            transientBean.operation();

            transientBean = context.getBean(TransientComponent.class);
            transientBean.operation();

            SingletonComponent singletonBean = context.getBean(SingletonComponent.class);
            singletonBean.operation();

            singletonBean = context.getBean(SingletonComponent.class);
            singletonBean.operation();

            ClientComponent client = context.getBean(ClientComponent.class);
            client.operation();

            client = (ClientComponent) context.getBean("clientComponent");
            client.operation();
        } catch (Exception e) {
            System.out.println("Nota: Componentele vechi nu au rulat, dar serverul continua.");
        }
    } 

    // --- Configurare CORS globală ---
    // Această metodă este acum ÎNAFARA metodei main(), dar ÎN INTERIORUL clasei
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
            }
        };
    }

}
package edu.javagroup.seabattle;

/*
 * строку ниже не трогать
 */

import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * закомментировать после выполнения задач и тестов
 */
//import org.springframework.boot.SpringApplication;

/*
 * убрать комментарий после выполнения задач и тестов
 */
import edu.javagroup.seabattle.frame.MainFrame;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author kaa
 * @version 1.1
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) {

        /*
         * закомментировать после выполнения задач и тестов
         */
        //  SpringApplication.run(App.class, args);

        /*
         * убрать комментарий после выполнения задач и тестов
         */
        ConfigurableApplicationContext context = new SpringApplicationBuilder(App.class).headless(false).run(args);
        MainFrame mainFrame = context.getBean(MainFrame.class);
        mainFrame.setVisible(true);
    }

    /*
     * убрать комментарий после выполнения задач и тестов
     */
    @Bean
    public CommandLineRunner commandLineRunner() {
        return new AppInitializer();
    }
}

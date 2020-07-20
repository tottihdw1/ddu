package myprofile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hdw
 * @create 2020-07-17-14:46
 * @desc 描述
 */
public class Test {

    public static void main(String[] args) {
       // m1();
        ClassPathXmlApplicationContext cl = new ClassPathXmlApplicationContext();
        cl.getEnvironment().setActiveProfiles("dev");
        cl.setConfigLocation("applicationContext.xml");
        cl.refresh();
        DataSource bean = cl.getBean(DataSource.class);
        System.out.println(bean);


    }

    private static void m1() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("prod");
        ctx.register(JavaProfileConfig.class);
        ctx.refresh();
        DataSource ds = ctx.getBean(DataSource.class);

        System.out.println(ds);
    }
}

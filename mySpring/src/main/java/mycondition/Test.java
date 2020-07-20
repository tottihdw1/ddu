package mycondition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hdw
 * @create 2020-07-17-14:46
 * @desc 描述
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        ShowCmd cmd = (ShowCmd) ctx.getBean("cmd");
        System.out.println(cmd.showCmd());
    }
}

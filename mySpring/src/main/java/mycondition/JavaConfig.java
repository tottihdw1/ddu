package mycondition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author hdw
 * @create 2020-07-17-14:43
 * @desc 描述
 */
@Configuration
public class JavaConfig {

    @Bean("cmd")
    @Conditional(WindowsCondition.class)
    ShowCmd winCmd(){
       return  new WindowsShowCmd();
    }


    @Bean("cmd")
    @Conditional(LinuxCondition.class)
    ShowCmd linuxCmd(){
        return  new LinuxShowCmd();
    }
}

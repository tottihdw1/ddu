package hdw.org.jwt;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class JwtApplicationTests {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

/*
    public static void main(String[] args) {
        String password = "123";
        String pwd = encodePassword(password);
        System.out.println(pwd);
    }
*/



    @Test
    void contextLoads() {
        String password = "456";
        String pwd = encodePassword(password);
        System.out.println("pwd: "+pwd);

    }

}

package org.drools.spring.demo.login;

import org.kie.api.runtime.KieSession;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/8/5.
 */
public class LoginTest {

    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( "/config/applicationContext.xml" );
            KieSession kSession = (KieSession) context.getBean("ksessionLogin");

            Vip vip = new Vip();
            System.out.println("输入用户名=jack，密码=123 是正确的，其他的需要重新输入--------------");
            kSession.insert(vip);
            kSession.fireAllRules();
            System.out.println("e");

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}

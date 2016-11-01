package org.drools.spring.demo.junit;

import org.drools.spring.demo.simple.Message;
import org.kie.api.runtime.KieSession;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Drools Spring 配合使用开发
 *
 * 1、添加一个spring-drools.xml配置文件，引入到 applicationContext.xml中
 *
 */
public class DroolsSpringTest {

    public static final void main(String[] args) {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( "/config/applicationContext.xml" );
            KieSession kSession = (KieSession) context.getBean("ksession1");

            // go !
            Message message = new Message();
            message.setMessage("Hello World");
            message.setStatus(Message.HELLO);

            //将事实数据传入kSession中
            kSession.insert(message);
            //执行所有的规则
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}

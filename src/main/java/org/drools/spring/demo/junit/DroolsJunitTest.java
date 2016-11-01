package org.drools.spring.demo.junit;

import org.drools.spring.demo.simple.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2016/7/28.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/config/applicationContext.xml"})
public class DroolsJunitTest {

    @KSession("ksession1")
    private KieSession kSession;

    @KSession("ksessionDemo1")
    private KieSession kieSessionDemo;

    @Test
    public void testDrools(){
        try {

            Message message = new Message();
            message.setMessage("Hello World");
            message.setStatus(Message.HELLO);

            //将事实数据传入kSession中
            kSession.insert(message);
            //执行所有的规则
            kSession.fireAllRules();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDemo1(){
        kieSessionDemo.fireAllRules();
    }

}

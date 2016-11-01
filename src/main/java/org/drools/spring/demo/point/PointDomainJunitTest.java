package org.drools.spring.demo.point;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2016/8/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/config/applicationContext.xml"})
public class PointDomainJunitTest {

    @KSession("ksession-pointDomain")
    private KieSession kSession;

    @Test
    public void testPointDomain() {

        //System.setProperty("drools.dateformat", "yyyy-MM-dd");

        PointDomain pointDomain = new PointDomain();
        pointDomain.setUserName("hello kity");
        pointDomain.setBackMondy(100d);
        pointDomain.setBuyMoney(500d);
        pointDomain.setBackNums(1);
        pointDomain.setBuyNums(5);
        pointDomain.setBillThisMonth(5);
        pointDomain.setBirthDay(true);
        pointDomain.setPoint(0l);

        kSession.insert(pointDomain);

        kSession.fireAllRules();

        System.out.println("执行完毕BillThisMonth："+pointDomain.getBillThisMonth());
        System.out.println("执行完毕BuyMoney："+pointDomain.getBuyMoney());
        System.out.println("执行完毕BuyNums："+pointDomain.getBuyNums());
        System.out.println("执行完毕规则引擎决定发送积分："+pointDomain.getPoint());
    }

}

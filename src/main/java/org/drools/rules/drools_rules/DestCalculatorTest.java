package org.drools.rules.drools_rules;

import org.drools.spring.demo.point.PointDomain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2016/8/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/config/applicationContext.xml"})
public class DestCalculatorTest {

    @KSession("destCalKs")
    private KieSession kSession;

    @Test
    public void testDestCalculator() {

        FormulasOptionVO optionVO = new FormulasOptionVO();
        optionVO.setNumber(10.0);
        optionVO.setVolume(12.0);
        optionVO.setWeight(2.0);
        optionVO.setTotal(0.0);

        kSession.insert(optionVO);

        //System.out.println(kSession.getIdentifier());

        kSession.getAgenda().getAgendaGroup("001").setFocus();


        int n = kSession.fireAllRules();

        System.out.println("执行完毕, 执行规则条数："+ n +", Total："+ optionVO.getTotal());
    }

}

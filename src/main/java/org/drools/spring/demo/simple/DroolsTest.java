package org.drools.spring.demo.simple;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Drools 原始的写法
 *
 * 配置文件配置【路径和文件名都不可以改】：
 * 1、kmodule配置
 *   路径： src\main\resources\META-INF\kmodule.xml
 *   配置规则的文件(.drl)
 *
 *   ps. 此处的文件名可以为：kmodule.xml 或  kmodule-spring.xml
 *
 * 2、pom.properties 文件
 *   路径： src\main\resources\META-INF\maven\pom.properties
 *
 */
public class DroolsTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
            //得到一个KieService
            KieServices ks = KieServices.Factory.get();
            //工作kieService加载默认路径下的kmodule.xml 得到kContainer场所
            KieContainer kContainer = ks.getKieClasspathContainer();
            //kContainer得到一个会话
            KieSession kSession = kContainer.newKieSession("ksession-rules");

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

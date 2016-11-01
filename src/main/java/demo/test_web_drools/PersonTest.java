package demo.test_web_drools;

import org.drools.compiler.kproject.ReleaseIdImpl;
import org.drools.core.io.impl.UrlResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.cdi.KReleaseId;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/8/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/config/applicationContext.xml" })
public class PersonTest {

    @Test
    public void test() throws IOException {

        // 第一段：以下代码，它告诉JAVA，需要上哪儿去调用我们位于远程布署的规则
        String url = "http://127.0.0.1:9090/kie-drools-wb/maven2/demo/test_web_drools/1.0/test_web_drools-1.0.jar";
        ReleaseIdImpl releaseId = new ReleaseIdImpl("demo", "test_web_drools", "LATEST");
        KieServices ks = KieServices.Factory.get();
        KieRepository kr = ks.getRepository();
        UrlResource urlResource = (UrlResource) ks.getResources().newUrlResource(url);

        // 第二段：以下代码做的事情就是相当于在IE中打开KIE-DROOLS的Web地址，然后输入用户名、密码并点击登录
        urlResource.setUsername("drools");
        urlResource.setPassword("admin");
        urlResource.setBasicAuthentication("enabled");
        InputStream is = urlResource.getInputStream();
        KieModule kModule = kr.addKieModule(ks.getResources().newInputStreamResource(is));
        KieContainer kContainer = ks.newKieContainer(kModule.getReleaseId());

        // 第三段：以下代码用的就是kieSession接口去调用规则的。
        KieSession kieSession = kContainer.newKieSession();

        demo.test_web_drools.Person p=new demo.test_web_drools.Person();
        p.setAge(10);
        p.setName("张三");

        kieSession.insert(p);
        int i=kieSession.fireAllRules();
        System.out.print("共执行了"+i+"条规则，");
        System.out.print("修改后的结果"+p.getName());
    }

    //-----------------------------------------------------------------------------------------------------------------

    /**
     * 通过Drools的 workbeanch 实现与java 的自动扫描功能
     * 具体方式有两种，第一种是ci-api的形式，第二种是Spring整合。
     *
     */

    @KSession("defaultKieSession")
    @KReleaseId( groupId = "demo", artifactId = "test_web_drools", version = "1.0")
    private KieSession kSession;

    /**
     * Spring整合实现
     */
    @Test
    public void  runRules() {
        while (true) {
            try {
                Person p = new Person();
                p.setAge(10);
                p.setName("张三");
                kSession.insert(p);
                int i = kSession.fireAllRules();
                System.out.println(">>>server:" + p.getName() + ", runRules.size=" + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * ci-api实现
     */
    @Test
    public void runRules2() {

        KieServices kieServices = KieServices.Factory.get();
        ReleaseId releaseId = kieServices.newReleaseId("demo", "test_web_drools", "1.0");
        KieContainer kContainer = kieServices.newKieContainer(releaseId);
        KieScanner kScanner = kieServices.newKieScanner(kContainer);
        // Start the KieScanner polling the Maven repository every 10 seconds
        kScanner.start(10000L);
        while (true) {
            try {
                KieSession kSession = kContainer.newKieSession();
                Person p = new Person();
                p.setAge(10);
                p.setName("张三");
                kSession.insert(p);
                kSession.fireAllRules();
                System.out.println(">>>server:" + p.getName());
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

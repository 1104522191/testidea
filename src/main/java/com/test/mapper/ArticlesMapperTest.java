package com.test.mapper;



import com.test.model.Articles;
import com.test.service.IArticlesService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring.xml")
public class ArticlesMapperTest {
    @Autowired
    private ArticlesMapper articlesMapper;
    private Articles articles=new Articles();
    @Test
    public void selectByPrimaryKey() {
        Articles article = articlesMapper.selectByPrimaryKey(1);
        System.out.println(article);
        this.articles =articlesMapper.selectByPrimaryKey(1);
        System.out.println(articles);
    }

    @Test
    public void shiro(){
        IniSecurityManagerFactory ini = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = ini.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zs","123");
        try {
            subject.login(token);
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码错误");
        } catch (UnknownAccountException e){
            System.out.println("账号错误");
        }
    }

    @Test
    public void shiro1(){
        IniSecurityManagerFactory ini = new IniSecurityManagerFactory("classpath:shiro-permission.ini");
        SecurityManager securityManager = ini.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zs", "123");
        subject.login(token);
        if(subject.isPermitted("user:create")){
            System.out.println("正常访问");
        }else{
            System.out.println("不具备对应权限");
        }
    }
}
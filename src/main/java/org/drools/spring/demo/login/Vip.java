package org.drools.spring.demo.login;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/8.
 */
public class Vip implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name = "";
    private String password = "";

    public Vip() {
    }

    public Vip(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = ((String) in.readObject());
        this.password = ((String) in.readObject());
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.name);
        out.writeObject(this.password);
    }

    public static boolean checkDB(String name,String password){
        //实际可以到数据库匹配
        return name.trim().equals("jack")&&password.trim().equals("123");
    }
}
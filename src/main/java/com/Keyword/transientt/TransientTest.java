package com.Keyword.transientt;


import java.io.*;

/**
 *一旦变量被transient修饰，变量将不再是对象持久化的一部分，该变量内容在序列化后无法获得访问
 */
public class TransientTest {

    public static void main(String[] args) {
        User user = new User();
        user.setUsername("moxiaobei").setPassword("123456");

        System.out.println("read before Serializable:");
        System.out.println("username1:" + user.getUsername());
        System.err.println("password1:" + user.getPassword());

        try{
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:/user.txt"));
            os.writeObject(user);
            os.flush();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("C:/user.txt"));
            user = (User) is.readObject();
            is.close();
            System.out.println("\read after Serializable");
            System.out.println("username2 :" + user.getUsername());
            System.err.println("password2 ：" + user.getPassword());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

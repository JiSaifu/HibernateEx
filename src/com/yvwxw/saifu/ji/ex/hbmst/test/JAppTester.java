package com.yvwxw.saifu.ji.ex.hbmst.test;

import com.yvwxw.saifu.ji.ex.hbmst.bean.Dog;
import com.yvwxw.saifu.ji.ex.hbmst.dao.DogDBService;
import com.yvwxw.saifu.ji.ex.hbmst.util.DBConnector;

import java.util.List;

/**
 * Created by jisai on 2016/11/27.
 */
public class JAppTester {
    public static void main(String[] args) {
        // 0.DB疏通测试执行
        /*
        dbConnTest();
         */

        // 1.第二章测试执行
        chapter2Test();

        System.exit(0);
    }

    /**
     * 0.DB疏通测试方法
     */
    @SuppressWarnings("unused")
    private static void dbConnTest() {
        String INSSQL = "INSERT INTO DOGS (ID,NAME,AGE,GENDER)"
                + "VALUES("
                + "1,'Cookie01',10,'F')";
        DBConnector dbConn = new DBConnector();
        dbConn.execSQL(INSSQL);
    }

    /**
     * 1.Chapter2测试方法
     */
    private static void chapter2Test() {
        Dog dog = new Dog();
        dog.setName("Cookie08");
        dog.setAge(15);
        dog.setGender('M');

        DogDBService dds = new DogDBService();
        dds.save(dog);

        List<Dog> dogslist = dds.search("from Dog as d order by d.name asc");
        for (Dog searchedDog : dogslist) {
            System.out.println(searchedDog.getName());
        }

        dds.updateName(1l, "Cookie01");

        dds.delete(dog.getId());

        dogslist = dds.search("from Dog as d order by d.name asc");
        for (Dog searchedDog : dogslist) {
            System.out.println(searchedDog.getName());
        }
    }
}

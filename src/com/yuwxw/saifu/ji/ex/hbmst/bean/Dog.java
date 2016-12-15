package com.yuwxw.saifu.ji.ex.hbmst.bean;

/**
 * 持久化类Dog
 *
 * 注意点：
 * 1.持久化类符合JavaBean的规范。
 * 2.Hibernate要求持久化类必须提供一个不带参数的默认构造方法，因为在程序运行时，
 *  Hibernate会运用Java的反射机制，调用java.lang.reflect.Constructor.newInstance()
 *  方法来构造持久化类的实例。
 *
 *
 * @author Ji.Saifu
 *
 */
public class Dog extends Entity {
    private long id;
    private String name;

    /**
     * 属性定义成包装类的话，其内容既可以为某些数值，也可以为空。
     * ※ 从Java 1.5开始，包装类可以参与数学运算。
     */
    private Integer age;
    private Character gender;

    public Dog() {}

    @SuppressWarnings("unused")
    private void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(Character gender) { this.gender = gender; }

    public Character getGender() { return gender; }
}

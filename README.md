## Hibernate Exercise

自学《[Mastering Hibernate Easily](http://baike.baidu.com/view/4122277.htm)》时的练习用Project。

#### ChapterII Point

* 初次通过Hibernate的API实现对数据库的CRUD操作。
    1. Hibernate接续配置文件的内容：
        参照*hibernate.cfg.xml*。
    2. 初始化Hibernate配置，创建Session工厂：
        参照*com.yuwxw.saifu.ji.ex.hbmst.util.BaseHibernateService.java*
    3. 持久化类，及其配置文件的写法：
        参照*com.yuwxw.saifu.ji.ex.hbmst.bean.Dog,Dog.hbm.xml*。
    4. 使用Hibernate的API实现对数据库的CRUD操作：
        参照*com.yuwxw.saifu.ji.ex.hbmst.dao.DBService.java,DogDBService.java*。
    5. 除此之外，还有用正常JDBC方式连接DB，并对其内容进行修改的疏通测试例子：
        参照*com.yuwxw.saifu.ji.ex.hbmst.util.DBConnector.java*
    6. 用来测试以上各类的测试MainClass：
        参照*com.yuwxw.saifu.ji.ex.hbmst.test.JAppTester.java*

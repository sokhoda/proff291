package HomeWork_ModuleTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by User on 21.12.2015.
 */
public class HomeWork_UsersTest {
    private HomeWork_User module;
    private HomeWork_User module1;


    @Before
    public  void setUp(){// моделируем ситуацию(создаем два ипытуемых объекта)
        module = new HomeWork_User("mail",234.5,"05.10.2015","milongiwit","doc");
        module1 = new HomeWork_User("mail",234.5,"05.10.2015","milongiwit","doc");
    }

    @Test//(expected = Exception.class)///Тест проверяющий провильность возвращаемых данных методом HomeWork_User.HashCode()
        public void testHashCode()
        {
            int expectedResult = -1229872624;
            int actualResalt = module1.hashCode();
            Assert.assertEquals(expectedResult,actualResalt);
            System.out.println("testHashCode");
        }

    @Test
    public void testEquals()///Тест проверяющий провильность сравнения объектов с помощью метода HomeWork_User.equals()
    {
        boolean expectedResult = true;
        boolean actualResalt = module.equals(module1);
        boolean result=actualResalt;
        Assert.assertEquals(expectedResult,actualResalt);
        System.out.println("testEquals");
    }
}

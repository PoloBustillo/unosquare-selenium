package utils;

import org.testng.annotations.DataProvider;

public class DataProviderTest {

    @DataProvider(name = "credentials")

    public static Object[][] credentials() {

        return new Object[][]{{"test_user", "password"}, {"qa_user", "1231"}};

    }

}
package api.data.providers;

import org.testng.annotations.DataProvider;

public class DataForTests {

    @DataProvider(name="incorrectIds")
    public static Object[][] localDataProvider() {
        return new Object[][] {
                {"321321","message","Invalid ID."},
                {"123213","message","Invalid ID."},
                {"321321","message","Invalid ID."},
                {"253213219","message","Invalid ID."}
        };
    }

    @DataProvider(name = "correctID")
    public static Object[][] correctIdProvider() {
        return new Object[][] {
                {"259","name","Premium Quality"},
                {"222","name","Shirt 2"},
                {"201","name","Men shirt"},
                {"199","name","Black Bag"},
                {"198","name","Simple Shirt"}
        };
    }
}

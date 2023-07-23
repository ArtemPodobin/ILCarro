import manager.ProviderData;
import models.SearchCar;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTests extends TestBase{
        @BeforeMethod(alwaysRun = true)
    public void precondition(){
        app.getSearch().openSearchForm();

    }

    @Test(dataProvider = "carSearchDtoCSV", dataProviderClass = ProviderData.class)
    public void searchPositiveTest(SearchCar search){
    app.getSearch().fillSearchForm(search);
    app.getSearch().pause(1000);
    app.getSearch().submitForm();
}


}

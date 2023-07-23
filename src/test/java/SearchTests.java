import manager.ProviderData;
import org.testng.annotations.Test;

public class SearchTests extends TestBase{

    @Test(dataProvider = "carSearchDtoCSV", dataProviderClass = ProviderData.class)
    public void searchPositiveTest(){
    app.getSearch().fillSearchForm("Haifa", "07/28/2023", "03/19/2024");
    app.getSearch().pause(1000);
    app.getSearch().submitForm();
}


}

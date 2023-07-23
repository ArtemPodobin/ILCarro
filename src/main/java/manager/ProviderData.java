package manager;

import models.Car;
import models.SearchCar;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderData {

    @DataProvider
    public Iterator<Object[]> userLoginDtoCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/login_dataset.csv")));
        String line = reader.readLine();
        while (line != null){
            String[] split = line.split(",");
            list.add(new Object[]{ User.builder()
                    .email(split[0])
                    .password(split[1])
                    .build()
            });
            line = reader.readLine();
        }
        return list.iterator();
    }

@DataProvider
public Iterator<Object[]> userRegDtoCSV() throws IOException {
    List<Object[]> list = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/reg_dataset.csv")));
    String line = reader.readLine();
    while (line != null){
        String[] split = line.split(",");
        list.add(new Object[]{User.builder()
                .name(split[0])
                .lastName(split[1])
                .email(split[2])
                .password(split[3])
                .build()
        });
        line = reader.readLine();
    }
    return list.iterator();
}
    @DataProvider
    public Iterator<Object[]> carAddDtoCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/add_dataset.csv")));
        String line = reader.readLine();

        while(line != null){
            String[] split = line.split(";");
            list.add(new Object[]{ Car.builder().location(split[0])
                    .make(split[1])
                    .model(split[2])
                    .year(split[3])
                    .fuel(split[4])
                    .seats(split[5])
                    .carClass(split[6])
                    .carRegNumber(split[7])
                    .price(split[8])
                    .build()
            });
            line = reader.readLine();
        }
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> carSearchDtoCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/search_dataset.csv")));
        String line = reader.readLine();
        while (line != null){
            String[] split = line.split(";");
            list.add(new Object[]{SearchCar.builder()
                    .city(split[0])
                    .start(split[1])
                    .end(split[2])
                    .build()
            });
            line = reader.readLine();
        }
        return list.iterator();
    }


}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        File file = new File("cities.txt");
        List<WeatherInfo> info = new ArrayList<>();
        LoadAndSave load = new LoadAndSave();
        WeatherApi api = new WeatherApi();
        int i = 0;

        try {
            String[] city = new String[load.loadCity(file).size()];
            while(i<city.length) {
                city[i] = load.loadCity(file).get(i);
                info.add(new WeatherInfo(city[i], api.getDescription(city[i]), api.getTemperature(city[i])));
                i++;
            }
            for (WeatherInfo weatherInfo : info) {
                System.out.println(weatherInfo.getCity() + " jest " + weatherInfo.getDescription() + " i temperatura wynosi: " + weatherInfo.getTemperature());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku");
        } catch (IOException e) {
            System.out.println("Nie udało się pobrać informacji dla mista " + info.get(i).getCity());
        }


        try {
            FileWriter writer = new FileWriter("plik.csv");
            load.saveFile(writer,info);
        } catch (IOException e) {
            System.out.println("Bład przy zapisie");
        }


    }
}
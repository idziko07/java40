import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoadAndSave {

    public List<String> loadCity(File name) throws FileNotFoundException {
        Scanner scan = new Scanner(name);
        List<String> city = new ArrayList<>();

        while (scan.hasNext()){
            city.add(scan.next());
        }
        scan.close();
        return city;
    }

    public void saveFile(FileWriter name,List<WeatherInfo> info) throws IOException {

        BufferedWriter writer = new BufferedWriter(name);
        for (int i = 0; i < info.size(); i++) {
            writer.write(info.get(i).getCity() + ";" + info.get(i).getTemperature() + ";" + info.get(i).getDescription());
            writer.newLine();
        }
        writer.close();
    }

}

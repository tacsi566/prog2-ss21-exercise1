import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Fuel {


    public int getMass() {
        return mass;
    }

    private int mass;
    private File file;
    private ArrayList<Integer> data;

    public Fuel (int mass){
        setMass(mass);
    }

    public Fuel (File file){
        setFile(file);
        loadFile();
    }

    private void setMass(int mass){
        if (mass < 0){
            throw new IllegalArgumentException("Mass can not be smaller than zero.");
        }else{
            this.mass = mass;
        }
    }

    private void setFile(File inputFile){
        if (inputFile == null){
            throw new NullPointerException("Input file can not be null.");
        }else{
            file = inputFile;
        }
    }

    public int calculateFuel(int mass){
        return mass/3-2;
    }

    public int calculateFuel2(int mass){
        int total = calculateFuel(mass);
        if (total < 0){
            return 0;
        }
        return total;
    }

    public int calculateFuelLoop(int mass){
        int temp = calculateFuel2(mass);
        int sum = temp;
        while (!(temp == 0)){
            temp = calculateFuel2(temp);
            sum += temp;
        }
        return sum;
    }

    public int calculateTotalFuel(){
        if (data == null){
            return this.calculateFuel(this.mass);
        }
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i : data){
            temp.add(calculateFuel(i));
        }

        return temp.stream().mapToInt(Integer::intValue).sum();
    }

    public int calculateTotalFuel2(){
        if (data == null){
            return this.calculateFuel(this.mass);
        }
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i : data){
            temp.add(calculateFuelLoop(i));
        }

        return temp.stream().mapToInt(Integer::intValue).sum();
    }



    private void loadFile(){
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(this.file.getName());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            data = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                data.add(Integer.parseInt(line));
            }
        }catch (IOException e){
            Logger.getLogger(Fuel.class.getName()).log(Level.SEVERE, "Reading file not ok");
        }
    }

}

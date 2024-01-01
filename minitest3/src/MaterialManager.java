import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialManager implements Serializable {
    public static final String filePath = "data";
    public static void writeDate(List<Material> materialList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(materialList);
            oos.close();
        }catch (IOException io){
            io.printStackTrace();
        }
    }
    public static List<Material> readData(){
        List<Material> materialList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            materialList = (List<Material>) ois.readObject();
            ois.close();
        }catch (IOException | ClassNotFoundException io){
            io.printStackTrace();
        }
        return materialList;
    }
}

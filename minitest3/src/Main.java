import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Material crispyFlour1 = new CrispyFlour("c1","bột mì","2023-01-11",5000,5);
        Material crispyFlour2 = new CrispyFlour("c2","bột mì","2023-10-14",6000,5);
        Material crispyFlour3 = new CrispyFlour("c3","bột mì","2023-03-01",7000,5);
        Material crispyFlour4 = new CrispyFlour("c4","bột mì","2023-07-12",1000,5);
        Material crispyFlour5 = new CrispyFlour("c5","bột mì","2023-10-23",9000,5);
        Material meat1 = new Meat("m1","thịt gà","2023-02-21",10000,1);
        Material meat2 = new Meat("m2","thịt lợn","2023-06-04",8000,2);
        Material meat3 = new Meat("m3","thịt chó","2023-04-01",13000,3);
        Material meat4 = new Meat("m4","thịt khỉ","2023-07-27",11000,4);
        Material meat5 = new Meat("m5","thịt bò","2023-08-30",12000,5);
        ArrayList<Material> materials = new ArrayList<>();
        materials.add(crispyFlour1);
        materials.add(crispyFlour2);
        materials.add(crispyFlour3);
        materials.add(crispyFlour4);
        materials.add(crispyFlour5);
        materials.add(meat1);
        materials.add(meat2);
        materials.add(meat3);
        materials.add(meat4);
        materials.add(meat5);
        System.out.println("Tổng tiền 10 sản phẩm:" + getTotalMaterial(materials));
        for (int i = 0;i < materials.size();i++){
            System.out.println(materials.get(i));
        }
        sortMaterial(materials);
        System.out.println("---------------------");
        for (int i = 0;i < materials.size();i++){
            System.out.println(materials.get(i));
        }
        System.out.println("số tiền chênh lệnh:" +  getDifferenceAmount(materials));
    }

    private static void sortMaterial(ArrayList<Material> materials) {
        Comparator<Material> comparator = new Comparator<>() {
            @Override
            public int compare(Material o1, Material o2) {
                return o1.getCost() - o2.getCost();
            }
        };
        Collections.sort(materials,comparator);
    }

    public static double getTotalMaterial(ArrayList<Material> arr){
        double sum = 0;
        for (Material i: arr){
            sum += i.getAmount();
        }
        return sum;
    }
    public static double getTotalRealmoney(AbstractList<Material> arr){
        double sum = 0;
        for (Material i: arr){
            sum += i.getRealMoney();
        }
        return sum;
    }
    public static double getDifferenceAmount(ArrayList<Material> arr){
        return getTotalMaterial(arr) - getTotalRealmoney(arr);
    }
}
























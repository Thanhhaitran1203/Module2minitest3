import java.time.LocalDate;
import java.util.*;

public class Main {
    static List<Material> materials = MaterialManager.readData();

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        menuMaterial();
    }
    public static void menuAdd(){
        int choice = -1;
        while (choice != 0){
            System.out.println("Add menu");
            System.out.println("1. Add meat");
            System.out.println("2. Add Crispy Flour");
            System.out.println("0. Back");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    materials = MaterialManager.readData();
                    addMeet(materials);
                    MaterialManager.writeDate(materials);
                    break;
                case 2:
                    materials = MaterialManager.readData();
                    addCrispyFlour(materials);
                    MaterialManager.readData();
                    break;
                case 0:
                    menuMaterial();
                    break;
            }
        }
    }
    public static void printMaterial(){
        materials = MaterialManager.readData();
        for(Material material: materials){
            System.out.println(material);
        }
    }
    public static void menuMaterial(){
        materials = MaterialManager.readData();
        int choice = -1;
        while(choice != 0){
            System.out.println("material menu");
            System.out.println("1.add material");
            System.out.println("2.edit material");
            System.out.println("3.delete material");
            System.out.println("4.showlist material");
            System.out.println("5.total cost material");
            System.out.println("6.Sort by cost");
            System.out.println("0. exit");
            System.out.println("Enter choice");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    menuAdd();
                    break;
                case 2:
                    editMaterial();
                    break;
                case 3:
                    int index = checkIndex();
                    materials.remove(index);
                    MaterialManager.writeDate(materials);
                    break;
                case 4:
                    printMaterial();
                    break;
                case 5:
                    System.out.println("Total cost material:" + getTotalMaterial(materials));
                    break;
                case 6:
                    sortMaterial();
                    MaterialManager.writeDate(materials);
                    printMaterial();
                    break;
                case 0:
                    System.exit(1);
            }

        }
    }
    public static void editMaterial(){
        int index = checkIndex();
        materials = MaterialManager.readData();
        Material temp = materials.get(index);
        int choice = -1;
        while (choice != 0){
            System.out.println("1.edit name");
            System.out.println("2.edit manufacturing date");
            System.out.println("3.edit cost");
            System.out.println("4.edit quantity / weight");
            System.out.println("0. Back");
            System.out.println("Enter choice:");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("enter name");
                    String name = sc.next();
                    temp.setName(name);
                    MaterialManager.writeDate(materials);
                    break;
                case 2:
                    System.out.println("enter manufacturing date(yyyy-MM-dd)");
                    String date = sc.next();
                    temp.setManufacturingDate(LocalDate.parse(date));
                    MaterialManager.writeDate(materials);
                    break;
                case 3:
                    System.out.println("enter cost");
                    int cost = sc.nextInt();
                    temp.setCost(cost);
                    MaterialManager.writeDate(materials);
                    break;
                case 4:
                    if (temp instanceof Meat){
                        System.out.println("enter weight");
                        int weight = sc.nextInt();
                        ((Meat)temp).setWeight(weight);
                    }else if(temp instanceof CrispyFlour){
                        System.out.println("enter qauntity");
                        int quantity = sc.nextInt();
                        ((CrispyFlour)temp).setQuantity(quantity);
                }
                    MaterialManager.writeDate(materials);
                    break;
                case 0:
                    menuMaterial();
                    break;
            }
        }
    }
    public static int checkIndex(){
        while (true){
            System.out.println("Enter index:");
            int index = sc.nextInt();
            if (index<0 || index>materials.size()){
                System.out.println("Invalid index");
            }else return index;
        }
    }
    public static void  addCrispyFlour(List<Material> materialList){
        System.out.println("id:");
        String id = sc.nextLine();
        System.out.println("name:");
        String name = sc.nextLine();
        System.out.println("manufacturingDate (yyyy-MM-dd):");
        String manufacturingDate = sc.nextLine();
        System.out.println("cost:");
        int cost = sc.nextInt();
        System.out.println("quantity:");
        int quantity = sc.nextInt();
        Material cf = new CrispyFlour(id,name,manufacturingDate,cost,quantity);
        materialList.add(cf);
    }
    public static void addMeet(List<Material> materialList){
        System.out.println("id:");
        String id = sc.next();
        System.out.println("name:");
        String name = sc.next();
        System.out.println("manufacturingDate (yyyy-MM-dd):");
        String manufacturingDate = sc.next();
        System.out.println("cost:");
        int cost = sc.nextInt();
        System.out.println("weight:");
        double weight = sc.nextDouble();
        Material meat = new Meat(id,name,manufacturingDate,cost,weight);
        materialList.add(meat);
    }

    public static void sortMaterial() {
        Comparator<Material> comparator = Comparator.comparingInt(Material::getCost);
        materials.sort(comparator);
    }

    public static double getTotalMaterial(List<Material> arr){
        double sum = 0;
        for (Material i: arr){
            sum += i.getAmount();
        }
        return sum;
    }
    public static double getTotalRealmoney(List<Material> arr){
        double sum = 0;
        for (Material i: arr){
            sum += i.getRealMoney();
        }
        return sum;
    }
    public static double getDifferenceAmount(List<Material> arr){
        return getTotalMaterial(arr) - getTotalRealmoney(arr);
    }
}
























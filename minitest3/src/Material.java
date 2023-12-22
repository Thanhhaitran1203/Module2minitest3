import java.time.LocalDate;
public abstract class Material{
    public final int ONE = 1;
    public final int SEVEN = 7;
    public final int TWO = 2;
    public final int FOUR = 4;
    private String id;
    private String name;
    private LocalDate manufacturingDate;

    private int cost;

    public Material() {
    }

    public Material(String id, String name, String manufacturingDate, int cost) {
        this.id = id;
        this.name = name;
        this.manufacturingDate = LocalDate.parse(manufacturingDate);
        this.cost = cost;
    }
    public abstract double getAmount();
    public abstract LocalDate getExpiryDate();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    public abstract double getRealMoney();
}

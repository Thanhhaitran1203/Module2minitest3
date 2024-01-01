import java.io.Serializable;
import java.time.LocalDate;

public class Meat extends Material implements Discount, Serializable {
    private double weight;

    public Meat(double weight) {
        this.weight = weight;
    }

    public Meat(String id, String name, String manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getRealMoney() {
        if(LocalDate.now().plusDays(FIVE).isAfter(getExpiryDate())){
            return getAmount() * DISCOUNT30;
        }else return getAmount() * DISCOUNT10;
    }

    @Override
    public double getAmount() {
        return getCost()*weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusDays(SEVEN);
    }

    @Override
    public String toString() {
        return ("id:"+getId()+" name:"+getName()+" Ngày sản xuât:"+getManufacturingDate()+" giá:"+getCost()+" trọng lượng:"+getWeight());
    }
}

import java.time.LocalDate;

public class CrispyFlour extends Material implements Discount {
    private int quantity;

    public CrispyFlour(int quantity) {
        this.quantity = quantity;
    }

    public CrispyFlour(String id, String name, String manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    @Override
    public double getRealMoney() {
        if (getManufacturingDate().plusMonths(FOUR).isAfter(getExpiryDate())){
            if(getManufacturingDate().plusMonths(TWO).isAfter(getExpiryDate())){
                return getAmount() * DISCOUNT40;
            }else return getAmount() * DISCOUNT20;
        }else return getAmount() % DISCOUNT05;
    }

    @Override
    public double getAmount() {
        return quantity*getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusYears(ONE);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return ("id:"+getId()+" name:"+getName()+" Ngày sản xuât:"+getManufacturingDate()+" giá:"+getCost()+" số lượng:"+getQuantity());
    }
}

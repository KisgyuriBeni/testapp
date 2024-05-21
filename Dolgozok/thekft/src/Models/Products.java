package Models;

public class Products {
    String product_name;
    Double price;
    Integer amount;
    Integer selection_id;
    String purcharser;

    public Products(String product_name, Double price, Integer amount, Integer selection_id, String purcharser) {
        this.product_name = product_name;
        this.price = price;
        this.amount = amount;
        this.selection_id = selection_id;
        this.purcharser = purcharser;
    }

    public String getName() {
        return product_name;
    }

    public void setName(String product_name) {
        this.product_name = product_name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getSelection_id() {
        return selection_id;
    }

    public void setSelection_id(Integer selection_id) {
        this.selection_id = selection_id;
    }

    public String getPurcharser() {
        return purcharser;
    }

    public void setPurcharser(String purcharser) {
        this.purcharser = purcharser;
    }
    
    

}

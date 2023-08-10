package ptit.android.sqlite.model;

public class Item {
    private int id;
    private String name;
    private float price;
    private String dateUpdate;
    private Category category;

    public Item() {
    }

    public Item(int id, String name, float price, String dateUpdate, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.dateUpdate = dateUpdate;
        this.category = category;
    }

    public Item(String name, float price, String dateUpdate, Category category) {
        this.name = name;
        this.price = price;
        this.dateUpdate = dateUpdate;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(String dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
}

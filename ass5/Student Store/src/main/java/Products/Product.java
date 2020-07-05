package Products;

public class Product {
    private String productId;
    private String name;
    private String imageFile;
    private double price;

    public Product(String productId, String name, String imageFile, double price){
        this.price = price;
        this.productId = productId;
        this.name = name;
        this.imageFile = imageFile;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getImageFile() {
        return imageFile;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        Product prod = (Product)obj;
        if(prod.getImageFile().equals(imageFile) && prod.getName().equals(name) &&
                prod.getPrice() == price && prod.getProductId().equals(getProductId()))
            return true;
        return false;
    }
}

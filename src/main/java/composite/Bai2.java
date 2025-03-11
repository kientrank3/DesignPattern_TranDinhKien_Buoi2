package composite;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.sound.sampled.ReverbType;

// Component
interface CafeComponent {
    double getPrice();
}

// Leaf: Sản phẩm (Product)
class Product implements CafeComponent {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

// Composite: Bàn (Table)
class Table implements CafeComponent {
    private List<CafeComponent> products = new ArrayList<>();

    public void addProduct(CafeComponent product) {
        products.add(product);
    }

    public void removeProduct(CafeComponent product) {
        products.remove(product);
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (CafeComponent product : products) {
            total += product.getPrice();
        }
        return total;
    }
}

// Demo
public class Bai2 {
    public static void main(String[] args) {
        // Tạo các sản phẩm
        CafeComponent coffee = new Product("Cà phê đen", 20000);
        CafeComponent tea = new Product("Trà đào", 25000);
        CafeComponent cake = new Product("Bánh ngọt", 15000);
        CafeComponent milk = new Product("Sữa tươi", 15000);
        CafeComponent combo = new Product("Combo ăn sáng", 50000);
        CafeComponent combo2 = new Product("Combo ăn trưa",75000);
        
        // Tạo bàn và thêm sản phẩm vào bàn
        Table table1 = new Table();
        table1.addProduct(coffee);
        table1.addProduct(cake);
        table1.addProduct(milk);
        table1.addProduct(combo2);

        Table table2 = new Table();
        table2.addProduct(tea);
        table2.addProduct(cake);
        table2.addProduct(combo);
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        // Tính tổng giá trị của từng bàn
        System.out.println("+ Tổng giá trị bàn 1: " + formatter.format(table1.getPrice()));
        System.out.println("+ Tổng giá trị bàn 2: " + formatter.format(table2.getPrice()));

        // Tính doanh thu của quán
        double totalRevenue = table1.getPrice() + table2.getPrice();
        System.out.println("Doanh thu của quán: " + formatter.format(totalRevenue));
    }
}
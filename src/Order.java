public class Order {
    private String name;

    public Order(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person =[" + "id=" + ", name='" + name + '\'' + ']';
    }
}

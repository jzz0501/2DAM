public class Tenedor {

    private String name;
    private boolean isUsing;

    public Tenedor(String name) {
        this.name = name;
        this.isUsing = false;
    }

    public String getName() {
        return name;
    }

    public void setUsing(boolean using) {
        isUsing = using;
    }

    public boolean isUsing() {
        return isUsing;
    }
}

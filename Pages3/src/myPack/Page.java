package myPack;

/**
 * Created by Laptop on 2017-02-28.
 */
public class Page {
    static private int counter;
    private String name;
    private String path;
    private int id;

    public Page(String name, String path) {
        this.name = name;
        this.path = path;
        this.id = counter++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }
}

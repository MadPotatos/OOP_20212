package hust.soict.hedspi.aims.media;

public abstract class Media implements Comparable {
    protected int id;
    protected String title;
    protected String category;
    protected float cost;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public void printInfo() {

    }

    public boolean equals(Object obj) {

        if (this.id == ((Media) obj).id) {
            return true;
        }
        return false;

    }

    @Override
    public int compareTo(Object o) {

        return this.getTitle().compareToIgnoreCase(((Media) o).getTitle());
    }
}

import java.util.Objects;

public class NameCoordinates {

    private String name;
    private Coordinates coordinates;

    public NameCoordinates(int lineOffset,int charOffset,String name) {
        this.coordinates = new Coordinates(lineOffset, charOffset);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates=coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NameCoordinates that=(NameCoordinates) o;
        return Objects.equals(name,that.name) && Objects.equals(coordinates,that.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),name,coordinates);
    }

    @Override
    public String toString() {
        return "NameCoordinates{" +
                "name='" + name + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }
}

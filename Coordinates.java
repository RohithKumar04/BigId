import java.util.Objects;

public class Coordinates {

    private int lineOffset;
    private int charOffset;

    public Coordinates(int lineOffset,int charOffset) {
        this.lineOffset=lineOffset;
        this.charOffset=charOffset;
    }

    public int getLineOffset() {
        return lineOffset;
    }

    public void setLineOffset(int lineOffset) {
        this.lineOffset=lineOffset;
    }

    public int getCharOffset() {
        return charOffset;
    }

    public void setCharOffset(int charOffset) {
        this.charOffset=charOffset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that=(Coordinates) o;
        return lineOffset == that.lineOffset && charOffset == that.charOffset;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineOffset,charOffset);
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "lineOffset=" + lineOffset +
                ", charOffset=" + charOffset +
                '}';
    }
}

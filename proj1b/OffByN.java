public class OffByN implements CharacterComparator {
    private int offSet;

    public OffByN(int offSet) {
        this.offSet = offSet;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == offSet;
    }
}

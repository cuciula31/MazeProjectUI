public class Chamber {
    private boolean hasExit;
    private boolean hasPerson;

    public Chamber(boolean hasExit, boolean hasPerson) {
        this.hasExit = hasExit;
        this.hasPerson = hasPerson;
    }

    public boolean hasExit() {
        return hasExit;
    }

    public boolean hasPerson() {
        return hasPerson;
    }

    public void setPerson(boolean hasPerson) {
        this.hasPerson = hasPerson;
    }
}

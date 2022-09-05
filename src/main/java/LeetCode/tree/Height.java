package LeetCode.tree;

public enum Height {
    TALL('T'),
    SHORT('S');

    private Character db;
    Height(Character db) {
        this.db = db;
    }

    public Character getDb() {
        return db;
    }
}

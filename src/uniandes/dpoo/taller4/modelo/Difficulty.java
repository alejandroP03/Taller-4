package uniandes.dpoo.taller4.modelo;

public enum Difficulty {
    EASY("facil", 5),
    MEDIUM("medio", 10),
    HARD("difícil", 15);

    private final String name;
    private final int numOfMoves;

    Difficulty(String name, int numOfMoves) {
        this.name = name;
        this.numOfMoves = numOfMoves;
    }

    public String getName() {
        return name;
    }

    public int getNumOfMoves(){
        return numOfMoves;
    }
}
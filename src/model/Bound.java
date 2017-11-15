package model;

/**
 * Classe para guardar informacoes sobre os limites
 * @author Bruno Soares Chien
 * @author Kaio Henrique Andrade
 */
public class Bound {
    public static final int FREE = 1;
    public static final int GREATER_OR_EQUAL = 2;
    public static final int LESS_OR_EQUAL = 3;
    public static final int BETWEEN = 4;
    public static final int EQUAL = 5;
    
    public double lb, ub;
    public int type;

    public Bound( int type, double lb, double ub) {
        this.lb = lb;
        this.ub = ub;
        this.type = type;
    }
}

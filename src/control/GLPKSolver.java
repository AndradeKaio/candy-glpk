package control;

import java.util.List;
import model.Bound;
import org.gnu.glpk.GLPK;
import org.gnu.glpk.GLPKConstants;
import org.gnu.glpk.SWIGTYPE_p_double;
import org.gnu.glpk.SWIGTYPE_p_int;
import org.gnu.glpk.glp_iocp;
import org.gnu.glpk.glp_prob;

/**
 * Classe para montar e resolver o problema utilizando a biblioteca GLPK
 *
 * @author Bruno Soares Chien
 * @author Kaio Henrique Andrade
 */
public class GLPKSolver {

    public static final int MAX = 1;
    public static final int MIN = 2;

    private final String PROBLEM_NAME;
    private final int NUMBER_VARIABLES;
    private final int NUMBER_RESTRICTIONS;
    private final int PROBLEM_TYPE;

    private final List<String> VARIABLES_NAME;
    private final List<String> RESTRICTIONS_NAME;
    private final List<Bound> VARIABLES_BOUNDS;
    private final List<Bound> RESTRICTIONS_BOUNDS;

    private final double[][] COEFICIENTS;

    private int flag;

    private glp_prob problem;
    private glp_iocp param;

    public GLPKSolver(String PROBLEM_NAME, int PROBLEM_TYPE, int NUMBER_VARIABLES,
            int NUMBER_RESTRICTIONS, List<String> VARIABLES_NAME, List<String> RESTRICTIONS_NAME,
            List<Bound> VARIABLES_BOUNDS, List<Bound> RESTRICTIONS_BOUNDS, double[][] COEFICIENTS) {
        this.PROBLEM_NAME = PROBLEM_NAME;
        this.PROBLEM_TYPE = PROBLEM_TYPE;
        this.NUMBER_VARIABLES = NUMBER_VARIABLES;
        this.NUMBER_RESTRICTIONS = NUMBER_RESTRICTIONS;
        this.VARIABLES_NAME = VARIABLES_NAME;
        this.RESTRICTIONS_NAME = RESTRICTIONS_NAME;
        this.VARIABLES_BOUNDS = VARIABLES_BOUNDS;
        this.RESTRICTIONS_BOUNDS = RESTRICTIONS_BOUNDS;
        this.COEFICIENTS = COEFICIENTS;
        flag = -1;
    }

    public void delete() {
        GLPK.glp_delete_prob(problem);
    }

    /**
     * Realiza a montagem do problema no GLPK
     */
    public void mountGlpkProblem() {
        problem = GLPK.glp_create_prob();                                  //cria o problema
        GLPK.glp_set_prob_name(problem, PROBLEM_NAME);                          //define o nome do problema

        GLPK.glp_add_cols(problem, NUMBER_VARIABLES);                           //cria as colunas (uma por variavel)

        //realiza a leitura das variaveis e seus limites
        for (int i = 0; i < NUMBER_VARIABLES; i++) {
            GLPK.glp_set_col_name(problem, i + 1, VARIABLES_NAME.get(i));         //define o nome da variavel
            GLPK.glp_set_col_kind(problem, i + 1, GLPKConstants.GLP_IV);          //define a variavel como inteira

            //define o tipo do limite e o limite
            switch (VARIABLES_BOUNDS.get(i).type) {
                case Bound.FREE:                                                //a variavel e livre
                    GLPK.glp_set_col_bnds(problem, i + 1, GLPKConstants.GLP_FR, 0, 0);
                    break;

                case Bound.GREATER_OR_EQUAL:                                    //var >= k
                    GLPK.glp_set_col_bnds(problem, i + 1, GLPKConstants.GLP_LO,
                            VARIABLES_BOUNDS.get(i).lb, 0);
                    break;

                case Bound.LESS_OR_EQUAL:                                       //var <= k
                    GLPK.glp_set_col_bnds(problem, i + 1, GLPKConstants.GLP_UP,
                            0, VARIABLES_BOUNDS.get(i).ub);
                    break;

                case Bound.BETWEEN:                                             // k1 <= var <= k2
                    GLPK.glp_set_col_bnds(problem, i + 1, GLPKConstants.GLP_DB,
                            VARIABLES_BOUNDS.get(i).lb, VARIABLES_BOUNDS.get(i).ub);
                    break;

                case Bound.EQUAL:                                               // var = x
                    GLPK.glp_set_col_bnds(problem, i + 1, GLPKConstants.GLP_FX,
                            VARIABLES_BOUNDS.get(i).lb, VARIABLES_BOUNDS.get(i).ub);
                    break;

                default:
                    System.out.printf("Erro: tipo do limite invalido em limite da"
                            + " variavel %s: %d\n", VARIABLES_NAME.get(i),
                            VARIABLES_BOUNDS.get(i).type);
            }
        }

        SWIGTYPE_p_int index = GLPK.new_intArray(NUMBER_VARIABLES);             //vetor de indices
        SWIGTYPE_p_double values = GLPK.new_doubleArray(NUMBER_VARIABLES);      //vetor de valores
        GLPK.glp_add_rows(problem, NUMBER_RESTRICTIONS);                        //cria a quantidade de linhas referentes as restricoes

        //realiza a leitura das restricoes, seus coeficientes e seus limites
        for (int i = 1; i <= NUMBER_RESTRICTIONS; i++) {
            GLPK.glp_set_row_name(problem, i, RESTRICTIONS_NAME.get(i - 1));
            //define o tipo do limite e o limite
            switch (RESTRICTIONS_BOUNDS.get(i - 1).type) {
                case Bound.FREE:                                                //a variavel e livre
                    GLPK.glp_set_row_bnds(problem, i - 1, GLPKConstants.GLP_FR, 0, 0);
                    break;

                case Bound.GREATER_OR_EQUAL:                                    //var >= k
                    GLPK.glp_set_row_bnds(problem, i, GLPKConstants.GLP_LO,
                            RESTRICTIONS_BOUNDS.get(i - 1).lb, 0);
                    break;

                case Bound.LESS_OR_EQUAL:                                       //var <= k
                    GLPK.glp_set_row_bnds(problem, i, GLPKConstants.GLP_UP,
                            0, RESTRICTIONS_BOUNDS.get(i - 1).ub);
                    break;

                case Bound.BETWEEN:                                             // k1 <= var <= k2
                    GLPK.glp_set_row_bnds(problem, i, GLPKConstants.GLP_DB,
                            RESTRICTIONS_BOUNDS.get(i - 1).lb, RESTRICTIONS_BOUNDS.get(i - 1).ub);
                    break;

                case Bound.EQUAL:                                               // var = x
                    GLPK.glp_set_row_bnds(problem, i, GLPKConstants.GLP_FX,
                            RESTRICTIONS_BOUNDS.get(i - 1).lb, RESTRICTIONS_BOUNDS.get(i - 1).ub);
                    break;

                default:
                    System.out.printf("Erro: tipo do limite invalido em limite da"
                            + " restricao %s: %d\n", RESTRICTIONS_NAME.get(i - 1),
                            RESTRICTIONS_BOUNDS.get(i - 1).type);
            }

            //mapeia os indices
            for (int k = 1; k <= NUMBER_VARIABLES; k++) {
                GLPK.intArray_setitem(index, k, k);
            }

            //pega os coeficientes da restricao
            for (int j = 0; j < NUMBER_VARIABLES; j++) {
                GLPK.doubleArray_setitem(values, j + 1, COEFICIENTS[i][j]);
            }

            GLPK.glp_set_mat_row(problem, i, NUMBER_VARIABLES, index, values);
        }

        GLPK.delete_intArray(index);                                            //limpa a memoria de index
        GLPK.delete_doubleArray(values);                                        //limpa a memoria de values

        //define a funcao objetiva
        GLPK.glp_set_obj_name(problem, "z");

        //define o tipo da funcao objetiva
        if (PROBLEM_TYPE == GLPKSolver.MAX) {
            GLPK.glp_set_obj_dir(problem, GLPKConstants.GLP_MAX);
        } else {
            GLPK.glp_set_obj_dir(problem, GLPKConstants.GLP_MIN);
        }

        //realiza a leitura dos coeficientes da funcao objetiva
        for (int j = 0; j < NUMBER_VARIABLES; j++) {
            GLPK.glp_set_obj_coef(problem, j + 1, COEFICIENTS[0][j]);
        }
    }

    public void solveProblem() {
        param = new glp_iocp();
        GLPK.glp_init_iocp(param);
        param.setPresolve(GLPKConstants.GLP_ON);
        flag = GLPK.glp_intopt(problem, param);
    }

    public String getAnswer() {
        StringBuilder answer = new StringBuilder();
        if (flag == 0) {
            answer.append("O maior lucro possivel é: ");
            answer.append(GLPK.glp_mip_obj_val(problem));
            answer.append(".\nPara se atingir o maior lucro deve-se produzir:\n");

            for (int i = 1; i <= NUMBER_VARIABLES; i++) {
                answer.append("\t");
                answer.append(new Double(GLPK.glp_mip_col_val(problem, i)).intValue());
                answer.append(" ");
                answer.append(GLPK.glp_get_col_name(problem, i));
                answer.append("\n");
            }
        } else {
            answer.append("Não existe solucao para o problema informado");
        }
        return answer.toString();
    }
}
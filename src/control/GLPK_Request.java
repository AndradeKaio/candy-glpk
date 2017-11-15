package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bound;

/**
 * Receptor da requisicao de um problema do GLPK
 * @author Bruno Soares Chien
 * @author Kaio Henrique Andrade
 */
@WebServlet(name="Request GLPK", urlPatterns="/request_glpk")
public class GLPK_Request extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

			try {
				PrintWriter out = response.getWriter();
				String param_problemName = request.getParameter("problemName");
				String param_problemType = request.getParameter("problemType");
				String param_numberVariables = request.getParameter("numberVariables");
				String param_numberRestrictions = request.getParameter("numberRestrictions");
				String[] param_variablesName = request.getParameterValues("variablesName");
				String[] param_restrictionsName = request.getParameterValues("restrictionsName");
				String[] param_variablesBounds = request.getParameterValues("variablesBounds");
				String[] param_restrictionsBounds = request.getParameterValues("restrictionsBounds");
				String[] param_coeficients = request.getParameterValues("coeficients");

				out.write(getAnswer(param_problemName, param_problemType, param_numberVariables,
						param_numberRestrictions, param_variablesName, param_restrictionsName, param_variablesBounds,
						param_restrictionsBounds, param_coeficients));
			}catch(Exception e) {
				try {
					response.sendRedirect("/error.html");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}


		}

		/**
		 * receptor dos gets
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			processRequest(request, response);
		}

		/**
		 * receptor dos posts
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			processRequest(request, response);
		}

		/**
		 * Obtem a resposta do GLPK_Solver
		 * @param param_problemName Nome do problema
		 * @param param_problemType Tipo do problema
		 * @param param_numberVariables Quantidade de variaveis
		 * @param param_numberRestrictions Quantidade de restricoes
		 * @param param_variablesName Nome das variaveis
		 * @param param_restrictionsName Nome das restricoes
		 * @param param_variablesBounds Limite das variaveis
		 * @param param_restrictionsBounds Limite das restricoes
		 * @param param_coeficients Coeficientes	
		 * @return Resposta gerencial
		 */
		private String getAnswer(String param_problemName, String param_problemType, String param_numberVariables,
				String param_numberRestrictions, String[] param_variablesName, String[] param_restrictionsName,
				String[] param_variablesBounds, String[] param_restrictionsBounds, String[] param_coeficients) {

			String PROBLEM_NAME = param_problemName;
			int PROBLEM_TYPE = Integer.parseInt(param_problemType);
			int NUMBER_VARIABLES = Integer.parseInt(param_numberVariables);
			int NUMBER_RESTRICTIONS = Integer.parseInt(param_numberRestrictions);

			List<String> VARIABLES_NAME = new ArrayList<>();
			List<String> RESTRICTIONS_NAME = new ArrayList<>();
			List<Bound> VARIABLES_BOUNDS = new ArrayList<>();
			List<Bound> RESTRICTIONS_BOUNDS = new ArrayList<>();
			double[][] COEFICIENTS = new double[NUMBER_RESTRICTIONS + 1][NUMBER_VARIABLES];

			//realiza a copia dos nomes das variaveis
			for (int i = 0; i < NUMBER_VARIABLES; i++) {
				VARIABLES_NAME.add(param_variablesName[i]);
			}

			//realiza a copia dos nomes das restricoes
			for (int i = 0; i < param_restrictionsName.length; i++) {
				RESTRICTIONS_NAME.add(param_restrictionsName[i]);
			}

			//realiza a copia dos limites das variaveis
			for (int i = 0; i < param_variablesBounds.length; i += 3) {
				VARIABLES_BOUNDS.add(new Bound(Integer.parseInt(param_variablesBounds[i]),
						Double.parseDouble(param_variablesBounds[i+1]), Double.parseDouble(param_variablesBounds[i+2])));
			}

			//realiza a copia dos limites das retricoes
			for (int i = 0; i < param_restrictionsBounds.length; i += 3) {
				RESTRICTIONS_BOUNDS.add(new Bound(Integer.parseInt(param_restrictionsBounds[i]),
						Double.parseDouble(param_restrictionsBounds[i+1]), Double.parseDouble(param_restrictionsBounds[i+2])));
			}

			//realiza a copia dos limites das retricoes
			for (int i = 0; i < param_restrictionsBounds.length; i += 3) {
				RESTRICTIONS_BOUNDS.add(new Bound(Integer.parseInt(param_restrictionsBounds[i]),
						Double.parseDouble(param_restrictionsBounds[i+1]), Double.parseDouble(param_restrictionsBounds[i+2])));
			}

			//realiza a copia dos coeficientes
			int k = 0;

			for (int i = 0; i <= NUMBER_RESTRICTIONS; i++) {
				for (int j = 0; j < NUMBER_VARIABLES; j++) {
					COEFICIENTS[i][j] = Double.parseDouble(param_coeficients[k]);
					k++;
				}
			}

			GLPKSolver solver = new GLPKSolver(PROBLEM_NAME, PROBLEM_TYPE, NUMBER_VARIABLES, NUMBER_RESTRICTIONS, VARIABLES_NAME, RESTRICTIONS_NAME, VARIABLES_BOUNDS, RESTRICTIONS_BOUNDS, COEFICIENTS);
			solver.mountGlpkProblem();
			solver.solveProblem();
			String answer = solver.getAnswer();
			solver.delete();
			solver = null;
			return answer;
		}

	}

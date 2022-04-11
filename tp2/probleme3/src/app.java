

import ilog.concert.*;
import ilog.cplex.*;


public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        calculate();
	}
	
	
	public static void calculate() {
	     
		try {
			
			IloCplex simplexe = new IloCplex();
			
			IloNumVar variable_decision[][] = new IloNumVar[3][1];
			
			for (int i=0 ; i<3 ; i++) {
					variable_decision[i][0] = simplexe.numVar(0,Double.MAX_VALUE);
				}
			IloLinearNumExpr objective = simplexe.linearNumExpr();
			

			objective.addTerm(25, variable_decision[0][0]);
		    objective.addTerm(35, variable_decision[1][0]);
		    objective.addTerm(25, variable_decision[2][0]);
		    

		    objective.addTerm(25, variable_decision[2][1]);
		    objective.addTerm(35, variable_decision[2][2]);
			
		    
		    simplexe.addMaximize(objective);
		    
		     IloLinearNumExpr contrainte_1 = simplexe.linearNumExpr();
		     contrainte_1.addTerm(1,variable_decision[0][0]);
		     contrainte_1.addTerm(1,variable_decision[1][0]);
		     contrainte_1.addTerm(1,variable_decision[2][0]);
		     simplexe.addLe(contrainte_1,17);
		    
		     IloLinearNumExpr contrainte_2 = simplexe.linearNumExpr();
		     contrainte_2.addTerm(1,variable_decision[0][0]);
		     contrainte_2.addTerm(1,variable_decision[1][0]);
		     contrainte_2.addTerm(1,variable_decision[2][0]);
		     simplexe.addLe(contrainte_2,35);
		     
		     IloLinearNumExpr contrainte_3 = simplexe.linearNumExpr();
		     contrainte_3.addTerm(1,variable_decision[0][0]);
		     contrainte_3.addTerm(1,variable_decision[1][0]);
		     contrainte_3.addTerm(1,variable_decision[2][0]);
		     simplexe.addLe(contrainte_3,25);
		     
		     IloLinearNumExpr contrainte_4 = simplexe.linearNumExpr();
		     contrainte_4.addTerm(1,variable_decision[0][0]);
		     contrainte_4.addTerm(1,variable_decision[1][0]);
		     contrainte_4.addTerm(1,variable_decision[2][0]);
		     simplexe.addLe(contrainte_4,0);
		    
		    
		    
		    simplexe.solve();
		     System.out.println("z = " + simplexe.getObjValue());
		     for(int i=0 ; i<1 ; i++){
		    	
		    	    System.out.println(simplexe.getValue(variable_decision[0][0]));
		    	    System.out.println(simplexe.getValue(variable_decision[1][0]));
		    	    System.out.println(simplexe.getValue(variable_decision[2][0]));
			}
				
		} catch (IloException e){
			   System.out.println("exception " + e);
	}

}
}
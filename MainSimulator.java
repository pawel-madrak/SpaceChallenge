import java.util.ArrayList;

public class MainSimulator {
    public static void main(String[] args){

        Simulation simulation = new Simulation();

        ArrayList<Item> itemsPhase1 = simulation.loadItems("Phase-1.txt");
        ArrayList<Item> itemsPhase2 = simulation.loadItems("Phase-2.txt");
        ArrayList<U1> rocketsU1phase1 = simulation.loadU1(itemsPhase1);
        ArrayList<U1> rocketsU1phase2 = simulation.loadU1(itemsPhase2);
        ArrayList<U2> rocketsU2phase1 = simulation.loadU2(itemsPhase1);
        ArrayList<U2> rocketsU2phase2 = simulation.loadU2(itemsPhase2);


        int u1Phase1Budget = simulation.runSimulation(new ArrayList<Rocket>(rocketsU1phase1));
        int u1Phase2Budget = simulation.runSimulation(new ArrayList<Rocket>(rocketsU1phase2));
        int u1totalBudget = u1Phase1Budget + u1Phase2Budget;
        System.out.println("Rockets U1 budget: " + u1totalBudget);


        int u2Phase1Budget = simulation.runSimulation(new ArrayList<Rocket>(rocketsU2phase1));
        int u2Phase2Budget = simulation.runSimulation(new ArrayList<Rocket>(rocketsU2phase2));
        int u2totalBudget = u2Phase1Budget + u2Phase2Budget;
        System.out.println("Rockets U2 budget: " + u2totalBudget);

    }

}

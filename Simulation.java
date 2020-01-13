import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Simulation {

    public ArrayList<Item> loadItems(String fileName) {
        ArrayList<Item> items = new ArrayList<>();

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileName));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] args = line.split("=");
                items.add(new Item(args[0], Integer.parseInt(args[1]) / 1000));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return items;
    }

    public ArrayList<U1> loadU1(ArrayList<Item> items) {
        ArrayList<U1> rocketsU1 = new ArrayList<>();

        while (!items.isEmpty()) {

            rocketsU1.add(new U1());
            int cargoCounter = 0;
            for (int i = 0; i < items.size(); i++) {

                if (rocketsU1.get(rocketsU1.size() - 1).canCarry(items.get(i))) {
                    rocketsU1.get(rocketsU1.size() - 1).carry(items.get(i));
                    cargoCounter++;
                }
            }
            if (cargoCounter > 0) {
                items = new ArrayList<Item>(items.subList(cargoCounter - 1, items.size() - 1));
            }
        }
        return rocketsU1;
    }

    public ArrayList<U2> loadU2(ArrayList<Item> items) {
        ArrayList<U2> rocketsU2 = new ArrayList<>();

        while (!items.isEmpty()) {

            rocketsU2.add(new U2());
            int cargoCounter = 0;
            for (int i = 0; i < items.size(); i++) {

                if (rocketsU2.get(rocketsU2.size() - 1).canCarry(items.get(i))) {
                    rocketsU2.get(rocketsU2.size() - 1).carry(items.get(i));
                    cargoCounter++;
                }
            }
            if (cargoCounter > 0) {
                items = new ArrayList<Item>(items.subList(cargoCounter - 1, items.size() - 1));
            }
        }
        return rocketsU2;
    }

    public int runSimulation(ArrayList<Rocket> rockets) {

        ArrayList<Rocket> rocketstoLaunch = new ArrayList<>(rockets);
        int totalCost = 0;
        while (!rocketstoLaunch.isEmpty()) {
            totalCost = rocketstoLaunch.get(0).cost + totalCost;

            if (rocketstoLaunch.get(0).launch()) {
                if (!rocketstoLaunch.get(0).land()) {
//                    System.out.println("Rocket failed to land");
                    rocketstoLaunch.add(new U1(rocketstoLaunch.get(0).totalWeight));
                }
            } else {
//                System.out.println("Rocket failed to launch");
                rocketstoLaunch.add(new U1(rocketstoLaunch.get(0).totalWeight));
            }
            rocketstoLaunch.remove(0);
        }

        return totalCost;
    }
}
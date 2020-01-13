public class U1 extends Rocket {

    public U1() {
        this.maxWeight = 18;
        this.totalWeight = 10;
        this.cost = 100;
    }

    public U1(int totalWeight) {
        this.maxWeight = 18;
        this.totalWeight = totalWeight;
        this.cost = 100;
    }

    public boolean launch() {
        int launchU1Random = (int) (Math.random() * 100) + 1;
        int u1LaunchExpProbability = (int) (0.05 * ((double)totalWeight / (double) maxWeight) * 100);

        return launchU1Random > u1LaunchExpProbability;
    }

    public boolean land() {
        boolean chanceOfLandExpU1;
        int landU1Random = (int) (Math.random() * 100) + 1;
        int u1LandExpProbability = (int) (0.01 * ((double)totalWeight / (double) maxWeight) * 100);

        chanceOfLandExpU1 = landU1Random > u1LandExpProbability;
        return chanceOfLandExpU1;
    }


}

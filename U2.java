public class U2 extends Rocket {

    public U2() {
        this.maxWeight = 29;
        this.totalWeight = 18;
        this.cost = 120;
    }

    public boolean launch() {
        boolean chanceOfLaunchExpU2;
        int launchU2Random = (int) (Math.random() * 100) + 1;
        int u2LaunchExpProbability = (int) (0.04 * (totalWeight / maxWeight));

        chanceOfLaunchExpU2 = launchU2Random < u2LaunchExpProbability;
        return chanceOfLaunchExpU2;
    }

    public boolean land() {

        boolean chanceOfLandExpU2;
        int landU2Random = (int) (Math.random() * 100) + 1;
        int u2LandExpProbability = (int) (0.08 * (totalWeight / maxWeight));

        chanceOfLandExpU2 = landU2Random < u2LandExpProbability;
        return chanceOfLandExpU2;
    }

}

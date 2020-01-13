public class Rocket implements Spaceship {

    int maxWeight;
    int totalWeight;
    int cost;


    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        if (totalWeight + item.getWeight() <= this.maxWeight){
            return true;
        }   else{
            return false;
        }
    }

    @Override
    public void carry(Item item) {
            totalWeight = totalWeight + item.getWeight();
    }

}

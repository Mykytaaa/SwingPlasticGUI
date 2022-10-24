package SubClasses;

import SuperClass.Plastic;


public class PlasticBottle extends Plastic { //PETE

    int density;
    int qty;
    int id;
    String plastic_name;


    public PlasticBottle(String plastic_name, int qty){
        this.plastic_name = plastic_name;
        this.qty = qty;
        super.setHeatPermission(false);
        super.setRecycleStatus(true);
        setPackingVolume(packageVolume((int) (Math.random() * 10),
                (int) (Math.random() * 10)));
        setDensity(DensityCoefficient(getPackingVolume()));
    }

    public PlasticBottle(String plastic_name, int qty, int volume, int id, int density){
        super.setHeatPermission(false);
        super.setRecycleStatus(true);
        this.plastic_name = plastic_name;
        this.qty = qty;
        this.id = id;
        setPackingVolume(volume);
        setDensity(density);
    }

    @Override
    public int packageVolume(int... variables) {
        return (int) (3.14 * Math.pow(variables[0], 2) / 4 * variables[1]);
    }

    public int DensityCoefficient(int packageVolume){
        return (int) Math.pow(packageVolume, 2);
    }

    public void setDensity(int density) {
        this.density = density;
    }

    public int getDensity() {
        return density;
    }

    public int getId() {
        return id;
    }

    public int getQty() {
        return qty;
    }

    public String getPlasticName() {
        return plastic_name;
    }

    @Override
    public String toString() {
        return "PlasticBottle{"
                + "density coefficient='" + getDensity() + '\''
                + ", heat permission: " + isHeatPermission()
                + ", recycleStatus: " + isRecycleStatus()
                + ", package volume: " + getPackingVolume()
                + '}';
    }
}

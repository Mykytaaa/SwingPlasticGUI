package SuperClass;


public abstract class Plastic {
    private boolean heatPermission;
    private boolean recycleStatus;

    private int packingVolume;

    protected Plastic() {
    }

    public abstract int packageVolume(int... variables);

    public void showCharacteristics(){
        System.out.println("Heat permission: " + heatPermission + "\n" +
                            "Possibility of recycling: " + recycleStatus + "\n");
    }

    public boolean isHeatPermission() {
        return heatPermission;
    }

    public void setHeatPermission(boolean heatPermission) {
        this.heatPermission = heatPermission;
    }

    public boolean isRecycleStatus() {
        return recycleStatus;
    }

    public void setRecycleStatus(boolean recycleStatus) {
        this.recycleStatus = recycleStatus;
    }

    public int getPackingVolume() {
        return packingVolume;
    }

    public void setPackingVolume(int packingVolume) {
        this.packingVolume = packingVolume;
    }

}

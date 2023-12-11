package aufgaben.watergun.FillStates;

import aufgaben.watergun.WaterGun;

public class EmptyState extends FillState {

    public EmptyState(WaterGun gun) {
        super(gun);
    }

    @Override
    public int addWater(int ml) {
        return Math.min(gun.getCurrent() + ml, gun.MAX_CAPACITY);
    }

    @Override
    public int shootWater() {
        return 0;
    }
}

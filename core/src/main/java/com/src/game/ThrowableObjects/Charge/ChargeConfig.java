package com.src.game.ThrowableObjects.Charge;

import com.src.game.EntityConfig;

public class ChargeConfig implements EntityConfig {
    private String path;

    public ChargeConfig(String parent) {
        path = parent + "/Charge.png";
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public int getIdleCol() {

        throw new UnsupportedOperationException("Unimplemented method 'getIdleCol'");
    }

    @Override
    public int getIdleRow() {

        throw new UnsupportedOperationException("Unimplemented method 'getIdleRow'");
    }

    @Override
    public int getWalkCol() {

        throw new UnsupportedOperationException("Unimplemented method 'getWalkCol'");
    }

    @Override
    public int getWalkRow() {

        throw new UnsupportedOperationException("Unimplemented method 'getWalkRow'");
    }

    @Override
    public int getRunningCol() {

        throw new UnsupportedOperationException("Unimplemented method 'getRunningCol'");
    }

    @Override
    public int getRunningRow() {

        throw new UnsupportedOperationException("Unimplemented method 'getRunningRow'");
    }

    @Override
    public int getDyingCol() {

        throw new UnsupportedOperationException("Unimplemented method 'getDyingCol'");
    }

    @Override
    public int getDyingRow() {

        throw new UnsupportedOperationException("Unimplemented method 'getDyingRow'");
    }

    @Override
    public int getAttackingCol() {

        throw new UnsupportedOperationException("Unimplemented method 'getAttackingCol'");
    }

    @Override
    public int getAttackingRow() {

        throw new UnsupportedOperationException("Unimplemented method 'getAttackingRow'");
    }

    @Override
    public int getJumpCol() {

        throw new UnsupportedOperationException("Unimplemented method 'getJumpCol'");
    }

    @Override
    public int getJumpRow() {

        throw new UnsupportedOperationException("Unimplemented method 'getJumpRow'");
    }

    @Override
    public int getSwordThrustCol() {

        throw new UnsupportedOperationException("Unimplemented method 'getSwordThrustCol'");
    }

    @Override
    public int getSwordThrustRow() {

        throw new UnsupportedOperationException("Unimplemented method 'getSwordThrustRow'");
    }

    @Override
    public int getSwordSlidingCol() {

        throw new UnsupportedOperationException("Unimplemented method 'getSwordSlidingCol'");
    }

    @Override
    public int getSwordSlidingRow() {

        throw new UnsupportedOperationException("Unimplemented method 'getSwordSlidingRow'");
    }

    @Override
    public int getFlameJetCol() {

        throw new UnsupportedOperationException("Unimplemented method 'getFlameJetCol'");
    }

    @Override
    public int getFlameJetRow() {

        throw new UnsupportedOperationException("Unimplemented method 'getFlameJetRow'");
    }

    @Override
    public int getFireballCol() {

        throw new UnsupportedOperationException("Unimplemented method 'getFireballCol'");
    }

    @Override
    public int getFireballRow() {

        throw new UnsupportedOperationException("Unimplemented method 'getFireballRow'");
    }

    @Override
    public int getChargeCol() {
        return 12;
    }

    @Override
    public int getChargeRow() {
        return 1;
    }

}

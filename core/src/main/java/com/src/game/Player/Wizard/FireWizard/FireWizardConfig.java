package com.src.game.Player.Wizard.FireWizard;

import com.src.game.Player.Wizard.WizardConfig;

public class FireWizardConfig implements WizardConfig {
    private final String fire_wizard = "Player/FireWizard/";

    private final int idle_col = 7;
    private final int idle_row = 1;

    private final int walk_col = 6;
    private final int walk_row = 1;

    private final int running_col = 8;
    private final int running_row = 1;

    private final int dying_col = 6;
    private final int dying_row = 1;

    private final int attacking_fireball_col = 8;
    private final int attacking_fireball_row = 1;

    private final int sword_thrust_col = 4;
    private final int sword_thrust_row = 1;

    private final int sword_sliding_col = 4;
    private final int sword_sliding_row = 1;

    private final int jump_col = 9;
    private final int jump_row = 1;

    private final int fireball_col = 8;
    private final int fireball_row = 1;

    private final int flamejet_col = 14;
    private final int flamejet_row = 1;

    private final int charge_col = 12;
    private final int charge_row = 1;

    @Override
    public String getPath() {
        return fire_wizard;
    }

    @Override
    public int getWalkCol() {
        return walk_col;
    }

    @Override
    public int getWalkRow() {
        return walk_row;
    }

    @Override
    public int getRunningCol() {
        return running_col;
    }

    @Override
    public int getRunningRow() {
        return running_row;
    }

    @Override
    public int getDyingCol() {
        return dying_col;
    }

    @Override
    public int getDyingRow() {
        return dying_row;
    }

    @Override
    public int getAttackingCol() {
        return attacking_fireball_col;
    }

    @Override
    public int getAttackingRow() {
        return attacking_fireball_row;
    }

    @Override
    public int getIdleCol() {
        return idle_col;
    }

    @Override
    public int getIdleRow() {
        return idle_row;
    }

    @Override
    public int getJumpCol() {
        return jump_col;
    }

    @Override
    public int getJumpRow() {
        return jump_row;
    }

    public int getidle_col() {
        return idle_col;
    }

    public int getidle_row() {
        return idle_row;
    }

    public int getwalk_col() {
        return walk_col;
    }

    public int getwalk_row() {
        return walk_row;
    }

    public int getrunning_col() {
        return running_col;
    }

    public int getrunning_row() {
        return running_row;
    }

    public int getdying_col() {
        return dying_col;
    }

    public int getdying_row() {
        return dying_row;
    }

    public int getattacking_fireball_col() {
        return attacking_fireball_col;
    }

    public int getattacking_fireball_row() {
        return attacking_fireball_row;
    }

    public int getSwordThrustCol() {
        return sword_thrust_col;
    }

    public int getSwordThrustRow() {
        return sword_thrust_row;
    }

    public int getSwordSlidingCol() {
        return sword_sliding_col;
    }

    public int getSwordSlidingRow() {
        return sword_sliding_row;
    }

    public int getjump_col() {
        return jump_col;
    }

    public int getjump_row() {
        return jump_row;
    }

    @Override
    public int getFlameJetCol() {
        return flamejet_col;
    }

    @Override
    public int getFlameJetRow() {
        return flamejet_row;
    }

    @Override
    public int getFireballCol() {
        return fireball_col;
    }

    @Override
    public int getFireballRow() {
        return fireball_row;
    }

    @Override
    public int getChargeCol() {
        return charge_col;
    }

    @Override
    public int getChargeRow() {
        return charge_row;
    }

}

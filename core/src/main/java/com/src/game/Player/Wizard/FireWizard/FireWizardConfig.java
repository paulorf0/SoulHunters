package com.src.game.Player.Wizard.FireWizard;

import com.src.game.Player.Wizard.WizardConfig;

public class FireWizardConfig implements WizardConfig {
    private final String fire_wizard = "Player/FireWizard/";

    private final int fire_wizard_idle_col = 7;
    private final int fire_wizard_idle_row = 1;

    private final int fire_wizard_walk_col = 6;
    private final int fire_wizard_walk_row = 1;

    private final int fire_wizard_running_col = 8;
    private final int fire_wizard_running_row = 1;

    private final int fire_wizard_dying_col = 6;
    private final int fire_wizard_dying_row = 1;

    private final int fire_wizard_attacking_fireball_col = 8;
    private final int fire_wizard_attacking_fireball_row = 1;

    private final int fire_wizard_sword_thrust_col = 4;
    private final int fire_wizard_sword_thrust_row = 1;

    
    private final int fire_wizard_sword_sliding_col = 4;
    private final int fire_wizard_sword_sliding_row = 1;


    private final int fire_wizard_jump_col = 9;
    private final int fire_wizard_jump_row = 1;

    @Override
    public String getPath() {
        return fire_wizard;
    }

    @Override
    public int getWalkCol() {
        return fire_wizard_walk_col;
    }

    @Override
    public int getWalkRow() {
        return fire_wizard_walk_row;
    }

    @Override
    public int getRunningCol() {
        return fire_wizard_running_col;
    }

    @Override
    public int getRunningRow() {
        return fire_wizard_running_row;
    }

    @Override
    public int getDyingCol() {
        return fire_wizard_dying_col;
    }

    @Override
    public int getDyingRow() {
        return fire_wizard_dying_row;
    }

    @Override
    public int getAttackingCol() {
        return fire_wizard_attacking_fireball_col;
    }

    @Override
    public int getAttackingRow() {
        return fire_wizard_attacking_fireball_row;
    }

    @Override
    public int getIdleCol() {
        return fire_wizard_idle_col;
    }

    @Override
    public int getIdleRow() {
        return fire_wizard_idle_row;
    }

    @Override
    public int getJumpCol() {
        return fire_wizard_jump_col;
    }

    @Override
    public int getJumpRow() {
        return fire_wizard_jump_row;
    }

    public int getFire_wizard_idle_col() {
        return fire_wizard_idle_col;
    }

    public int getFire_wizard_idle_row() {
        return fire_wizard_idle_row;
    }

    public int getFire_wizard_walk_col() {
        return fire_wizard_walk_col;
    }

    public int getFire_wizard_walk_row() {
        return fire_wizard_walk_row;
    }

    public int getFire_wizard_running_col() {
        return fire_wizard_running_col;
    }

    public int getFire_wizard_running_row() {
        return fire_wizard_running_row;
    }

    public int getFire_wizard_dying_col() {
        return fire_wizard_dying_col;
    }

    public int getFire_wizard_dying_row() {
        return fire_wizard_dying_row;
    }

    public int getFire_wizard_attacking_fireball_col() {
        return fire_wizard_attacking_fireball_col;
    }

    public int getFire_wizard_attacking_fireball_row() {
        return fire_wizard_attacking_fireball_row;
    }

    public int getFire_wizard_sword_thrust_col() {
        return fire_wizard_sword_thrust_col;
    }

    public int getFire_wizard_sword_thrust_row() {
        return fire_wizard_sword_thrust_row;
    }  
      public int getFire_wizard_sword_sliding_col() {
        return fire_wizard_sword_sliding_col;
    }

    public int getFire_wizard_sword_sliding_row() {
        return fire_wizard_sword_sliding_row;
    }

    public int getFire_wizard_jump_col() {
        return fire_wizard_jump_col;
    }

    public int getFire_wizard_jump_row() {
        return fire_wizard_jump_row;
    }

}

package com.src.game.Player.Wizard.FireWizard;

import com.src.game.Player.Wizard.WizardConfig;

public class FireWizardConfig implements WizardConfig {
    public final String fire_wizard = "Player/FireWizard/";

    public final int fire_wizard_idle_col = 7;
    public final int fire_wizard_idle_row = 1;

    public final int fire_wizard_walk_col = 6;
    public final int fire_wizard_walk_row = 1;

    public final int fire_wizard_running_col = 8;
    public final int fire_wizard_running_row = 1;

    public final int fire_wizard_dying_col = 6;
    public final int fire_wizard_dying_row = 1;

    public final int fire_wizard_attacking_fireball_col = 8;
    public final int fire_wizard_attacking_fireball_row = 1;

    public final int fire_wizard_jump_col = 9;
    public final int fire_wizard_jump_row = 1;

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

}

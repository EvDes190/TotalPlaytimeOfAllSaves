package tptas;

import arc.struct.*;
import arc.util.*;
import mindustry.mod.*;
import mindustry.game.Saves.*;

import static mindustry.Vars.control;

public class TotalPlaytimeOfAllSaves extends Mod{
    Seq<SaveSlot> saves1 = control.saves.getSaveSlots();

    public TotalPlaytimeOfAllSaves(){
        getTime();
    }

    public void getTime() {
        long time = 0;
        control.saves.load();
        for (SaveSlot save : saves1) {
            time += save.meta.timePlayed;
            Log.info(save.getPlayTime() + " " + save.meta.timePlayed + " ms");
        }
        float time1 = (float) time / (1000 * 60 * 60);
        Log.info("[TPTAS] Total playtime of all saves: " + time1 + " hours");
    }

}


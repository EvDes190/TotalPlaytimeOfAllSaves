package tptas;

import arc.struct.*;
import arc.util.*;
import mindustry.mod.*;
import mindustry.game.Saves.*;

import static arc.util.Strings.formatMillis;
import static mindustry.Vars.control;

public class TotalPlaytimeOfAllSaves extends Mod{
    Seq<SaveSlot> saves1;

    public void getTime() {
        saves1 = control.saves.getSaveSlots();
        long time = 0;
        long sectorTime = 0;
        for (SaveSlot save : saves1) {
            time += save.meta.timePlayed;
            sectorTime += save.isSector() ? save.meta.timePlayed : 0;
            Log.info("[TPTAS] "+ save.getPlayTime() + " " + save.meta.timePlayed + " ms");
        }
        String time1 = formatMillis(time);
        String sectorTime1 = formatMillis(sectorTime);
        Log.info("[TPTAS] Total playtime of all saves: " + time1);
        Log.info("[TPTAS] Total playtime on campaign: " + sectorTime1);

    }

    @Override
    public void init() {
        super.init();
        getTime();
    }
}


package ground;

import java.util.ArrayList;
import java.util.List;
import location.Location;
import creature.Creature;
import formation.Formation;

public class Ground {
    private int maxY;
    private int maxX;

    private Creature [][] ground;

    private ArrayList<Formation> exists;
    private Location[] loc;

    public Ground() {
        this.maxY = 20;
        this.maxX = 20;
        this.ground = new Creature[this.maxY][this.maxX];
        this.exists = new ArrayList<Formation>();
    }

    public void addFormation(Formation f){
        this.exists.add(f);
        Creature[][] tmp = f.getContents();
        for (Creature[] t : tmp) {
            for (Creature tt : t) {
                int y = tt.getLoc().getY() + f.getLocation().getY();
                int x = tt.getLoc().getX() + f.getLocation().getX();
                ground[y][x] = tt;
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxY; i++){
            for (int j = 0; j < maxX; j++){
                sb.append(ground[i][j].toString());
                sb.append(" ");
            }
            sb.append("\n");
        }
        return  sb.toString();
    }
}

package de.mat2095.my_slither;
import java.awt.Color;
import java.util.Random;
import java.util.Random;
class Food {

    final int x, y;
    private final double size;
    private final double rsp;
    private final long spawnTime;
    private Color foodColour;
    Food(int x, int y, double size, boolean fastSpawn) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.rsp = fastSpawn ? 4 : 1;
        spawnTime = System.currentTimeMillis();
        foodColour = genColor();
    }

    double getSize() {
        return size;
    }

    double getRadius() {
        double fillRate = rsp * (System.currentTimeMillis() - spawnTime) / 1200;
        if (fillRate >= 1) {
            return size;
        } else {
            return (1 - Math.cos(Math.PI * fillRate)) / 2 * size;
        }
    }


    Color genColor()
    {
        Random r = new Random();
        int number = r.nextInt((2 - 1)+1) + 1;

        return (number == 1) ? Color.PINK: Color.BLUE;


    }

    public Color getFoodColour()
    {
        return foodColour;
    }
}

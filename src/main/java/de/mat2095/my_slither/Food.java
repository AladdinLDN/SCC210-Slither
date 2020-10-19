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
        int number = r.nextInt((9 - 1)+1) + 1;

        
        switch(number) {
            case 1:
                return new Color(0xb10000);
            case 2:
                return new Color(0x5800b1);
            case 3:
                return new Color(0x1cfaff);
            case 4:
                return new Color(0x1cffa9);
            case 5:
                return new Color(0xf4df60);
            case 6:
                return new Color(0xff88ff);
            case 7:
                return new Color(0xfe7955);
            case 8:
                return new Color(0xaf37ff);
            case 9:
                return new Color(0xfffdf3);

            default:
                return Color.BLACK;
        }

    }

    public Color getFoodColour()
    {
        return foodColour;
    }
}

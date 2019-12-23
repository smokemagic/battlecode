package battlecode.world.maps;

import battlecode.world.MapBuilder;

import java.io.IOException;

/**
 * Generate a map.
 */
public class FourLakeLand {

    // change this!!!
    public static final String mapName = "FourLakeLand";

    // don't change this!!
    public static final String outputDirectory = "engine/src/main/battlecode/world/resources/";

    private static int width;
    private static int height;

    /**
     * @param args unused
     */
    public static void main(String[] args) {
        try {
            makeSimple();
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("Generated a map!");
    }

    public static void makeSimple() throws IOException {
        width = 61;
        height = 41;
        MapBuilder mapBuilder = new MapBuilder(mapName, width, height, 4444);
        mapBuilder.setWaterLevel(0);
        mapBuilder.setSymmetry(MapBuilder.MapSymmetry.vertical);
        mapBuilder.addSymmetricHQ(10, 10);

        // create 4 nice lakes
        addLake(mapBuilder, 18, 20, 17); // creates 2
        addLake(mapBuilder, 30, 10, 17);
        addLake(mapBuilder, 30, 30, 17);

        // add some nice central soup
        addSoup(mapBuilder, 30, 20, 5, 10);
        // add some team soup
        addSoup(mapBuilder, 10, 30, 4, 5);

        for(int i = 0; i < mapBuilder.width; i++) {
            for (int j = 0; j < mapBuilder.height; j++) {
                mapBuilder.setSymmetricDirt(i, j, Math.min(50, 3+2*Math.min(Math.min(j,height-j-1),Math.min(i,width-i-1))));
            }
        }

        addRectangleDirt(mapBuilder, 28, 30, 32, 40, 3);

        // add a river to make things interesting

        mapBuilder.saveMap(outputDirectory);

    }

    public static void addRectangleDirt(MapBuilder mapBuilder, int xl, int yb, int xr, int yt, int v) {
        for (int i = xl; i < xr+1; i++) {
            for (int j = yb; j < yt+1; j++) {
                mapBuilder.setSymmetricDirt(i, j, v);
            }
        }
    }


    /*
     * Add a nice circular lake centered at (x,y).
     */
    public static void addSoup(MapBuilder mapBuilder, int x, int y, int r2, int v) {
        for (int xx = 0; xx < width; xx++) {
            for (int yy = 0; yy < height; yy++) {
                int d = (xx-x)*(xx-x)/2 + (yy-y)*(yy-y);
                if (d <= r2) {
                    mapBuilder.setSymmetricSoup(xx, yy, v*(d+v));
                }
            }
        }
    }

    /*
     * Add a nice circular lake centered at (x,y).
     */
    public static void addLake(MapBuilder mapBuilder, int x, int y, int r2) {
        for (int xx = 0; xx < width; xx++) {
            for (int yy = 0; yy < height; yy++) {
                int d = (xx-x)*(xx-x) + (yy-y)*(yy-y);
                if (d <= r2) {
                    mapBuilder.setSymmetricWater(xx, yy, true);
                }
            }
        }
    }
}

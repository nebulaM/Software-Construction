package drones;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class DroneLandings {

    /**
     * Determine the time it takes a drone to land given the landing procedure.
     *
     * @param x
     *            the starting x-coordinate for the drone
     * @param y
     *            the starting y-coordinate for the drone
     * @param platforms
     *            a list of obstructing platforms described as strings with
     *            three integer components. The first component of the string is
     *            the y-coordinate of the platform and the next two coordinates
     *            describe the width of the platform using the extreme
     *            x-coordinates.
     * @return
     */
    public static int timeToLand(int x, int y, String[] platforms) {
        if(platforms==null){
            return y;
        }
        int time=y;
        List<Platform> platformList=new ArrayList<>();
        for(String p : platforms) {
            String[] platCord=p.split(" ");
            platformList.add(new Platform(Integer.parseInt(platCord[0]),Integer.parseInt(platCord[1]),Integer.parseInt(platCord[2])));
        }
        List<Platform>sorted=platformList.stream().sorted(comparing(Platform::getY).reversed()).collect(Collectors.toList());
        for(Platform p : sorted){
            if(y>=p.getY() && x>=p.getX1() && x<=p.getX2()){
                time+=(p.getX2()-x);
                x=p.getX2();
            }

        }
        return time;
    }

    private static class Platform {
        private int xx1;
        private int xx2;
        private int yy;

        Platform(int y, int x1, int x2) {
            xx1 = x1;
            xx2 = x2;
            yy = y;
        }

        private int getY() {
            return yy;
        }

        private int getX1() {
            return xx1;
        }

        private int getX2() {
            return xx2;
        }

    }

}

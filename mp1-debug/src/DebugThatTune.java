// This is a program that can be used to test the basic functionality of the
// Guitar210 class.  It does not test all of the functionality.

public class DebugThatTune {
    public static final String KEYBOARD =
        "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";  // keyboard layout

    public static void main(String[] args) {
        Guitar g = new Guitar210();
        for (int i = 0; i < KEYBOARD.length(); i++) {
            int note = i - 12;
            System.out.println("Playing note " + note);
            g.playNote(note);
            advance(g, 4);
            char key = KEYBOARD.charAt(i);
            System.out.println("Plucking string '" + key + "'");
            if (g.hasString(key)) {
                g.pluck(key);
                advance(g, 4);
            } else {
                System.out.println("ERROR: not recognizing key '" + key + "'");
            }
            System.out.println("making an extra call on tic");
            // throw in an extra call on tic without calling time and sample
            g.tic();
            System.out.println();
        }
    }

    public static void advance(Guitar g, int tics) {
        for (int i = 0; i < tics; i++) {
            System.out.println("time " + g.time() + " sample = " + g.sample());
            g.tic();
        }
    }
}

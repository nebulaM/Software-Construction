// This class is used for debugging the Guitar210 class.  It is not an example
// to be emulated.  When a string is plucked, it is set to the integer part of
// the string's frequency.  As tic is called, it goes up or down by 10
// depending upon whether it is positive or negative respectively.

public class GuitarString {
    double value;
    double freq;

    public GuitarString(double frequency) {
        freq = frequency;
    }

    public void pluck() {
        value = (int) freq;
    }

    public void tic() {
        if (value < 0) {
            value = value + 10;
        } else if (value > 0) {
            value = value - 10;
        }
    }

    public double sample() {
        return value;
    }
}

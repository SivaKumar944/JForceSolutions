package beginner;

import com.sandwich.koan.Koan;

import static com.sandwich.koan.constant.KoanConstants.__;
import static com.sandwich.util.Assert.assertEquals;

public class AboutMethodPreference {

    class A {
        public String doStuff(int i) {
            return "int";
        }

        public String doStuff(Integer i) {
            return "Integer";
        }

        public String doStuff(Object i) {
            return "Object";
        }

        public String doStuff(int... i) {
            return "int vararg";
        }
    }

    @Koan
    public void methodPreferenceInt() {
        assertEquals(new A().doStuff(1), new A().doStuff(4));
    }

    @Koan
    public void methodPreferenceInteger() {
        assertEquals(new A().doStuff(Integer.valueOf(1)), new A().doStuff(Integer.valueOf(4)));
    }

    @Koan
    public void methodPreferenceLong() {
        long l = 1;
        assertEquals(new A().doStuff(l), new A().doStuff(l));
    }

    @Koan
    public void methodPreferenceBoxedLong() {
        Long l = Long.valueOf(1);
        assertEquals(new A().doStuff(l), new A().doStuff(l));
    }

    @Koan
    public void methodPreferenceDouble() {
        Double l = Double.valueOf(1);
        assertEquals(new A().doStuff(l), new A().doStuff(3.0));
    }

    @Koan
    public void methodPreferenceMore() {
        // What happens if you change 'Integer' to 'Double'
        // Does this explain 'methodPreferenceDouble'?
        // Think about why this happens?
        assertEquals(new A().doStuff(1, Integer.valueOf(2)),new A().doStuff(1, Integer.valueOf(4)));
    }
}

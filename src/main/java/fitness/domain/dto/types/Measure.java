package fitness.domain.dto.types;

import java.util.function.BiFunction;

/**
 * Created by Anton_Kramarev on 6/16/2017.
 */
public enum Measure implements BiFunction<Integer, Integer, Integer> {

    UNIT(1) {
        @Override
        public Integer apply(Integer productValue, Integer value) {
            return productValue * value;
        }
    }, WT(100) {
        @Override
        public Integer apply(Integer productValue, Integer lineValue) {
            return productValue * lineValue / 100;
        }
    };
    private final int defaultAmount;

    Measure(int defaultAmount) {
        this.defaultAmount = defaultAmount;
    }

    public int getDefaultAmount() {
        return defaultAmount;
    }
}

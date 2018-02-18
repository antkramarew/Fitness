package fitness.domain.dto.types;

import com.google.common.collect.ForwardingList;
import fitness.domain.dto.types.facts.Nutrition;

import java.util.List;
import java.util.Objects;

/**
 * Created by toxa on 7/29/2017.
 */
public class Nutritions<T extends Nutrition> extends ForwardingList<T> {

    private List<T> delegate;

    @Override
    protected List<T> delegate() {
        return delegate;
    }

    public Totals getTotals() {
        for (T t : delegate) {
            t.getTotals().
        }
    }

    public void addItem(T item) {
        if (Objects.nonNull(item)) {
            delegate.add(item);
        }
    }

    public Nutritions(List<T> delegate){
        this.delegate = delegate;
    }
}

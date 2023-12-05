package OOP_3;

import java.util.Iterator;
import java.util.List;

public abstract class Pharmacy implements Iterable<PharmancyComponent>, Comparable<Pharmacy> {
    private List<PharmancyComponent> components;
    public int index;

    public Pharmacy(List<PharmancyComponent> components) {
        this.components = components;
        this.index = 0;
    }

    @Override
    public Iterator<PharmancyComponent> iterator() {
        return new Iterator<PharmancyComponent>() {
            @Override
            public boolean hasNext() {
                return index < components.size();
            }

            @Override
            public PharmancyComponent next() {
                return components.get(index++);
            }
        };
    }

    public int getDrugPower() {
        int power = 0;
        for (PharmancyComponent component : components) {
            power += component.getPower();
        }
        return power;
    }

    @Override
    public String toString() {
        return String.format(
                "%s {components: %s, power: %s}%n",
                this.getClass().getSimpleName(),
                components, getDrugPower());
    }

    @Override
    public int compareTo(@NotNull Pharmacy o) {
        int power = getDrugPower();
        int comparison1 = Integer.compare(power, o.getDrugPower());

        return comparison1 == 0 ? compareComponents(o.components) : comparison1;
    }

    public int compareComponents(List<PharmancyComponent> componentsToCompare) {
        int comparedLess = 0;
        int comparedMore = 0;
        for (PharmancyComponent c : this.components) {
            for (PharmancyComponent c1 : componentsToCompare) {
                if (c.compareTo(c1) < 0)
                    comparedLess++;
                else if (c.compareTo(c1) > 0)
                    comparedMore++;
            }
        }
        return Integer.compare(comparedMore, comparedLess);
    }
}

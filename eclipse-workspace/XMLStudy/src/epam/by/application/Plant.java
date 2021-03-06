package epam.by.application;

import java.util.LinkedHashSet;
import java.util.Set;

public class Plant {
    private String id;
    private String name;
    private Soil soil;
    private String origin;
    private Set<AVisual> visual = new LinkedHashSet<AVisual>();
    private Set<AGrowingTips> growingTips = new LinkedHashSet<AGrowingTips>();
    private Multiplying multiplying;
    private Integer sortedElement;//averagePlantSize
    
    
    public Integer getSortedElement() {
        return sortedElement;
    }

    public void setSortedElement(Integer sortedElement) {
        this.sortedElement = sortedElement;
    }

    public Plant(String id, String name, Soil soil, String origin, Set<AVisual> visual, Set<AGrowingTips> growingTips,
            Multiplying multiplying) {
        this.id = id;
        this.name = name;
        this.soil = soil;
        this.origin = origin;
        this.visual = visual;
        this.growingTips = growingTips;
        this.multiplying = multiplying;
    }

    public Plant() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Soil getSoil() {
        return soil;
    }

    public void setSoil(Soil soil) {
        this.soil = soil;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Set<AVisual> getVisual() {
        return visual;
    }

    public void setVisual(Set<AVisual> visual) {
        this.visual = visual;
    }

    public Set<AGrowingTips> getGrowingTips() {
        return growingTips;
    }

    public void setGrowingTips(Set<AGrowingTips> growingTips) {
        this.growingTips = growingTips;
    }

    public Multiplying getMultiplying() {
        return multiplying;
    }

    public void setMultiplying(Multiplying multiplying) {
        this.multiplying = multiplying;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ID: ").append(getId()).append('\n');
        builder.append("Название растения: ").append(getName()).append('\n');
        builder.append("Почва для посадки: ").append(getSoil().getType()).append('\n');
        builder.append("Место происхождения растения: ").append(getOrigin()).append('\n');
        builder.append("Внешние параметры\n");
        for (AVisual visual: getVisual()) {
            builder.append('\t').append(visual.getName()).append(": ").append(visual.getValue()).append('\n');
        }
        builder.append("Предпочитаемые условия произрастания\n");
        for (AGrowingTips growingTips: getGrowingTips()) {
            builder.append('\t').append(growingTips.getName()).append(": ").append(growingTips.getValue()).append('\n');
        }
        builder.append("Размножение: ").append(getMultiplying().getType()).append('\n');
        return builder.toString();
    }

}

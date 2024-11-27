package de.arkem.clean.arc.demo.explosion.chart.adapter.in.api.resource;

public class EquipmentResource {

    private String code;
    private String label;

    public EquipmentResource() {}

    public EquipmentResource(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}

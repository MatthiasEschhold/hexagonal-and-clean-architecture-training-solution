package de.arkem.clean.arc.demo.explosion.chart.adapter.in.chart.provider;

import java.util.List;

public class ExplosionChartCreatedEvent {
    private int chartId;
    private String name;
    private int mainCategory;
    private String mainCategoryName;
    private int subCategory;
    private String subCategoryName;
    private String vehicleModel;
    private int constructionYearFrom;
    private int constructionYearTo;
    private List<String> spareParts;

    public int getChartId() {
        return chartId;
    }

    public void setChartId(int chartId) {
        this.chartId = chartId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(int mainCategory) {
        this.mainCategory = mainCategory;
    }

    public String getMainCategoryName() {
        return mainCategoryName;
    }

    public void setMainCategoryName(String mainCategoryName) {
        this.mainCategoryName = mainCategoryName;
    }

    public int getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(int subCategory) {
        this.subCategory = subCategory;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public int getConstructionYearFrom() {
        return constructionYearFrom;
    }

    public void setConstructionYearFrom(int constructionYearFrom) {
        this.constructionYearFrom = constructionYearFrom;
    }

    public int getConstructionYearTo() {
        return constructionYearTo;
    }

    public void setConstructionYearTo(int constructionYearTo) {
        this.constructionYearTo = constructionYearTo;
    }

    public List<String> getSpareParts() {
        return spareParts;
    }

    public void setSpareParts(List<String> spareParts) {
        this.spareParts = spareParts;
    }
}

package de.arkem.clean.arc.demo.vehicle.adapter.out.masterdata.dto;

public class VehicleDataDto {
    private String vehicleId;
    private EquipmentListDto equipmentListDto;
    private String originCountry;
    private Integer constructionYear;
    private String vehicleType;

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Integer getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(Integer constructionYear) {
        this.constructionYear = constructionYear;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public EquipmentListDto getEquipmentListDto() {
        return equipmentListDto;
    }

    public void setEquipmentListDto(EquipmentListDto equipmentListDto) {
        this.equipmentListDto = equipmentListDto;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }
}

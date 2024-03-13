package de.arkem.clean.arc.demo.app.vehicle.adapter.out.masterdata;

public class VehicleDataDto {
    private String vehicleIdentificationNumber;
    private EquipmentListDto equipmentListDto;
    private String originCountry;

    public String getVehicleIdentificationNumber() {
        return vehicleIdentificationNumber;
    }

    public void setVehicleIdentificationNumber(String vehicleIdentificationNumber) {
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
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

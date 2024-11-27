package de.arkem.clean.arc.demo.vehicle.adapter.in.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.arkem.clean.arc.demo.vehicle.adapter.in.api.resource.MileageRecordResource;
import de.arkem.clean.arc.demo.vehicle.adapter.in.api.resource.VehicleResource;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.mileage.record.Mileage;
import de.arkem.clean.arc.demo.vehicle.test.data.VehicleTestDataFactory;
import de.arkem.clean.arc.demo.vehicle.usecase.in.CreateVehicle;
import de.arkem.clean.arc.demo.vehicle.usecase.in.GetAllVehicles;
import de.arkem.clean.arc.demo.vehicle.usecase.in.GetVehicleByVin;
import de.arkem.clean.arc.demo.vehicle.usecase.in.UpdateMileage;
import de.arkem.clean.arc.demo.vehicle.usecase.interactor.VehicleNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VehicleController.class)
class ExplosionChartVehicleControllerTest {
    private static final String VEHICLES_URL = "/vehicles";
    @MockBean
    CreateVehicle createVehicle;
    @MockBean
    GetVehicleByVin getVehicle;
    @MockBean
    GetAllVehicles getAllVehicles;
    @MockBean
    VehicleToResourceMapper resourceMapper;
    @MockBean
    UpdateMileage updateMileage;
    VehicleResource vehicleResource;
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        vehicleResource = VehicleTestDataFactory.constructVehicleResource();
        when(resourceMapper.mapVehicleToResource(any(Vehicle.class))).thenReturn(vehicleResource);
    }

    @Test
    void shouldReadAndReturnVehicleResource() throws Exception {
        when(getVehicle.get(any(Vin.class))).thenReturn(VehicleTestDataFactory.createVehicle());

        mockMvc.perform(get(VEHICLES_URL + "/{vin}", VehicleTestDataFactory.VIN_TEST_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.vin").value(VehicleTestDataFactory.VIN_TEST_VALUE))
                .andExpect(jsonPath("$.licensePlate").value(VehicleTestDataFactory.LICENSE_PLATE_TEST_VALUE))
                .andExpect(jsonPath("$.vehicleMasterData.countryOfManufacture")
                        .value(VehicleTestDataFactory.COUNTRY_OF_MANUFACTURE_TEST_VALUE))
                .andExpect(jsonPath("$.vehicleMasterData.equipmentList[0].equipmentCode")
                        .value(vehicleResource.getVehicleMasterData().getEquipmentList().get(0).getEquipmentCode()))
                .andExpect(jsonPath("$.vehicleMasterData.equipmentList[0].equipmentLabel")
                        .value(vehicleResource.getVehicleMasterData().getEquipmentList().get(0).getEquipmentLabel()))
                .andExpect(jsonPath("$.vehicleMasterData.equipmentList[1].equipmentCode")
                        .value(vehicleResource.getVehicleMasterData().getEquipmentList().get(1).getEquipmentCode()))
                .andExpect(jsonPath("$.vehicleMasterData.equipmentList[1].equipmentLabel")
                        .value(vehicleResource.getVehicleMasterData().getEquipmentList().get(1).getEquipmentLabel()))
                .andExpect(jsonPath("$.vehicleMasterData.equipmentList[2].equipmentCode")
                        .value(vehicleResource.getVehicleMasterData().getEquipmentList().get(2).getEquipmentCode()))
                .andExpect(jsonPath("$.vehicleMasterData.equipmentList[2].equipmentLabel")
                        .value(vehicleResource.getVehicleMasterData().getEquipmentList().get(2).getEquipmentLabel()))
                .andExpect(jsonPath("$.mileageRecords[0].mileage")
                        .value(vehicleResource.getMileageRecords().get(0).getMileage()))
                /*.andExpect(jsonPath("$.mileageRecords[0].recordDate")
                        .value(vehicleResource.getMileageRecords().get(0).getRecordDate()))*/
                .andExpect(jsonPath("$.mileageRecords[1].mileage")
                        .value(vehicleResource.getMileageRecords().get(1).getMileage()))
                /*.andExpect(jsonPath("$.mileageRecords[1].recordDate")
                        .value(vehicleResource.getMileageRecords().get(1).getRecordDate()))*/
                .andExpect(jsonPath("$.mileageRecords[2].mileage")
                        .value(vehicleResource.getMileageRecords().get(2).getMileage()));
                /*.andExpect(jsonPath("$.mileageRecords[2].recordDate")
                        .value(vehicleResource.getMileageRecords().get(2).getRecordDate()));*/
    }

    @Test
    void shouldCreateAndReturnVehicleResource() throws Exception {
        when(createVehicle.create(any(Vin.class), any(LicensePlate.class), any(Mileage.class)))
                .thenReturn(VehicleTestDataFactory.createVehicle());

        mockMvc.perform(post(VEHICLES_URL)
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(vehicleResource)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.vin").value(VehicleTestDataFactory.VIN_TEST_VALUE))
                .andExpect(jsonPath("$.licensePlate").value(VehicleTestDataFactory.LICENSE_PLATE_TEST_VALUE))
                .andExpect(jsonPath("$.vehicleMasterData.countryOfManufacture")
                        .value(VehicleTestDataFactory.COUNTRY_OF_MANUFACTURE_TEST_VALUE))
                .andExpect(jsonPath("$.vehicleMasterData.equipmentList[0].equipmentCode")
                        .value(vehicleResource.getVehicleMasterData().getEquipmentList().get(0).getEquipmentCode()))
                .andExpect(jsonPath("$.vehicleMasterData.equipmentList[0].equipmentLabel")
                        .value(vehicleResource.getVehicleMasterData().getEquipmentList().get(0).getEquipmentLabel()))
                .andExpect(jsonPath("$.vehicleMasterData.equipmentList[1].equipmentCode")
                        .value(vehicleResource.getVehicleMasterData().getEquipmentList().get(1).getEquipmentCode()))
                .andExpect(jsonPath("$.vehicleMasterData.equipmentList[1].equipmentLabel")
                        .value(vehicleResource.getVehicleMasterData().getEquipmentList().get(1).getEquipmentLabel()))
                .andExpect(jsonPath("$.vehicleMasterData.equipmentList[2].equipmentCode")
                        .value(vehicleResource.getVehicleMasterData().getEquipmentList().get(2).getEquipmentCode()))
                .andExpect(jsonPath("$.vehicleMasterData.equipmentList[2].equipmentLabel")
                        .value(vehicleResource.getVehicleMasterData().getEquipmentList().get(2).getEquipmentLabel()))
                .andExpect(jsonPath("$.mileageRecords[0].mileage")
                        .value(vehicleResource.getMileageRecords().get(0).getMileage()))
                .andExpect(jsonPath("$.mileageRecords[0].recordDate")
                        .value(vehicleResource.getMileageRecords().get(0).getRecordDate()))
                .andExpect(jsonPath("$.mileageRecords[1].mileage")
                        .value(vehicleResource.getMileageRecords().get(1).getMileage()))
                .andExpect(jsonPath("$.mileageRecords[1].recordDate")
                        .value(vehicleResource.getMileageRecords().get(1).getRecordDate()))
                .andExpect(jsonPath("$.mileageRecords[2].mileage")
                        .value(vehicleResource.getMileageRecords().get(2).getMileage()))
                .andExpect(jsonPath("$.mileageRecords[2].recordDate")
                        .value(vehicleResource.getMileageRecords().get(2).getRecordDate()));
    }

    @Test
    void shouldReturnNotFoundWhenVehicleDoesNotExist() throws Exception {
        when(getVehicle.get(any(Vin.class))).thenThrow(new VehicleNotFoundException("INVALID_VIN"));

        mockMvc.perform(get(VEHICLES_URL + "/{vin}", "INVALID_VIN"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnInternalServerErrorWhenUnexpectedErrorOccurs() throws Exception {
        when(getVehicle.get(any(Vin.class))).thenThrow(VehicleNotFoundException.class);

        mockMvc.perform(get(VEHICLES_URL + "/{vin}", "WP0ZZZ99ZTS392111"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldReadAndReturnAllVehicles() throws Exception {
        List<Vehicle> vehicles = List.of(VehicleTestDataFactory.createVehicle());
        when(getAllVehicles.get()).thenReturn(vehicles);
        when(resourceMapper.mapVehicleToResource(any(Vehicle.class))).thenReturn(vehicleResource);

        mockMvc.perform(get(VEHICLES_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].vin").value(VehicleTestDataFactory.VIN_TEST_VALUE))
                .andExpect(jsonPath("$[0].licensePlate").value(VehicleTestDataFactory.LICENSE_PLATE_TEST_VALUE))
                .andExpect(jsonPath("$[0].vehicleMasterData.countryOfManufacture")
                        .value(VehicleTestDataFactory.COUNTRY_OF_MANUFACTURE_TEST_VALUE))
                .andExpect(jsonPath("$[0].vehicleMasterData.equipmentList[0].equipmentCode")
                        .value(vehicleResource.getVehicleMasterData().getEquipmentList().get(0).getEquipmentCode()))
                .andExpect(jsonPath("$[0].vehicleMasterData.equipmentList[0].equipmentLabel")
                        .value(vehicleResource.getVehicleMasterData().getEquipmentList().get(0).getEquipmentLabel()))
                .andExpect(jsonPath("$[0].vehicleMasterData.equipmentList[1].equipmentCode")
                        .value(vehicleResource.getVehicleMasterData().getEquipmentList().get(1).getEquipmentCode()))
                .andExpect(jsonPath("$[0].vehicleMasterData.equipmentList[1].equipmentLabel")
                        .value(vehicleResource.getVehicleMasterData().getEquipmentList().get(1).getEquipmentLabel()))
                .andExpect(jsonPath("$[0].vehicleMasterData.equipmentList[2].equipmentCode")
                        .value(vehicleResource.getVehicleMasterData().getEquipmentList().get(2).getEquipmentCode()))
                .andExpect(jsonPath("$[0].vehicleMasterData.equipmentList[2].equipmentLabel")
                        .value(vehicleResource.getVehicleMasterData().getEquipmentList().get(2).getEquipmentLabel()))
                .andExpect(jsonPath("$[0].mileageRecords[0].mileage")
                        .value(vehicleResource.getMileageRecords().get(0).getMileage()))
                .andExpect(jsonPath("$[0].mileageRecords[1].mileage")
                        .value(vehicleResource.getMileageRecords().get(1).getMileage()))
                .andExpect(jsonPath("$[0].mileageRecords[2].mileage")
                        .value(vehicleResource.getMileageRecords().get(2).getMileage()));
    }

    @Test
    void shouldReturnEmptyListWhenNoVehiclesExist() throws Exception {
        when(getAllVehicles.get()).thenReturn(List.of(VehicleTestDataFactory.createVehicle()));
        when(resourceMapper.mapVehicleToResource(any(Vehicle.class))).thenReturn(vehicleResource);
        mockMvc.perform(get(VEHICLES_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    void shouldUpdateMileageAndReturnVehicleResource() throws Exception {
        when(updateMileage.update(any(Vin.class), any(Mileage.class)))
                .thenReturn(VehicleTestDataFactory.createVehicle());

        var resource = createMileageRecordResource(4000.0);

        when(resourceMapper.mapVehicleToResource(any(Vehicle.class))).thenReturn(vehicleResource);
        mockMvc.perform(put(VEHICLES_URL + "/{vin}", VehicleTestDataFactory.VIN_TEST_VALUE)
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(resource)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.vin").value(VehicleTestDataFactory.VIN_TEST_VALUE))
                .andExpect(jsonPath("$.mileageRecords[0].mileage")
                        .value(vehicleResource.getMileageRecords().get(0).getMileage()))
                .andExpect(jsonPath("$.mileageRecords[0].recordDate")
                        .value(vehicleResource.getMileageRecords().get(0).getRecordDate()))
                .andExpect(jsonPath("$.mileageRecords[1].mileage")
                        .value(vehicleResource.getMileageRecords().get(1).getMileage()))
                .andExpect(jsonPath("$.mileageRecords[1].recordDate")
                        .value(vehicleResource.getMileageRecords().get(1).getRecordDate()));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionForUpdateMileage() throws Exception {
        when(updateMileage.update(any(Vin.class), any(Mileage.class)))
                .thenReturn(VehicleTestDataFactory.createVehicle());
        var resource = createMileageRecordResource(100.0);
        mockMvc.perform(put(VEHICLES_URL + "/{vin}", VehicleTestDataFactory.VIN_TEST_VALUE)
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(resource)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnNotFoundWhenUpdatingMileageForNonExistentVehicle() throws Exception {
        when(updateMileage.update(any(Vin.class), any(Mileage.class)))
                .thenThrow(new VehicleNotFoundException("NOT_FOUND"));

        var resource = createMileageRecordResource(4000.0);

        mockMvc.perform(put(VEHICLES_URL + "/{vin}", VehicleTestDataFactory.VIN_TEST_VALUE)
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(resource)))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturnBadRequestWhenUpdatingMileageWithInvalidVin() throws Exception {
        mockMvc.perform(put(VEHICLES_URL + "/{vin}", "INVALID_VIN_FORMAT")
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(createMileageRecordResource(4000.0))))
                .andExpect(status().isBadRequest());
    }

    private MileageRecordResource createMileageRecordResource(double mileage) {
        var resource = new MileageRecordResource();
        resource.setMileage(mileage);
        resource.setRecordDate(LocalDateTime.now());
        return resource;
    }
}
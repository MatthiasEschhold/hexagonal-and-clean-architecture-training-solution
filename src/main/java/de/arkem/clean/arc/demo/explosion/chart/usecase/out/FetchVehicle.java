package de.arkem.clean.arc.demo.explosion.chart.usecase.out;

import de.arkem.clean.arc.demo.explosion.chart.usecase.interactor.load.VehicleData;

public interface FetchVehicle {
    VehicleData fetch(String vin);
}

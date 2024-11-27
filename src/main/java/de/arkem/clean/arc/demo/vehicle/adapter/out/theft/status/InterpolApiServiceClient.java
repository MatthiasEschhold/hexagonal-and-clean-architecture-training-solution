package de.arkem.clean.arc.demo.vehicle.adapter.out.theft.status;

import de.arkem.clean.arc.demo.vehicle.domain.model.risk.rating.IsStolen;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.vehicle.usecase.out.DetectTheftStatus;
import org.springframework.stereotype.Component;

@Component
class InterpolApiServiceClient implements DetectTheftStatus {
    @Override
    public IsStolen detect(Vin vin) {
        return new IsStolen(false);
    }
}

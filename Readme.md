# Navigating Through the Demo

| Pattern or Practice                                         | Problem to Solve                                                                           | Reference(s)                                                                           |
|-------------------------------------------------------------|--------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------|
| Parameterized constructor for creating (root) entities      | Creating a (root) entity based on a paramized constructor                                  | _vehicle.domain.model_                                                                 |
| Static factory method for creating (root) entities          | Creating a (root) entity based on a static factory method                                  | _vehicle.domain.model_ & _garage.order.domain.model_                                   |
| ApplicationService within clean architecture pattern        | Resolve dependencies between root entities                                                 | _garage.order.application_                                                             |
| Domain Model implementation with domain-primitives          | Implement a self-validation domain model with reuseable validation based on abstract types | _garage.order.domain.model_ & _parts.catalog.domain.model_                             |
| Domain Model implementation java native with abstraction    | Implement a self-validation domain model without resusablitiy and java native validations  | _vehicle.domain.model_                                                                 |
| Two-Way mapping strategy with native mapping implementation | Implement a mapper in java native                                                          | _vehicle.adapter.out.db_, _vehicle.adapter.out.masterdata_  & _vehicle.adapter.in.api_ |
| Two-Way mapping strategy with mapstruct                     | Implement a mapper in java with mapstruct                                                  | WIP                                                                                    |
| Two-Way mapping strategy with orika                         | Implement a mapper in java with orika                                                      | WIP                                                                                    |
| Full Mapping strategy with command and query objects        | WIP                                                                                        | WIP                                                                                    |

## Creation of Domain Objects

| Trigger for Object Creation | Use Case Types              | Pattern                |
|-----------------------------|-----------------------------|------------------------|
| Adapter.In                  | create, update              | Static Factory Method  |
| Adapter.Out                 | read, load from database    | Paramized Constructor  |
| Adapter.Out                 | fetch (from exernal system) | Static Factory Mehthod |

```java
## Aggregate-Modul ExplosionChart

### Command as Use Case In Parameter
Examples:
- `CreateVehicleCommand`
- 
Decoupling:
- Each consumer has its own command model
- Full mapping strategy on the inbound application side and highly encapsulated domain model

## Applied Clean Code Principles by Example

### Single Responsibility Principle und Single Level of Abstraction Principle

**Class stereotype:** _ApplicationService_

**Example:** _ExplosionChartApplicationService_

#### Step 1: Single Responsibility Principle to the Outside

The class _ExplosionChartApplicationService_ has the responsibility to load an explosion chart. For this
purpose, it is necessary to fetch explosionChartVehicle data from the aggregate module _vehicle_.

| Responsibility Type          | Description                             |
|------------------------------|-----------------------------------------|
| Architectural responsibility | Resolve dependencies between Aggregates |
| Domain responsibility        | Load an explosion chart                 |

```java
package de.arkem.clean.arc.demo.parts.catalog.application;

import de.arkem.clean.arc.demo.explosion.chart.application.LoadExplosionChartQuery;
import de.arkem.clean.arc.demo.explosion.chart.application.model.ExplosionChartEquipment;
import model.application.de.arkem.clean.arc.demo.explosion.chart.ExplosionChartResponse;
import model.application.de.arkem.clean.arc.demo.explosion.chart.ExplosionChartVehicle;
import category.model.domain.de.arkem.clean.arc.demo.explosion.chart.CategoryNumber;
import in.usecase.de.arkem.clean.arc.demo.explosion.chart.LoadExplosionChart;

// the encapsulated dependencies to the explosionChartVehicle aggregate module
import de.arkem.clean.arc.demo.explosionChartVehicle.domain.model.explosionChartVehicle.Vin;
import de.arkem.clean.arc.demo.explosionChartVehicle.usecase.in.GetVehicleByVin;

public class ExplosionChartApplicationService {
    private final GetVehicleByVin getVehicleByVin; //use case in of explosionChartVehicle aggregate module
    private final LoadExplosionChart loadExplosionChart;

    public ExplosionChartApplicationService(GetVehicleByVin getVehicleByVin, LoadExplosionChart loadExplosionChart) {
        this.getVehicleByVin = getVehicleByVin;
        this.loadExplosionChart = loadExplosionChart;
    }

    public ExplosionChartResponse loadExplosionChart(LoadExplosionChartQuery query) {
        var explosionChartVehicle = getVehicleByVin.get(new Vin(query.vin()));

        var explosionChart = loadExplosionChart.load(new CategoryNumber(query.mainCategory()),
                new CategoryNumber(query.subCategory()),
                new model.domain.de.arkem.clean.arc.demo.explosion.chart.Vin(explosionChartVehicle.getVin().value()));

        var explosionChartVehicle = new ExplosionChartVehicle(explosionChartVehicle.getVin().value(),
                explosionChartVehicle.getVehicleMasterData()
                        .equipmentList().stream()
                        .map(equipment -> new ExplosionChartEquipment(equipment.equipmentCode().value(),
                                equipment.equipmentLabel().value()))
                        .collect(Collectors.toList()));

        return new ExplosionChartResponse(explosionChart.getMainCategory().getValue(),
                explosionChart.getSubCategory().getValue(),
                explosionChart.getName().getValue(),
                explosionChart.getSpareParts(),
                explosionChartVehicle);
    }
}

```

#### Step 2: Sharpen Single Responsibility Principle to the Inside

The code above is not only responsible for loading an explosion chart but also for mapping the explosionChartVehicle data 
between the involved aggregate modules (explosionChartVehicle and explosion chart). 
This is a violation of the Single Responsibility Principle in the origin sense. DeMarco defines the Single Responsibility Principle as follows:

> A class should have one, and only one, reason to change.

Below the code quality is improved by separating the mapping logic from the flow of control logic.
But there are still two responsibilities for change - the flow of control and the mapping logic.

```java
package de.arkem.clean.arc.demo.parts.catalog.application;

import de.arkem.clean.arc.demo.explosion.chart.application.LoadExplosionChartQuery;
import de.arkem.clean.arc.demo.explosion.chart.application.model.ExplosionChartEquipment;
import model.application.de.arkem.clean.arc.demo.explosion.chart.ExplosionChartResponse;
import model.application.de.arkem.clean.arc.demo.explosion.chart.ExplosionChartVehicle;
import category.model.domain.de.arkem.clean.arc.demo.explosion.chart.CategoryNumber;
import model.domain.de.arkem.clean.arc.demo.explosion.chart.ExplosionChart;
import in.usecase.de.arkem.clean.arc.demo.explosion.chart.LoadExplosionChart;

// the encapsulated dependencies to the explosionChartVehicle aggregate module
import de.arkem.clean.arc.demo.explosionChartVehicle.domain.model.explosionChartVehicle.Vehicle;
import de.arkem.clean.arc.demo.explosionChartVehicle.domain.model.explosionChartVehicle.Vin;
import de.arkem.clean.arc.demo.explosionChartVehicle.usecase.in.GetVehicleByVin;

public class ExplosionChartApplicationService {
    private final GetVehicleByVin getVehicleByVin; //use case in of explosionChartVehicle aggregate module
    private final LoadExplosionChart loadExplosionChart;

    public ExplosionChartApplicationService(GetVehicleByVin getVehicleByVin, LoadExplosionChart loadExplosionChart) {
        this.getVehicleByVin = getVehicleByVin;
        this.loadExplosionChart = loadExplosionChart;
    }

    public ExplosionChartResponse loadExplosionChart(LoadExplosionChartQuery query) {
        var explosionChartVehicle = getVehicleByVin.get(new Vin(query.vin()));

        var explosionChart = loadExplosionChart.load(new CategoryNumber(query.mainCategory()),
                new CategoryNumber(query.subCategory()),
                new model.domain.de.arkem.clean.arc.demo.explosion.chart.Vin(explosionChartVehicle.getVin().value()));

        return mapToExplosionChartResponse(explosionChart, explosionChartVehicle);
    }

    private ExplosionChartResponse mapToExplosionChartResponse(ExplosionChart explosionChart, Vehicle explosionChartVehicle) {
        var explosionChartVehicle = new ExplosionChartVehicle(explosionChartVehicle.getVin().value(),
                explosionChartVehicle.getVehicleMasterData()
                        .equipmentList().stream()
                        .map(equipment -> new ExplosionChartEquipment(equipment.equipmentCode().value(),
                                equipment.equipmentLabel().value()))
                        .collect(Collectors.toList()));

        return new ExplosionChartResponse(explosionChart.getMainCategory().getValue(),
                explosionChart.getSubCategory().getValue(),
                explosionChart.getName().getValue(),
                explosionChart.getSpareParts(),
                explosionChartVehicle);
    }
}

```
Additionally, the mapping logic cloud only be tested implicitly by testing the flow of control logic.

The solution is to shift the mapping logic into a separated class (class stereotype _Mapper_).
The mapper should be not accessible for other classes than the _ExplosionChartApplicationService_.

```java
package de.arkem.clean.arc.demo.parts.catalog.application;

import de.arkem.clean.arc.demo.explosion.chart.application.LoadExplosionChartQuery;
import de.arkem.clean.arc.demo.explosion.chart.application.model.ExplosionChartResponse;
import category.model.domain.de.arkem.clean.arc.demo.explosion.chart.CategoryNumber;
import in.usecase.de.arkem.clean.arc.demo.explosion.chart.LoadExplosionChart;

// the encapsulated dependencies to the explosionChartVehicle aggregate module
import de.arkem.clean.arc.demo.explosionChartVehicle.domain.model.explosionChartVehicle.Vin;
import de.arkem.clean.arc.demo.explosionChartVehicle.usecase.in.GetVehicleByVin;

public class ExplosionChartApplicationService {

    private final GetVehicleByVin getVehicleByVin; //use case in of explosionChartVehicle aggregate module
    private final LoadExplosionChart loadExplosionChart;
    private final ExplosionChartVehicleToVehicleMapper mapper;

    public ExplosionChartApplicationService(GetVehicleByVin getVehicleByVin, LoadExplosionChart loadExplosionChart, ExplosionChartVehicleToVehicleMapper mapper) {
        this.getVehicleByVin = getVehicleByVin;
        this.loadExplosionChart = loadExplosionChart;
        this.mapper = mapper;
    }

    public ExplosionChartResponse loadExplosionChart(LoadExplosionChartQuery query) {
        var explosionChartVehicle = getVehicleByVin.get(new Vin(query.vin()));

        var explosionChart = loadExplosionChart.load(new CategoryNumber(query.mainCategory()),
                new CategoryNumber(query.subCategory()),
                new model.domain.de.arkem.clean.arc.demo.explosion.chart.Vin(explosionChartVehicle.getVin().value()));

        return mapper.mapToExplosionChartResponse(explosionChart, explosionChartVehicle);
    }

}

```

```java
package de.arkem.clean.arc.demo.parts.catalog.application;

import model.domain.de.arkem.clean.arc.demo.explosion.chart.ExplosionChart;

// the encapsulated dependencies to the explosionChartVehicle aggregate module
import de.arkem.clean.arc.demo.explosionChartVehicle.domain.model.explosionChartVehicle.Vehicle;

class ExplosionChartVehicleToVehicleMapper {

    public ExplosionChartResponse mapToExplosionChartResponse(ExplosionChart explosionChart, Vehicle explosionChartVehicle) {
        var explosionChartVehicle = new ExplosionChartVehicle(explosionChartVehicle.getVin().value(),
                explosionChartVehicle.getVehicleMasterData()
                        .equipmentList().stream()
                        .map(equipment -> new ExplosionChartEquipment(equipment.equipmentCode().value(),
                                equipment.equipmentLabel().value()))
                        .collect(Collectors.toList()));

        return new ExplosionChartResponse(explosionChart.getMainCategory().getValue(),
                explosionChart.getSubCategory().getValue(),
                explosionChart.getName().getValue(),
                explosionChart.getSpareParts(),
                explosionChartVehicle);
    }
}

```

#### Step 3: Improve Readability based on Single Level of Abstraction Principle

The current implementation of the _ExplosionChartApplicationService_ has already clearly expressed
actions as part of the flow of control.

The part, where the explosion chart will be loaded, seems to be a weakness of this code snippet.
Here additional sub-actions comes into play, like creating domain objects and read out the information
from the query object. Of course this is no rocket sciense, but also simple things shifts the focus
aways from the main goal - understand the flow of control.

The flow of control should be expressed

```java
package de.arkem.clean.arc.demo.parts.catalog.application;

import de.arkem.clean.arc.demo.explosion.chart.application.LoadExplosionChartQuery;
import de.arkem.clean.arc.demo.explosion.chart.application.model.ExplosionChartResponse;
import category.model.domain.de.arkem.clean.arc.demo.explosion.chart.CategoryNumber;
import in.usecase.de.arkem.clean.arc.demo.explosion.chart.LoadExplosionChart;

// the encapsulated dependencies to the explosionChartVehicle aggregate module
import de.arkem.clean.arc.demo.explosionChartVehicle.domain.model.explosionChartVehicle.Vin;
import de.arkem.clean.arc.demo.explosionChartVehicle.usecase.in.GetVehicleByVin;

public class ExplosionChartApplicationService {

    private final GetVehicleByVin getVehicleByVin; //use case in of explosionChartVehicle aggregate module
    private final LoadExplosionChart loadExplosionChart;
    private final ExplosionChartVehicleToVehicleMapper mapper;

    public ExplosionChartApplicationService(GetVehicleByVin getVehicleByVin, LoadExplosionChart loadExplosionChart, ExplosionChartVehicleToVehicleMapper mapper) {
        this.getVehicleByVin = getVehicleByVin;
        this.loadExplosionChart = loadExplosionChart;
        this.mapper = mapper;
    }

    public ExplosionChartResponse loadExplosionChart(LoadExplosionChartQuery query) {
        var explosionChartVehicle = getVehicleByVin.get(new Vin(query.vin()));

        var explosionChart = loadExplosionChart.load(new CategoryNumber(query.mainCategory()),
                new CategoryNumber(query.subCategory()),
                new model.domain.de.arkem.clean.arc.demo.explosion.chart.Vin(explosionChartVehicle.getVin().value()));

        return mapper.mapToExplosionChartResponse(explosionChart, explosionChartVehicle);
    }

}

```
    
# Fitness Functions with ArchUnit
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
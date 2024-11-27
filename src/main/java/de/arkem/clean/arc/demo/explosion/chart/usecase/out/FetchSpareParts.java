package de.arkem.clean.arc.demo.explosion.chart.usecase.out;

import de.arkem.clean.arc.demo.explosion.chart.domain.model.SparePartNumber;
import de.arkem.clean.arc.demo.explosion.chart.usecase.interactor.load.SparePartData;

import java.util.List;

public interface FetchSpareParts {
    List<SparePartData> fetch(List<SparePartNumber> sparePartNumbers);
}

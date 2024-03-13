package de.arkem.clean.arc.demo.app.parts.catalog.adapter.in.api;

import de.arkem.clean.arc.demo.app.parts.catalog.adapter.in.api.resource.PartsCatalogViewResource;
import de.arkem.clean.arc.demo.app.parts.catalog.application.LoadPartsCatalogViewCommand;
import de.arkem.clean.arc.demo.app.parts.catalog.application.PartsCatalogViewApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parts-catalog-view")
public class PartsCatalogViewController {

    private final PartsCatalogViewToResourceMapper mapper;
    private final PartsCatalogViewApplicationService applicationService;

    public PartsCatalogViewController(PartsCatalogViewToResourceMapper mapper, PartsCatalogViewApplicationService applicationService) {
        this.mapper = mapper;
        this.applicationService = applicationService;
    }

    @GetMapping
    public ResponseEntity<PartsCatalogViewResource> getPartsCatalogView(@RequestParam Integer mainCategory,
                                                                        @RequestParam Integer subCategory,
                                                                        @RequestParam String vin) {
        LoadPartsCatalogViewCommand command = new LoadPartsCatalogViewCommand(mainCategory, subCategory, vin);
        return ResponseEntity.ok(mapper.mapToResource(applicationService.loadPartsCatalog(command)));
    }
}

package dio.marketplace.catalog.infrastructure.http;

import dio.marketplace.catalog.application.BrowseShowCaseUseCase;
import dio.marketplace.catalog.application.dto.EventOutput;
import dio.marketplace.catalog.domain.Event;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/showcase")
public class ShowcaseController {
    private final BrowseShowCaseUseCase browseShowCaseUseCase;

    public ShowcaseController(BrowseShowCaseUseCase browseShowCaseUseCase) {
        this.browseShowCaseUseCase = browseShowCaseUseCase;
    }

    @GetMapping
    List<EventOutput> browseShowCase() {
        return browseShowCaseUseCase.execute();
    }
}

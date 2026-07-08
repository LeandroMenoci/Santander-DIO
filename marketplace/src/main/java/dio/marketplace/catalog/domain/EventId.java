package dio.marketplace.catalog.domain;

import java.util.UUID;

public record EventId(UUID id) {
    public EventId(UUID id) {
        this.id = id;
    }
}

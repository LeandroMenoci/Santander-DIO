package dio.marketplace.catalog.infrastructure.event;

import dio.marketplace.catalog.infrastructure.persistence.entity.EventMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterDeleteEvent;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.stereotype.Component;

@Component
public class EventMetadataEventListener extends AbstractMongoEventListener<EventMetadata> {
    private static final Logger looger = LoggerFactory.getLogger(EventMetadataEventListener.class);

    @Override
    public void onAfterSave(AfterSaveEvent<EventMetadata> event) {
        looger.info("Event metadata save via onAfterSave {}", event.getDocument());
    }

    @Override
    public void onAfterDelete(AfterDeleteEvent<EventMetadata> event) {
        looger.info("Event metadata delete via onAfterDelete {}", event.getDocument());
    }
}

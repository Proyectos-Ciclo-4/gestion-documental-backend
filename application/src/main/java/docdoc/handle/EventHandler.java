package docdoc.handle;

import com.sofka.docs.events.DocumentCreated;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class EventHandler {
    @EventListener
    public void HandleCreate(DocumentCreated documentCreated){

    }
}

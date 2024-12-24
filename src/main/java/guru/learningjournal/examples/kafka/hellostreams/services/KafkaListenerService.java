package guru.learningjournal.examples.kafka.hellostreams.services;

import guru.learningjournal.examples.kafka.hellostreams.bindings.KafkaListenerBinding;
import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
// @Log4j2
// @Slf4j
@EnableBinding(KafkaListenerBinding.class)
public class KafkaListenerService {

    Logger logger = LoggerFactory.getLogger(KafkaListenerService.class);

    @StreamListener("input-channel-1")
    public void process(KStream<String, String> input) {
        input.foreach((k, v) -> logger.info(String.format("Key: %s, Value: %s", k, v)));
    }

}

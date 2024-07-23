package com.cryptomarket.cryptoanalyticmicroservice.conf;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import com.cryptomarket.cryptoanalyticmicroservice.kafka.CryptoBriefInfoKafkaDto;

@EnableKafka
@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic cryptocurrencyPricesTopic() {
        return TopicBuilder
                .name("cryptocurrency-prices")
                .partitions(5)
                .build();
    }

    @Bean
    public ConsumerFactory<String, CryptoBriefInfoKafkaDto> cryptoBriefInfoKafkaDtoConsumerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, ":9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "myGroup");
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        config.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        config.put(JsonDeserializer.USE_TYPE_INFO_HEADERS, false);
        config.put(JsonDeserializer.VALUE_DEFAULT_TYPE, CryptoBriefInfoKafkaDto.class.getName());
        return new DefaultKafkaConsumerFactory<>(config);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, CryptoBriefInfoKafkaDto> cryptoBriefInfoKafkaDtoKafkaListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, CryptoBriefInfoKafkaDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(cryptoBriefInfoKafkaDtoConsumerFactory());
        return factory;
    }
}

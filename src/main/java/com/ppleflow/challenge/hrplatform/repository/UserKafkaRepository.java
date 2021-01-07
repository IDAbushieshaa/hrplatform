package com.ppleflow.challenge.hrplatform.repository;

import com.ppleflow.challenge.hrplatform.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserKafkaRepository {

    private static final String USER_KAFKA_TOPIC = "UserKafkaTopic";

    private static final String USER_ID_FIELD = "UserID";
    private static final String USER_NAME_FIELD = "UserName";
    private static final String USER_CONTRACT_DETAILS_FIELD = "ContractDetails";
    private static final String USER_STATE_FIELD = "UserState";
    private static final String DB_OPERATION_FIELD = "Operation";

    @Autowired
    KafkaTemplate kafkaTemplate;

    public void publish(User user, String operation) {
        Map<String, Object> userDetails= new HashMap<>();
        userDetails.put(USER_ID_FIELD, user.getId());
        userDetails.put(USER_NAME_FIELD, user.getName());
        userDetails.put(USER_CONTRACT_DETAILS_FIELD, user.getContractDetails());
        userDetails.put(USER_STATE_FIELD, user.getState().name());
        userDetails.put(DB_OPERATION_FIELD, operation);

        kafkaTemplate.send(USER_KAFKA_TOPIC, userDetails);
    }
}

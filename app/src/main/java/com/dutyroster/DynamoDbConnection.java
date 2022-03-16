package com.dutyroster;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.dutyroster.models.Member;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DynamoDbConnection {

    final ObjectMapper objectMapper = new ObjectMapper();
    final String TABLE_NAME = "Members";
    final DynamoDB db;
    private Table dbTable;
    private int memberSize = 0;

    public int getMemberSize() {
        return memberSize;
    }

    public DynamoDbConnection() {
        AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard();
        builder.setRegion("us-east-1");
        db = new DynamoDB(builder.build());
        dbTable = db.getTable(TABLE_NAME);
        for (Item table : dbTable.scan()) {
            memberSize++;
        }
    }


    public Member getMemberById(int id) {
        Item result = dbTable.getItem("id", id);
        try {
            return objectMapper.readValue(result.toJSON(), Member.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}

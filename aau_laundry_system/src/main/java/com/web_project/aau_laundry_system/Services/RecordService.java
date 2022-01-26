package com.aaulaundary.aau_laundary_system.Services;

import java.util.List;

import com.aaulaundary.aau_laundary_system.models.Record;

public interface RecordService {
    public List<Record> getAllRecord();
    public String checkIfExists(String id,String name);
    public void updateRecordById(String id,Record record);
    public void createRecord(Record record);
    public void deleteRecordById(String id);
}

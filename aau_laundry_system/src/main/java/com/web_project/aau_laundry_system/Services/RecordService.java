package com.web_project.aau_laundry_system.Services;

import java.util.List;

import com.web_project.aau_laundry_system.models.Record;

public interface RecordService {
    public List<Record> getAllRecord();
    public String checkIfExists(String id,String name);
    public void updateRecordById(String id,Record record);
    public void createRecord(Record record);
    public void deleteRecordById(String id);
}

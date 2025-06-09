package com.aswathkannan.task1.model;

import java.util.*;

import lombok.*;




public class TaskExecution {
	private Date startTime;
	private Date endTime;
    private String output;
    
    
    public Date getStartTime() { return startTime; }
    public void setStartTime(Date startTime) { this.startTime = startTime; }

    public Date getEndTime() { return endTime; }
    public void setEndTime(Date endTime) { this.endTime = endTime; }

    public String getOutput() { return output; }
    public void setOutput(String output) { this.output = output; }
    

   
}

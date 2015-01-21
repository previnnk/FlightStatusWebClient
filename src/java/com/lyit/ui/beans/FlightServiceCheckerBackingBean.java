/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lyit.ui.beans;

import com.lyit.service.client.FlightCheckerService;
import com.lyit.service.client.FlightCheckerService_Service;
import com.lyit.service.client.LyitFlightCheckerboard;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Previn
 */
@ManagedBean(name = "FlightServiceCheckerBackingBean")
@SessionScoped
public class FlightServiceCheckerBackingBean implements java.io.Serializable{

    private List<LyitFlightCheckerboard> lyitFlightCheckerboardList;
    private String dateString;
    private String timeString;
    static final String DATE_FORMAT = "DATE_FORMAT";
    static final String TIME_FORMAT = "Time_FORMAT";
    private boolean arrivalFlag;
    private boolean departureFlag;
    private String errorDetail;
    private boolean successFlag = true;
private static final long serialVersionUID = -1;

    public String getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
    }

    public boolean isArrivalFlag() {
        return arrivalFlag;
    }

    public void setArrivalFlag(boolean arrivalFlag) {
        this.arrivalFlag = arrivalFlag;
    }

    public boolean isDepartureFlag() {
        return departureFlag;
    }

    public void setDepartureFlag(boolean departureFlag) {
        this.departureFlag = departureFlag;
    }

    public List<LyitFlightCheckerboard> getLyitFlightCheckerboardList() {
       this.successFlag = true;
        try {
            getFlightCheckerStatus();
        } catch (Exception ex) {
            System.out.println("Exception occured ! " + ex.getMessage());
           this.errorDetail = ex.getMessage();
           this.successFlag = false;
        }
        return lyitFlightCheckerboardList;
    }

    public boolean isSuccessFlag() {
        return successFlag;
    }

    public void setSuccessFlag(boolean successFlag) {
        this.successFlag = successFlag;
    }

    public void setLyitFlightCheckerboardList(List<LyitFlightCheckerboard> lyitFlightCheckerboardList) {
        this.lyitFlightCheckerboardList = lyitFlightCheckerboardList;
    }
    //@WebServiceRef(wsdlLocation="http://localhost:8080/FlightCheckerService/FlightCheckerService?wsdl")
    private Date currentTimeStamp;
    private String airportName = "Dublin";
    private FlightCheckerService flightCheckerService;
    private boolean pollEnabled = true;

    public String getDateString() {
        return this.getFormattedTimeStamp(DATE_FORMAT);
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public String getTimeString() {
        return this.getFormattedTimeStamp(TIME_FORMAT);
    }

    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }

    public Date getCurrentTimeStamp() {
        return currentTimeStamp;
    }

    public void setCurrentTimeStamp(Date currentTimeStamp) {
        this.currentTimeStamp = currentTimeStamp;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public FlightServiceCheckerBackingBean() {
        this.arrivalFlag = true;
        this.departureFlag = true;
        //getFlightCheckerStatus();
    }

    private void getFlightCheckerStatus() {
        flightCheckerService = new FlightCheckerService_Service().getFlightCheckerServicePort();
        lyitFlightCheckerboardList = flightCheckerService.getLyitFlightCheckerboardArray();
        List<LyitFlightCheckerboard> masterLyitFlightCheckerboardList = flightCheckerService.getLyitFlightCheckerboardArray();
        if (this.arrivalFlag && this.departureFlag) {
            lyitFlightCheckerboardList = masterLyitFlightCheckerboardList;
        } else if (this.arrivalFlag && !this.departureFlag) {
            lyitFlightCheckerboardList = new ArrayList<LyitFlightCheckerboard>();
            for (LyitFlightCheckerboard lyitFlightCheckerboard : masterLyitFlightCheckerboardList) {
                if (lyitFlightCheckerboard.getFromAirport().equalsIgnoreCase("DUB")) {
                    lyitFlightCheckerboardList.add(lyitFlightCheckerboard);
                }
            }
        } else if (!this.arrivalFlag && this.departureFlag) {
            lyitFlightCheckerboardList = new ArrayList<LyitFlightCheckerboard>();
            for (LyitFlightCheckerboard lyitFlightCheckerboard : masterLyitFlightCheckerboardList) {
                if (lyitFlightCheckerboard.getDestAirport().equalsIgnoreCase("DUB")) {
                    lyitFlightCheckerboardList.add(lyitFlightCheckerboard);
                }
            }
        } else {
            lyitFlightCheckerboardList = new ArrayList<LyitFlightCheckerboard>();
        }
        System.out.println("Webservice is getting called ..... " + (lyitFlightCheckerboardList == null ? "is null" : lyitFlightCheckerboardList.size()));
    }

    public boolean getPollEnabled() {
        return pollEnabled;
    }

    public void setPollEnabled(boolean pollEnabled) {
        this.pollEnabled = pollEnabled;
    }

    private String getFormattedTimeStamp(String timeType) {
        String formatedOutput = null;
        SimpleDateFormat dateFormat = null;
        if (timeType.equals(DATE_FORMAT)) {
            dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        } else {
            dateFormat = new SimpleDateFormat("HH:mm:ss");
        }
        formatedOutput = dateFormat.format(new Date());
        System.out.println(" 2. " + formatedOutput);
        return formatedOutput;

    }

}

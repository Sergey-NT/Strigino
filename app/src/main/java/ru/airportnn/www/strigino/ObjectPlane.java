package ru.airportnn.www.strigino;

public class ObjectPlane {

    public String planeFlight;
    public String planeDirection;
    public String planeType;
    public String planeTimePlan;
    public String planeTimeFact;
    public String planeStatus;
    public String planeBaggageStatus;
    public String planeGate;
    public String planeCheckIn;
    public String planeCombination;
    public String planeRoute;
    public String planeRouteStatus;
    public String planeAirline;
    public String registrationBegin;
    public String registrationEnd;
    public String checkInStatus;
    public String boardingStatus;
    public String boardingEnd;
    public boolean planeTracking;

    public ObjectPlane(String planeFlight, String planeDirection, String planeType, String planeTimePlan, String planeTimeFact, String planeStatus, boolean planeTracking, String planeBaggageStatus, String planeGate, String planeCheckIn, String planeCombination, String planeRoute, String planeRouteStatus, String registrationBegin, String registrationEnd, String checkInStatus, String boardingEnd, String boardingStatus, String planeAirline) {
        this.planeFlight = planeFlight;
        this.planeDirection = planeDirection;
        this.planeType = planeType;
        this.planeTimePlan = planeTimePlan;
        this.planeTimeFact = planeTimeFact;
        this.planeStatus = planeStatus;
        this.planeTracking = planeTracking;
        this.planeBaggageStatus = planeBaggageStatus;
        this.planeGate = planeGate;
        this.planeCheckIn = planeCheckIn;
        this.planeCombination = planeCombination;
        this.planeRoute = planeRoute;
        this.planeRouteStatus = planeRouteStatus;
        this.planeAirline = planeAirline;
        this.registrationBegin = registrationBegin;
        this.registrationEnd = registrationEnd;
        this.checkInStatus = checkInStatus;
        this.boardingEnd = boardingEnd;
        this.boardingStatus = boardingStatus;
    }

    public String getPlaneFlight() {
        return planeFlight;
    }

    public String getPlaneDirection() {
        return planeDirection;
    }

    public String getPlaneType() {
        return planeType;
    }

    public String getPlaneTimePlan() {
        return planeTimePlan;
    }

    public String getPlaneTimeFact() {
        return planeTimeFact;
    }

    public String getPlaneStatus() {
        return planeStatus;
    }

    public String getPlaneBaggageStatus() {
        return planeBaggageStatus;
    }

    public String getPlaneGate() {
        return planeGate;
    }

    public String getPlaneCheckIn() {
        return planeCheckIn;
    }

    public String getPlaneCombination() {
        return planeCombination;
    }

    public String getPlaneRoute() {
        return planeRoute;
    }

    public String getPlaneRouteStatus() {
        return planeRouteStatus;
    }

    public String getPlaneAirline() {
        return planeAirline;
    }

    public String getRegistrationBegin() {
        return registrationBegin;
    }

    public String getRegistrationEnd() {
        return registrationEnd;
    }

    public String getCheckInStatus() {
        return checkInStatus;
    }

    public String getBoardingStatus() {
        return boardingStatus;
    }

    public String getBoardingEnd() {
        return boardingEnd;
    }

    public boolean isPlaneTracking() {
        return planeTracking;
    }

    public void setPlaneTracking(boolean planeTracking) {
        this.planeTracking = planeTracking;
    }
}

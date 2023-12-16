package RoutesManagement.BusRoutes.model;
import java.time.DayOfWeek;
import java.time.LocalTime;
public class Route {

    private String id;

    private String busId;

    private String source;

    private String destination;

    private LocalTime startTime;

    private LocalTime endTime;

    private DayOfWeek weekday;

    public Route(String id, String busId, String source, String destination, LocalTime startTime, LocalTime endTime, DayOfWeek weekday) {
        this.id = id;
        this.busId = busId;
        this.source = source;
        this.destination = destination;
        this.startTime = startTime;
        this.endTime = endTime;
        this.weekday = weekday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public DayOfWeek getWeekday() {
        return weekday;
    }

    public void setWeekday(DayOfWeek weekday) {
        this.weekday = weekday;
    }
}

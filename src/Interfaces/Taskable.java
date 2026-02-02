package Interfaces;

import Enums.Status;

public interface Taskable {
    int getTaskEstimation();
    void setStatus(Status status);
    Status getStatus();
}

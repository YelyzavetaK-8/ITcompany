package interfaces;

import enums.Status;

public interface Taskable {
    int getTaskEstimation();
    void setStatus(Status status);
    Status getStatus();
}

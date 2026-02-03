package interfaces_temp;

import enums_temp.Status;

public interface Taskable {
    int getTaskEstimation();
    void setStatus(Status status);
    Status getStatus();
}

package it.bz.beacon.api.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class IssueCreation {

    @NotNull
    @Min(0)
    private long beaconId;

    @NotEmpty
    @NotNull
    private String problem;

    private String problemDescription;

    @NotEmpty
    @NotNull
    private String reporter;

    public long getBeaconId() {
        return beaconId;
    }

    public void setBeaconId(long beaconId) {
        this.beaconId = beaconId;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }
}

package com.twc.lando.cdvr.model;

/**
 * status for a Client-Device-Recording combination
 */
public class CDRStatus {

    private Long id;
    private String status;

    public CDRStatus() {
    }

    public void setId(Long theId) {
        this.id = theId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }
    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = (31 * result) + getStatus().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CDRStatus cdrs = (CDRStatus) o;
        if (!id.equals(cdrs.id) || !status.equals(cdrs.status)
                ) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ID:" + id + ",Status: " + status;
    }
}

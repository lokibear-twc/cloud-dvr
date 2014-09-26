package com.twc.lando.cdvr.model;

/**
 *
 */
public class OID {

    private Long id;

    public OID() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = (long)id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OID OID = (OID) o;
        if (!id.equals(OID.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id=" + id;
    }
}

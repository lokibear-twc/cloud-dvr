package com.twc.lando.cdvr.model;

/**
 *
 */
public class ClientDeviceRecording {

    // @todo factor out client and device into separate classes, we'll need them; use composition here instead.
    private Long client;
    private Long device;
    private Long recordingId;
    private String title;
    private String synopsis;
    private String details;
    private Long contentId;
    private String contentIdType;
    private Long boxArtId;

    public void setDevice(Long device) {
        this.device = device;
    }

    public void setClient(Long client) {
        this.client = client;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setRecordingId(Long recordingId) {
        this.recordingId = recordingId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public void setContentIdType(String contentIdType) {
        this.contentIdType = contentIdType;
    }

    public void setBoxArtId(Long boxArtId) {
        this.boxArtId = boxArtId;
    }

    public Long getClient() { return client; }

    public Long getDevice() {
        return device;
    }

    public String getTitle() {
        return title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getDetails() {
        return details;
    }

    public Long getRecordingId() {
        return recordingId;
    }

    public Long getContentId() {
        return contentId;
    }

    public String getContentIdType() {
        return contentIdType;
    }

    public Long getBoxArtId() {
        return boxArtId;
    }

    @Override
    public int hashCode() {
        int result = getClient().hashCode();
        result = (31 * result) + getDevice().hashCode();
        result = (31 * result) + getRecordingId().hashCode();
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

        ClientDeviceRecording recording = (ClientDeviceRecording) o;
        if (!getClient().equals(recording.client)
                || !getDevice().equals(recording.device)
                || !getRecordingId().equals(recording.recordingId)
                ) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Recording-ID:" + getRecordingId() + "Client: " + getClient() + ", Device: " + getDevice();
    }

}

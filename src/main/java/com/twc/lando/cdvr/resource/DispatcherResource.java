package com.twc.lando.cdvr.resource;

import com.twc.lando.cdvr.model.CDRStatus;
import com.twc.lando.cdvr.model.OID;
import com.twc.lando.cdvr.model.ClientDeviceRecording;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@Path("scheduler")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DispatcherResource {

    private static Map<OID, ClientDeviceRecording> recordings = new HashMap<>();
    private static Map<OID, CDRStatus> recordingStatus = new HashMap<>();

    /**
     *
     * @param theRecording
     * @return
     */
    @POST
    @Path("/recording")
    public Response startRecording(ClientDeviceRecording theRecording) {

        // publish an action to the device to start recording the given title
        // update status in the cache
        // publish status to the originating client
        // save status to database
        OID id = saveRecording(theRecording);
        return Response
                .ok(id)
                .status(Response.Status.CREATED)
                .build();
    }

    @PUT
    @Path("/status")
    public Response setStatus(CDRStatus status) {

        // update status in the cache (since this is a status change)
        // save status to database
        OID id = saveStatus(status);
        return Response
                .ok(id)
                .status(Response.Status.CREATED)
                .build();
    }

    @GET
    @Path("/recording")
    public Response getRecording(@QueryParam("id") int theId) {

        // this might actually be fetched from the cache, but is not targeted for initial round of
        // testing since storms are not expected for this request.
        // @todo if it's a cache miss, then what to do? dispatcher handles it with a notification in either event?
        OID id = new OID(); id.setId(theId);
        ClientDeviceRecording recording = recordings.get(id);
        if (recording != null) {
            return Response
                    .ok(recording)
                    .build();
        } else {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }
    }

    @GET
    @Path("/status")
    public Response getStatus(@QueryParam("id") int theId) {

        OID id = new OID(); id.setId(theId);
        CDRStatus status = recordingStatus.get(id);
        // @todo eventually want to publish the status asynchronously, vs returning it directly
        if (status != null) {
            return Response
                    .ok(status)
                    .build();
        } else {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }
    }

    /**
     *
     * @param theRecording
     * @return
     */
    private OID saveRecording(ClientDeviceRecording theRecording) {
        OID id = new OID(); id.setId(theRecording.hashCode());
        recordings.put(id, theRecording);
        return id;
    }

    /**
     *
     * @param status
     * @return
     */
    private OID saveStatus(CDRStatus status) {
        OID id = new OID(); id.setId(status.hashCode());
        recordingStatus.put(id, status);
        return id;
    }
}

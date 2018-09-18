/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.appdynamics.appdrestapi.queries;

import org.appdynamics.appdrestapi.resources.QueryEncoder;
import org.appdynamics.appdrestapi.resources.s;
import org.appdynamics.appdrestapi.util.RequestSnapshots;

/**
 *
 * @author gilbert.solorzano

 * 
 * 

 */

public class SnapshotQuery {
    
    /**
     * <p>
     *  This will be build the query for the Snapshots based on the application name.
     * </p>
     * 
     * @param baseURL Base controller URL
     * @param application Application name
     * @param start Start timestamp in milliseconds 
     * @param end End timestamp in milliseconds
     * @return URL for the REST API query
     */
    public static String queryRequestSnapshot(String baseURL, String application, long start, long end){
        StringBuilder val=new StringBuilder();
        val.append(baseURL).append(s.CONTROLLER_APPS);
        val.append(QueryEncoder.encode(application));
        val.append(s.URL_REQUEST_SNAPSHOTS);  
        
        //val.append(s.LAST_15_MINUTES);
        val.append(s.TIME_BETWEEN).append(s.TIME_START_TIME).append(start);
        val.append(s.TIME_END_TIME).append(end);
        val.append(s.SNAPSHOT_MAX_RESULTS).append(s.MAX_RESULT);

        return val.toString();
    }
    
    public static String queryRequestSnapshot(String baseURL, int application, long start, long end){
        StringBuilder val=new StringBuilder();
        val.append(baseURL).append(s.CONTROLLER_APPS);
        val.append(application);
        val.append(s.URL_REQUEST_SNAPSHOTS);  
        
        //val.append(s.LAST_15_MINUTES);
        val.append(s.TIME_BETWEEN).append(s.TIME_START_TIME).append(start);
        val.append(s.TIME_END_TIME).append(end);
        val.append(s.SNAPSHOT_MAX_RESULTS).append(s.MAX_RESULT);

        return val.toString();
    }

    //Support for detailed properties to be returned in snapshot
    public static String queryRequestSnapshot(String baseURL, String application, long start, long end, boolean needProps){
        StringBuilder val=new StringBuilder();
        val.append(baseURL).append(s.CONTROLLER_APPS);
        val.append(QueryEncoder.encode(application));
        val.append(s.URL_REQUEST_SNAPSHOTS);

        //val.append(s.LAST_15_MINUTES);
        val.append(s.TIME_BETWEEN).append(s.TIME_START_TIME).append(start);
        val.append(s.TIME_END_TIME).append(end);
        val.append(s.SNAPSHOT_NEED_PROPS).append(String.valueOf(needProps));
        val.append(s.SNAPSHOT_MAX_RESULTS).append(s.MAX_RESULT);

        return val.toString();
    }

    public static String queryRequestSnapshot(String baseURL, int application, long start, long end, boolean needProps){
        StringBuilder val=new StringBuilder();
        val.append(baseURL).append(s.CONTROLLER_APPS);
        val.append(application);
        val.append(s.URL_REQUEST_SNAPSHOTS);

        //val.append(s.LAST_15_MINUTES);
        val.append(s.TIME_BETWEEN).append(s.TIME_START_TIME).append(start);
        val.append(s.TIME_END_TIME).append(end);
        val.append(s.SNAPSHOT_NEED_PROPS).append(String.valueOf(needProps));
        val.append(s.SNAPSHOT_MAX_RESULTS).append(s.MAX_RESULT);

        return val.toString();
    }

    //Support to filter on Data Collector and Properties
    public static String queryRequestSnapshot(String baseURL, String application, long start, long end, boolean needProps, String dataCollectorName, String dataCollectorValue, String dataCollectorType){
        StringBuilder val=new StringBuilder();
        val.append(baseURL).append(s.CONTROLLER_APPS);
        val.append(QueryEncoder.encode(application));
        val.append(s.URL_REQUEST_SNAPSHOTS);

        //val.append(s.LAST_15_MINUTES);
        val.append(s.TIME_BETWEEN).append(s.TIME_START_TIME).append(start);
        val.append(s.TIME_END_TIME).append(end);
        val.append(s.SNAPSHOT_NEED_PROPS).append(String.valueOf(needProps));
        val.append(s.SNAPSHOT_DATA_COLLECTOR_NAME).append(dataCollectorName);
        val.append(s.SNAPSHOT_DATA_COLLECTOR_TYPE).append(QueryEncoder.encode(dataCollectorType));
        val.append(s.SNAPSHOT_DATA_COLLECTOR_VALUE).append(dataCollectorValue);
        val.append(s.SNAPSHOT_MAX_RESULTS).append(s.MAX_RESULT);

        return val.toString();
    }

    public static String queryRequestSnapshot(String baseURL, int application, long start, long end, boolean needProps, String dataCollectorName, String dataCollectorValue, String dataCollectorType){
        StringBuilder val=new StringBuilder();
        val.append(baseURL).append(s.CONTROLLER_APPS);
        val.append(application);
        val.append(s.URL_REQUEST_SNAPSHOTS);

        //val.append(s.LAST_15_MINUTES);
        val.append(s.TIME_BETWEEN).append(s.TIME_START_TIME).append(start);
        val.append(s.TIME_END_TIME).append(end);
        val.append(s.SNAPSHOT_NEED_PROPS).append(String.valueOf(needProps));
        val.append(s.SNAPSHOT_DATA_COLLECTOR_NAME).append(dataCollectorName);
        val.append(s.SNAPSHOT_DATA_COLLECTOR_TYPE).append(QueryEncoder.encode(dataCollectorType));
        val.append(s.SNAPSHOT_DATA_COLLECTOR_VALUE).append(dataCollectorValue);
        val.append(s.SNAPSHOT_MAX_RESULTS).append(s.MAX_RESULT);

        return val.toString();
    }
    
    //Support to filter on other properties
    public static String queryRequestSnapshot(String baseURL, String application, long start, long end, RequestSnapshots requestSnapshots){
        StringBuilder val=new StringBuilder();
        val.append(baseURL).append(s.CONTROLLER_APPS);
        val.append(QueryEncoder.encode(application));
        val.append(s.URL_REQUEST_SNAPSHOTS);
        
        val.append(requestSnapshots.getParameters());
        //val.append(s.LAST_15_MINUTES);
        val.append(s.TIME_BETWEEN).append(s.TIME_START_TIME).append(start);
        val.append(s.TIME_END_TIME).append(end);
        val.append(s.SNAPSHOT_MAX_RESULTS).append(s.MAX_RESULT);
        //val.append(QueryEncoder.encode(requestSnapshots.getParameters()));

        return val.toString();
    }

    public static String queryRequestSnapshot(String baseURL, int application, long start, long end, RequestSnapshots requestSnapshots){
        StringBuilder val=new StringBuilder();
        val.append(baseURL).append(s.CONTROLLER_APPS);
        val.append(application);
        val.append(s.URL_REQUEST_SNAPSHOTS);
        val.append(requestSnapshots.getParameters());
        //val.append(s.LAST_15_MINUTES);
        val.append(s.TIME_BETWEEN).append(s.TIME_START_TIME).append(start);
        val.append(s.TIME_END_TIME).append(end);
        val.append(s.SNAPSHOT_MAX_RESULTS).append(s.MAX_RESULT);

        return val.toString();
    }
    
}

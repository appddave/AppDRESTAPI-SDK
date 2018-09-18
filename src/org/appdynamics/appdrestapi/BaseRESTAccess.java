/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.appdynamics.appdrestapi;

import org.appdynamics.appdrestapi.data.AutoDiscoveryConfig;
import org.appdynamics.appdrestapi.queries.*;
import org.appdynamics.appdrestapi.data.*;
import org.appdynamics.appdrestapi.exportdata.*;
import org.appdynamics.appdrestapi.resources.*;
import org.appdynamics.appdrestapi.util.*;


import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author soloink
 * 
 * <p>The BaseRestAccess is going to have all of the base rest calls that are not metric base queries.</p>
 */
public class BaseRESTAccess {
    private static final Logger logger=Logger.getLogger(RESTAccess.class.getName());
    protected RESTBaseURL baseURL;
    protected RESTAuth auth;
    protected RESTExecuter R;
    
    
    /**
     * <p>
     * Returns a RESTAccess object that can be used to query the AppDynamics 
     * controller. This will default to the following :
     * useSSL false
     * account customer1
     * </p>
     * 
     * @param controllerURL FQDN of the controller
     * @param port Port the controller is using
     * @param username User to execute the query as
     * @param password Password to use with the connection
     */
    public BaseRESTAccess(String controllerURL, String port, String username, String password){
        baseURL=new RESTBaseURL(controllerURL, port);
        auth=new RESTAuth(username, password);
        R=new RESTExecuter(baseURL.getControllerURL());
    }
    
    /**
     * <p>
     * Returns a RESTAccess object that can be used to query the AppDynamics 
     * controller.This will default to the following :
     * account customer1
     * </p>
     * 
     * @param controllerURL FQDN of the controller
     * @param port Port the controller is using
     * @param ssl Use SSL
     * @param username User to execute the query as
     * @param password Password to use with the connection
     */
    public BaseRESTAccess(String controllerURL, String port, boolean ssl, String username, String password){
        baseURL=new RESTBaseURL(controllerURL, port, ssl);
        auth=new RESTAuth(username,password);
        R=new RESTExecuter(baseURL.getControllerURL());
    }
    
    /**
     * <p>
     * Returns a RESTAccess object that can be used to query the AppDynamics 
     * controller.This will default to the following :
     * useSSL false
     * </p>.
     * 
     * @param controllerURL FQDN of the controller
     * @param port Port the controller is using
     * @param username User to execute the query as
     * @param password Password to use with the connection
     * @param account Account name to use with the queries
     */
    public BaseRESTAccess(String controllerURL, String port, String username, String password, String account){
        baseURL=new RESTBaseURL(controllerURL, port);
        auth=new RESTAuth(username, password, account, true);
        R=new RESTExecuter(baseURL.getControllerURL());
    }
    
    /**
     * <p>
     * Returns a RESTAccess object that can be used to query the AppDynamics 
     * controller.
     * </p>
     * 
     * @param controllerURL FQDN of the controller
     * @param port Port the controller is using
     * @param ssl Use SSL
     * @param username User to execute the query as
     * @param password Password to use with the connection
     * @param account Account name to use with the queries
     */
    public BaseRESTAccess(String controllerURL, String port, boolean ssl, String username, String password, String account){
        baseURL=new RESTBaseURL(controllerURL, port, ssl);
        auth=new RESTAuth(username, password, account, true);
        R=new RESTExecuter(baseURL.getControllerURL());
        
    }
    
     /**
     * <p>
     * Returns a RESTAccess object that can be used to query the AppDynamics 
     * controller.
     * </p>
     * 
     * @param controllerURL FQDN of the controller
     * @param port Port the controller is using
     * @param ssl Use SSL
     * @param username User to execute the query as
     * @param password Password to use with the connection
     * @param account Account name to use with the queries
     * @param max_results This is the max results that we expect from a query, currently only applies to snapshots.
     */
    public BaseRESTAccess(String controllerURL, String port, boolean ssl, String username, String password, String account, int max_results){
        baseURL=new RESTBaseURL(controllerURL, port, ssl);
        auth=new RESTAuth(username, password, account, true);
        R=new RESTExecuter(baseURL.getControllerURL());
        s.MAX_RESULT = max_results;
    }
    
     /**
     * <p>
     * Returns a RESTAccess object that can be used to query the AppDynamics 
     * controller.
     * </p>
     * 
     * @param controllerURL FQDN of the controller
     * @param port Port the controller is using
     * @param ssl Use SSL
     * @param username User to execute the query as
     * @param password Password to use with the connection
     * @param account Account name to use with the queries
     * @param  proxy {@link RESTProxy} Proxy object with needed information
     */
    public BaseRESTAccess(String controllerURL, String port, boolean ssl, String username, String password, String account, RESTProxy proxy){
        baseURL=new RESTBaseURL(controllerURL, port, ssl);
        auth=new RESTAuth(username, password, account, true,proxy);
        R=new RESTExecuter(baseURL.getControllerURL());
        
    }
    
     /**
     * <p>
     * Returns a RESTAccess object that can be used to query the AppDynamics 
     * controller.
     * </p>
     * 
     * @param controllerURL FQDN of the controller
     * @param port Port the controller is using
     * @param ssl Use SSL
     * @param username User to execute the query as
     * @param password Password to use with the connection
     * @param account Account name to use with the queries
     * @param  proxy {@link RESTProxy} Proxy object with needed information
     * @param max_results This is the max results that we expect from a query, currently only applies to snapshots.
     */
    public BaseRESTAccess(String controllerURL, String port, boolean ssl, String username, String password, String account, RESTProxy proxy, int max_results){
        baseURL=new RESTBaseURL(controllerURL, port, ssl);
        auth=new RESTAuth(username, password, account, true,proxy);
        R=new RESTExecuter(baseURL.getControllerURL());
        s.MAX_RESULT = max_results;
    }
    
    /**
     * <p>
     * Turns debug level on, this will produce a lot of logging output and 
     * should only be run when troubleshooting an issue.
     * </p>
     * 
     * @param level Debug level 0-4, 0 being the default minimal logging
     */
    public void setDebugLevel(int level){
        if(level >= 0 || level < 4) s.debugLevel=level;
    }
    
        
    /**
     * <p>
     * Returns the list of application in the controller for the account provided in the authentication.
     * </p>
     * 
     * @return {@link Applications}
     */
    public Applications getApplications(){
        try{
            return R.executeApplicationQuery(auth, ApplicationQuery.queryAllApplications(baseURL.getControllerURL()));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        return null;
    }
    
    /**
     * <p>
     * This will return a string of the AppDynamics application export based on the
     * application id given.
     * </p>
     * 
     * @param appId Id of the application 
     * @return {@link String}
     */
    public String getApplicationExportById(int appId){
        try{
            return R.executeApplicationExportByIdQuery(auth, ApplicationExportQuery.queryApplicationExportByID(baseURL.getControllerURL(), appId));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }
    
    /**
     * <p>
     * This will return a Java object of the AppDynamics application export based on the
     * application id given. This can then be used to extract or check on configuration.
     * </p>
     * 
     * 
     * @param appId Id of the application 
     * @return {@link ExApplication}
     */
    public ExApplication getApplicationExportObjById(int appId){
        try{
            return R.executeApplicationExportObjByIdQuery(auth, ApplicationExportQuery.queryApplicationExportByID(baseURL.getControllerURL(), appId));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }
    
     /**
     * <p>
     * This will return a Dashboard object which consists of a name, value (xml string) and boolean exists
     * that checks to insure the dashboard exists.
     * </p>
     * 
     * @param dashId Id of the application 
     * @return {@link Dashboard}
     */
    public Dashboard getDashboardObjExportById(int dashId){
        try{
            return R.executeDashboardObjExportByIdQuery(auth, DashboardQuery.queryDashboardExportById(baseURL.getControllerURL(), dashId));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }
    
    /**
     * <p>
     * This will return a Dashboard object which consists of a name, value (xml string) and boolean exists
     * that checks to insure the dashboard exists.
     * </p>
     * 
     * @param dashId Id of the application 
     * @return {@link Dashboard}
     */
    public String getDashboardExportById(int dashId){
        try{
            return R.executeDashboardExportByIdQuery(auth, DashboardQuery.queryDashboardExportById(baseURL.getControllerURL(), dashId));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }
    
    /**
     * <p>
     * This will return the list of the metric base paths available for example:
     * </p>

     * 
     *  <ul>
            <li>metric-items
     *          <ul>   <li>metric-item
		   <ul><li>name = Business Transaction Performance
		   <li>type = folder</ul>
                </ul>
	<ul>   <li>metric-item
		   <ul><li>name = Mobile
		   <li>type = folder<li></ul></ul>
	<ul>   <li>metric-item
		   <ul><li>name = Overall Application Performance
		   <li>type = folder<li></ul></ul>
	<ul>   <li>metric-item
		   <ul><li>name = Service End Points
		   <li>type = folder<li></ul></ul>
	<ul>   <li>metric-item
		   <ul><li>name = End User Experience
		   <li>type = folder<li></ul></ul>
	<ul>   <li>metric-item
		   <ul><li>name = Backends
		   <li>type = folder<li></ul></ul>
	<ul>   <li>metric-item
		   <ul><li>name = Information Points
		   <li>type = folder<li></ul></ul>
	<ul>   <li>metric-item
		   <ul><li>name = Errors
		   <li>type = folder<li></ul></ul>
	<ul>   <li>metric-item
		   <ul><li>name = Application Infrastructure Performance
		   <li>type = folder<li></ul></ul>


        </ul>
     *
     *  <p>
     *      These paths can then be used to traverse custom metrics paths with AppDynamics.
     *  </p>
     * 
     * @param application Name of the application
     * @return {@link MetricItems}
     * 
     */
    public MetricItems getBaseMetricList(String application){
        try{
            MetricItems mis = R.executeMetricItems(auth, MetricItemQuery.queryMetricList(baseURL.getControllerURL(), application));
            mis.setParent(s._S);
            return mis;
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }
    
    /**
     * <p>
     * This will allow the user to provide the metric path they wish to walk. 
     * The metricPaths parameter is the metric path and needs to be separated by the character '|'.
     * </p>
     * 
     *  <ul><li>metric-items
	<ul>   <li>metric-item
	<ul>	   <li>name = Business Transactions
		   <li>type = folder</ul></ul>
	<ul><li>   metric-item
	<ul>	   <li>name = Business Transaction Groups
		   <li>type = folder</ul></ul>
        </ul>     * 
      
        <p>
        As long as the metric-item type is "folder" you can add it to the path
        of the metric path separated by '|'. Once you reach the type "leaf" you can 
        request the metric using {@link #getBaseMetricListPath(String, String) getBaseMetricListPath}
        </p>
	<ul><li>metric-item
	<ul>	<li>name = Average CPU Used (ms)
		<li>type = leaf</ul></ul>

     * 
     * 
     * @param application Name of the application
     * @param metricPath Metric path to the metric list requested
     * @return {@link MetricItems}
     * 
     */
    public MetricItems getBaseMetricListPath(String application, String metricPath){
        try{
            MetricItems mis = R.executeMetricItems(auth, MetricItemQuery.queryMetricListForPath(baseURL.getControllerURL(), application,metricPath));
            mis.setParent(metricPath);
            return mis;
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }

    
    /**
     * <p>
     * Returns the Business Transactions for an application name given.
     * </p>
     * @param application Name of the application
     * @return {@link BusinessTransactions}
     * 
     */
    public BusinessTransactions getBTSForApplication(String application){
        try{
            return R.executeBusinessTransactionQuery(auth, BusinessTransactionQuery.queryBTSFromApps(baseURL.getControllerURL(), application));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }
    
    /**
     * <p>
     * Returns the Business Transactions for an application id given.
     * </p>
     * @param appId The id for the application
     * @return {@link BusinessTransactions}
     * 
     */
    public BusinessTransactions getBTSForApplication(int appId){
        try{
            return R.executeBusinessTransactionQuery(auth, BusinessTransactionQuery.queryBTSFromApps(baseURL.getControllerURL(), appId));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }

    /**
     *
     * <p>
     * Returns the Business Transaction for application name and business transaction id given.
     * </p>
     * 
     * @param application Name of the application
     * @param btId Id of the Business Transaction
     * @return {@link BusinessTransactions}
     * 
     */
    public BusinessTransactions getBTForApplication(String application,int btId){
        try{
            return R.executeBusinessTransactionQuery(auth, BusinessTransactionQuery.queryBTFromApps(baseURL.getControllerURL(), application, btId));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }

    /**
     *
     * <p>
     * Returns the Business Transaction for application id and business transaction id given.
     * </p>
     * 
     * @param appId The id for the application
     * @param btId Id of the Business Transaction
     * @return {@link BusinessTransactions}
     */
    public BusinessTransactions getBTForApplication(int appId,int btId){
        try{
            return R.executeBusinessTransactionQuery(auth, BusinessTransactionQuery.queryBTFromApps(baseURL.getControllerURL(), appId, btId));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }

    
    /**
     * 
     * <p>
     * Returns the list of snapshots for the application name given.
     * </p>
     * 
     * @param application Name of the application
     * @param start Timestamp of the start time
     * @param end Timestamp of the end time
     * @return {@link Snapshots}
     * 
     */
    public Snapshots getSnapshots(String application, long start, long end){
        try{
            return R.executeSnapshots(auth, SnapshotQuery.queryRequestSnapshot(baseURL.getControllerURL(), application, start, end));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }
    
    /**
     * 
     * <p>
     * Returns the list of snapshots for the application id given.
     * </p>
     * 
     * @param application Id of the application
     * @param start Timestamp of the start time
     * @param end Timestamp of the end time
     * @return {@link Snapshots}
     * 
     */
    public Snapshots getSnapshots(int application, long start, long end){
        try{
            return R.executeSnapshots(auth, SnapshotQuery.queryRequestSnapshot(baseURL.getControllerURL(), application, start, end));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }
    
    /**
     * <p>
     * Returns the list of snapshot for the application id given and filtering provided in the RequestSnapshots object.
     * </p>
     * 
     * @param application Id of the application
     * @param start Timestamp of the start time
     * @param end Timestamp of the end time
     * @param req {@link RequestSnapshots}
     * @return {@link Snapshots}
     */
    public Snapshots getSnapshots(int application, RequestSnapshots req, long start, long end){
        try{
            return R.executeSnapshots(auth, SnapshotQuery.queryRequestSnapshot(baseURL.getControllerURL(), application, start, end, req));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }
    
    /**
     * <p>
     * Returns the list of snapshot for the application id given and filtering provided in the RequestSnapshots object.
     * </p>
     * 
     * @param application Name of the application
     * @param start Timestamp of the start time
     * @param end Timestamp of the end time
     * @param req {@link RequestSnapshots}
     * @return {@link Snapshots}
     */
    public Snapshots getSnapshots(String application, RequestSnapshots req, long start, long end){
        try{
            return R.executeSnapshots(auth, SnapshotQuery.queryRequestSnapshot(baseURL.getControllerURL(), application, start, end, req));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }

    /**
     *
     * <p>
     * Returns the list of snapshots with detailed snapshot properties for the application name given.
     * </p>
     * 
     * @param application Name of the application
     * @param start Timestamp of the start time
     * @param end Timestamp of the end time
     * @param needProps Return Detailed Properties in Snapshot
     * @return {@link Snapshots}
     * 
     */
    public Snapshots getSnapshots(String application, long start, long end, boolean needProps){
        try{
            return R.executeSnapshots(auth, SnapshotQuery.queryRequestSnapshot(baseURL.getControllerURL(), application, start, end, needProps));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }

    /**
     *
     * <p>
     * Returns the list of snapshots with detailed snapshot properties for the application id. 
     * </p>
     * 
     * @param application Id of the application
     * @param start Timestamp of the start time
     * @param end Timestamp of the end time
     * @param needProps Return Detailed Properties in Snapshot
     * @return {@link Snapshots}
     */
    public Snapshots getSnapshots(int application, long start, long end, boolean needProps){
        try{
            return R.executeSnapshots(auth, SnapshotQuery.queryRequestSnapshot(baseURL.getControllerURL(), application, start, end, needProps));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }

    /**
     *
     * <p>
     * Returns the list of snapshots with detailed snapshot properties for the application name with additional parameters.
     * </p>
     * 
     * @param application Name of the application
     * @param start Timestamp of the start time
     * @param end Timestamp of the end time
     * @param needProps Return Detailed Properties in Snapshot

     * @param dataCollectorName Name of the data collector
     * @param dataCollectorType Type of the data collector
     * @param dataCollectorValue Value of the data collector
     * @return {@link Snapshots}
     * 
     */
    public Snapshots getSnapshots(String application, long start, long end, boolean needProps, String dataCollectorName, String dataCollectorValue, String dataCollectorType){
        try{
            return R.executeSnapshots(auth, SnapshotQuery.queryRequestSnapshot(baseURL.getControllerURL(), application, start, end, needProps, dataCollectorName, dataCollectorValue, dataCollectorType));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }

    /**
     *
     * <p>
     * Returns the list of snapshots with detailed snapshot properties for the application id with additional parameters.
     * </p>
     * 
     * @param application Id of the application
     * @param start Timestamp of the start time
     * @param end Timestamp of the end time
     * @param needProps Return Detailed Properties in Snapshot
     * @param dataCollectorName Name of the data collector
     * @param dataCollectorType Type of the data collector
     * @param dataCollectorValue Value of the data collector
     * @return {@link Snapshots}
     * 
     */
    
    public Snapshots getSnapshots(int application, long start, long end, boolean needProps, String dataCollectorName, String dataCollectorValue, String dataCollectorType){
        try{
            return R.executeSnapshots(auth, SnapshotQuery.queryRequestSnapshot(baseURL.getControllerURL(), application, start, end, needProps, dataCollectorName, dataCollectorValue, dataCollectorType));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }
    
    /**
     * <p>
     * Returns the tiers for an application name given.
     * </p>
     * 
     * @param application Name of the application
     * @return {@link Tiers}
     * 
     */
    public Tiers getTiersForApplication(String application){
        try{
            return R.executeTierQuery(auth, TierQuery.queryTiersFromApps(baseURL.getControllerURL(), application));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }
    
    /**
     * <p>
     * Returns the list of tiers for an application id given.
     * </p>
     * @param application ExApplication id
     * @return {@link Tiers}
     */
    public Tiers getTiersForApplication(int application){
        try{
            return R.executeTierQuery(auth, TierQuery.queryTiersFromApps(baseURL.getControllerURL(), application));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }

    /**
     *
     * <p>
     * Return the tier for the application name and tier id given.
     * </p>
     * 
     * @param application Name of the application
     * @param tierId ID of the Tier
     * @return {@link Tiers}
     */
    public Tiers getTierForApplication(String application, int tierId){
        try{
            return R.executeTierQuery(auth, TierQuery.queryTierFromApps(baseURL.getControllerURL(), application,tierId));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }

    /**
     * 
     * <p>
     * Return the tier for the application id and tier id given.
     * </p>
     * 
     * @param application ExApplication id
     * @param tierId ID of the Tier
     * @return {@link Tiers}
     */
    public Tiers getTierForApplication(int application, int tierId){
        try{
            return R.executeTierQuery(auth, TierQuery.queryTierFromApps(baseURL.getControllerURL(), application, tierId));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }

    /**
     *  
     * <p>
     * Return the list of nodes for the application name and tier name given.
     * </p>
     * 
     * @param application Name of the application
     * @param tier Name of the tier
     * @return {@link Nodes}
     */
    public Nodes getNodesFromTier(String application, String tier){
        try{
            return R.executeNodeQuery(auth, TierQuery.queryNodesFromTier(baseURL.getControllerURL(), application,tier));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }
    
    /**
     *  
     * <p>
     * Return the list of nodes for the application id and tier name given.
     * </p>
     * 
     * @param application Id of the application
     * @param tier Name of the tier
     * @return {@link Nodes}
     */
    public Nodes getNodesFromTier(int application, String tier){
        try{
            return R.executeNodeQuery(auth, TierQuery.queryNodesFromTier(baseURL.getControllerURL(), application,tier));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }
    
    /**
     *  
     * <p>
     * Return the list of nodes for the application name and tier id given.
     * </p>
     * 
     * @param application Name of the application
     * @param tier Id of the tier
     * @return {@link Nodes}
     */
    public Nodes getNodesFromTier(String application, int tier){
        try{
            return R.executeNodeQuery(auth, TierQuery.queryNodesFromTier(baseURL.getControllerURL(), application,tier));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }
    
    /**
     * 
     * <p>
     * Return the list of nodes for the application id and tier id given.
     * </p>
     * 
     * @param application Id of the application
     * @param tier Id of the tier
     * @return {@link Nodes}
     */
    public Nodes getNodesFromTier(int application, int tier){
        try{
            return R.executeNodeQuery(auth, TierQuery.queryNodesFromTier(baseURL.getControllerURL(), application,tier));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }
    
    
    /**
     * <p>
     * Returns the nodes for an application name given.
     * </p>
     * 
     * @param application Name of the application
     * @return {@link Nodes}
     */
    public Nodes getNodesForApplication(String application){
        try{
            return R.executeNodeQuery(auth, NodeQuery.queryNodesFromApps(baseURL.getControllerURL(), application));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }
    
    /**
     * <p>
     * Returns the nodes for an application id given.
     * </p>
     * 
     * @param application Id of the application 
     * @return {@link Nodes}
     */
    public Nodes getNodesForApplication(int application){
        try{
            return R.executeNodeQuery(auth, NodeQuery.queryNodesFromApps(baseURL.getControllerURL(), application));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }

    /**
     *
     * <p>
     * Returns the node for the application name and node id given.
     * </p>
     * 
     * @param application Name of the application
     * @param nodeId id of the Node
     * @return {@link Nodes}
     */
    public Nodes getNodeForApplication(String application, int nodeId){
        try{
            return R.executeNodeQuery(auth, NodeQuery.queryNodeFromApps(baseURL.getControllerURL(), application,nodeId));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }

    /**
     * <p>
     * Returns the node for the application id and node id given.
     * </p>
     *
     * @param application Id of the application
     * @param nodeId Id of the Node
     * @return {@link Nodes}
     */
    public Nodes getNodeForApplication(int application,int nodeId){
        try{
            return R.executeNodeQuery(auth, NodeQuery.queryNodeFromApps(baseURL.getControllerURL(), application, nodeId));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }

    /**
     * <p>
     * Returns the backends for an application name given.
     * </p>
     * @param application Name of the application
     * @return {@link Backends}
     */
    public Backends getBackendsForApplication(String application){
        try{
            return R.executeBackends(auth, BackendsQuery.queryBackendsFromApps(baseURL.getControllerURL(), application));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }
    
    /**
     * <p>
     * Returns the health rule violations for an application name given.
     * </p>
     * 
     * @param application Name of the application
     * @param start Timestamp of the start time
     * @param end Timestamp of the end time
     * @return {@link PolicyViolations}
     */
    public PolicyViolations getHealthRuleViolations(String application, long start, long end){
        try{
            return R.executePolicyViolations(auth, PolicyViolationQuery.queryHealthRuleViolationsFromApps(baseURL.getControllerURL(), application,start,end));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }
    
    /**
     * 
     * <p>
     * Returns the policy violations for an application name given.
     * </p>
     * 
     * @param application Name of the application
     * @param start Timestamp for the start time
     * @param end Timestamp for the end time
     * @return {@link PolicyViolations}
     */
    public PolicyViolations getPolicyViolations(String application, long start, long end){
        try{
            return R.executePolicyViolations(auth, PolicyViolationQuery.queryPolicyViolationsFromApps(baseURL.getControllerURL(), application, start, end));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        return null;
    }
    
    /**
     * <p>
     * Returns the events for an application name, event types and severities given.
     * </p>
     * 
     * @param application Name of the application
     * @param eventTypes Event types to request, comma delimited list
     * @param severities Severities to request, comma delimited list
     * @param start Timestamp of the start time
     * @param end Timestamp of the end time
     * @return {@link Events}
     */
    public Events getEvents(String application, String eventTypes, String severities, long start, long end){
        StringBuilder bud = new StringBuilder();
        try{
            bud.append("\nCreating the query::");
            String query=EventsQuery.queryPolicyViolationsSFromApps(baseURL.getControllerURL(), application, eventTypes, severities, start, end);
            bud.append("\nBuiltQuery::").append(query);
            return R.executeEvents(auth, query);
        }catch(Exception e){
            bud.append("\nApplication::").append(application).append("\nEventTypes::").append(eventTypes);
            bud.append("\nSeverities::").append(severities).append("\nStartTime::").append(start);
            bud.append("\nEndTime::").append(end);
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append(bud.toString()).toString());
        }
        return null;
    }

    
    /**
     * <p>
     * Returns transaction detection auto discovery rules for the application.
     * </p>
     * 
     * @param app Name of the application which holds the metric
     * @return {@link AutoDiscoveryConfig}
     * 
     */
    public AutoDiscoveryConfig getRESTExportOfAutoObj( String app){
        String query=null;
        if(s.debugLevel >= 2) logger.log(Level.INFO,new StringBuilder().append("\nQuery for application ").append(app).toString());
        
        
        query=TransactionDetectionQuery.queryTransactionDetectionAutoAll(baseURL.getControllerURL(), app); //tested
        
        //This will be the final check, to insure that we don't send a bad query.
        if(query==null){ 
            logger.log(Level.WARNING,new StringBuilder()
                    .append("\nQueryIndex sent ").append(" application ")
                    .append(app).toString());
            return null;
        }
        
        
        
        try{
            return R.executeExportAuto(auth, query);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }
    
    /**
     * <p>
     * Returns transaction detection auto discovery rules for the application.
     * </p>
     * 
     * 
     * @param app Name of the application which holds the metric
     * @return {@link String}
     * 
     */
    public String getRESTExportOfAuto(String app){
        String query=null;
        if(s.debugLevel >= 2) logger.log(Level.INFO,new StringBuilder().append("\nQuery for application ").append(app).toString());
        
        query=TransactionDetectionQuery.queryTransactionDetectionAutoAll(baseURL.getControllerURL(), app); //tested
        
        //This will be the final check, to insure that we don't send a bad query.
        if(query==null){ 
            logger.log(Level.WARNING,new StringBuilder()
                    .append("\nQueryIndex sent ").append(" application ")
                    .append(app).toString());
            return null;
        }
        
        
        try{
            return R.executeExportAuto(auth, query).toXML();
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }
    
    
    /**
     * <p>
     * Returns transaction detection auto discovery rules for the application.
     * </p>
     * 
     * <ul>
     * <li>Index  0 : queryTransactionDetectionAutoAll
     * <li>Index  1 : queryTransactionDetectionAutoSingle 
     * </ul>
     * 
     * @param queryIndex Index of the type of query to run
     * @param app Name of the application which holds the rules
     * @param objNode Depending on the query this can be the tier name for all rules or the name of the single rule to export
     * @return {@link AutoDiscoveryConfig}
     * 
     * 
     */
    public AutoDiscoveryConfig getRESTExportOfAutoObj(int queryIndex, String app, String objNode){
        String query=null;
        
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder().append("\nQueryIndex ")
                    .append(queryIndex).append(" for application ").append(app).append(" automatic rule ").append(objNode).toString());}
        
        switch(queryIndex){
            
            case 0: // All auto on a tier
                query=TransactionDetectionQuery.queryTransactionDetectionAutoAll(baseURL.getControllerURL(), app, objNode); //tested
                break;
            
            case 1: // Auto for single 
                query=TransactionDetectionQuery.queryTransactionDetectionAutoSingle(baseURL.getControllerURL(), app, objNode); //tested
                break;

            default:
                break;
        }
        
        //This will be the final check, to insure that we don't send a bad query.
        if(query==null){ 
            logger.log(Level.WARNING,new StringBuilder()
                    .append("\nQueryIndex sent ").append(queryIndex).append(" application ")
                    .append(app).append(" automatic rule ").append(objNode).toString());
            return null;
        }
        
        
        try{
            return R.executeExportAuto(auth, query);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }
    
    /**
     * <p>
     * Returns transaction detection auto discovery rules for the application.
     * </p>
     * 
     * 
     * 
     * <ul>
     * <li>Index  0 : queryTransactionDetectionAutoAll
     * <li>Index  1 : queryTransactionDetectionAutoSingle 
     * </ul>
     * 
     * @param queryIndex Index of the type of query to run
     * @param app Name of the application which holds the rules
     * @param objNode Depending on the query this can be the tier name for all rules or the name of the single rule to export
     * @return {@link String}
     * 
     */
    public String getRESTExportOfAuto(int queryIndex, String app, String objNode){
        String query=null;
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder().append("\nQueryIndex ")
                    .append(queryIndex).append(" for application ").append(app).append(" automatic rule ").append(objNode).toString());}
        
        switch(queryIndex){
            
            case 0: // All auto on a tier
                query=TransactionDetectionQuery.queryTransactionDetectionAutoAll(baseURL.getControllerURL(), app, objNode); //tested
                break;
            
            case 1: // Auto for single 
                query=TransactionDetectionQuery.queryTransactionDetectionAutoSingle(baseURL.getControllerURL(), app, objNode); //tested
                break;

            default:
                break;
        }
        
        //This will be the final check, to insure that we don't send a bad query.
        if(query==null){ 
            logger.log(Level.WARNING,new StringBuilder()
                    .append("\nQueryIndex sent ").append(queryIndex).append(" application ")
                    .append(app).append(" automatic ").append(objNode).toString());
            return null;
        }
        
        
        try{
            return R.executeExportAuto(auth, query).toXML();
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }
    
    /**
     * <p>
     * Returns transaction detection auto discovery rules for the application.
     * </p>
     * 
     * 
     * @param app Name of the application which holds the rules
     * @param tier Name of the tier which holds the rules
     * @param objNode Depending on the query this can be the tier name for all rules or the name of the single rule to export
     * @return {@link AutoDiscoveryConfig}
     * 
     */
    public AutoDiscoveryConfig getRESTExportOfAutoObj(String app, String tier, String objNode){
        String query=null;
        
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder().append("\nQueryIndex ")
                    .append(" for application ").append(app).append(" automatic rule ").append(objNode).toString());}
        
        if(objNode != null){
            query=TransactionDetectionQuery.queryTransactionDetectionAutoSingle(baseURL.getControllerURL(), app, tier, objNode); //tested
        }else{
            query=TransactionDetectionQuery.queryTransactionDetectionAutoAll(baseURL.getControllerURL(), app, tier);
        }
        
        //This will be the final check, to insure that we don't send a bad query.
        if(query==null){ 
            logger.log(Level.WARNING,new StringBuilder()
                    .append("\nQueryIndex sent ").append(" application ")
                    .append(app).append(" objNode ").append(objNode).toString());
            return null;
        }
        
        
        try{
            return R.executeExportAuto(auth, query);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }
    
     /**
     * <p>
     * Returns transaction detection auto discovery rules for the application.
     * </p>
     * 
     * @param app Name of the application which holds the rules
     * @param tier Name of the tier which holds the rules
     * @param objNode Depending on the query this can be the tier name for all rules or the name of the single rule to export
     * @return {@link AutoDiscoveryConfig}
     * 
     */
    public String getRESTExportOfAuto(String app, String tier, String objNode){
        String query=null;
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder().append("\nQuery for application ").append(app)
                .append(" automatic rule ").append(objNode).toString());}
        
        if(objNode != null){
            query=TransactionDetectionQuery.queryTransactionDetectionAutoSingle(baseURL.getControllerURL(), app, tier, objNode); //tested
        }else{
            query=TransactionDetectionQuery.queryTransactionDetectionAutoAll(baseURL.getControllerURL(), app, tier);
        }
        
        //This will be the final check, to insure that we don't send a bad query.
        if(query==null){ 
            logger.log(Level.WARNING,new StringBuilder()
                    .append("\nQueryIndex sent ").append(" application ")
                    .append(app).append(" objNode ").append(objNode).toString());
            return null;
        }
        
        
        
        try{
            return R.executeExportAuto(auth, query).toXML();
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }
    
    
    /**
     * <p>
     *  This will import a single auto discovery rule into the application and tier.
     * </p>
     * 
     * @param app The name of the application
     * @param entityName Name of the auto discovery rule
     * @param xml Xml string of the auto discovery rule
     * @return {@link String}
     * 
     */
    public String postRESTAutoSingle(String app, String entityName, String xml){
        String query=null;
        
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder().append("\nPOST for application ")
                .append(app).append(" automatic rule ").append(entityName).toString());}
        
        query=TransactionDetectionQuery.queryTransactionDetectionAutoAll(baseURL.getControllerURL(), app); //tested
        
        //This will be the final check, to insure that we don't send a bad query.
        if(query==null){ 
            logger.log(Level.WARNING,new StringBuilder()
                    .append("\nQueryIndex sent ").append(" application ")
                    .append(app).toString());
            return null;
        }
        
        
        
        try{
            return R.executeAutoPostQuery(auth, query,entityName,xml);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        
        
        return null;
    }
    
    /**
     * <p>
     *  This will import a single auto discovery rule into the application and tier.
     * </p>
     * 
     * @param app The name of the application
     * @param tier The name of the tier
     * @param entityName Name of the auto discovery rule
     * @param xml Xml string of the auto discovery rule
     * @return {@link String}
     * 
     */
    public String postRESTAutoSingle(String app, String tier, String entityName, String xml){
        String query=null;
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder().append("\nPOST for application ")
                .append(app).append(" for tier ").append(tier).append(" automatic rule ").append(entityName).toString());}
        
        query=TransactionDetectionQuery.queryTransactionDetectionAutoAll(baseURL.getControllerURL(), app); //tested
        
        //This will be the final check, to insure that we don't send a bad query.
        if(query==null){ 
            logger.log(Level.WARNING,new StringBuilder()
                    .append("\nQueryIndex sent ").append(" application ")
                    .append(app).toString());
            return null;
        }

        
        
        try{
            return R.executeAutoPostQuery(auth, query,entityName,xml);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        
        
        return null;
    }
    

    /**
     * <p>
     *  This will export all custom pojo into the application.
     * </p>
     * 
     * @param app The name of the application
     * @return {@link String}
     * 
     */
    public String getRESTCustomPojoExportAll(String app){
        String query=null;
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder()
                .append("\nPojo Export query for application ").append(app).toString());}
        
        query=TransactionDetectionQuery.queryTransactionDetectionExportAllPojo(baseURL.getControllerURL(), app); //tested
        
        //This will be the final check, to insure that we don't send a bad query.
        if(query==null){ 
            logger.log(Level.WARNING,new StringBuilder()
                    .append("\nQueryIndex sent ").append(" application ")
                    .append(app).toString());
            return null;
        }
        
        try{
            return R.executeTDQuery(auth, query);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }
    
    /**
     * <p>
     *  This will export all custom pojo into the application and tier.
     * </p>
     * 
     * @param app The name of the application
     * @param tier The name of the tier
     * @return {@link String}
     * 
     */
    public String getRESTCustomPojoExportAll(String app, String tier){
        String query=null;
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder()
                .append("\nPojo Export query for application ").append(app).append(" tier ").append(tier).toString());}
        
        query=TransactionDetectionQuery.queryTransactionDetectionExportAllPojo(baseURL.getControllerURL(), app, tier); //tested
        
        //This will be the final check, to insure that we don't send a bad query.
        if(query==null){ 
            logger.log(Level.WARNING,new StringBuilder()
                    .append("\nQueryIndex sent ").append(" application ")
                    .append(app).toString());
            return null;
        }
        
        
        try{
            return R.executeTDQuery(auth, query);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }
    
    
    
    /**
     * <p>
     *  This will export all custom pojo into the application and tier.
     * </p>
     * 
     * @param app The name of the application
     * @return  {@link CustomMatchPoints}
     * 
     */
    public CustomMatchPoints getRESTCustomPojoExportAllObj(String app){
        String query=null;
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder()
                .append("\nPojo Export query for application ").append(app).toString());}
        
        query=TransactionDetectionQuery.queryTransactionDetectionExportAllPojo(baseURL.getControllerURL(), app); //tested
        
        //This will be the final check, to insure that we don't send a bad query.
        if(query==null){ 
            logger.log(Level.WARNING,new StringBuilder()
                    .append("\nQueryIndex sent ").append(" application ")
                    .append(app).toString());
            return null;
        }
        
        
        try{
            return R.executeTDObjQuery(auth, query);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }
    
    
    /**
     * <p>
     *  This will export all custom pojo into the application and tier.
     * </p>
     * 
     * @param app The name of the application
     * @param tier The name of the tier
     * @return {@link CustomMatchPoints}
     * 
     */
    public CustomMatchPoints getRESTCustomPojoExportAllObj(String app, String tier){
        String query=null;
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder()
                .append("\nPojo Export query for application ").append(app).append(" tier ").append(tier).toString());}
        
        query=TransactionDetectionQuery.queryTransactionDetectionExportAllPojo(baseURL.getControllerURL(), app, tier); //tested
        
        //This will be the final check, to insure that we don't send a bad query.
        if(query==null){ 
            logger.log(Level.WARNING,new StringBuilder()
                    .append("\nQueryIndex sent ").append(" application ")
                    .append(app).toString());
            return null;
        }
        
        
        try{
            return R.executeTDObjQuery(auth, query);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }
    
    /**
     * <p>
     *  This will export a single custom pojo into the application.
     * </p>
     * 
     * @param app The name of the application
     * @param objNode The name of the custom pojo
     * @return {@link String}
     * 
     */
    public String getRESTCustomPojoExport(String app, String objNode){
        String query=null;
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder()
                .append("\nPojo Export query for application ").append(app).append(" for custom pojo ").append(objNode).toString());}
        
        query=TransactionDetectionQuery.queryTransactionDetectionExportPojo(baseURL.getControllerURL(), app, objNode); //tested
        
        //This will be the final check, to insure that we don't send a bad query.
        if(query==null){ 
            logger.log(Level.WARNING,new StringBuilder()
                    .append("\nQueryIndex sent ").append(" application ")
                    .append(app).append(" objNode ").append(objNode).toString());
            return null;
        }
        
        
        try{
            return R.executeTDQuery(auth, query);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }
    
    /**
     * <p>
     *  This will export a single custom pojo into the application and tier.
     * </p>
     * 
     * @param app The name of the application
     * @param tier The name of the tier
     * @param objNode The name of the custom pojo
     * @return {@link String}
     * 
     */
    public String getRESTCustomPojoExport(String app, String tier, String objNode){
        String query=null;
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder()
                .append("\nPojo Export query for application ").append(app)
                .append(" tier ").append(tier).append(" for custom pojo ").append(objNode).toString());}
        
        query=TransactionDetectionQuery.queryTransactionDetectionExportPojo(baseURL.getControllerURL(), app, tier, objNode); //tested
        
        //This will be the final check, to insure that we don't send a bad query.
        if(query==null){ 
            logger.log(Level.WARNING,new StringBuilder()
                    .append("\nQueryIndex sent ").append(" application ")
                    .append(app).append(" objNode ").append(objNode).toString());
            return null;
        }

        
        try{
            return R.executeTDQuery(auth, query);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }
    
    /**
     * <p>
     *  This will import a custom pojo into the application and tier.
     * </p>
     * 
     * @param app The name of the application
     * @param objNode The name of the custom pojo
     * @param xml Xml string for the custom pojo
     * @return {@link String}
     * 
     */
    public String postRESTCustomPojo(String app, String objNode, String xml){
        
        String query=null;
        
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder()
                .append("\nPojo POST for application ").append(app).append(" for custom pojo ").append(objNode).toString());}
        
        query=TransactionDetectionQuery.queryTransactionDetectionImportPojo(baseURL.getControllerURL(), app, objNode); //tested
        logger.log(Level.INFO,new StringBuilder().append("The query is ").append(query).toString());
        
        try{
            //return R.executeTDPostQuery(auth, query, objNode,xml);
            return R.executeAutoPostQuery(auth, query,objNode,xml);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }
    
    /**
     * <p>
     *  This will import a custom pojo into the application and tier given.
     * </p>
     * 
     * @param app The name of the application
     * @param tier The name of the tier
     * @param objNode The name of the custom pojo
     * @param xml Xml string for the custom pojo
     * @return {@link String}
     * 
     */
    public String postRESTCustomPojo(String app, String tier, String objNode, String xml){
        
        String query=null;
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder()
                .append("\nPojo POST for application ").append(app)
                .append(" tier ").append(tier).append(" for custom pojo ").append(objNode).toString());}
        
        query=TransactionDetectionQuery.queryTransactionDetectionImportPojo(baseURL.getControllerURL(), app,tier, objNode); //tested
        
        
        try{
            //return R.executeTDPostQuery(auth, query, objNode,xml);
            return R.executeAutoPostQuery(auth, query,objNode,xml);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }
    
    /**
     * <p>
     *  This will export all health rules for the application name,
     * <br> this functionality is only in the controller version 3.9.x and above. 
     * </p>
     * 
     * @param app Name of the application

     * @return {@link String}
     * 
     */
    public String getRESTHealthRuleExportAll(String app){
        String query=null;
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder()
                .append("\nQuery to get health rules for application ").append(app).toString());}

        query=HealthRuleQuery.queryHealthRulesExportAll(baseURL.getControllerURL(), app); //tested

        
        //This will be the final check, to insure that we don't send a bad query.
        if(query==null){ 
            logger.log(Level.WARNING,new StringBuilder()
                    .append("\nHealthRule query for ")
                    .append(app).toString());
            return null;
        }
        
        
        try{
            return R.executeExportHealthRule(auth, query);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }
    
    /**
     * <p>
     *  This will export all health rules for the application name,
     * <br> this functionality is only in the controller version 3.9.x and above. 
     * </p>
     * 

     * @param app Name of the application

     * @return {@link HealthRules}
     * 
     */
    public HealthRules getRESTHealthRuleObjExportAll(String app){
        String query=null;
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder()
                .append("\nQuery to get health rules for application ").append(app).toString());}

        query=HealthRuleQuery.queryHealthRulesExportAll(baseURL.getControllerURL(), app); //tested

        
        //This will be the final check, to insure that we don't send a bad query.
        if(query==null){ 
            logger.log(Level.WARNING,new StringBuilder()
                    .append("\nHealthRule query for ")
                    .append(app).toString());
            return null;
        }
        
        
        try{
            return R.executeExportHealthRuleObj(auth, query);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }
    
    
    /**
     * <p>
     *  This will export a single health rule for the application name and rule
     * <br> name given, this functionality is only 
     * <br> in the controller version 3.9.x and above. 
     * </p>
     * 
     * @param app Application name
     * @param name Health rule name
     * @return {@link String}
     */
    public String getRESTHealthRuleExportSingle(String app, String name){
        String query=null;
        
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder()
                .append("\nQuery to get health rule for application ").append(app)
                .append(" for rule ").append(name).toString());}

        query=HealthRuleQuery.queryHealthRulesExportSingle(baseURL.getControllerURL(), app, name); 

        
        //This will be the final check, to insure that we don't send a bad query.
        if(query==null){ 
            logger.log(Level.WARNING,new StringBuilder()
                    .append("\nHealthRule query for ")
                    .append(app).toString());
            return null;
        }
        
        
        try{
            return R.executeExportHealthRule(auth, query);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }
    
    /**
     * <p>
     *  This will export a single health rule for the application name and rule
     * <br> name given, this functionality is only 
     * <br> in the controller version 3.9.x and above. 
     * </p>
     * 
     * @param app Application name
     * @param name Health rule name
     * @return {@link HealthRules}
     */
    public HealthRules getRESTHealthRuleObjExportSingle(String app, String name){
        String query=null;
        
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder()
                .append("\nQuery to get health rule for application ").append(app)
                .append(" for rule ").append(name).toString());}

        query=HealthRuleQuery.queryHealthRulesExportSingle(baseURL.getControllerURL(), app, name); 

        
        //This will be the final check, to insure that we don't send a bad query.
        if(query==null){ 
            logger.log(Level.WARNING,new StringBuilder()
                    .append("\nHealthRule query for ")
                    .append(app).toString());
            return null;
        }
        
        
        try{
            return R.executeExportHealthRuleObj(auth, query);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }    
    
    /**
     * <p>
     *  This will import a single health rule for the application name and rule
     * <br> name given, this functionality is only 
     * <br> in the controller version 3.9.x and above. 
     * </p>
     * 
     * @param app Application name
     * @param entityName Health rule name
     * @param xml Xml String for the health rule entry
     * @return {@link String}
     */
    public String postRESTHealthRule(String app, String entityName, String xml){
        
        String query=null;
        
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder()
                .append("\nHealth rule POST for application ").append(app)
                .append(" for rule ").append(entityName).toString());}
        

        query=HealthRuleQuery.queryHealthRulesImportSingle(baseURL.getControllerURL(), app, entityName); //tested

        
        try{
            return R.executeAutoPostQuery(auth, query,entityName,xml);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n").append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }
    
    /**
     * <p>
     * This method will allow a user to post an event to the controller, the PostEvent
     * has its own set of requirements. {@link PostEvent}
     * </p>
     * @param app Name of the application to post the event too
     * @param postEvent PostEvent object that contains the information for the event.
     * @return {@link String}
     */
    public String postRESTCustomEvent(String app, PostEvent postEvent){
        
        String query=null;
        
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder()
                .append("\nEvent POST for application ").append(app).append(" for custom event ").toString());}

        try{
            query=EventsQuery.queryPostEvent(baseURL.getControllerURL(), app, postEvent);
            
            //return R.executeTDPostQuery(auth, query, objNode,xml);
            return R.executeEventPostQuery(auth, query);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }
    
    /**
     * <p>
     * This method will allow a user to post an event to the controller, the PostEvent
     * has its own set of requirements. {@link PostEvent}
     * </p>
     * @param app Name of the application to post the event too
     * @param summary Summary of the event
     * @param comment Comment for the event
     * @return {@link String}
     */
    public String postRESTCustomEvent(String app, String summary, String comment){
        
        String query=null;
        
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder()
                .append("\nEvent POST for application ").append(app).append(" for custom event ").toString());}

        try{
            query=EventsQuery.queryPostEvent(baseURL.getControllerURL(), app, new PostEvent(summary,comment));
            
            //return R.executeTDPostQuery(auth, query, objNode,xml);
            return R.executeEventPostQuery(auth, query);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }
    
     /**
     * <p>
     * This method will allow a user to mark nodes historical
     * </p>
     * @param ids The id or ids that should be marked for deletion
     * @return {@link String}
     */
    public String postRESTMarkNodeHistorical(String ids){
        
        String query=null;
        
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder()
                .append("\nMark Node Historical with ids = ").append(ids).toString());}

        try{
            query=MarkHistoricalQuery.queryMarkNodeHistorical(baseURL.getControllerURL(), ids);
            
            //return R.executeTDPostQuery(auth, query, objNode,xml);
            return R.executeEventPostQuery(auth, query);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }
    
    /**
     * <p>
     * This method will allow a user to add a user
     * </p>
     * @param user The user object
     * @return {@link String}
     */
    public String postRESTAddUser(User user){
        
        String query=null;
        
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder()
                .append("\nUser to be created or updated = ").append(user).toString());}
        
        if(!user.ableToCreate()){
            logger.log(Level.SEVERE,new StringBuilder()
                    .append("Unable to create user because the user object does not have all of the mandatory objects.").append(user).toString());
        }
        try{
            query=UserQuery.queryPostUser(baseURL.getControllerURL(), user.createURL());
            
            return R.executeEventPostQuery(auth, query);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }
    
    /**
     * <p>
     * This method will allow a user to update a user
     * </p>
     * @param user The user object
     * @return {@link String}
     */
    public String postRESTUpdateUser(User user){
        
        String query=null;
        
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder()
                .append("\nUser to be created or updated = ").append(user).toString());}
        if(!user.ableToUpdate()){
            logger.log(Level.SEVERE,new StringBuilder()
                    .append("Unable to create user because the user object does not have all of the mandatory objects.").append(user).toString());
        }
        try{
            query=UserQuery.queryPostUser(baseURL.getControllerURL(), user.createURL());
            
            return R.executeEventPostQuery(auth, query);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }
    
    /**
     * <p>
     *  This will import a dashboard file into the controller, the filePath must be the full path
     * to the dashboard file.
     * </p>
     * 
     * @param filePath Full path to the file
     * @return {@link String}
     */
    public String postRESTImportDashboard(String filePath){
        String query=null;
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder()
                .append("\nThe dashboard being import is  ").append(filePath).toString());}
 
        try{
            query=DashboardQuery.queryDashboardImport(baseURL.getControllerURL());
            
            return R.executePostDashboardQuery(auth, query, filePath);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        
        return null;
        
    }
    
    /**
     * <p>
     * This will return the controller's configuration properties.
     * </p>
     * @param application The application name that has the information
     * @return {@link ConfigurationItems}
     */
    public ConfigurationItems getConfigurationItems(String application){
        try{
            return R.executeConfigurationItems(auth, 
                    ConfigurationItemQuery.queryConfiguration(baseURL.getControllerURL(), application));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        return null;
    }
    
    /**
     * <p>
     * This will return the controller's configuration properties.
     * </p>
     * @param application The application name that has the information
     * @param metricName The name of the metric you want
     * @return {@link ConfigurationItems}
     */
    public ConfigurationItems getConfigurationItems(String application, String metricName){
        try{
            return R.executeConfigurationItems(auth, 
                    ConfigurationItemQuery.queryConfiguration(baseURL.getControllerURL(), application, metricName));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        return null;
    }
    
    /**
     * <p>
     * This will return the controller's license properties, the REST user must have account owner rights
     * </p>
     * @return {@link LicenseProperties}
     */
    public LicenseProperties getLicenseProperties(){
        try{
            return R.executeLicenseProperties(auth, 
                    LicenseQuery.queryLicenseProperties(baseURL.getControllerURL()));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        return null;
    }
    
    /**
     * <p>
     * This will return the controller's license EUM properties, the REST user must have account owner rights
     * </p>
     * @return {@link LicenseProperties}
     */
    public AccountEUM getAccountEUM(){
        try{
            return R.executeAccountEUM(auth, 
                    LicenseQuery.queryAccountEUM(baseURL.getControllerURL()));
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        return null;
    }
    
    /**
     * <p>This will provide the list of dashboards.</p>
     * @return String
     */
    public String getDashboardListing(){
        String query = DashboardQuery.queryDashboardList(baseURL.getControllerURL());
        try{
            return R.executeDashboardList(auth, query);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        
        return null;
        
    }

    
    
    
    /**
     * <p>
     *  This will export the custom match object of either a single java customer match of the type provide or the set of custom match rules. 
     *  If you want the set of custom match rules then provide null as the objNode otherwise we will return a single rule based on the name provided.
     * </p>  
     * <ul>
     *  <li><b>Java Custom Match Rules</b>
     *      <ul>
            * <li>Index  0 : Exports all of the custom match rules of type <b>binaryRemoting</b> for the application
            * <li>Index  1 : Exports the custom match rules of type <b>binaryRemoting</b> with the name objNode
            * <li>Index  2 : Exports all of the custom match rules of type <b>servlet</b> for the application
            * <li>Index  3 : Exports the custom match rules of type <b>servlet</b> with the name objNode
            * <li>Index  4 : Exports all of the custom match rules of type <b>strutsAction</b> for the application
            * <li>Index  5 : Exports the custom match rules of type <b>strutsAction</b> with the name objNode
            * <li>Index  6 : Exports all of the custom match rules of type <b>springBean</b> for the application
            * <li>Index  7 : Exports the custom match rules of type <b>springBean</b> with the name objNode
            * <li>Index  8 : Exports all of the custom match rules of type <b>ejb</b> for the application
            * <li>Index  9 : Exports the custom match rules of type <b>ejb</b> with the name objNode
            * <li>Index  10 : Exports all of the custom match rules of type <b>pojo</b> for the application
            * <li>Index  11 : Exports the custom match rules of type <b>pojo</b> with the name objNode
            * <li>Index  12 : Exports all of the custom match rules of type <b>jms</b> for the application
            * <li>Index  13 : Exports the custom match rules of type <b>jms</b> with the name objNode
            * <li>Index  14 : Exports all of the custom match rules of type <b>webService</b> for the application
            * <li>Index  15 : Exports the custom match rules of type <b>webService</b> with the name objNode
        *   </ul>
        *<li><b>DotNet Custom Match Rules</b>
        *   <ul>
            * <li>Index  16 : Exports all of the custom match rules of type <b>aspDotNet</b> for the application
            * <li>Index  17 : Exports the custom match rule of type <b>aspDotNet</b> with the name objNode
            * <li>Index  18: Exports all of the custom match rules of type <b>dotNetWebService</b> for the application
            * <li>Index  19 : Exports the custom match rule of type <b>dotNetWebService</b> with the name objNode
            * <li>Index  20 : Exports all of the custom match rules of type <b>wcf</b> for the application
            * <li>Index  21 : Exports the custom match rule of type <b>wcf</b> with the name objNode
            * <li>Index  22 : Exports all of the custom match rules of type <b>poco</b> for the application
            * <li>Index  23 : Exports the custom match rule of type <b>poco</b> with the name objNode
            * <li>Index  24 : Exports all of the custom match rules of type <b>dotNetJms</b> for the application
            * <li>Index  25 : Exports the custom match rule of type <b>dotNetJms</b> with the name objNode
            * <li>Index  26 : Exports all of the custom match rules of type <b>dotNetRemoting</b> for the application
            * <li>Index  27 : Exports the custom match rule of type <b>dotNetRemoting</b> with the name objNode
            </ul>
        * <li><b>PHP Custom Match Rules</b>
        *   <ul>
            * <li>Index  28 : Exports all of the custom match rules of type <b>phpWeb</b> for the application
            * <li>Index  29 : Exports the custom match rule of type <b>phpWeb</b> with the name objNode
            * <li>Index  30 : Exports all of the custom match rules of type <b>phpMvc</b> for the application
            * <li>Index  31 : Exports the custom match rule of type <b>phpMvc</b> with the name objNode
            * <li>Index  32 : Exports all of the custom match rules of type <b>phpDrupal</b> for the application
            * <li>Index  33 : Exports the custom match rule of type <b>phpDrupal</b> with the name objNode
            * <li>Index  34 : Exports all of the custom match rules of type <b>phpWordpress</b> for the application
            * <li>Index  35 : Exports the custom match rule of type <b>phpWordpress</b> with the name objNode
            * <li>Index  36 : Exports all of the custom match rules of type <b>phpCli</b> for the application
            * <li>Index  37 : Exports the custom match rule of type <b>phpCli</b> with the name objNode
            * <li>Index  38 : Exports all of the custom match rules of type <b>phpWebService</b> for the application
            * <li>Index  39 : Exports the custom match rule of type <b>phpWebService</b> with the name objNode
            * <li>Index  40 : Exports all of the custom match rules of type <b>nodeJsWeb</b> for the application
            </ul>
        * <li><b>NodeJS Custom Match Rules</b>
        *   <ul>
            * <li>Index  41 : Exports the custom match rule of type <b>nodeJsWeb</b> with the name objNode
        *   </ul>

     * </ul>
     * 
     * @param queryIndex The index for this query
     * @param app The name of the application
     * @param objNode The name of the custom match rule
     * @return {@link CustomMatchPoints}
     * 
     *  
     *
     */
    public CustomMatchPoints getRESTCustomMatchRuleExportObj(int queryIndex,String app,String objNode){
        String query=null;
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder()
                .append("\nCustomer Match Export query for application ").append(app).append(" for ").append(objNode).toString());}
        
        switch(queryIndex){
            case 0:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.JAVA_CUSTOM_MATCHES[0],null);
                break;
            case 1:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.JAVA_CUSTOM_MATCHES[0],objNode);
                break;
            case 2:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.JAVA_CUSTOM_MATCHES[1],null);
                break;
            case 3:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[1],objNode);
                break;
            case 4:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.JAVA_CUSTOM_MATCHES[2],null);
                break;
            case 5:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.JAVA_CUSTOM_MATCHES[2],objNode);
                break;
            case 6:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[3],null);
                break;
            case 7:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.JAVA_CUSTOM_MATCHES[3],objNode);
                break;
            case 8:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[4],null);
                break;
            case 9:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[4],objNode);
                break;
            case 10:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[5],null);
                break;
            case 11:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[5],objNode);
                break;
            case 12:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[6],null);
                break;
            case 13:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[6],objNode);
                break;
            case 14:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[7],null);
                break;
            case 15:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.JAVA_CUSTOM_MATCHES[7],objNode);
                break;
            case 16:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.DOTNET_CUSTOM_MATCHES[0],null);
                break;
            case 17:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.DOTNET_CUSTOM_MATCHES[0],objNode);
                break;
            case 18:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.DOTNET_CUSTOM_MATCHES[1],null);
                break;
            case 19:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.DOTNET_CUSTOM_MATCHES[1],objNode);
                break;
            case 20:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.DOTNET_CUSTOM_MATCHES[2],null);
                break;
            case 21:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.DOTNET_CUSTOM_MATCHES[2],objNode);
                break;
            case 22:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.DOTNET_CUSTOM_MATCHES[3],null);
                break;
            case 23:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.DOTNET_CUSTOM_MATCHES[3],objNode);
                break;
            case 24:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.DOTNET_CUSTOM_MATCHES[4],null);
                break;
            case 25:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.DOTNET_CUSTOM_MATCHES[4],objNode);
                break;
            case 26:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.DOTNET_CUSTOM_MATCHES[5],null);
                break;
            case 27:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.DOTNET_CUSTOM_MATCHES[5],objNode);
                break;
            case 28:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.PHP_CUSTOM_MATCHES[0],null);
                break;
            case 29:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.PHP_CUSTOM_MATCHES[0],objNode);
                break;
            case 30:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.PHP_CUSTOM_MATCHES[1],null);
                break;
            case 31:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[1],objNode);
                break;
            case 32:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.PHP_CUSTOM_MATCHES[2],null);
                break;
            case 33:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.PHP_CUSTOM_MATCHES[2],objNode);
                break;
            case 34:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[3],null);
                break;
            case 35:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.PHP_CUSTOM_MATCHES[3],objNode);
                break;
            case 36:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[4],null);
                break;
            case 37:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[4],objNode);
                break;
            case 38:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[5],null);
                break;
            case 39:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[5],objNode);
                break;
            case 40:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.NODEJS_CUSTOM_MATCHES[0],null);
                break;
            case 41:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.NODEJS_CUSTOM_MATCHES[0],objNode);
                break;

        }
        
        //This will be the final check, to insure that we don't send a bad query.
        if(query==null){ 
            logger.log(Level.WARNING,new StringBuilder()
                    .append("\nQueryIndex sent ").append(" application ")
                    .append(app).append(" objNode ").append(objNode).toString());
            return null;
        }
        
        
        try{
            return R.executeTDObjQuery(auth, query);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }
    
    /**
     * <p>
     *  This will export the custom match object of either a single java customer match of the type provide or the set of custom match rules. 
     *  If you want the set of custom match rules then provide null as the objNode otherwise we will return a single rule based on the name provided.
     * </p>
     * 
     * <ul>
     *  <li><b>Java Custom Match Rules</b>
     *      <ul>
            * <li>Index  0 : Exports all of the custom match rules of type <b>binaryRemoting</b> for the application
            * <li>Index  1 : Exports the custom match rules of type <b>binaryRemoting</b> with the name objNode
            * <li>Index  2 : Exports all of the custom match rules of type <b>servlet</b> for the application
            * <li>Index  3 : Exports the custom match rules of type <b>servlet</b> with the name objNode
            * <li>Index  4 : Exports all of the custom match rules of type <b>strutsAction</b> for the application
            * <li>Index  5 : Exports the custom match rules of type <b>strutsAction</b> with the name objNode
            * <li>Index  6 : Exports all of the custom match rules of type <b>springBean</b> for the application
            * <li>Index  7 : Exports the custom match rules of type <b>springBean</b> with the name objNode
            * <li>Index  8 : Exports all of the custom match rules of type <b>ejb</b> for the application
            * <li>Index  9 : Exports the custom match rules of type <b>ejb</b> with the name objNode
            * <li>Index  10 : Exports all of the custom match rules of type <b>pojo</b> for the application
            * <li>Index  11 : Exports the custom match rules of type <b>pojo</b> with the name objNode
            * <li>Index  12 : Exports all of the custom match rules of type <b>jms</b> for the application
            * <li>Index  13 : Exports the custom match rules of type <b>jms</b> with the name objNode
            * <li>Index  14 : Exports all of the custom match rules of type <b>webService</b> for the application
            * <li>Index  15 : Exports the custom match rules of type <b>webService</b> with the name objNode
        *   </ul>
        *<li><b>DotNet Custom Match Rules</b>
        *   <ul>
            * <li>Index  16 : Exports all of the custom match rules of type <b>aspDotNet</b> for the application
            * <li>Index  17 : Exports the custom match rule of type <b>aspDotNet</b> with the name objNode
            * <li>Index  18: Exports all of the custom match rules of type <b>dotNetWebService</b> for the application
            * <li>Index  19 : Exports the custom match rule of type <b>dotNetWebService</b> with the name objNode
            * <li>Index  20 : Exports all of the custom match rules of type <b>wcf</b> for the application
            * <li>Index  21 : Exports the custom match rule of type <b>wcf</b> with the name objNode
            * <li>Index  22 : Exports all of the custom match rules of type <b>poco</b> for the application
            * <li>Index  23 : Exports the custom match rule of type <b>poco</b> with the name objNode
            * <li>Index  24 : Exports all of the custom match rules of type <b>dotNetJms</b> for the application
            * <li>Index  25 : Exports the custom match rule of type <b>dotNetJms</b> with the name objNode
            * <li>Index  26 : Exports all of the custom match rules of type <b>dotNetRemoting</b> for the application
            * <li>Index  27 : Exports the custom match rule of type <b>dotNetRemoting</b> with the name objNode
            </ul>
        * <li><b>PHP Custom Match Rules</b>
        *   <ul>
            * <li>Index  28 : Exports all of the custom match rules of type <b>phpWeb</b> for the application
            * <li>Index  29 : Exports the custom match rule of type <b>phpWeb</b> with the name objNode
            * <li>Index  30 : Exports all of the custom match rules of type <b>phpMvc</b> for the application
            * <li>Index  31 : Exports the custom match rule of type <b>phpMvc</b> with the name objNode
            * <li>Index  32 : Exports all of the custom match rules of type <b>phpDrupal</b> for the application
            * <li>Index  33 : Exports the custom match rule of type <b>phpDrupal</b> with the name objNode
            * <li>Index  34 : Exports all of the custom match rules of type <b>phpWordpress</b> for the application
            * <li>Index  35 : Exports the custom match rule of type <b>phpWordpress</b> with the name objNode
            * <li>Index  36 : Exports all of the custom match rules of type <b>phpCli</b> for the application
            * <li>Index  37 : Exports the custom match rule of type <b>phpCli</b> with the name objNode
            * <li>Index  38 : Exports all of the custom match rules of type <b>phpWebService</b> for the application
            * <li>Index  39 : Exports the custom match rule of type <b>phpWebService</b> with the name objNode
            * <li>Index  40 : Exports all of the custom match rules of type <b>nodeJsWeb</b> for the application
            </ul>
        * <li><b>NodeJS Custom Match Rules</b>
        *   <ul>
            * <li>Index  41 : Exports the custom match rule of type <b>nodeJsWeb</b> with the name objNode
        *   </ul>

     * </ul>
     * 
     * @param queryIndex The index for this query
     * @param app The name of the application
     * @param objNode The name of the custom match rule
     * @return {@link String}
     * 
     *  
     *  
     */
    public String getRESTCustomMatchRuleExport(int queryIndex,String app,String objNode){
        String query=null;
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder()
                .append("\nCustomer Match Export query for application ").append(app).append(" for ").append(objNode).toString());}
        
        switch(queryIndex){
            case 0:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.JAVA_CUSTOM_MATCHES[0],null);
                break;
            case 1:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.JAVA_CUSTOM_MATCHES[0],objNode);
                break;
            case 2:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.JAVA_CUSTOM_MATCHES[1],null);
                break;
            case 3:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[1],objNode);
                break;
            case 4:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.JAVA_CUSTOM_MATCHES[2],null);
                break;
            case 5:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.JAVA_CUSTOM_MATCHES[2],objNode);
                break;
            case 6:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[3],null);
                break;
            case 7:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.JAVA_CUSTOM_MATCHES[3],objNode);
                break;
            case 8:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[4],null);
                break;
            case 9:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[4],objNode);
                break;
            case 10:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[5],null);
                break;
            case 11:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[5],objNode);
                break;
            case 12:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[6],null);
                break;
            case 13:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[6],objNode);
                break;
            case 14:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[7],null);
                break;
            case 15:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.JAVA_CUSTOM_MATCHES[7],objNode);
                break;
            case 16:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.DOTNET_CUSTOM_MATCHES[0],null);
                break;
            case 17:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.DOTNET_CUSTOM_MATCHES[0],objNode);
                break;
            case 18:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.DOTNET_CUSTOM_MATCHES[1],null);
                break;
            case 19:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.DOTNET_CUSTOM_MATCHES[1],objNode);
                break;
            case 20:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.DOTNET_CUSTOM_MATCHES[2],null);
                break;
            case 21:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.DOTNET_CUSTOM_MATCHES[2],objNode);
                break;
            case 22:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.DOTNET_CUSTOM_MATCHES[3],null);
                break;
            case 23:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.DOTNET_CUSTOM_MATCHES[3],objNode);
                break;
            case 24:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.DOTNET_CUSTOM_MATCHES[4],null);
                break;
            case 25:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.DOTNET_CUSTOM_MATCHES[4],objNode);
                break;
            case 26:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.DOTNET_CUSTOM_MATCHES[5],null);
                break;
            case 27:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.DOTNET_CUSTOM_MATCHES[5],objNode);
                break;
            case 28:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.PHP_CUSTOM_MATCHES[0],null);
                break;
            case 29:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.PHP_CUSTOM_MATCHES[0],objNode);
                break;
            case 30:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.PHP_CUSTOM_MATCHES[1],null);
                break;
            case 31:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[1],objNode);
                break;
            case 32:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.PHP_CUSTOM_MATCHES[2],null);
                break;
            case 33:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.PHP_CUSTOM_MATCHES[2],objNode);
                break;
            case 34:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[3],null);
                break;
            case 35:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  s.PHP_CUSTOM_MATCHES[3],objNode);
                break;
            case 36:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[4],null);
                break;
            case 37:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[4],objNode);
                break;
            case 38:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[5],null);
                break;
            case 39:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[5],objNode);
                break;
            case 40:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.NODEJS_CUSTOM_MATCHES[0],null);
                break;
            case 41:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, s.NODEJS_CUSTOM_MATCHES[0],objNode);
                break;

        }
        
        //This will be the final check, to insure that we don't send a bad query.
        if(query==null){ 
            logger.log(Level.WARNING,new StringBuilder()
                    .append("\nQueryIndex sent ").append(" application ")
                    .append(app).append(" objNode ").append(objNode).toString());
            return null;
        }
        
        
        try{
            return R.executeTDQuery(auth, query);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }
    
    /**
     * <p>
     *  This will export the custom match object of either a single java customer match of the type provide or the set of custom match rules. 
     *  If you want the set of custom match rules then provide null as the objNode otherwise we will return a single rule based on the name provided.
     * </p>
     * 
     * 
     * <ul>
     *  <li><b>Java Custom Match Rules</b>
     *      <ul>
            * <li>Index  0 : Exports all of the custom match rules of type <b>binaryRemoting</b> for the application
            * <li>Index  1 : Exports the custom match rules of type <b>binaryRemoting</b> with the name objNode
            * <li>Index  2 : Exports all of the custom match rules of type <b>servlet</b> for the application
            * <li>Index  3 : Exports the custom match rules of type <b>servlet</b> with the name objNode
            * <li>Index  4 : Exports all of the custom match rules of type <b>strutsAction</b> for the application
            * <li>Index  5 : Exports the custom match rules of type <b>strutsAction</b> with the name objNode
            * <li>Index  6 : Exports all of the custom match rules of type <b>springBean</b> for the application
            * <li>Index  7 : Exports the custom match rules of type <b>springBean</b> with the name objNode
            * <li>Index  8 : Exports all of the custom match rules of type <b>ejb</b> for the application
            * <li>Index  9 : Exports the custom match rules of type <b>ejb</b> with the name objNode
            * <li>Index  10 : Exports all of the custom match rules of type <b>pojo</b> for the application
            * <li>Index  11 : Exports the custom match rules of type <b>pojo</b> with the name objNode
            * <li>Index  12 : Exports all of the custom match rules of type <b>jms</b> for the application
            * <li>Index  13 : Exports the custom match rules of type <b>jms</b> with the name objNode
            * <li>Index  14 : Exports all of the custom match rules of type <b>webService</b> for the application
            * <li>Index  15 : Exports the custom match rules of type <b>webService</b> with the name objNode
        *   </ul>
        *<li><b>DotNet Custom Match Rules</b>
        *   <ul>
            * <li>Index  16 : Exports all of the custom match rules of type <b>aspDotNet</b> for the application
            * <li>Index  17 : Exports the custom match rule of type <b>aspDotNet</b> with the name objNode
            * <li>Index  18: Exports all of the custom match rules of type <b>dotNetWebService</b> for the application
            * <li>Index  19 : Exports the custom match rule of type <b>dotNetWebService</b> with the name objNode
            * <li>Index  20 : Exports all of the custom match rules of type <b>wcf</b> for the application
            * <li>Index  21 : Exports the custom match rule of type <b>wcf</b> with the name objNode
            * <li>Index  22 : Exports all of the custom match rules of type <b>poco</b> for the application
            * <li>Index  23 : Exports the custom match rule of type <b>poco</b> with the name objNode
            * <li>Index  24 : Exports all of the custom match rules of type <b>dotNetJms</b> for the application
            * <li>Index  25 : Exports the custom match rule of type <b>dotNetJms</b> with the name objNode
            * <li>Index  26 : Exports all of the custom match rules of type <b>dotNetRemoting</b> for the application
            * <li>Index  27 : Exports the custom match rule of type <b>dotNetRemoting</b> with the name objNode
            </ul>
        * <li><b>PHP Custom Match Rules</b>
        *   <ul>
            * <li>Index  28 : Exports all of the custom match rules of type <b>phpWeb</b> for the application
            * <li>Index  29 : Exports the custom match rule of type <b>phpWeb</b> with the name objNode
            * <li>Index  30 : Exports all of the custom match rules of type <b>phpMvc</b> for the application
            * <li>Index  31 : Exports the custom match rule of type <b>phpMvc</b> with the name objNode
            * <li>Index  32 : Exports all of the custom match rules of type <b>phpDrupal</b> for the application
            * <li>Index  33 : Exports the custom match rule of type <b>phpDrupal</b> with the name objNode
            * <li>Index  34 : Exports all of the custom match rules of type <b>phpWordpress</b> for the application
            * <li>Index  35 : Exports the custom match rule of type <b>phpWordpress</b> with the name objNode
            * <li>Index  36 : Exports all of the custom match rules of type <b>phpCli</b> for the application
            * <li>Index  37 : Exports the custom match rule of type <b>phpCli</b> with the name objNode
            * <li>Index  38 : Exports all of the custom match rules of type <b>phpWebService</b> for the application
            * <li>Index  39 : Exports the custom match rule of type <b>phpWebService</b> with the name objNode
            * <li>Index  40 : Exports all of the custom match rules of type <b>nodeJsWeb</b> for the application
            </ul>
        * <li><b>NodeJS Custom Match Rules</b>
        *   <ul>
            * <li>Index  41 : Exports the custom match rule of type <b>nodeJsWeb</b> with the name objNode
        *   </ul>

     * </ul>
     * 
     * @param queryIndex The index for this query
     * @param app The name of the application
     * @param tier The name of the tier
     * @param objNode The name of the custom match rule
     * @return {@link CustomMatchPoints}
     * 
     *  
     * 
     */
    public CustomMatchPoints getRESTCustomMatchRuleExportObj(int queryIndex,String app, String tier, String objNode){
        String query=null;
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder()
                .append("\nCustomer Match Export query for application ").append(app).append(" for ").append(objNode).toString());}
        
        switch(queryIndex){
            case 0:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.JAVA_CUSTOM_MATCHES[0],null);
                break;
            case 1:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.JAVA_CUSTOM_MATCHES[0],objNode);
                break;
            case 2:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.JAVA_CUSTOM_MATCHES[1],null);
                break;
            case 3:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.JAVA_CUSTOM_MATCHES[1],objNode);
                break;
            case 4:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.JAVA_CUSTOM_MATCHES[2],null);
                break;
            case 5:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.JAVA_CUSTOM_MATCHES[2],objNode);
                break;
            case 6:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.JAVA_CUSTOM_MATCHES[3],null);
                break;
            case 7:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  tier,s.JAVA_CUSTOM_MATCHES[3],objNode);
                break;
            case 8:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.JAVA_CUSTOM_MATCHES[4],null);
                break;
            case 9:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.JAVA_CUSTOM_MATCHES[4],objNode);
                break;
            case 10:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.JAVA_CUSTOM_MATCHES[5],null);
                break;
            case 11:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.JAVA_CUSTOM_MATCHES[5],objNode);
                break;
            case 12:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.JAVA_CUSTOM_MATCHES[6],null);
                break;
            case 13:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.JAVA_CUSTOM_MATCHES[6],objNode);
                break;
            case 14:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.JAVA_CUSTOM_MATCHES[7],null);
                break;
            case 15:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.JAVA_CUSTOM_MATCHES[7],objNode);
                break;
            case 16:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  tier,s.DOTNET_CUSTOM_MATCHES[0],null);
                break;
            case 17:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.DOTNET_CUSTOM_MATCHES[0],objNode);
                break;
            case 18:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.DOTNET_CUSTOM_MATCHES[1],null);
                break;
            case 19:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,tier, s.DOTNET_CUSTOM_MATCHES[1],objNode);
                break;
            case 20:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.DOTNET_CUSTOM_MATCHES[2],null);
                break;
            case 21:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.DOTNET_CUSTOM_MATCHES[2],objNode);
                break;
            case 22:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.DOTNET_CUSTOM_MATCHES[3],null);
                break;
            case 23:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.DOTNET_CUSTOM_MATCHES[3],objNode);
                break;
            case 24:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.DOTNET_CUSTOM_MATCHES[4],null);
                break;
            case 25:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.DOTNET_CUSTOM_MATCHES[4],objNode);
                break;
            case 26:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.DOTNET_CUSTOM_MATCHES[5],null);
                break;
            case 27:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.DOTNET_CUSTOM_MATCHES[5],objNode);
                break;
            case 28:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.PHP_CUSTOM_MATCHES[0],null);
                break;
            case 29:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.PHP_CUSTOM_MATCHES[0],objNode);
                break;
            case 30:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.PHP_CUSTOM_MATCHES[1],null);
                break;
            case 31:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,tier, s.PHP_CUSTOM_MATCHES[1],objNode);
                break;
            case 32:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.PHP_CUSTOM_MATCHES[2],null);
                break;
            case 33:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.PHP_CUSTOM_MATCHES[2],objNode);
                break;
            case 34:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,tier, s.PHP_CUSTOM_MATCHES[3],null);
                break;
            case 35:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,tier,  s.PHP_CUSTOM_MATCHES[3],objNode);
                break;
            case 36:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.PHP_CUSTOM_MATCHES[4],null);
                break;
            case 37:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,tier, s.PHP_CUSTOM_MATCHES[4],objNode);
                break;
            case 38:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,tier, s.PHP_CUSTOM_MATCHES[5],null);
                break;
            case 39:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,tier, s.PHP_CUSTOM_MATCHES[5],objNode);
                break;
            case 40:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.NODEJS_CUSTOM_MATCHES[0],null);
                break;
            case 41:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,tier, s.NODEJS_CUSTOM_MATCHES[0],objNode);
                break;

        }
        
        //This will be the final check, to insure that we don't send a bad query.
        if(query==null){ 
            logger.log(Level.WARNING,new StringBuilder()
                    .append("\nQueryIndex sent ").append(" application ")
                    .append(app).append(" objNode ").append(objNode).toString());
            return null;
        }
        
        
        try{
            return R.executeTDObjQuery(auth, query);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }
    
    /**
     * <p>
     *  This will export the custom match object of either a single java customer match of the type provide or the set of custom match rules. 
     *  If you want the set of custom match rules then provide null as the objNode otherwise we will return a single rule.
     * </p>
     * 
     * 
     * <ul>
     *  <li><b>Java Custom Match Rules</b>
     *      <ul>
            * <li>Index  0 : Exports all of the custom match rules of type <b>binaryRemoting</b> for the application
            * <li>Index  1 : Exports the custom match rules of type <b>binaryRemoting</b> with the name objNode
            * <li>Index  2 : Exports all of the custom match rules of type <b>servlet</b> for the application
            * <li>Index  3 : Exports the custom match rules of type <b>servlet</b> with the name objNode
            * <li>Index  4 : Exports all of the custom match rules of type <b>strutsAction</b> for the application
            * <li>Index  5 : Exports the custom match rules of type <b>strutsAction</b> with the name objNode
            * <li>Index  6 : Exports all of the custom match rules of type <b>springBean</b> for the application
            * <li>Index  7 : Exports the custom match rules of type <b>springBean</b> with the name objNode
            * <li>Index  8 : Exports all of the custom match rules of type <b>ejb</b> for the application
            * <li>Index  9 : Exports the custom match rules of type <b>ejb</b> with the name objNode
            * <li>Index  10 : Exports all of the custom match rules of type <b>pojo</b> for the application
            * <li>Index  11 : Exports the custom match rules of type <b>pojo</b> with the name objNode
            * <li>Index  12 : Exports all of the custom match rules of type <b>jms</b> for the application
            * <li>Index  13 : Exports the custom match rules of type <b>jms</b> with the name objNode
            * <li>Index  14 : Exports all of the custom match rules of type <b>webService</b> for the application
            * <li>Index  15 : Exports the custom match rules of type <b>webService</b> with the name objNode
        *   </ul>
        *<li><b>DotNet Custom Match Rules</b>
        *   <ul>
            * <li>Index  16 : Exports all of the custom match rules of type <b>aspDotNet</b> for the application
            * <li>Index  17 : Exports the custom match rule of type <b>aspDotNet</b> with the name objNode
            * <li>Index  18: Exports all of the custom match rules of type <b>dotNetWebService</b> for the application
            * <li>Index  19 : Exports the custom match rule of type <b>dotNetWebService</b> with the name objNode
            * <li>Index  20 : Exports all of the custom match rules of type <b>wcf</b> for the application
            * <li>Index  21 : Exports the custom match rule of type <b>wcf</b> with the name objNode
            * <li>Index  22 : Exports all of the custom match rules of type <b>poco</b> for the application
            * <li>Index  23 : Exports the custom match rule of type <b>poco</b> with the name objNode
            * <li>Index  24 : Exports all of the custom match rules of type <b>dotNetJms</b> for the application
            * <li>Index  25 : Exports the custom match rule of type <b>dotNetJms</b> with the name objNode
            * <li>Index  26 : Exports all of the custom match rules of type <b>dotNetRemoting</b> for the application
            * <li>Index  27 : Exports the custom match rule of type <b>dotNetRemoting</b> with the name objNode
            </ul>
        * <li><b>PHP Custom Match Rules</b>
        *   <ul>
            * <li>Index  28 : Exports all of the custom match rules of type <b>phpWeb</b> for the application
            * <li>Index  29 : Exports the custom match rule of type <b>phpWeb</b> with the name objNode
            * <li>Index  30 : Exports all of the custom match rules of type <b>phpMvc</b> for the application
            * <li>Index  31 : Exports the custom match rule of type <b>phpMvc</b> with the name objNode
            * <li>Index  32 : Exports all of the custom match rules of type <b>phpDrupal</b> for the application
            * <li>Index  33 : Exports the custom match rule of type <b>phpDrupal</b> with the name objNode
            * <li>Index  34 : Exports all of the custom match rules of type <b>phpWordpress</b> for the application
            * <li>Index  35 : Exports the custom match rule of type <b>phpWordpress</b> with the name objNode
            * <li>Index  36 : Exports all of the custom match rules of type <b>phpCli</b> for the application
            * <li>Index  37 : Exports the custom match rule of type <b>phpCli</b> with the name objNode
            * <li>Index  38 : Exports all of the custom match rules of type <b>phpWebService</b> for the application
            * <li>Index  39 : Exports the custom match rule of type <b>phpWebService</b> with the name objNode
            * <li>Index  40 : Exports all of the custom match rules of type <b>nodeJsWeb</b> for the application
            </ul>
        * <li><b>NodeJS Custom Match Rules</b>
        *   <ul>
            * <li>Index  41 : Exports the custom match rule of type <b>nodeJsWeb</b> with the name objNode
        *   </ul>

     * </ul>
     * 
     * @param queryIndex The index for this query
     * @param app The name of the application
     * @param tier The name of the tier
     * @param objNode The name of the custom match rule
     * @return {@link String}
     * 
     *  
     * 
     */
    public String getRESTCustomMatchRuleExport(int queryIndex,String app, String tier, String objNode){
        String query=null;
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder()
                .append("\nCustomer Match Export query for application ").append(app).append(" for ").append(objNode).toString());}
        
        switch(queryIndex){
            case 0:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.JAVA_CUSTOM_MATCHES[0],null);
                break;
            case 1:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.JAVA_CUSTOM_MATCHES[0],objNode);
                break;
            case 2:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.JAVA_CUSTOM_MATCHES[1],null);
                break;
            case 3:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.JAVA_CUSTOM_MATCHES[1],objNode);
                break;
            case 4:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.JAVA_CUSTOM_MATCHES[2],null);
                break;
            case 5:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.JAVA_CUSTOM_MATCHES[2],objNode);
                break;
            case 6:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.JAVA_CUSTOM_MATCHES[3],null);
                break;
            case 7:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  tier,s.JAVA_CUSTOM_MATCHES[3],objNode);
                break;
            case 8:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.JAVA_CUSTOM_MATCHES[4],null);
                break;
            case 9:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.JAVA_CUSTOM_MATCHES[4],objNode);
                break;
            case 10:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.JAVA_CUSTOM_MATCHES[5],null);
                break;
            case 11:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.JAVA_CUSTOM_MATCHES[5],objNode);
                break;
            case 12:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.JAVA_CUSTOM_MATCHES[6],null);
                break;
            case 13:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.JAVA_CUSTOM_MATCHES[6],objNode);
                break;
            case 14:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.JAVA_CUSTOM_MATCHES[7],null);
                break;
            case 15:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.JAVA_CUSTOM_MATCHES[7],objNode);
                break;
            case 16:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,  tier,s.DOTNET_CUSTOM_MATCHES[0],null);
                break;
            case 17:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.DOTNET_CUSTOM_MATCHES[0],objNode);
                break;
            case 18:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.DOTNET_CUSTOM_MATCHES[1],null);
                break;
            case 19:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,tier, s.DOTNET_CUSTOM_MATCHES[1],objNode);
                break;
            case 20:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.DOTNET_CUSTOM_MATCHES[2],null);
                break;
            case 21:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.DOTNET_CUSTOM_MATCHES[2],objNode);
                break;
            case 22:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.DOTNET_CUSTOM_MATCHES[3],null);
                break;
            case 23:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.DOTNET_CUSTOM_MATCHES[3],objNode);
                break;
            case 24:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.DOTNET_CUSTOM_MATCHES[4],null);
                break;
            case 25:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.DOTNET_CUSTOM_MATCHES[4],objNode);
                break;
            case 26:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.DOTNET_CUSTOM_MATCHES[5],null);
                break;
            case 27:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.DOTNET_CUSTOM_MATCHES[5],objNode);
                break;
            case 28:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.PHP_CUSTOM_MATCHES[0],null);
                break;
            case 29:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.PHP_CUSTOM_MATCHES[0],objNode);
                break;
            case 30:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.PHP_CUSTOM_MATCHES[1],null);
                break;
            case 31:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,tier, s.PHP_CUSTOM_MATCHES[1],objNode);
                break;
            case 32:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.PHP_CUSTOM_MATCHES[2],null);
                break;
            case 33:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier, s.PHP_CUSTOM_MATCHES[2],objNode);
                break;
            case 34:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,tier, s.PHP_CUSTOM_MATCHES[3],null);
                break;
            case 35:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,tier,  s.PHP_CUSTOM_MATCHES[3],objNode);
                break;
            case 36:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.PHP_CUSTOM_MATCHES[4],null);
                break;
            case 37:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,tier, s.PHP_CUSTOM_MATCHES[4],objNode);
                break;
            case 38:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,tier, s.PHP_CUSTOM_MATCHES[5],null);
                break;
            case 39:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,tier, s.PHP_CUSTOM_MATCHES[5],objNode);
                break;
            case 40:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app, tier,s.NODEJS_CUSTOM_MATCHES[0],null);
                break;
            case 41:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionExport(baseURL.getControllerURL(), app,tier, s.NODEJS_CUSTOM_MATCHES[0],objNode);
                break;

        }
        
        //This will be the final check, to insure that we don't send a bad query.
        if(query==null){ 
            logger.log(Level.WARNING,new StringBuilder()
                    .append("\nQueryIndex sent ").append(" application ")
                    .append(app).append(" objNode ").append(objNode).toString());
            return null;
        }
        
        
        try{
            return R.executeTDQuery(auth, query);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }
    
    
    
    
    
    
    
    
    /**
     * <p>
     *  This will import a custom pojo into the application and tier given.
     * </p>
     * 
     * 
     * <ul>
     *  <li><b>Java Custom Match Rules</b>
     *      <ul>
            * <li>Index  0 : Imports all of the custom match rules of type <b>binaryRemoting</b> for the application
            * <li>Index  1 : Imports the custom match rules of type <b>binaryRemoting</b> with the name objNode
            * <li>Index  2 : Imports all of the custom match rules of type <b>servlet</b> for the application
            * <li>Index  3 : Imports the custom match rules of type <b>servlet</b> with the name objNode
            * <li>Index  4 : Imports all of the custom match rules of type <b>strutsAction</b> for the application
            * <li>Index  5 : Imports the custom match rules of type <b>strutsAction</b> with the name objNode
            * <li>Index  6 : Imports all of the custom match rules of type <b>springBean</b> for the application
            * <li>Index  7 : Imports the custom match rules of type <b>springBean</b> with the name objNode
            * <li>Index  8 : Imports all of the custom match rules of type <b>ejb</b> for the application
            * <li>Index  9 : Imports the custom match rules of type <b>ejb</b> with the name objNode
            * <li>Index  10 : Imports all of the custom match rules of type <b>pojo</b> for the application
            * <li>Index  11 : Imports the custom match rules of type <b>pojo</b> with the name objNode
            * <li>Index  12 : Imports all of the custom match rules of type <b>jms</b> for the application
            * <li>Index  13 : Imports the custom match rules of type <b>jms</b> with the name objNode
            * <li>Index  14 : Imports all of the custom match rules of type <b>webService</b> for the application
            * <li>Index  15 : Imports the custom match rules of type <b>webService</b> with the name objNode
        *   </ul>
        *<li><b>DotNet Custom Match Rules</b>
        *   <ul>
            * <li>Index  16 : Imports all of the custom match rules of type <b>aspDotNet</b> for the application
            * <li>Index  17 : Imports the custom match rule of type <b>aspDotNet</b> with the name objNode
            * <li>Index  18 : Imports all of the custom match rules of type <b>dotNetWebService</b> for the application
            * <li>Index  19 : Imports the custom match rule of type <b>dotNetWebService</b> with the name objNode
            * <li>Index  20 : Imports all of the custom match rules of type <b>wcf</b> for the application
            * <li>Index  21 : Imports the custom match rule of type <b>wcf</b> with the name objNode
            * <li>Index  22 : Imports all of the custom match rules of type <b>poco</b> for the application
            * <li>Index  23 : Imports the custom match rule of type <b>poco</b> with the name objNode
            * <li>Index  24 : Imports all of the custom match rules of type <b>dotNetJms</b> for the application
            * <li>Index  25 : Imports the custom match rule of type <b>dotNetJms</b> with the name objNode
            * <li>Index  26 : Imports all of the custom match rules of type <b>dotNetRemoting</b> for the application
            * <li>Index  27 : Imports the custom match rule of type <b>dotNetRemoting</b> with the name objNode
            </ul>
        * <li><b>PHP Custom Match Rules</b>
        *   <ul>
            * <li>Index  28 : Imports all of the custom match rules of type <b>phpWeb</b> for the application
            * <li>Index  29 : Imports the custom match rule of type <b>phpWeb</b> with the name objNode
            * <li>Index  30 : Imports all of the custom match rules of type <b>phpMvc</b> for the application
            * <li>Index  31 : Imports the custom match rule of type <b>phpMvc</b> with the name objNode
            * <li>Index  32 : Imports all of the custom match rules of type <b>phpDrupal</b> for the application
            * <li>Index  33 : Imports the custom match rule of type <b>phpDrupal</b> with the name objNode
            * <li>Index  34 : Imports all of the custom match rules of type <b>phpWordpress</b> for the application
            * <li>Index  35 : Imports the custom match rule of type <b>phpWordpress</b> with the name objNode
            * <li>Index  36 : Imports all of the custom match rules of type <b>phpCli</b> for the application
            * <li>Index  37 : Imports the custom match rule of type <b>phpCli</b> with the name objNode
            * <li>Index  38 : Imports all of the custom match rules of type <b>phpWebService</b> for the application
            * <li>Index  39 : Imports the custom match rule of type <b>phpWebService</b> with the name objNode
            * <li>Index  40 : Imports all of the custom match rules of type <b>nodeJsWeb</b> for the application
            </ul>
        * <li><b>NodeJS Custom Match Rules</b>
        *   <ul>
            * <li>Index  41 : Imports the custom match rule of type <b>nodeJsWeb</b> with the name objNode
        *   </ul>

     * </ul>
     * 
     * @param queryIndex The index for this query
     * @param app The name of the application
     * @param objNode The name of the custom pojo
     * @param xml Xml string for the custom pojo
     * @return {@link String}

     */
    public String postRESTCustomMatch(int queryIndex, String app, String objNode, String xml){
        
        String query=null;
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder()
                .append("\nPojo POST for application ").append(app)
                .append(" tier ").append(" for custom pojo ").append(objNode).toString());}
        
        switch(queryIndex){
            case 0:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[0],null);
                break;
            case 1:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[0],objNode);
                break;
            case 2:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[1],null);
                break;
            case 3:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.JAVA_CUSTOM_MATCHES[1],objNode);
                break;
            case 4:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[2],null);
                break;
            case 5:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[2],objNode);
                break;
            case 6:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.JAVA_CUSTOM_MATCHES[3],null);
                break;
            case 7:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[3],objNode);
                break;
            case 8:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.JAVA_CUSTOM_MATCHES[4],null);
                break;
            case 9:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.JAVA_CUSTOM_MATCHES[4],objNode);
                break;
            case 10:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.JAVA_CUSTOM_MATCHES[5],null);
                break;
            case 11:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.JAVA_CUSTOM_MATCHES[5],objNode);
                break;
            case 12:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.JAVA_CUSTOM_MATCHES[6],null);
                break;
            case 13:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.JAVA_CUSTOM_MATCHES[6],objNode);
                break;
            case 14:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.JAVA_CUSTOM_MATCHES[7],null);
                break;
            case 15:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[7],objNode);
                break;
            case 16:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.DOTNET_CUSTOM_MATCHES[0],null);
                break;
            case 17:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.DOTNET_CUSTOM_MATCHES[0],objNode);
                break;
            case 18:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.DOTNET_CUSTOM_MATCHES[1],null);
                break;
            case 19:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.DOTNET_CUSTOM_MATCHES[1],objNode);
                break;
            case 20:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.DOTNET_CUSTOM_MATCHES[2],null);
                break;
            case 21:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.DOTNET_CUSTOM_MATCHES[2],objNode);
                break;
            case 22:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.DOTNET_CUSTOM_MATCHES[3],null);
                break;
            case 23:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.DOTNET_CUSTOM_MATCHES[3],objNode);
                break;
            case 24:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.DOTNET_CUSTOM_MATCHES[4],null);
                break;
            case 25:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.DOTNET_CUSTOM_MATCHES[4],objNode);
                break;
            case 26:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.DOTNET_CUSTOM_MATCHES[5],null);
                break;
            case 27:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.DOTNET_CUSTOM_MATCHES[5],objNode);
                break;
            case 28:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[0],null);
                break;
            case 29:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[0],objNode);
                break;
            case 30:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[1],null);
                break;
            case 31:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[1],objNode);
                break;
            case 32:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[2],null);
                break;
            case 33:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[2],objNode);
                break;
            case 34:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[3],null);
                break;
            case 35:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,  s.PHP_CUSTOM_MATCHES[3],objNode);
                break;
            case 36:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.PHP_CUSTOM_MATCHES[4],null);
                break;
            case 37:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[4],objNode);
                break;
            case 38:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[5],null);
                break;
            case 39:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[5],objNode);
                break;
            case 40:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.NODEJS_CUSTOM_MATCHES[0],null);
                break;
            case 41:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.NODEJS_CUSTOM_MATCHES[0],objNode);
                break;

        }
        
        
        try{
            //return R.executeTDPostQuery(auth, query, objNode,xml);
            return R.executeAutoPostQuery(auth, query,objNode,xml);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }
    
    /**
     * <p>
     *  This will import a custom pojo into the application and tier given.
     * </p>
     * 
     * 
     * <ul>
     *  <li><b>Java Custom Match Rules</b>
     *      <ul>
            * <li>Index  0 : Imports all of the custom match rules of type <b>binaryRemoting</b> for the application
            * <li>Index  1 : Imports the custom match rules of type <b>binaryRemoting</b> with the name objNode
            * <li>Index  2 : Imports all of the custom match rules of type <b>servlet</b> for the application
            * <li>Index  3 : Imports the custom match rules of type <b>servlet</b> with the name objNode
            * <li>Index  4 : Imports all of the custom match rules of type <b>strutsAction</b> for the application
            * <li>Index  5 : Imports the custom match rules of type <b>strutsAction</b> with the name objNode
            * <li>Index  6 : Imports all of the custom match rules of type <b>springBean</b> for the application
            * <li>Index  7 : Imports the custom match rules of type <b>springBean</b> with the name objNode
            * <li>Index  8 : Imports all of the custom match rules of type <b>ejb</b> for the application
            * <li>Index  9 : Imports the custom match rules of type <b>ejb</b> with the name objNode
            * <li>Index  10 : Imports all of the custom match rules of type <b>pojo</b> for the application
            * <li>Index  11 : Imports the custom match rules of type <b>pojo</b> with the name objNode
            * <li>Index  12 : Imports all of the custom match rules of type <b>jms</b> for the application
            * <li>Index  13 : Imports the custom match rules of type <b>jms</b> with the name objNode
            * <li>Index  14 : Imports all of the custom match rules of type <b>webService</b> for the application
            * <li>Index  15 : Imports the custom match rules of type <b>webService</b> with the name objNode
        *   </ul>
        *<li><b>DotNet Custom Match Rules</b>
        *   <ul>
            * <li>Index  16 : Imports all of the custom match rules of type <b>aspDotNet</b> for the application
            * <li>Index  17 : Imports the custom match rule of type <b>aspDotNet</b> with the name objNode
            * <li>Index  18 : Imports all of the custom match rules of type <b>dotNetWebService</b> for the application
            * <li>Index  19 : Imports the custom match rule of type <b>dotNetWebService</b> with the name objNode
            * <li>Index  20 : Imports all of the custom match rules of type <b>wcf</b> for the application
            * <li>Index  21 : Imports the custom match rule of type <b>wcf</b> with the name objNode
            * <li>Index  22 : Imports all of the custom match rules of type <b>poco</b> for the application
            * <li>Index  23 : Imports the custom match rule of type <b>poco</b> with the name objNode
            * <li>Index  24 : Imports all of the custom match rules of type <b>dotNetJms</b> for the application
            * <li>Index  25 : Imports the custom match rule of type <b>dotNetJms</b> with the name objNode
            * <li>Index  26 : Imports all of the custom match rules of type <b>dotNetRemoting</b> for the application
            * <li>Index  27 : Imports the custom match rule of type <b>dotNetRemoting</b> with the name objNode
            </ul>
        * <li><b>PHP Custom Match Rules</b>
        *   <ul>
            * <li>Index  28 : Imports all of the custom match rules of type <b>phpWeb</b> for the application
            * <li>Index  29 : Imports the custom match rule of type <b>phpWeb</b> with the name objNode
            * <li>Index  30 : Imports all of the custom match rules of type <b>phpMvc</b> for the application
            * <li>Index  31 : Imports the custom match rule of type <b>phpMvc</b> with the name objNode
            * <li>Index  32 : Imports all of the custom match rules of type <b>phpDrupal</b> for the application
            * <li>Index  33 : Imports the custom match rule of type <b>phpDrupal</b> with the name objNode
            * <li>Index  34 : Imports all of the custom match rules of type <b>phpWordpress</b> for the application
            * <li>Index  35 : Imports the custom match rule of type <b>phpWordpress</b> with the name objNode
            * <li>Index  36 : Imports all of the custom match rules of type <b>phpCli</b> for the application
            * <li>Index  37 : Imports the custom match rule of type <b>phpCli</b> with the name objNode
            * <li>Index  38 : Imports all of the custom match rules of type <b>phpWebService</b> for the application
            * <li>Index  39 : Imports the custom match rule of type <b>phpWebService</b> with the name objNode
            * <li>Index  40 : Imports all of the custom match rules of type <b>nodeJsWeb</b> for the application
            </ul>
        * <li><b>NodeJS Custom Match Rules</b>
        *   <ul>
            * <li>Index  41 : Imports the custom match rule of type <b>nodeJsWeb</b> with the name objNode
        *   </ul>

     * </ul>
     * 
     * @param queryIndex The index for this query
     * @param app The name of the application
     * @param objNode The name of the custom pojo
     * @param xml1 Xml File for the custom pojo
     * @return {@link String}
     * 
     * 
     */
    public String postRESTCustomMatch(int queryIndex, String app, String objNode, java.io.FileReader xml1){
        
        String query=null;
        String xml=null;
        
        try{
            java.io.BufferedReader br=new java.io.BufferedReader(xml1);
            StringBuilder bud = new StringBuilder();
            String s;
            while((s= br.readLine()) != null){
                bud.append(s);
            }

            xml=bud.toString();
        }catch(Exception e){ logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred while attempting to open the file ").append(e.getMessage()).toString());return null;}
        
        
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder()
                .append("\nPojo POST for application ").append(app)
                .append(" tier ").append(" for custom pojo ").append(objNode).toString());}
        
        switch(queryIndex){
            case 0:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[0],null);
                break;
            case 1:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[0],objNode);
                break;
            case 2:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[1],null);
                break;
            case 3:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.JAVA_CUSTOM_MATCHES[1],objNode);
                break;
            case 4:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[2],null);
                break;
            case 5:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[2],objNode);
                break;
            case 6:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.JAVA_CUSTOM_MATCHES[3],null);
                break;
            case 7:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[3],objNode);
                break;
            case 8:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.JAVA_CUSTOM_MATCHES[4],null);
                break;
            case 9:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.JAVA_CUSTOM_MATCHES[4],objNode);
                break;
            case 10:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.JAVA_CUSTOM_MATCHES[5],null);
                break;
            case 11:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.JAVA_CUSTOM_MATCHES[5],objNode);
                break;
            case 12:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.JAVA_CUSTOM_MATCHES[6],null);
                break;
            case 13:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.JAVA_CUSTOM_MATCHES[6],objNode);
                break;
            case 14:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.JAVA_CUSTOM_MATCHES[7],null);
                break;
            case 15:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.JAVA_CUSTOM_MATCHES[7],objNode);
                break;
            case 16:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.DOTNET_CUSTOM_MATCHES[0],null);
                break;
            case 17:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.DOTNET_CUSTOM_MATCHES[0],objNode);
                break;
            case 18:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.DOTNET_CUSTOM_MATCHES[1],null);
                break;
            case 19:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.DOTNET_CUSTOM_MATCHES[1],objNode);
                break;
            case 20:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.DOTNET_CUSTOM_MATCHES[2],null);
                break;
            case 21:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.DOTNET_CUSTOM_MATCHES[2],objNode);
                break;
            case 22:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.DOTNET_CUSTOM_MATCHES[3],null);
                break;
            case 23:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.DOTNET_CUSTOM_MATCHES[3],objNode);
                break;
            case 24:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.DOTNET_CUSTOM_MATCHES[4],null);
                break;
            case 25:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.DOTNET_CUSTOM_MATCHES[4],objNode);
                break;
            case 26:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.DOTNET_CUSTOM_MATCHES[5],null);
                break;
            case 27:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.DOTNET_CUSTOM_MATCHES[5],objNode);
                break;
            case 28:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[0],null);
                break;
            case 29:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[0],objNode);
                break;
            case 30:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[1],null);
                break;
            case 31:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[1],objNode);
                break;
            case 32:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[2],null);
                break;
            case 33:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[2],objNode);
                break;
            case 34:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[3],null);
                break;
            case 35:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,  s.PHP_CUSTOM_MATCHES[3],objNode);
                break;
            case 36:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.PHP_CUSTOM_MATCHES[4],null);
                break;
            case 37:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[4],objNode);
                break;
            case 38:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[5],null);
                break;
            case 39:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.PHP_CUSTOM_MATCHES[5],objNode);
                break;
            case 40:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app,s.NODEJS_CUSTOM_MATCHES[0],null);
                break;
            case 41:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), app, s.NODEJS_CUSTOM_MATCHES[0],objNode);
                break;

        }
        
        
        try{
            //return R.executeTDPostQuery(auth, query, objNode,xml);
            return R.executeAutoPostQuery(auth, query,objNode,xml);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }
    
    /**
     * <p>
     *  This will import a custom pojo into the application and tier given.
     * </p>
     * 
     * 
     * <ul>
     *  <li><b>Java Custom Match Rules</b>
     *      <ul>
            * <li>Index  0 : Imports all of the custom match rules of type <b>binaryRemoting</b> for the application
            * <li>Index  1 : Imports the custom match rules of type <b>binaryRemoting</b> with the name objNode
            * <li>Index  2 : Imports all of the custom match rules of type <b>servlet</b> for the application
            * <li>Index  3 : Imports the custom match rules of type <b>servlet</b> with the name objNode
            * <li>Index  4 : Imports all of the custom match rules of type <b>strutsAction</b> for the application
            * <li>Index  5 : Imports the custom match rules of type <b>strutsAction</b> with the name objNode
            * <li>Index  6 : Imports all of the custom match rules of type <b>springBean</b> for the application
            * <li>Index  7 : Imports the custom match rules of type <b>springBean</b> with the name objNode
            * <li>Index  8 : Imports all of the custom match rules of type <b>ejb</b> for the application
            * <li>Index  9 : Imports the custom match rules of type <b>ejb</b> with the name objNode
            * <li>Index  10 : Imports all of the custom match rules of type <b>pojo</b> for the application
            * <li>Index  11 : Imports the custom match rules of type <b>pojo</b> with the name objNode
            * <li>Index  12 : Imports all of the custom match rules of type <b>jms</b> for the application
            * <li>Index  13 : Imports the custom match rules of type <b>jms</b> with the name objNode
            * <li>Index  14 : Imports all of the custom match rules of type <b>webService</b> for the application
            * <li>Index  15 : Imports the custom match rules of type <b>webService</b> with the name objNode
        *   </ul>
        *<li><b>DotNet Custom Match Rules</b>
        *   <ul>
            * <li>Index  16 : Imports all of the custom match rules of type <b>aspDotNet</b> for the application
            * <li>Index  17 : Imports the custom match rule of type <b>aspDotNet</b> with the name objNode
            * <li>Index  18 : Imports all of the custom match rules of type <b>dotNetWebService</b> for the application
            * <li>Index  19 : Imports the custom match rule of type <b>dotNetWebService</b> with the name objNode
            * <li>Index  20 : Imports all of the custom match rules of type <b>wcf</b> for the application
            * <li>Index  21 : Imports the custom match rule of type <b>wcf</b> with the name objNode
            * <li>Index  22 : Imports all of the custom match rules of type <b>poco</b> for the application
            * <li>Index  23 : Imports the custom match rule of type <b>poco</b> with the name objNode
            * <li>Index  24 : Imports all of the custom match rules of type <b>dotNetJms</b> for the application
            * <li>Index  25 : Imports the custom match rule of type <b>dotNetJms</b> with the name objNode
            * <li>Index  26 : Imports all of the custom match rules of type <b>dotNetRemoting</b> for the application
            * <li>Index  27 : Imports the custom match rule of type <b>dotNetRemoting</b> with the name objNode
            </ul>
        * <li><b>PHP Custom Match Rules</b>
        *   <ul>
            * <li>Index  28 : Imports all of the custom match rules of type <b>phpWeb</b> for the application
            * <li>Index  29 : Imports the custom match rule of type <b>phpWeb</b> with the name objNode
            * <li>Index  30 : Imports all of the custom match rules of type <b>phpMvc</b> for the application
            * <li>Index  31 : Imports the custom match rule of type <b>phpMvc</b> with the name objNode
            * <li>Index  32 : Imports all of the custom match rules of type <b>phpDrupal</b> for the application
            * <li>Index  33 : Imports the custom match rule of type <b>phpDrupal</b> with the name objNode
            * <li>Index  34 : Imports all of the custom match rules of type <b>phpWordpress</b> for the application
            * <li>Index  35 : Imports the custom match rule of type <b>phpWordpress</b> with the name objNode
            * <li>Index  36 : Imports all of the custom match rules of type <b>phpCli</b> for the application
            * <li>Index  37 : Imports the custom match rule of type <b>phpCli</b> with the name objNode
            * <li>Index  38 : Imports all of the custom match rules of type <b>phpWebService</b> for the application
            * <li>Index  39 : Imports the custom match rule of type <b>phpWebService</b> with the name objNode
            * <li>Index  40 : Imports all of the custom match rules of type <b>nodeJsWeb</b> for the application
            </ul>
        * <li><b>NodeJS Custom Match Rules</b>
        *   <ul>
            * <li>Index  41 : Imports the custom match rule of type <b>nodeJsWeb</b> with the name objNode
        *   </ul>

     * </ul>
     * 
     * @param queryIndex The index of the query
     * @param app The name of the application
     * @param tier The name of the tier
     * @param objNode The name of the custom pojo
     * @param xml Xml string for the custom pojo
     * @return {@link String}
     * 

* 
     */
    public String postRESTCustomMatch(int queryIndex, String app, String tier, String objNode, String xml){
        
        String query=null;
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder()
                .append("\nPojo POST for application ").append(app)
                .append(" tier ").append(tier).append(" for custom pojo ").append(objNode).toString());}
        
        switch(queryIndex){
            case 0:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.JAVA_CUSTOM_MATCHES[0],null);
                break;
            case 1:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.JAVA_CUSTOM_MATCHES[0],objNode);
                break;
            case 2:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.JAVA_CUSTOM_MATCHES[1],null);
                break;
            case 3:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.JAVA_CUSTOM_MATCHES[1],objNode);
                break;
            case 4:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.JAVA_CUSTOM_MATCHES[2],null);
                break;
            case 5:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.JAVA_CUSTOM_MATCHES[2],objNode);
                break;
            case 6:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.JAVA_CUSTOM_MATCHES[3],null);
                break;
            case 7:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.JAVA_CUSTOM_MATCHES[3],objNode);
                break;
            case 8:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.JAVA_CUSTOM_MATCHES[4],null);
                break;
            case 9:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.JAVA_CUSTOM_MATCHES[4],objNode);
                break;
            case 10:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.JAVA_CUSTOM_MATCHES[5],null);
                break;
            case 11:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.JAVA_CUSTOM_MATCHES[5],objNode);
                break;
            case 12:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.JAVA_CUSTOM_MATCHES[6],null);
                break;
            case 13:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.JAVA_CUSTOM_MATCHES[6],objNode);
                break;
            case 14:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.JAVA_CUSTOM_MATCHES[7],null);
                break;
            case 15:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.JAVA_CUSTOM_MATCHES[7],objNode);
                break;
            case 16:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.DOTNET_CUSTOM_MATCHES[0],null);
                break;
            case 17:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.DOTNET_CUSTOM_MATCHES[0],objNode);
                break;
            case 18:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.DOTNET_CUSTOM_MATCHES[1],null);
                break;
            case 19:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.DOTNET_CUSTOM_MATCHES[1],objNode);
                break;
            case 20:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.DOTNET_CUSTOM_MATCHES[2],null);
                break;
            case 21:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.DOTNET_CUSTOM_MATCHES[2],objNode);
                break;
            case 22:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.DOTNET_CUSTOM_MATCHES[3],null);
                break;
            case 23:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.DOTNET_CUSTOM_MATCHES[3],objNode);
                break;
            case 24:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.DOTNET_CUSTOM_MATCHES[4],null);
                break;
            case 25:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.DOTNET_CUSTOM_MATCHES[4],objNode);
                break;
            case 26:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.DOTNET_CUSTOM_MATCHES[5],null);
                break;
            case 27:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.DOTNET_CUSTOM_MATCHES[5],objNode);
                break;
            case 28:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.PHP_CUSTOM_MATCHES[0],null);
                break;
            case 29:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.PHP_CUSTOM_MATCHES[0],objNode);
                break;
            case 30:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.PHP_CUSTOM_MATCHES[1],null);
                break;
            case 31:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.PHP_CUSTOM_MATCHES[1],objNode);
                break;
            case 32:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.PHP_CUSTOM_MATCHES[2],null);
                break;
            case 33:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.PHP_CUSTOM_MATCHES[2],objNode);
                break;
            case 34:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.PHP_CUSTOM_MATCHES[3],null);
                break;
            case 35:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,  s.PHP_CUSTOM_MATCHES[3],objNode);
                break;
            case 36:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.PHP_CUSTOM_MATCHES[4],null);
                break;
            case 37:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.PHP_CUSTOM_MATCHES[4],objNode);
                break;
            case 38:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.PHP_CUSTOM_MATCHES[5],null);
                break;
            case 39:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.PHP_CUSTOM_MATCHES[5],objNode);
                break;
            case 40:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.NODEJS_CUSTOM_MATCHES[0],null);
                break;
            case 41:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.NODEJS_CUSTOM_MATCHES[0],objNode);
                break;

        }
        
        
        try{
           
            return R.executeAutoPostQuery(auth, query,objNode,xml);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }
    
    /**
     * <p>
     *  This will import a custom pojo into the application and tier given.
     * </p>
     * 
     * 
     * <ul>
     *  <li><b>Java Custom Match Rules</b>
     *      <ul>
            * <li>Index  0 : Imports all of the custom match rules of type <b>binaryRemoting</b> for the application
            * <li>Index  1 : Imports the custom match rules of type <b>binaryRemoting</b> with the name objNode
            * <li>Index  2 : Imports all of the custom match rules of type <b>servlet</b> for the application
            * <li>Index  3 : Imports the custom match rules of type <b>servlet</b> with the name objNode
            * <li>Index  4 : Imports all of the custom match rules of type <b>strutsAction</b> for the application
            * <li>Index  5 : Imports the custom match rules of type <b>strutsAction</b> with the name objNode
            * <li>Index  6 : Imports all of the custom match rules of type <b>springBean</b> for the application
            * <li>Index  7 : Imports the custom match rules of type <b>springBean</b> with the name objNode
            * <li>Index  8 : Imports all of the custom match rules of type <b>ejb</b> for the application
            * <li>Index  9 : Imports the custom match rules of type <b>ejb</b> with the name objNode
            * <li>Index  10 : Imports all of the custom match rules of type <b>pojo</b> for the application
            * <li>Index  11 : Imports the custom match rules of type <b>pojo</b> with the name objNode
            * <li>Index  12 : Imports all of the custom match rules of type <b>jms</b> for the application
            * <li>Index  13 : Imports the custom match rules of type <b>jms</b> with the name objNode
            * <li>Index  14 : Imports all of the custom match rules of type <b>webService</b> for the application
            * <li>Index  15 : Imports the custom match rules of type <b>webService</b> with the name objNode
        *   </ul>
        *<li><b>DotNet Custom Match Rules</b>
        *   <ul>
            * <li>Index  16 : Imports all of the custom match rules of type <b>aspDotNet</b> for the application
            * <li>Index  17 : Imports the custom match rule of type <b>aspDotNet</b> with the name objNode
            * <li>Index  18 : Imports all of the custom match rules of type <b>dotNetWebService</b> for the application
            * <li>Index  19 : Imports the custom match rule of type <b>dotNetWebService</b> with the name objNode
            * <li>Index  20 : Imports all of the custom match rules of type <b>wcf</b> for the application
            * <li>Index  21 : Imports the custom match rule of type <b>wcf</b> with the name objNode
            * <li>Index  22 : Imports all of the custom match rules of type <b>poco</b> for the application
            * <li>Index  23 : Imports the custom match rule of type <b>poco</b> with the name objNode
            * <li>Index  24 : Imports all of the custom match rules of type <b>dotNetJms</b> for the application
            * <li>Index  25 : Imports the custom match rule of type <b>dotNetJms</b> with the name objNode
            * <li>Index  26 : Imports all of the custom match rules of type <b>dotNetRemoting</b> for the application
            * <li>Index  27 : Imports the custom match rule of type <b>dotNetRemoting</b> with the name objNode
            </ul>
        * <li><b>PHP Custom Match Rules</b>
        *   <ul>
            * <li>Index  28 : Imports all of the custom match rules of type <b>phpWeb</b> for the application
            * <li>Index  29 : Imports the custom match rule of type <b>phpWeb</b> with the name objNode
            * <li>Index  30 : Imports all of the custom match rules of type <b>phpMvc</b> for the application
            * <li>Index  31 : Imports the custom match rule of type <b>phpMvc</b> with the name objNode
            * <li>Index  32 : Imports all of the custom match rules of type <b>phpDrupal</b> for the application
            * <li>Index  33 : Imports the custom match rule of type <b>phpDrupal</b> with the name objNode
            * <li>Index  34 : Imports all of the custom match rules of type <b>phpWordpress</b> for the application
            * <li>Index  35 : Imports the custom match rule of type <b>phpWordpress</b> with the name objNode
            * <li>Index  36 : Imports all of the custom match rules of type <b>phpCli</b> for the application
            * <li>Index  37 : Imports the custom match rule of type <b>phpCli</b> with the name objNode
            * <li>Index  38 : Imports all of the custom match rules of type <b>phpWebService</b> for the application
            * <li>Index  39 : Imports the custom match rule of type <b>phpWebService</b> with the name objNode
            * <li>Index  40 : Imports all of the custom match rules of type <b>nodeJsWeb</b> for the application
            </ul>
        * <li><b>NodeJS Custom Match Rules</b>
        *   <ul>
            * <li>Index  41 : Imports the custom match rule of type <b>nodeJsWeb</b> with the name objNode
        *   </ul>

     * </ul>
     * 
     * @param queryIndex The index of the query
     * @param app The name of the application
     * @param tier The name of the tier
     * @param objNode The name of the custom pojo
     * @param xml1 Xml FileReader for the custom pojo
     * @return {@link String}
     * 

* 
     */
    public String postRESTCustomMatch(int queryIndex, String app, String tier, String objNode, java.io.FileReader xml1){
        
        String query=null;
        String xml=null;
        
        try{
            java.io.BufferedReader br=new java.io.BufferedReader(xml1);
            StringBuilder bud = new StringBuilder();
            String s;
            while((s= br.readLine()) != null){
                bud.append(s);
            }

            xml=bud.toString();
        }catch(Exception e){ logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred while attempting to open the file ").append(e.getMessage()).toString());return null;}
        
        if(s.debugLevel >= 2){logger.log(Level.INFO,new StringBuilder()
                .append("\nPojo POST for application ").append(app)
                .append(" tier ").append(tier).append(" for custom pojo ").append(objNode).toString());}
        
        switch(queryIndex){
            case 0:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.JAVA_CUSTOM_MATCHES[0],null);
                break;
            case 1:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.JAVA_CUSTOM_MATCHES[0],objNode);
                break;
            case 2:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.JAVA_CUSTOM_MATCHES[1],null);
                break;
            case 3:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.JAVA_CUSTOM_MATCHES[1],objNode);
                break;
            case 4:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.JAVA_CUSTOM_MATCHES[2],null);
                break;
            case 5:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.JAVA_CUSTOM_MATCHES[2],objNode);
                break;
            case 6:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.JAVA_CUSTOM_MATCHES[3],null);
                break;
            case 7:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.JAVA_CUSTOM_MATCHES[3],objNode);
                break;
            case 8:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.JAVA_CUSTOM_MATCHES[4],null);
                break;
            case 9:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.JAVA_CUSTOM_MATCHES[4],objNode);
                break;
            case 10:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.JAVA_CUSTOM_MATCHES[5],null);
                break;
            case 11:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.JAVA_CUSTOM_MATCHES[5],objNode);
                break;
            case 12:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.JAVA_CUSTOM_MATCHES[6],null);
                break;
            case 13:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.JAVA_CUSTOM_MATCHES[6],objNode);
                break;
            case 14:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.JAVA_CUSTOM_MATCHES[7],null);
                break;
            case 15:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.JAVA_CUSTOM_MATCHES[7],objNode);
                break;
            case 16:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.DOTNET_CUSTOM_MATCHES[0],null);
                break;
            case 17:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.DOTNET_CUSTOM_MATCHES[0],objNode);
                break;
            case 18:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.DOTNET_CUSTOM_MATCHES[1],null);
                break;
            case 19:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.DOTNET_CUSTOM_MATCHES[1],objNode);
                break;
            case 20:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.DOTNET_CUSTOM_MATCHES[2],null);
                break;
            case 21:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.DOTNET_CUSTOM_MATCHES[2],objNode);
                break;
            case 22:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.DOTNET_CUSTOM_MATCHES[3],null);
                break;
            case 23:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.DOTNET_CUSTOM_MATCHES[3],objNode);
                break;
            case 24:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.DOTNET_CUSTOM_MATCHES[4],null);
                break;
            case 25:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.DOTNET_CUSTOM_MATCHES[4],objNode);
                break;
            case 26:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.DOTNET_CUSTOM_MATCHES[5],null);
                break;
            case 27:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.DOTNET_CUSTOM_MATCHES[5],objNode);
                break;
            case 28:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.PHP_CUSTOM_MATCHES[0],null);
                break;
            case 29:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.PHP_CUSTOM_MATCHES[0],objNode);
                break;
            case 30:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.PHP_CUSTOM_MATCHES[1],null);
                break;
            case 31:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.PHP_CUSTOM_MATCHES[1],objNode);
                break;
            case 32:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.PHP_CUSTOM_MATCHES[2],null);
                break;
            case 33:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.PHP_CUSTOM_MATCHES[2],objNode);
                break;
            case 34:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.PHP_CUSTOM_MATCHES[3],null);
                break;
            case 35:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,  s.PHP_CUSTOM_MATCHES[3],objNode);
                break;
            case 36:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.PHP_CUSTOM_MATCHES[4],null);
                break;
            case 37:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.PHP_CUSTOM_MATCHES[4],objNode);
                break;
            case 38:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.PHP_CUSTOM_MATCHES[5],null);
                break;
            case 39:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.PHP_CUSTOM_MATCHES[5],objNode);
                break;
            case 40:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app,s.NODEJS_CUSTOM_MATCHES[0],null);
                break;
            case 41:
                query=TransactionDetectionQuery.queryGenericTransactionDetectionImport(baseURL.getControllerURL(), tier, app, s.NODEJS_CUSTOM_MATCHES[0],objNode);
                break;

        }
        
        
        try{
           
            return R.executeAutoPostQuery(auth, query,objNode,xml);
        }catch(Exception e){
            logger.log(Level.SEVERE,new StringBuilder().append("Exception occurred executing REST query::\n")
                    .append(e.getMessage()).append("\n").toString());
        }
        
        return null;
    }
    
    
    
}

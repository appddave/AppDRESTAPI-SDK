/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.appdynamics.appdrestapi.resources;

import java.util.HashMap;

/**
 *
 * @author soloink
 */
public class s {

    
    public static int debugLevel=0;
    public static int detailLevel=0;
    public static double percentageThreshold=0.25;
    public static final int MAX_TRIES=3;
    
    public static final int VERSION_MAJOR=2;
    public static final int VERSION_MINOR=5;
    public static final int VERSION_BUILD=5;
    
    
    public static final String RESTAPI_VERSION=new StringBuilder().append(VERSION_MAJOR).append(".").append(VERSION_MINOR).append(".").append(VERSION_BUILD).toString();
    
    public static final String HTTP_PROXYHOST="http.proxyHost";
    public static final String HTTP_PROXYPORT="http.proxyPort";
    public static final String HTTPS="https://";
    public static final String HTTP="http://";
    public static final String CONTROLLER_OBJ="/controller/";
    public static final String CONTROLLER_ACCOUNTS="/controller/api/accounts/";
    public static final String CONTROLLER_APPS="/controller/rest/applications/";
    public static final String CONTROLLER_CONFIG="/controller/rest/configuration";
    public static final String CONTROLLER_USERS="/controller/rest/users";
    public static final String CONTROLLER_BT_URL="/controller/transactiondetection/";
    public static final String CONTROLLER_DASHBOARD="/controller/CustomDashboardImportExportServlet";
    public static final String CONTROLLER_DASHBOARD_EX=CONTROLLER_DASHBOARD+"?dashboardId=";
    public static final String CONTROLLER_MARK_HISTORICAL="/controller/rest/mark-nodes-historical?application-component-node-ids=";
    public static final String CONTROLLER_RESTUI="/controller/restui/";
    public static final String CONTROLLER_DB_COLLECTOR="/controller/restui/dbMonitoring/createConfiguration";// Will change
    public static final String CONTROLLER_DASHBOARD_LIST="/controller/restui/dashboards/list2/false";
    public static final String ACCOUNT_LICENSE_PROPERTIES="user/accountLicenseProperties";
    public static final String ACCOUNT_EUM="user/accountEUM";
    public static final String CONTROLLER_AUTH_ACTION="/controller/auth?action=login";
    public static final String[] APPD_INTERNAL_APPS={"Database Monitoring"};
    
    public static final String COLON=":";
    public static final String P="|";
    public static final String F="/";
    public static final String Q="?";
    public static final String D_=" - ";
    public static final String _ALL_="*";
    public static final String _E="=";
    public static final String _A="&";
    public static final String _QQ="\"";
    public static final String _C=",";
    public static final String _S=" ";
   
    
    public static final String CONTENT_DISPOSITION="Content-Disposition";
    public static final String URL_TIERS="/tiers";
    public static final String URL_NODES="/nodes";
    public static final String URL_PROBLEMS="/problems";
    public static final String URL_EVENTS="/events";
    public static final String URL_POLICY_VIOLATIONS="/policy-violations?";
    public static final String URL_HEALTH_RULE_VIOLATIONS="/healthrule-violations?";
    public static final String URL_REQUEST_SNAPSHOTS="/request-snapshots?";
    public static final String URL_BACKENDS="/backends";
    public static final String URL_BACKENDS1="Backends|";
    public static final String URL_METRIC_LIST="/metrics";
    public static final String URL_OVERWRITE="?overwrite=true";
    public static final String URL_BT_AUTO="/auto";
    public static final String URL_EXCLUDE="/exclude/";
    public static final String URL_SERVLET_U="Servlet";
    public static final String URL_SERVLET_L="servlet";
    public static final String URL_POJO_CUSTOM="/pojo/custom/";
    public static final String URL_CUSTOM_MATCH="/custom";
    public static final String URL_HEALTHRULES="healthrules/";
    public static final String URL_NAME="?name=";
    public static final String URL_METRIC_PATH="/metric-data?metric-path=";
    
    
    public static final String APPLICATION_INFRA_PERF="Application Infrastructure Performance|"; //Tier comes afterwards
    public static final String INDIVIDUAL_NODES="|Individual Nodes|";
    
    /*
        This is going to handle the Agent type information
    */
    
    public static final String AGENT="|Agent|";
    public static final String AGENT_APP="App|";
    public static final String AGENT_MACHINE="Machine|";
    public static final String AVAILABILITY="Availability";
    public static final String AGENT_TOP_SUMMARY_UPLOAD="TopSummaryStats Upload|";
    public static final String AGENT_TOP_SUMMARY_STATS_EXCEED_LIMIT="TopSummaryStats Exceeding Limit";
    public static final String AGENT_TOP_SUMMARY_STATS_INVALID_TOPSUMMARY_STATS="Invalid TopSummaryStats";
    public static final String AGENT_TOP_SUMMARY_STATS_UPLOADED="TopSummaryStats uploaded";
    public static final String AGENT_TOP_SUMMARY_STATS_TIME_SKEW_ERRORS="TopSummaryStats Time skew Errors";
    public static final String AGENT_DISCOVERED_BACKENDS="Discovered Backends|";
    public static final String AGENT_DISCOVERED_BACKENDS_REGISTRATION_SUCCESSFUL="Registration Successful";
    public static final String AGENT_DISCOVERED_BACKENDS_REGISTRATION_FAILED="Registration Failed";
    public static final String AGENT_DISCOVERED_BACKENDS_UNMONITORED_CALLS_PER_MINUTE="Unmonitored Calls per Minute";
    public static final String AGENT_CONFIG_CHANNEL="ConfigChannel";
    public static final String AGENT_CONFIG_CHANNEL_NUM_OF_APP_INFRA_CHANGES_SENT="|Number Of Application Infrastructure Changes Sent";
    public static final String AGENT_SNAPSHOT_UPLOAD="Snapshot Upload|";
    public static final String AGENT_SNAPSHOT_UPLOAD_SNAPSHOTS_UPLOADED="Snapshots uploaded";
    public static final String AGENT_SNAPSHOT_UPLOAD_INVALID_SNAPSHOTS="Invalid Snapshots";
    public static final String AGENT_SNAPSHOT_UPLOAD_TIME_SKEW_ERRORS="Time skew Errors";
    public static final String AGENT_SNAPSHOT_UPLOAD_SNAPSHOTS_EXCEEDING_LIMIT="Snapshots Exceeding Limit";
    public static final String AGENT_METRIC_UPLOAD="Metric Upload|";
    public static final String AGENT_METRIC_UPLOAD_REQUESTS_LICENSE_ERRORS="Requests License Errors";
    public static final String AGENT_METRIC_UPLOAD_INVALID_METRICS="Invalid Metrics";
    public static final String AGENT_METRIC_UPLOAD_REQUESTS_TIME_SKEW_ERRORS="Requests Time skew Errors";
    public static final String AGENT_METRIC_UPLOAD_METRICS_UPLOADED="Metrics uploaded";
    public static final String AGENT_METRIC_UPLOAD_REQUESTS_EXCEEDING_LIMIT="Requests Exceeding Limit";
    public static final String AGENT_EVENT_UPLOAD="Event Upload|";
    public static final String AGENT_EVENT_UPLOAD_EVENTS_UPLOADED="Events uploaded";
    public static final String AGENT_EVENT_UPLOAD_EVENTS_EXCEEDING_LIMIT="Events Exceeding Limit";
    public static final String AGENT_EVENT_UPLOAD_TIME_SKEWS_ERRORS="Time skews Errors";
    public static final String AGENT_BUSINESS_TRANSACTIONS="Business Transactions|";
    public static final String AGENT_BUSINESS_TRANSACTIONS_UNMONITORED_CALLS_PER_MINUTE="Unmonitored Calls per Minute";
    public static final String AGENT_BUSINESS_TRANSACTIONS_REGISTRATION_FAILED="Registration Failed";
    public static final String AGENT_BUSINESS_TRANSACTIONS_REGISTRATION_SUCCESSFUL="Registration Successful";
    
    
    public static final String APP_AGENT_AVAIL_1="|Agent|App|Availability";
    public static final String MACHINE_AGENT_AVAIL_2="|Agent|Machine|Availability";
    
    
    /*
Application Infrastructure Performance|AAC-App|Hardware Resources|Memory|Swap Free (MB)
Application Infrastructure Performance|AAC-App|Hardware Resources|Memory|Swap Total (MB)
Application Infrastructure Performance|AAC-App|Hardware Resources|Memory|Swap Used (MB)
Application Infrastructure Performance|AAC-App|Hardware Resources|Memory|Total (MB) *
Application Infrastructure Performance|AAC-App|Hardware Resources|Memory|Used (MB) *
Application Infrastructure Performance|AAC-App|Hardware Resources|Memory|Free % *
Application Infrastructure Performance|AAC-App|Hardware Resources|Memory|Used % *
Application Infrastructure Performance|AAC-App|Hardware Resources|Memory|Free (MB) *
    
Application Infrastructure Performance|AAC-App|Hardware Resources|Machine|Availability
    
Application Infrastructure Performance|AAC-App|Hardware Resources|Network|eth1|Outgoing KB
Application Infrastructure Performance|AAC-App|Hardware Resources|Network|eth1|Outgoing KB/sec
Application Infrastructure Performance|AAC-App|Hardware Resources|Network|eth1|Incoming KB
Application Infrastructure Performance|AAC-App|Hardware Resources|Network|eth1|Outgoing packets
Application Infrastructure Performance|AAC-App|Hardware Resources|Network|eth1|Incoming KB/sec
Application Infrastructure Performance|AAC-App|Hardware Resources|Network|eth1|Outgoing packets/sec
Application Infrastructure Performance|AAC-App|Hardware Resources|Network|eth1|Incoming packets
Application Infrastructure Performance|AAC-App|Hardware Resources|Network|eth1|Incoming packets/sec
    
Application Infrastructure Performance|AAC-App|Hardware Resources|CPU|%Stolen
Application Infrastructure Performance|AAC-App|Hardware Resources|CPU|%Busy
Application Infrastructure Performance|AAC-App|Hardware Resources|CPU|%Idle
Application Infrastructure Performance|AAC-App|Hardware Resources|Disks|dev-mapper-vglocal00-usr00|Space Used 
Application Infrastructure Performance|AAC-App|Hardware Resources|Disks|dev-mapper-vglocal00-usr00|Avg Service Time (ms) 
Application Infrastructure Performance|AAC-App|Hardware Resources|Disks|dev-mapper-vglocal00-usr00|% CPU Time 
Application Infrastructure Performance|AAC-App|Hardware Resources|Disks|dev-mapper-vglocal00-usr00|Space Available 
Application Infrastructure Performance|AAC-App|Hardware Resources|Disks|dev-mapper-vglocal00-usr00|Avg Queue Time (ms) 
Application Infrastructure Performance|AAC-App|Hardware Resources|Disks|dev-mapper-vglocal00-usr00|Reads/sec *
Application Infrastructure Performance|AAC-App|Hardware Resources|Disks|dev-mapper-vglocal00-usr00|KB written/sec *
Application Infrastructure Performance|AAC-App|Hardware Resources|Disks|dev-mapper-vglocal00-usr00|Writes/sec *
Application Infrastructure Performance|AAC-App|Hardware Resources|Disks|dev-mapper-vglocal00-usr00|KB read/sec *
Application Infrastructure Performance|AAC-App|Hardware Resources|Volumes|/usr|Used (MB)
Application Infrastructure Performance|AAC-App|Hardware Resources|Volumes|/usr|Free (MB)
Application Infrastructure Performance|AAC-App|Hardware Resources|Volumes|/usr|Used (%)
Application Infrastructure Performance|AAC-App|Hardware Resources|Volumes|/usr|Total (MB)
    */
    public static final String HARDWARE_RESOURCES="|Hardware Resources|";
    public static final String HD_JVM_MEMORY="Memory|";
    public static final String HD_MEMORY_SWAP_TOTAL_MB="Swap Total (MB)";
    public static final String HD_MEMORY_SWAP_USED_MB="Swap Used (MB)";
    public static final String HD_MEMORY_TOTAL_MB="Total (MB)";
    public static final String HD_MEMORY_USED_MB="Used (MB)"; //Multi-used
    public static final String HD_MEMORY_FREE_PERC="Free %"; 
    public static final String HD_MEMORY_USED_PERC="Used %";
    public static final String HD_MEMORY_FREE_MB="Free (MB)"; //Multi-used
    public static final String HD_MEMORY_SWAP_FREE_MB="Swap Free (MB)";
    // Machine is here ---
    public static final String HD_NETWORK="Network|";
    public static final String HD_NETWORK_OUTGOING_KB="Outgoing KB";
    public static final String HD_NETWORK_OUTGOING_KB_PER_SEC="Outgoing KB/sec";
    public static final String HD_NETWORK_OUTGOING_PACKETS="Outgoing packets";
    public static final String HD_NETWORK_OUTGOING_PACKETS_PER_SEC="Outgoing packets/sec";
    public static final String HD_NETWORK_INCOMING_KB="Incoming KB";
    public static final String HD_NETWORK_INCOMING_KB_PER_SEC="Incoming KB/sec";
    public static final String HD_NETWORK_INCOMING_PACKETS="Incoming packets";
    public static final String HD_NETWORK_INCOMING_PACKETS_PER_SEC="Incoming packets/sec";
    public static final String HD_CPU="CPU|";
    public static final String HD_CPU_BUSY="%Busy";
    public static final String HD_CPU_IDLE="%Idle";
    public static final String HD_CPU_STOLEN="%Stolen";
    public static final String HD_DISKS="Disks|";
    public static final String HD_DISKS_KB_READ_PER_SEC="KB read/sec";
    public static final String HD_DISKS_KB_WRITE_PER_SEC="KB written/sec";
    public static final String HD_DISKS_READ_PER_SEC="Reads/sec";
    public static final String HD_DISKS_WRITES_PER_SEC="Writes/sec";
    public static final String HD_DISKS_SPACE_USED="Space Used";
    public static final String HD_DISKS_AVG_SERVICE_TIME_MS="Avg Service Time (ms)";
    public static final String HD_DISKS_PER_CPU_TIME="% CPU Time";
    public static final String HD_DISKS_SPACE_AVAILABLE="Space Available";
    public static final String HD_DISKS_AVG_QUEUE_TIME_MS="Avg Queue Time (ms)";
    public static final String HD_VOLUMES="Volumes|";
    public static final String HD_VOLUMES_USED_PER="Used (%)";
    public static final String HD_VOLUMES_TOTAL_MB="Total (MB)";
    
    public static final String HD_SYSTEM="System|";
    public static final String HD_RQ="RQ";
   
    /*
        As of 4.2, there have been a good number of additional metrics
        Application Infrastructure Performance|AAC-App|JVM|Threads|Current No. of Threads
Application Infrastructure Performance|AAC-App|JVM|Memory|Non-Heap|Current Usage (MB)
Application Infrastructure Performance|AAC-App|JVM|Memory|Non-Heap|Used %
Application Infrastructure Performance|AAC-App|JVM|Memory|Non-Heap|Max Available (MB)
Application Infrastructure Performance|AAC-App|JVM|Memory|Non-Heap|Committed (MB)
Application Infrastructure Performance|AAC-App|JVM|Memory|Heap|Max Available (MB)
Application Infrastructure Performance|AAC-App|JVM|Memory|Heap|Current Usage (MB)
Application Infrastructure Performance|AAC-App|JVM|Memory|Heap|Committed (MB)
Application Infrastructure Performance|AAC-App|JVM|Memory|Heap|Used %
Application Infrastructure Performance|AAC-App|JVM|Classes|Current Loaded Class Count
Application Infrastructure Performance|AAC-App|JVM|Classes|Total Classes Loaded
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Par Eden Space|Committed (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Par Eden Space|Current Usage (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Par Eden Space|Max Available (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|PS Survivor Space|Max Available (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|PS Survivor Space|Committed (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|PS Survivor Space|Current Usage (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|G1 Eden Space|Committed (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|G1 Eden Space|Current Usage (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|G1 Eden Space|Max Available (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|PS Old Gen|Committed (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|PS Old Gen|Max Available (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|PS Old Gen|Current Usage (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Tenured Gen|Current Usage (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Tenured Gen|Committed (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Tenured Gen|Max Available (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Compressed Class Space|Max Available (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Compressed Class Space|Committed (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Compressed Class Space|Current Usage (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Nursery|Current Usage (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Nursery|Committed (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Nursery|Max Available (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Eden Space|Committed (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Eden Space|Current Usage (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Eden Space|Max Available (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|CMS Perm Gen|Committed (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|CMS Perm Gen|Max Available (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|CMS Perm Gen|Current Usage (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Code Cache|Current Usage (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Code Cache|Max Available (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Code Cache|Committed (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|G1 Perm Gen|Max Available (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|G1 Perm Gen|Committed (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|G1 Perm Gen|Current Usage (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Par Survivor Space|Max Available (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Par Survivor Space|Committed (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Par Survivor Space|Current Usage (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|G1 Survivor Space|Current Usage (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|G1 Survivor Space|Max Available (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|G1 Survivor Space|Committed (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Perm Gen|Max Available (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Perm Gen|Current Usage (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Perm Gen|Committed (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Survivor Space|Current Usage (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Survivor Space|Max Available (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Survivor Space|Committed (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Old Space|Committed (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Old Space|Current Usage (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Old Space|Max Available (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|CMS Old Gen|Current Usage (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|CMS Old Gen|Committed (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|CMS Old Gen|Max Available (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Metaspace|Committed (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Metaspace|Current Usage (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Metaspace|Max Available (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|PS Eden Space|Max Available (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|PS Eden Space|Current Usage (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|PS Eden Space|Committed (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|G1 Old Gen|Max Available (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|G1 Old Gen|Committed (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|G1 Old Gen|Current Usage (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|ClassBlock Memory|Max Available (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|ClassBlock Memory|Committed (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|ClassBlock Memory|Current Usage (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Class Memory|Committed (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Class Memory|Max Available (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|Class Memory|Current Usage (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|PS Perm Gen|Committed (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|PS Perm Gen|Current Usage (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Memory Pools|PS Perm Gen|Max Available (MB)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Number of Major Collections Per Min
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Minor Collection Time Spent Per Min (ms)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|GC Time Spent Per Min (ms)
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Number of Minor Collections Per Min
Application Infrastructure Performance|AAC-App|JVM|Garbage Collection|Major Collection Time Spent Per Min (ms)
Application Infrastructure Performance|AAC-App|JVM|Process CPU Usage %
Application Infrastructure Performance|AAC-App|JVM|Process CPU Burnt (ms/min)

    */
    public static final String JVM="|JVM|"; // *
    public static final String JVM_PROCESS_CPU_BURNT_MS_PER_MIN="Process CPU Burnt (ms/min)";
    public static final String JVM_PROCESS_CPU_USAGE_PERC="Process CPU Usage %";
    public static final String JVM_GARBAGE_COLLECTION="Garbage Collection|"; // *
    public static final String JVM_GARBAGE_COLLECTION_GC_TIME_SPENT_PER_MIN_MS="GC Time Spent Per Min (ms)";
    public static final String JVM_GARBAGE_COLLECTION_MAJOR_COLLECTION_TIME_SPENT_PER_MIN_MS="Major Collection Time Spent Per Min (ms)";
    public static final String JVM_GARBAGE_COLLECTION_MINOR_COLLECTION_TIME_SPENT_PER_MIN_MS="Minor Collection Time Spent Per Min (ms)";
    public static final String JVM_GARBAGE_COLLECTION_NUMBER_OF_MAJOR_COLLECTION_PER_MIN="Number of Major Collections Per Min";
    public static final String JVM_GARBAGE_COLLECTION_NUMBER_OF_MINOR_COLLECTIONS_PER_MIN="Number of Minor Collections Per Min"; // Memory Pools|
    public static final String JVM_MEMORY_POOLS="Memory Pools|"; // *
    public static final String JVM_CODE_CACHE="Code Cache|";
    public static final String JVM_PS_EDEN_SPACE="PS Eden Space|";
    public static final String JVM_EDEN_SPACE="Eden Space|";
    public static final String JVM_PAR_EDEN_SPACE="Par Eden Space|";
    public static final String JVM_PS_OLD_GEN="PS Old Gen|";
    public static final String JVM_OLD_GEN="Old Gen|";
    public static final String JVM_PERM_GEN="Perm Gen|";
    public static final String JVM_PS_PERM_GEN="PS Perm Gen|";
    public static final String JVM_G1_EDEN_SPACE="G1 Eden Space|";
    public static final String JVM_G1_PERM_GEN="G1 Perm Gen|";
    public static final String JVM_G1_SURVIVOR_SPACE="G1 Survivor Space|";
    public static final String JVM_G1_OLD_GEN="G1 Old Gen|";
    public static final String JVM_SURVIVOR_SPACE="Survivor Space|";
    public static final String JVM_OLD_SPACE="Old Space|";
    public static final String JVM_CLASSBLOCK_MEMORY="ClassBlock Memory|";
    public static final String JVM_CLASS_MEMORY="Class Memory|";
    public static final String JVM_TENURED_GEN="Tenured Gen|";
    public static final String JVM_METASPACE="Metaspace|";
    public static final String JVM_NURSERY="Nursery|";
    public static final String JVM_PAR_SURVIVOR_SPACE="Par Survivor Space";
    public static final String JVM_COMPRESSED_CLASS_SPACE="Compressed Class Space|";
    public static final String JVM_CMS_PERM_GEN="CMS Perm Gen|";
    public static final String JVM_CMS_OLD_GEN="CMS Old Gen|";
    public static final String JVM_PS_SURVIVOR_SPACE="PS Survivor Space|";
    public static final String JVM_MEMORY_HEAP="Heap|";
    public static final String JVM_MEMORY_NON_HEAP="Non-Heap|";
    public static final String JVM_MEMORY_HEAP_COMMITED_MB="Committed (MB)";
    public static final String JVM_MEMORY_HEAP_CURRENT_USAGE_MB="Current Usage (MB)";
    public static final String JVM_MEMORY_HEAP_MAX_AVAILABLE_MB="Max Available (MB)";
    public static final String JVM_MEMORY_HEAP_USED_PERC="Used %";
    public static final String JVM_THREADS_CURRENT_NO_OF_THREADS="Threads|Current No. of Threads";
    public static final String JVM_CLASSES="Classes|";
    public static final String JVM_CLASSES_CURRENT_LOADED_CLASS_COUNT="Current Loaded Class Count";
    public static final String JVM_CLASSES_TOTAL_CLASSES_LOADED="Total Classes Loaded";
    
    public static final String LAST_15_MINUTES="&time-range-type=BEFORE_NOW&duration-in-mins=15";
    public static final String TIME_BETWEEN="&time-range-type=BETWEEN_TIMES";
    public static final String TIME_BETWEEN1="?time-range-type=BETWEEN_TIMES";
    public static final String TIME_START_TIME="&start-time=";
    public static final String TIME_END_TIME="&end-time=";
    public static final String NO_ROLL_UP="&rollup=false";
    public static final String XML_OUTPUT="&output=XML";
    
    public static final String EVENT_TYPES="&event-types=";
    public static final String SEVERITIES="&severities=";

    // For USER
    public static final String USER_NAME="user-name";
    public static final String USER_PASSWD="user-password";
    public static final String USER_ID="user-id";
    public static final String USER_ROLES="user-roles";
    public static final String USER_DISPLAY_NAME="user-display-name";
    public static final String USER_EMAIL="user-email";
    
    //For Snapshot parameters
    public static final String SNAPSHOT_ARCHIVED="&archived=";
    public static final String SNAPSHOT_DEEP_DIVE_POLICY="&deep-dive-policy=";
    public static final String SNAPSHOT_GUIDS="&guids=";
    public static final String SNAPSHOT_APPLICATION_COMPONENT_IDS="&application-component-ids=";
    public static final String SNAPSHOT_APPLICATION_COMPONENT_NODE_IDS="&application-component-node-ids=";
    public static final String SNAPSHOT_BUSINESS_TRANSACTION_IDS="&business-transaction-ids=";
    public static final String SNAPSHOT_USER_EXPERIENCE="&user-experience=";
    public static final String SNAPSHOT_FIRST_IN_CHAIN="&first-in-chain=";
    public static final String SNAPSHOT_NEED_PROPS="&need-props=";
    public static final String SNAPSHOT_NEED_EXIT_CALLS="&need-exit-calls=";
    public static final String SNAPSHOT_EXECUTION_TIME_IN_MILIS="&execution-time-in-milis=";
    public static final String SNAPSHOT_SESSION_ID="&session-id=";
    public static final String SNAPSHOT_USER_PRINCIPLE_ID="&user-principal-id=";
    public static final String SNAPSHOT_ERROR_IDS="&error-ids=";
    public static final String SNAPSHOT_ERROR_OCCURED="&error-occured=";
    public static final String SNAPSHOT_DIAGNOSTIC_SNAPSHOT="&diagnostic-snapshot=";
    public static final String SNAPSHOT_BAD_REQUEST="&bad-request=";
    public static final String SNAPSHOT_DIAGNOSTIC_SESSION_GUID="&diagnostic-session-guid=";
    public static final String SNAPSHOT_DATA_COLLECTOR_NAME="&data-collector-name=";
    public static final String SNAPSHOT_STARTING_REQUEST_ID="&starting-request-id=";
    public static final String SNAPSHOT_ENDING_REQUEST_ID="&ending-request-id=";
    //Data Collector Name must be set
    public static final String SNAPSHOT_DATA_COLLECTOR_VALUE="&data-collector-value=";
    public static final String SNAPSHOT_DATA_COLLECTOR_TYPE="&data-collector-type=";
    public static final String[] SNAPSHOT_DEEP_DIVE_POLICY_VALUES={"SLA_FAILURE","TIME_SAMPLING","ERROR_SAMPLING","OCCURRENCE_SAMPLING",
        "ON_DEMAND","HOTSPOT","HOTSPOT_LEARN","APPLICATION_STARTUP","SLOW_DIAGNOSTIC_SESSION","ERROR_DIAGNOSTIC_SESSION",
        "POLICY_FAILURE_DIAGNOSTIC_SESSION","DIAGNOSTIC_SESSION","INFLIGHT_SLOW_SESSION"};
    public static final String[] SNAPSHOT_USER_EXP_VALUES={"NORMAL","SLOW","VERY_SLOW","STALL","ERROR"};
    public static final String[] SNAPSHOT_DATA_COLLECTOR_TYPE_VALUES={"Error IDs","Stack Traces","Error Detail","Http Parameter",
        "Business Data","Cookie","Http Header","Session Key","Response Header","Log Message","Transaction Property",
        "Transaction Event","Dotnet Property","isProtoBuf","EUM Request GUID"};
    
    public static final String ID="id";
    public static final String NAME="name";
    public static final String DESCRIPTION="description";
    public static final String APPLICATIONS="applications";
    public static final String APPLICATION="application";
    public static final String METRIC_DATAS="metric-datas";
    public static final String METRIC_DATA="metric-data";
    public static final String METRIC_PATH="metricPath";
    public static final String FREQUENCY="frequency";
    public static final String METRIC_ITEM="metric-item";
    public static final String METRIC_ITEMS="metric-items";
    public static final String METRIC_ITEM_FOLDER="folder";
    public static final String METRIC_ID="metricId";
    public static final String URL_METRIC_PATH_LIST="?metric-path=";
    
    
    public static final String METRIC_VALUES="metricValues";
    public static final String METRIC_VALUE="metric-value";
    public static final String START_TIME_IN_MILLIS="startTimeInMillis";
    public static final String VALUE="value";
    public static final String MIN="min";
    public static final String MAX="max";
    public static final String CURRENT="current";
    public static final String SUM="sum";
    public static final String COUNT="count";
    public static final String STD_DEVIATION="standardDeviation";
    public static final String OCCURRENCES="occurrences";
    public static final String USERANGE="useRange";
    
    public static final String TIERS="tiers";
    public static final String TIER="tier";
    public static final String NUMBER_OF_NODES="numberOfNodes";
    public static final String AGENT_TYPE="agentType";
    public static final String TYPE="type";
    
    public static final String NODE="node";
    public static final String NODES="nodes";
    public static final String IPADDRESS="ipAddress";
    public static final String IPADDRESSES="ipAddresses";
    public static final String TIER_NAME="tierName";
    public static final String TIER_ID="tierId";
    public static final String MACHINE_ID="machineId";
    public static final String MACHINE_NAME="machineName";
    public static final String MACHINE_OS_TYPE="machineOSType";
    public static final String MACHINE_AGENT_PRESENT="machineAgentPresent";
    public static final String MACHINE_AGENT_VERSION="machineAgentVersion";
    public static final String APP_AGENT_PRESENT="appAgentPresent";
    public static final String APP_AGENT_VERSION="appAgentVersion";
    
    public static final String BUSINESS_TRANSACTIONS="business-transactions";
    public static final String BUSINESS_TRANSACTION="business-transaction";
    public static final String ENTRY_POINT_TYPE="entryPointType";
    public static final String INTERNAL_NAME="internalName";
    public static final String BACKGROUND="background";
    
    public static final String APPLICATION_EX_ID="ConfigObjectImportExportServlet?applicationId=";
    
    public static final String AGENT_TYPE_CHK_PHP="PHP";
    public static final String AGENT_TYPE_CHK_IIS="IIS";
    public static final String AGENT_TYPE_CHK_NODEJS="nodejs";
    public static final String AGENT_TYPE_WEB_SERVER="NATIVE_WEB_SERVER";
    public static final String AGENT_TYPE_CHK_SDK="NATIVE_SDK";
    
    public static final String AGENT_NAME_JAVA="Java Agent";
    public static final String AGENT_NAME_PHP="PHP Agent";
    public static final String AGENT_NAME_NODEJS="NodeJS Agent";
    public static final String AGENT_NAME_DOTNET="DotNet Agent";
    public static final String AGENT_NAME_MACHINE_AGENT="Machine Agent";
    public static final String AGENT_NAME_WEB_SERVER="Web Server";
    public static final String AGENT_NAME_C_SDK="NATIVE SDK";
    
    /*
     *  Overall performance
    */
    public static final String OVERALL_APPLICATION_PERF="Overall Application Performance|"; //Tier comes afterwards
    public static final String AVERAGE_RESPONSE_TIME_MS="|Average Response Time (ms)";
    public static final String CALLS_PER_MINUTE="|Calls per Minute";
    public static final String ERROR_PAGE_REDIRECTS_PER_MINUTE="|Error Page Redirects per Minute";
    public static final String ERRORS_PER_MINUTE="|Errors per Minute";
    public static final String EXCEPTIONS_PER_MINUTE="|Exceptions per Minute";
    public static final String HTTP_ERROR_CODES_PER_MINUTE="|HTTP Error Codes per Minute";
    public static final String INFRASTRUCTURE_ERRORS_PER_MINUTE="|Infrastructure Errors per Minute";
    public static final String NUMBER_OF_SLOW_CALLS="|Number of Slow Calls";
    public static final String NUMBER_OF_VERY_SLOW_CALLS="|Number of Very Slow Calls";
    public static final String STALL_COUNT="|Stall Count";
    public static final String EXTERNAL_CALLS="|External Calls|";
    public static final String THREAD_TASKS="|Thread Tasks";
    public static final String LICENSE_FILE_TRACKER="|LicenseFileTracker";
    
    /*
     *  BT Performance
     */
    public static final String URL_BUSINESS_TRANSACTION_PERFORMANCE="Business Transaction Performance|";
    public static final String URL_BUSINESS_TRANSACTIONS="Business Transactions|";
    public static final String AVERAGE_BLOCK_TIME_MS="Average Block Time (ms)";
    public static final String AVERAGE_CPU_USED_MS="Average CPU Used (ms)";
    public static final String AVERAGE_REQUEST_SIZE="Average Request Size";
    public static final String AVERAGE_RESPONSE_TIME="Average Response Time (ms)";
    public static final String AVERAGE_WAIT_TIME_MS="Average Wait Time (ms)";
    public static final String CALL_PER_MINUTE="Calls per Minute";
    //public static final String ERRORS_PER_MINUTE="Errors per Minute";
    public static final String NORMAL_AVERAGE_RESPONSE_TIME_MS="Normal Average Response Time (ms)";
    //public static final String NUMBER_OF_SLOW_CALLS="";
    //public static final String NUMBER_OF_VERY_SLOW_CALLS="";
    //public static final String STALL_COUNT="Stall Count";
    

    
    public static final String EUM_USER_EXPERIENCE="End User Experience|";
    public static final String EUM_AJAX_Requests="AJAX Requests|";

    
    public static final String EUM_APPLICATION_SERVER_TIME_MS="|Application Server Time (ms)";
    public static final String EUM_APPLICATION_SERVER_CALLS_PER_MINUTE="|Application Server Calls per Minute";
    public static final String EUM_END_USER_RESPONSE_TIME_50TH_PERCENTILE_MS="|End User Response Time 50th percentile (ms)";
    public static final String EUM_END_USER_RESPONSE_TIME_90TH_PERCENTILE_MS="|End User Response Time 90th percentile (ms)";
    public static final String EUM_END_USER_RESPONSE_TIME_95TH_PERCENTILE_MS="|End User Response Time 95th percentile (ms)";
    public static final String EUM_END_USER_RESPONSE_TIME_99TH_PERCENTILE_MS="|End User Response Time 99th percentile (ms)";
    public static final String EUM_FIRST_BYTE_TIME_50TH_PERCENTILE_MS="|First Byte Time 50th percentile (ms)";
    public static final String EUM_FIRST_BYTE_TIME_90TH_PERCENTILE_MS="|First Byte Time 90th percentile (ms)";
    public static final String EUM_FIRST_BYTE_TIME_95TH_PERCENTILE_MS="|First Byte Time 95th percentile (ms)";
    public static final String EUM_FIRST_BYTE_TIME_99TH_PERCENTILE_MS="|First Byte Time 99th percentile (ms)";
    
    public static final String EUM_REQUESTS_PER_MIN="|Requests per Minute";
    public static final String EUM_AJAX_REQUEST_ERRORS_PER_MINUTE="|AJAX Request Errors per Minute";
    public static final String EUM_DOCUMENT_DOWNLOAD_TIME_MS="|Document Download Time (ms)";
    public static final String EUM_DOCUMENT_PROCESSING_TIME_MS="|Document Processing Time (ms)";
    public static final String EUM_END_USER_RESPONSE_TIME="|End User Response Time (ms)";
    public static final String EUM_FIRST_BYTE_TIME_MS="|First Byte Time (ms)";
    

    public static final String EUM_TCP_CONNECT_TIME_MS="|TCP Connect Time (ms)";
    public static final String EUM_DOM_READY_TIME_MS="|DOM Ready Time (ms)";
    public static final String EUM_DOM_READY_TIME_50TH_PERCENTILE_MS="|DOM Ready Time 50th percentile (ms)";
    public static final String EUM_DOM_READY_TIME_90TH_PERCENTILE_MS="|DOM Ready Time 90th percentile (ms)";
    public static final String EUM_DOM_READY_TIME_95TH_PERCENTILE_MS="|DOM Ready Time 95th percentile (ms)";
    public static final String EUM_DOM_READY_TIME_99TH_PERCENTILE_MS="|DOM Ready Time 99th percentile (ms)";
    public static final String EUM_DOMAIN_LOOKUP_TIME="|Domain Lookup Time (ms)";
    public static final String EUM_SSL_HANDSHAKE_TIME_MS="|SSL Handshake Time (ms)";
    public static final String EUM_BASE_PAGES="Base Pages|";
    public static final String EUM_IFRAMES="Iframes|";
    public static final String EUM_DOCUEMENT_READY_TIME_MS="|Document Ready Time (ms)";
    public static final String EUM_FRONT_END_TIME_MS="|Front End Time (ms)";
    public static final String EUM_PAGE_RENDER_TIME_MS="|Page Render Time (ms)";
    public static final String EUM_PAGE_VIEWS_WITH_JAVASCRIPT_ERRORS_PER_MINUTE="|Page views with JavaScript Errors per Minute";
    public static final String EUM_RESPONSE_AVAILABLE_TIME_MS="|Response Available Time (ms)";
    public static final String EUM_SERVER_CONNECTION_TIME_MS="|Server Connection Time (ms)";
    public static final String EUM_SYNTHETIC_REQUESTS_PER_MINUTE="|Synthetic Requests per Minute";
    
    
    public static final String DOT_NET_PROPERTY="dotnetProperty";
    public static final String UNRESOLVED_CALL_IN_CALL_CHAIN="unresolvedCallInCallChain";
    public static final String TRANSACTION_EVENTS="transactionEvents";
    public static final String TRANSACTION_PROPERTIES="transactionProperties";
    public static final String LOG_MESSAGES="logMessages";
    public static final String RESPONSE_HEADERS="responseHeaders";
    public static final String SESSION_KEYS="sessionKeys";
    public static final String SERVER_START_TIME="serverStartTime";
    public static final String HTTP_HEADERS="httpHeaders";
    public static final String COOKIES="cookies";
    public static final String BUSINESS_DATA="businessData";
    public static final String HTTP_PARAMETERS="httpParameters";
    public static final String ERROR_DETAILS="errorDetails";
    public static final String ERROR_IDS="errorIDs";
    public static final String URL="URL";
    public static final String EXIT_CALLS_DATA_TRUNCATED="exitCallsDataTruncated";
    public static final String DELAY_DEEP_DIVE_OFFSET="delayedDeepDiveOffSet";
    public static final String DELAY_DEEP_DIVE="delayedDeepDive";
    public static final String DEEP_DIVE_POLICY="deepDivePolicy";
    public static final String DIAGNOSTIC_SESSION_GUID="diagnosticSessionGUID";
    public static final String ERROR_SUMMARY="errorSummary";
    public static final String SUMMARY="summary";
    public static final String CRITICAL_THRESHOLD="criticalThreshold";
    public static final String WARNING_THRESHOLD="warningThreshold";
    public static final String CPU_TIME_TAKEN_IN_MILLISSECS="cpuTimeTakenInMilliSecs";
    public static final String TIME_TAKEN_IN_MILLISECS="timeTakenInMilliSecs";
    public static final String USER_EXPERIENCE="userExperience";
    public static final String HAS_DEEP_DIVE_DATA="hasDeepDiveData";
    public static final String ERROR_OCCURRED="errorOccured";
    public static final String LOCAL_ID="localID";
    public static final String CALL_CHAIN="callChain";
    public static final String FIRST_IN_CHAIN="firstInChain";
    public static final String LOCAL_START_TIME="localStartTime";
    public static final String THREAD_NAME="threadName";
    public static final String THREAD_ID="threadID";
    public static final String ASYNC="async";
    public static final String APPLICATION_COMPONENT_NODE_ID="applicationComponentNodeId";
    public static final String APPLICATION_COMPONENT_ID="applicationComponentId";
    public static final String APPLICATION_ID="applicationId";
    public static final String BUSINESS_TRANSACTION_ID="businessTransactionId";
    public static final String REQUEST_GUID="requestGUID";
    public static final String ARCHIVED="archived";
    public static final String REQUEST_SEGMENT_DATA="request-segment-data";
    public static final String REQUEST_SEGMENT_DATAS="request-segment-datas";
    
    public static final String[] SHORT_METRIC_TYPES={"BT","BE","Agent","HW","JVM","OAP","EUM","CUSTOM", "AJAX Requests", "Base Pages", "Iframes"};
    public static final String[] LONG_METRIC_TYPES={"Business Transation","Backend","Agent","Hardware","JVM","Overall Application Performance","End User Management","Custom Metric"};
    
    public static final String[] JAVA_CUSTOM_MATCHES={"binaryRemoting","servlet","strutsAction","springBean","ejb","pojo","jms","webService"};
    public static final String[] DOTNET_CUSTOM_MATCHES={"aspDotNet","dotNetWebService","wcf","poco","dotNetJms","dotNetRemoting"};
    public static final String[] PHP_CUSTOM_MATCHES={"phpWeb","phpMvc","phpDrupal","phpWordpress","phpCli","phpWeb","phpWebService"};
    public static final String[] NODEJS_CUSTOM_MATCHES={"nodeJsWeb"};
    
    //events?eventtype=CUSTOM&customeventtype=nagios&summary=test1&propertynames=key1&propertynames=key2&propertyvalues=value1&propertyvalues=value2
    public static final String CUSTOM_V="custom";
    public static final String EVENT_TYPE_CUSTOM="?eventtype=CUSTOM";
    public static final String CUSTOM_EVENT_TYPE="&customeventtype=";
    public static final String EVENT_SUMMARY="&summary=";
    public static final String PROPERTY_NAMES="&propertynames=";
    public static final String PROPERTY_VALUES="&propertyvalues=";
    public static final String EVENT_TIER="&tier=";
    public static final String EVENT_NODE="&node=";
    public static final String EVENT_BT="&bt=";
    public static final String EVENT_COMMENT="&comment=";
    public static final String EVENT_SEVERITY="&severity=";
    
    /*
     * Pojo

        <business-transaction-name>Cron4J</business-transaction-name>
        <entry-point>POJO</entry-point>
        <background>false</background>
        <enabled>false</enabled>
    
        <match-rule>
            <pojo-rule>
                <enabled>false</enabled>
                <priority>0</priority>
                <display-name>Cron4J</display-name>
                <background>true</background>
                <match-class type="inherits-from-class">
                    <name filter-type="EQUALS" filter-value="it.sauronsoftware.cron4j.Task"/>
                </match-class>
                <split-config type="4"/>
                <match-method>
                    <name filter-type="EQUALS" filter-value="execute"/>
                </match-method>
            </pojo-rule>
            <match-rule>
            <servlet-rule>
                <enabled>true</enabled>
                <priority>10</priority>
                <uri filter-type="[CONTAINS]" filter-value="[CHECK]"/>
                <properties/>
            </servlet-rule>
        </match-rule>
        </match-rule>
    <custom-match-point>
        <name>CM9TaxServices.updateFeeWaiver</name>
        <business-transaction-name>CM9TaxServices.updateFeeWaiver</business-transaction-name>
        <entry-point>EJB</entry-point>
        <background>false</background>
        <enabled>true</enabled>
        <match-rule>
            <ejb-rule>
                <enabled>true</enabled>
                <priority>0</priority>
                <ejb-name filter-type="CONTAINS" filter-value="CM9TaxServices"/>
                <match-method>
                    <name filter-type="CONTAINS" filter-value="updateFeeWaiver"/>
                </match-method>
            </ejb-rule>
        </match-rule>
    </custom-match-point>

     */
    
    public static final String[] FILTER_TYPE_VALUES={"EQUALS","STARTSWITH","CONTAINS","NOT_EMPTY"};
    public static final String NOT_EMPTY_VALUE="&lt;not empty>";
    public static final String CUSTOM_MATCH_POINTS="custom-match-points";
    public static final String CUSTOM_MATCH_POINT="custom-match-point";
    public static final String ENTRY_POINT="entry-point";
    public static final String MATCH_RULE="match-rule";
    public static final String POJO_RULE="pojo-rule";
    public static final String SERVLET_RULE="servlet-rule";
    public static final String EJB_RULE="ejb-rule";
    public static final String URI="uri";
    /*
     * Configuration items
     * 
     */
    public static final String CONFIGURATION_ITEM="configuration-item";
    public static final String CONFIGURATION_ITEMS="configuration-items";
    public static final String UPDATEABLE="updateable";
    public static final String SCOPE="scope";
   
    
    /* * SNAPSHOTS * 
      
 * <request-segment-datas>
 * <request-segment-data>
        <id>0</id>
        <archived>false</archived>
        <requestGUID>103b98e6-4b33-4a8d-9511-d572e9c828c8</requestGUID>
        <businessTransactionId>7204</businessTransactionId>
        <applicationId>81</applicationId>
        <applicationComponentId>650</applicationComponentId>
        <applicationComponentNodeId>19155</applicationComponentNodeId>
        <async>false</async>
        <threadID>59</threadID>
        <threadName>http-8080-19</threadName>
        <localStartTime>1398266842227</localStartTime>
        <serverStartTime>1398266842227</serverStartTime>
        <firstInChain>true</firstInChain>
        <callChain>Component:650</callChain>
        <localID>0</localID>
        <errorOccured>false</errorOccured>
        <hasDeepDiveData>true</hasDeepDiveData>
        <userExperience>VERY_SLOW</userExperience>
</request-segment-data>
 * 
     */
    
    
    /*

  <appAgentPresent>true</appAgentPresent>
  <appAgentVersion>Server Agent v3.7.11.0 GA #2013-09-27_11-05-45 re280bc92c2f193d92459c97836bba1297e1057cb 7</appAgentVersion>
     */
    
    public static final boolean QUERY_DEBUG=true;
    public static final boolean UI_DEBUG=false;
    
    public static final HashMap<String,String> TIMERANGE=new HashMap<String,String>();
    static{
        TIMERANGE.put("BEFORE_NODE", "1");
        TIMERANGE.put("BEFORE_TIME","2");
        TIMERANGE.put("AFTER_TIME","3");
        TIMERANGE.put("BETWEEN_TIMES","4");
    }
    
    public static long _20HOURSINMILLIS= 1000*60*20;
    
    public static String SEVERITY_INFO="INFO";
    public static String SEVERITY_WARN="WARN";
    public static String SEVERITY_ERROR="ERROR";
    
    // Action Suppression
    public static final String ACTION_SUPPRESSIONS="actionsuppressions";
    public static final String MYACCOUNT="myaccount";
    
    public static final String DBC_AGENT_NAME="agentName";
    public static final String DBC_DB_NAME="name"; 
    public static final String DBC_HOSTNAME="hostname";
    public static final String DBC_PORT="port";//
    public static final String DBC_USERNAME="username";//
    public static final String DBC_PASSWORD="password";//
    public static final String DBC_USE_SERVICE_NAME="useServiceName";//
    public static final String DBC_SID="sid";//
    public static final String DBC_ENABLE_OS_MONITOR="enableOSMonitor";//
    public static final String DBC_HOST_OS="hostOS";//
    public static final String DBC_SSH_PORT="sshPort";//
    public static final String DBC_HOST_USERNAME="hostUsername";//
    public static final String DBC_HOST_PASSWORD="hostPassword";
    
    /*
    "appAgentLicenseProperties"
"dotNetLicenseProperties"
"nativeLicenseProperties":
"nativeSDKLicenseProperties"
"nativeDynamicLicenseProperties"
"nativeWebServerLicenseProperties"
"phpLicenseProperties"
"nodeJsLicenseProperties"
"pythonLicenseProperties"
"dbLicenseProperties":
"machineLicenseProperties"
"transactionAnalyticsLicenseProperties"
"logAnalyticsLicenseProperties"
    */
    public static final String LICENSE_PROPERTIES="LicenseProperties";
    public static final String APP_AGENT_LICENSE_PROPERTIES="appAgentLicenseProperties";
    public static final String DOT_NET_LICENSE_PROPERTIES="dotNetLicenseProperties";
    public static final String NATIVE_LICENSE_PROPERTIES="nativeLicenseProperties";
    public static final String NATIVE_SDK_LICENSE_PROPERTIES="nativeSDKLicenseProperties";
    public static final String NATIVE_DYNAMIC_LICENSE_PROPERTIES="nativeDynamicLicenseProperties";
    public static final String NATIVE_WEB_SERVER_LICENSE_PROPERTIES="nativeWebServerLicenseProperties";
    public static final String PHP_LICENSE_PROPERTIES="phpLicenseProperties";
    public static final String NODEJS_LICENSE_PROPERTIES="nodeJsLicenseProperties";
    public static final String PYTHON_LICENSE_PROPERTIES="pythonLicenseProperties";
    public static final String DB_LICENSE_PROPERTIES="dbLicenseProperties";
    public static final String MACHINE_LICENSE_PROPERTIES="machineLicenseProperties";
    public static final String TRANSACTION_ANALYTICS_LICENSE_PROPERTIES="transactionAnalyticsLicenseProperties";
    public static final String LOG_ANALYTICS_LICENSE_PROPERTIES="logAnalyticsLicenseProperties";
    
    /* 
    */
    public static final String EDITION="edition";
    public static final String EXPIRATION_DATE="expirationDate";
    public static final String LICENSE_MODEL="licenseModel";
    public static final String NUM_OF_PROVISIONED_LICENSE="numOfProvisionedLicense";
    public static final String MAX_ALLOWED_LICENSES="maxAllowedLicenses";
    public static final String LAST_HOUR_USAGE="lastHourUsage";
    public static final String IS_LICENSED="isLicensed";
    public static final String IS_EXPIRED="isExpired";
    public static final String DATA_RETENTION_PERIOD="dataRetentionPeriod";
    
    
    public static final String LIC_ACCOUNT_EUM="Account_EUM";
    public static final String LICENSE_KEY="licenseKey";
    public static final String ALLOCATED_PAGE_VIEWS="allocatedPageViews";
    public static final String CONSUMED_PAGE_VIEWS= "consumedPageViews";
    public static final String CURRENT_USAGE_PERIOD_START_MILLIS="currentUsagePeriodStartMillis";
    public static final String CURRENT_USAGE_PERIOD_END_MILLIS="currentUsagePeriodEndMillis";
    public static final String LICENSE_TYPE="licenseType";
    public static final String LICENSE_UNITS="licenseUnits";
    public static final String LICENSE_ALLOWED_OVERAGES="licenseAllowsOverages";
    public static final String MOBILE_CURRENT_USAGE_PERIOD_START_MILLIS="mobileCurrentUsagePeriodStartMillis";
    public static final String MOBILE_CURRENT_USAGE_PERIOD_END_MILLIS="mobileCurrentUsagePeriodEndMillis";
    public static final String ALLOCATED_MOBILE_AGENTS="allocatedMobileAgents";
    public static final String CONSUMED_MOBILE_AGENTS="consumedMobileAgents";
    public static final String MOBILE_LICENSE_TYPE="mobileLicenseType";
    public static final String MOBILE_LICENSE_UNIT="mobileLicenseUnits";
    public static final String MOBILE_LICENSE_ALLOWS_OVERAGES="mobileLicenseAllowsOverages";
    public static final String SYNTHETIC_CURRENT_USAGE_PERIOD_START_MILLIS="syntheticCurrentUsagePeriodStartMillis";
    public static final String SYNTHETIC_CURRENT_USAGE_PERIOD_END_MILLIS="syntheticCurrentUsagePeriodEndMillis";
    public static final String ALLOCATED_SYNTHETIC_MEASUREMENT="allocatedSyntheticMeasurementUnits";
    public static final String CONSUMED_SYNTHETIC_MEASUREMENT_UNITS="consumedSyntheticMeasurementUnits";
    public static final String SYNTHETIC_LICENSE_TYPE="syntheticLicenseType";
    public static final String SYNTHETIC_LICENSE_UNIT="syntheticLicenseUnits";
    public static final String ERROR_MESSAGE="errorMessage";
    
    
    public static final String CONF_CONTROLLER="controller";
    public static final String CONF_ACCOUNT="account";
    public static final String CONF_USER="user";
    public static final String CONF_PASSWORD="password";
    public static final String CONF_PORT="Port";
    public static final String CONF_USESSL="useSSL";
    public static final String CONF_SERVER_CONFIG="server-config";
    
    
    public static String JSON(String name, String value){
        return new StringBuilder().append(_QQ).append(name)
                .append(_QQ).append(COLON).append(_QQ)
                .append(value).append(_QQ).toString();
    }
    
    public static String JSON(String name, Boolean value){
        return new StringBuilder().append(_QQ).append(name)
                .append(_QQ).append(COLON)
                .append(value).toString();
    }
}

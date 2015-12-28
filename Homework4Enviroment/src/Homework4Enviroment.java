import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Homework4Enviroment {

	/**
	 * @param args
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException {
		log("file.separator: "+System.getProperty("file.separator"));
		log("java.class.path: "+System.getProperty("java.class.path"));
		log("java.home: "+System.getProperty("java.home"));
		log("java.vendor: "+System.getProperty("java.vendor"));
		log("java.vendor.url: "+System.getProperty("java.vendor.url"));
		log("java.version: "+System.getProperty("java.version"));
		log("line.separator: "+System.getProperty("line.separator"));
		log("os.arch: "+System.getProperty("os.arch"));
		log("os.name: "+System.getProperty("os.name"));
		log("os.version: "+System.getProperty("os.version"));
		log("path.separator: "+System.getProperty("path.separator"));
		log("user.dir: "+System.getProperty("user.dir"));
		log("user.home: "+System.getProperty("user.home"));
		log("user.name: "+System.getProperty("user.name"));
		log("HOSTNAME: "+System.getProperty("HOSTNAME"));
		log("COMPUTERNAME: "+System.getProperty("COMPUTERNAME"));
		log("JBOSS_HOME: "+System.getenv("JBOSS_HOME"));
		log("LocalHostName: "+InetAddress.getLocalHost().getHostName());
		
		Iterator<Object> iter = System.getProperties().keySet().iterator();
		while(iter.hasNext()) {
		    Object item = iter.next();
		    log(item.toString() + "=" + System.getProperty(item.toString()));
		}

		Iterator<String> envIter = System.getenv().keySet().iterator();
        while(envIter.hasNext()) {
            String keyItem = envIter.next();
            log(keyItem + "=" + System.getenv(keyItem));
        }
        
        Runtime run = Runtime.getRuntime();
        log("available processors="+run.availableProcessors());
        log("Max memory (GiB)="+run.maxMemory()/1024D/1024D/1024D);
        log("Free memory (GiB)="+run.freeMemory()/1024D/1024D/1024D);
        log("Total memory (GiB)="+run.totalMemory()/1024D/1024D/1024D);
        
        RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
        List<String> arguments = runtimeMxBean.getInputArguments();
        Iterator<String>argsIter = arguments.iterator();
        while(argsIter.hasNext()) {
            String arg = argsIter.next();
            log(arg);
        }
        Map<String,String> sysPropMap = runtimeMxBean.getSystemProperties();
        Iterator<String> sysKeys = sysPropMap.keySet().iterator();
        while (sysKeys.hasNext()) {
            String key = (String) sysKeys.next();
            String value = sysPropMap.get(key);
            log(key + "=" + value);
        }
                
	}

	private static void log(String m) {
	    System.out.println(m);
	}
}

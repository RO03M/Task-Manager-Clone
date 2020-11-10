package modules;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;


public class SystemInfo {

    private OperatingSystemMXBean bean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

    public double CpuAppUsage() {
        return bean.getProcessCpuLoad();
    }

    public double CpuSystemUsage() {
        return bean.getSystemCpuLoad();
    }

}

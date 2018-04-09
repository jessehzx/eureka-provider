package top.jessehzx.cloud.serviceprovider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jessehzx
 * @Date 2018/4/8
 */
@RestController
public class ServiceInstanceRestController {
    private final static Logger LOGGER = LoggerFactory.getLogger(ServiceInstanceRestController.class);

    @Autowired
    private Registration registration;      // 服务注册

    @Autowired
    private DiscoveryClient discoveryClient;// 服务发现客户端

    @RequestMapping("/add")
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = serviceInstance();
        Integer res = a + b;
        LOGGER.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + res);
        return res;
    }

    /**
     * 获取当前服务的服务实例
     * @return ServiceInstance
     */
    public ServiceInstance serviceInstance() {
        List<ServiceInstance> list = discoveryClient.getInstances(registration.getServiceId());
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}

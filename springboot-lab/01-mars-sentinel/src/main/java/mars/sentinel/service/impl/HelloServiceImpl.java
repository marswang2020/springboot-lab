package mars.sentinel.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import mars.sentinel.config.HelloWorldSentinelConfig;
import mars.sentinel.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @SentinelResource(value = "sayHello")
    @Override
    public String sayHello() {
        HelloWorldSentinelConfig.initFlowRules("sayHello");
        return "hello dubbo";
    }

    @Override
    public String sayHello(String word) {
        return word;
    }
}

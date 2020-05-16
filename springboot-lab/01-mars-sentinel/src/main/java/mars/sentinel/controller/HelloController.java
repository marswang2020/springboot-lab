package mars.sentinel.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import mars.sentinel.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/say/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name){
        return helloService.sayHello(name);
    }

    @GetMapping("/say")
    @ResponseBody
    public String sayHello(){
        // 1.5.0 版本开始可以直接利用 try-with-resources 特性，自动 exit entry
        try (Entry entry = SphU.entry("sayHello")) {
            // 被保护的逻辑
            return helloService.sayHello();
        } catch (BlockException ex) {
            // 处理被流控的逻辑
            return "服务繁忙，请稍候重试";
        }
    }
}

package mars.sentinel.test;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

    static Logger log = LoggerFactory.getLogger(Test2.class);
    private static final String RESOURCE_NAME = "hello";

    /**
     * 加载限流规则
     */
    public static void loadRules() {
        List<FlowRule> rules = new ArrayList<FlowRule>();
        FlowRule flowRule = new FlowRule();
        flowRule.setResource(RESOURCE_NAME); //资源名
        flowRule.setLimitApp("default");//default 代表对所有应用生效
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS); //限流阈值类型
        flowRule.setCount(10); //阈值
        rules.add(flowRule);
        FlowRuleManager.loadRules(rules);
    }

    /**
     * 执行方法
     * @param hello
     */
    public static void hello(String hello){
        Entry entry = null;
        try {
            entry = SphU.entry(RESOURCE_NAME);
            log.info("args hello value is {}",hello);
        }catch (Exception e){
            if(FlowException.isBlockException(e)){
                log.error("block resourceName: {}",RESOURCE_NAME);
            }
        }finally {
            if(entry !=null){
                entry.exit();
            }
        }
    }

    public static void main(String[] args) {
        loadRules();
        for(int i=0;i<20;i++){
            hello("hello"+i);
        }
    }
}
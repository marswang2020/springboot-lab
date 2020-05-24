package mars.gupao.adapter.demo.passport.adapterv2.adapters;

import mars.gupao.adapter.demo.passport.ResultMsg;

/**
 * Created by Tom.
 */
public interface ILoginAdapter {
    boolean support(Object object);
    ResultMsg login(String id, Object adapter);
}

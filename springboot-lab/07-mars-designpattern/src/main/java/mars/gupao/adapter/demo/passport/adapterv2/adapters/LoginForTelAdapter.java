package mars.gupao.adapter.demo.passport.adapterv2.adapters;

import mars.gupao.adapter.demo.passport.ResultMsg;

/**
 * Created by Tom.
 */
public class LoginForTelAdapter extends AbstraceAdapter{
    public boolean support(Object adapter) {
        return adapter instanceof LoginForTelAdapter;
    }

    public ResultMsg login(String id, Object adapter) {
        return super.loginForRegist(id,null);
    }

}

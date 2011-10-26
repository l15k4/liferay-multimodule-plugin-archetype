#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import ${package}.service.HelloService;

public abstract class HelloServiceBaseImpl extends PrincipalBean implements HelloService {
    @BeanReference(name = "${package}.service.HelloService")
    protected HelloService helloService;

    public HelloService getHelloService() {
        return helloService;
    }

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
    		DB db = DBFactoryUtil.getDB();
    		db.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
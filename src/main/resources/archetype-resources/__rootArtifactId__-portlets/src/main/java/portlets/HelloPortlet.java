#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.portlets;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import ${package}.service.HelloServiceUtil;

public class HelloPortlet extends GenericPortlet {
    public void doView(RenderRequest request, RenderResponse response) throws PortletException, java.io.IOException {
        String msg = HelloServiceUtil.hello("Hello World");
        response.setContentType("text/html");
        response.getWriter().print(msg);
    }
}
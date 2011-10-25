#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

public class HelloServiceUtil {
    private static HelloService _service;

    public static HelloService getService() {
        if (_service == null) {
            throw new RuntimeException("HelloService is not set");
        }

        return _service;
    }

    public void setService(HelloService service) {
        _service = service;
    }

    public static String hello(String name) {
        return getService().hello(name);
    }
}
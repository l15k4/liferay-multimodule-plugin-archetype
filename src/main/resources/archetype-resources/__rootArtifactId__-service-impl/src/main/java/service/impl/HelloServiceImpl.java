#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.impl;

import ${package}.service.base.HelloServiceBaseImpl;

public class HelloServiceImpl extends HelloServiceBaseImpl {
    public String hello(String name) {
        return "Hello, " + name;
    }
}
A maven archetype for generating multimodule Liferay maven project for plugin development. 
It can be used even for Service Builder based plugins, it is up to you.

######
NOTICE : before you read this or clone this, you should know that it would be better for you to use official liferay portlet archetype
https://github.com/liferay/liferay-portal/tree/master/support-maven
 
I am maintaining this for a long time, because a year or two ago this wasn't available, now Service Builder Archetype :
https://github.com/liferay/liferay-portal/tree/master/support-maven/archetypes/liferay-servicebuilder-archetype
has even a separate module for API, though you have to use Maven 2, because it is using maven-reactor-plugin. 
Or you have to specify postBuildDependencyModules=false property in liferay-maven-plugin
######

I would decide to use ServiceBuilder : 
     - if you are new to Liferay and you have already developed a sample portlet or you want to learn LR internal workings 
     - if you are about to create rather simple plugin then complex one
             - because with ServiceBuilder you won't be able to use ORM extensively and make infrastructure testing
             - on the other hand you loose all the advantages that come with SB 

USAGE :

mvn install              # installs the archetype into local maven repository
cd workspace
mvn archetype:generate         
            
            # find this archetype in the list, type :  groupId, archetypeId, version, enter
            # then hit  N - for not accepting default properties 
            # now you hit a little maven bug that you can vote up for :-) http://jira.codehaus.org/browse/ARCHETYPE-308 

cd project

In all cases modify Portlet and Liferay specific assets : portlet.xml, liferay-portlet.xml, liferay-display.xml, etc.

###  If you go for service builder :
  
 delete   service-impl/src/main/resources/META-INF/portlet-spring.xml
 modify  service-impl/src/main/webapp/WEB-INF/service.xml
 delete   *.java files

cd project-service-impl
mvn com.liferay.maven.plugins:liferay-maven-plugin:6.1.0-SNAPSHOT:build-service 

cd ..
mvn package  # liferay-maven-plugin phase is bound to package phase, so it deploys the resulting WAR


###  If you choose not to use service builder : 

 delete  service-impl/src/main/webapp/WEB-INF/service.xml
 do whatever you want with *.java files

cd project
mvn package 

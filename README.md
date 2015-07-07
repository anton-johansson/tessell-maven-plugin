
[![Join the chat at https://gitter.im/stephenh/tessell](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/stephenh/tessell?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

# tessell-maven-plugin
This plugin makes it possible to generate tessell sources as a Maven goal. Simply add the following code to your projects ```pom.xml```-file:
```xml
<plugins>
    ....
    <plugin>
        <groupId>org.tessell</groupId>
        <artifactId>tessell-maven-plugin</artifactId>
        <version>${tessell.version}</version>
    </plugin>
    ....
</plugins>
```

### Maven repository
Currently, the tessell-maven-plugin is not released into a Maven repository, but it will be soon. When that happens, you will get the artifacts by adding the following code in your projects ```pom.xml```-file:
```xml
<repositories>
    ....
    <repository>
        <id>joist</id>
        <name>Joist</name>
        <url>http://repo.joist.ws/</url>
    </repository>
    ....
</repositories>
```


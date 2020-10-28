# Dominect

## 1. Protocol Compiler Installation
Source: [https://github.com/protocolbuffers/protobuf/blob/master/README.md]

Protocol Buffers( download protobuf-java-3.13.0.tar.gz ) [https://github.com/protocolbuffers/protobuf/releases]
![alt text](https://imgur.com/EwJgDll.png)

## 2. Install Maven
[https://www.javahelps.com/2017/10/install-apache-maven-on-linux.html]

Check if it works: ``` mvn --version ```

## 3. Compile the Protocol
Source: [https://github.com/protocolbuffers/protobuf/tree/master/java]

Run: ``` mvn test ```

![alt text](https://imgur.com/E5ynFKM.png)

If some tests fail, this library may not work correctly.

Navigate to your protobuf directory/java ```/Downloads/protobuf-3.13.0/java```

Run: ``` mvn install ```

![alt text](https://imgur.com/KyxYcyk.png)

If this compiles succesefully it means everything works and the project can be compiled.

## 4. Compile the Project
Pull the project, navigate to the directory where pom.xml and run:
```mvn clean install```

![alt text](https://imgur.com/ZIHruMN.png)

## BUGS: 
Connects but RPC fails

```mvn -e compile exec:java -Dexec.mainClass=dominect.userreg.UserRegistration```

![alt text](https://imgur.com/4YvIyQN.png)

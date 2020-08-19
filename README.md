# KMIP v 2.0 JAVA SDK and Client Application

## Overview ##
This repository contains the code for a scalable and extensible JAVA library for the communication protocol, KMIP v 2.0 (Key Management Interoperability Protocol). [KMIP v 2.0 released in October 2019](https://docs.oasis-open.org/kmip/kmip-spec/v2.0/os/kmip-spec-v2.0-os.html "KMIP Specification Version 2.0"). This SDK provides developers secure ways to manage keys and other cryptographic objects on a key management server. This was [our](#team "Team") final year project sponsored by [IBM](https://www.ibm.com/in-en "IBM-India") and the key management server we used in the development and testing of this SDK was IBM Security Key Lifecycle Manager (SKLM).

## Table of Contents ##
- [The Why](#the-why "The Why")
- [Features](#features "Features")
  - [Library](#features "Library Features")
  - [Client Application](#features "Client App Features")
- [Tech Stack](#tech-stack "Tech Stack")
- [Documentation](#documentation "Documentation")
- [Team](#team "Team")
- [Mentors](#mentors "Mentors")

----

### The Why ###
Key Management Interoperability Protocol is an extensible communication protocol developed by [OASIS](https://www.oasis-open.org/ "OASIS") (a global non-profit consortium) for efficient management of cryptographic keys in a centralized server. IBM uses A Secure Key Lifecycle Management server for storing its cryptographic keys and objects. To manage these keys in the SKLM server, IBM uses the KMIP protocol. KMIP is widely used today and has had several versions of itself released, the latest one being KMIP v2.0 (asof October 2019). As of now, there are not many libraries that support KMIP v 2.0 which clients can use to access the services of KMIP v2.0. 

Therefore, our motivation is to build an open source, scalable and easily upgradable KMIP v 2.0 library which developers can use for availing the services of KMIP v 2.0 and the utility to manage keys for encryption/decryption of his data, on the SKLM server using KMIP. Developers can import the library into their application program (.jar format), to access the services offered by the interfaces of the library. A client application supporting various environments which provides the end-user with a UI, can also directly access services of KMIP through this library. The client application will use the library at the backend to provide services as specified by the end-users through the user interface of the client application.

----

### Features ###

#### Library ####
- Extensible.
- Easily upgradable when new versions of KMIP are released.
- Key Operations
  1. Create Key
  2. Create Key-Pair
  3. Get Key 
  4. Locate Key
  5. Destroy Key

#### Client Application ####
- Key Operations
  1. Create Key
  2. Create Key-Pair
  3. Get Key 
  4. Locate Key
  5. Destroy Key
- Encrypt/Decrypt files using RSA or AES depending on the key-type.
----

### Tech Stack ###
- [JAVA](https://www.java.com "Java") (for the Library).
  The packages used in the develpment of java library are: 
  1. java.net.* 
  2. javax.xml.bind.annotation.*  
  3. javax.xml.parsers.* 
  4. org.w3c.dom.* 
- [Spring](https://www.spring.io "Spring Framework").
- [Angular.JS](https://www.angularjs.org "AngularJS").
- [Maven](https://www.maven.apache.org "Maven").

----

### Documentation ###

[This](https://github.com/VedikaGhai/KMIP-2.0-Implementation/tree/master/doc "javadoc") folder contains the documentation for the library. Once downloaded locally, open **index.html** to begin navigating the documentation.

----

### Team ###

- Vedika Ghai.
- Soha Parasnis.
- Tanisha Rathi.
- Vidushi Mishra.

----

### Mentors ###

We would like to thank our mentors for their valuable time, guidance and encouragement:
- Professor A.N. Muchrikar, Assistant Professor and Dean (Student Affairs) at MKSSS Cummins College of Engineering for Women, Pune. 
- Mr. Arvind Ashtekar (mentor from IBM).
- Mr. Vikram Khopade (mentor from IBM).

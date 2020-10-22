# TinyBoard
A Simple Spring Boot Board With Mariadb Database Support. This Project Developed For Hidden Service.
<br>
although project developed for hidden service, also you can use for surface web.

## Features
- Simple CAPTCHA
- Delete Thread via Password
- Easy TinyBoard management panel
    - Delete All Thread, Server deactivation, Disable Posting<br>
     (Default manage password is ``1234``)



## Licence
This software is made available under the GNU Affero GPL 3 License.. What this means is that is you deploy this software as part of networked software that is available to the public, you must make the source code available (and any modifications).
From the GNU site:
> The GNU Affero General Public License is a modified version of the ordinary GNU GPL version 3. It has one added requirement: if you run a modified program on a server and let other users communicate with it there, your server must also allow them to download the source code corresponding to the modified version running there

## Dependencies
- Java 11
- Maven
- MariaDB 10.5.4 higher
- Lombok

## Installation
##### 1) Install the necessary modules. (Ubuntu 20.04 Server environment)
```
sudo apt update
sudo apt install openjdk-11-jdk
sudo apt install git
sudo apt install maven
sudo apt install mariadb-server
```

##### 2) Download the latest version of tinyBoard from GitHub.
```
sudo git clone https://github.com/uhwGhGFaJd/TinyBoard.git
cd TinyBoard
pwd //you should remember your result path. My result paht is: /home/server/TinyBoard
```

##### 3) Database configuration settings
```
sudo mysql
set password = password('YOUR PASSWORD'); //Example: set password = password('mariadb');
flush privileges;
exit;
mysql -u root -p
source /home/server/TinyBoard/init.sql;
exit;
```


##### If you need change tinyBoard Server Config (Option)
```
sudo nano TinyBoard/src/main/resources/application.properties

//Save if modified.
```

##### 4) Build & Run
```
cd TinyBoard
sudo mvn clean package
cd target
sudo java -jar FILENAME.jar
```

##### 5) Login to TinyBoard
```
http://SERVER-IP/manage
Default manage password is 1234
And change the default password.
thank you!
```



## Support
 1. Review the [open issues](https://github.com/uhwGhGFaJd/TinyBoard/issues).
 2. Open a [new issue](https://github.com/uhwGhGFaJd/TinyBoard/issues/new).
 3. Lastly, you can send me email [refer to my profile](https://github.com/uhwGhGFaJd).
 
## TinyBoard Screenshots


<img width="1480" alt="1" src="https://user-images.githubusercontent.com/72780307/96549713-b8b79280-1264-11eb-863e-bc852cbc1038.png">
<img width="1480" alt="2" src="https://user-images.githubusercontent.com/72780307/96549718-ba815600-1264-11eb-8d97-1330810053fe.png">
<img width="1480" alt="3" src="https://user-images.githubusercontent.com/72780307/96549719-bb19ec80-1264-11eb-941a-255d76fad6da.png">
<img width="1480" alt="4" src="https://user-images.githubusercontent.com/72780307/96549722-bbb28300-1264-11eb-9e00-62f70900f08d.png">
<img width="1480" alt="5" src="https://user-images.githubusercontent.com/72780307/96549725-bc4b1980-1264-11eb-80e5-c69d5ca1697a.png">
<img width="1480" alt="6" src="https://user-images.githubusercontent.com/72780307/96549728-bce3b000-1264-11eb-81f9-c58d7132b3fa.png">
<img width="1480" alt="7" src="https://user-images.githubusercontent.com/72780307/96549733-bd7c4680-1264-11eb-8ddb-08b4d4b7787a.png">





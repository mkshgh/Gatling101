## Get Gatling Certification

Gatling Zero to Hero in 3 hours.


## Main Feature

- Easy to use
- Uses message based model, so it can support (or multiple) user-requests at once
- No need to know about programming
- Multiple ways to generate automation (HAR and Proxy modes)
- Can be stored in git along-side the Code to be tested
- Neat and clean test results Exported Automatically

## Fallbacks

- Pro Features only for paid users
- Other better alternatives are availablle too [here](https://www.softwaretestinghelp.com/performance-testing-tools-load-testing-tools/)
- Limited to Web-Automation

## Gatling Backbone

- Scala
- Akka
- Netty


## Pre-requisities

Java and Scala bin location need to be in the Environment Variables location

- Java ( 8 or 11 recommended ) but works fine with 8 and above 
- Scala 2.12 above (installed via zip or other build tools like maven, SBT, Maven)
- IDE (optional)


## Gatling Documentations

- [Gatling Docs](https://gatling.io/docs/)
- []


## Gatling Recorder

[Gatling Recorder](https://gatling.io/docs/current/http/recorder/) helps you record the gatling shits floating in your website.
Learn How to use the Gatling Recorder to record user journies for Gatling scripts

- HAR modes
- PROXY modes

## PROXY MODE

### Starting the recorder

- Open the Recorder

```
open recorder file

Gatling\bin\recorder.bat for Windows
Gatling\bin\recorder.sh for Mac
```

- you will see the gatling recorder UI

![Gatling Recorder](https://github.com/mkshgh/Gatling101/blob/main/images/GatlingRecorder.PNG)

- Click on start and you will see that recording has started at the top

![Gatling Recorder](https://github.com/mkshgh/Gatling101/blob/main/images/GatlingRecoder_Running.PNG)




### Setting up proxy in the Browser or System

In order to use the Gatling, you need to use the proxy server in the system. We will use the firefox proxy to setup the 

- Firefox

``` 
Options > General > Settings

proxy: localhost
Port: 8000
Options: Use this poxy for ftp and https
Socket: sockv5(default)
 ```


- Go to the website you want to record with Gatling

- Click on stop and save in the recorder once you are done recording

- Saved file is in the location 

``` 
You can change the location of this

Path\to\Gatling\user-files\simulations\RecordedSimulation.scala

```

- I open scala with VS code but you can use IDE like IntelliJ or others.



## HAR MODE

### Starting the recorder

- Open the Recorder

```
open recorder file

Gatling\bin\recorder.bat for Windows
Gatling\bin\recorder.sh for Mac
```

- Drop Down Menu with har at the left top 

![Gatling Recorder](https://github.com/mkshgh/Gatling101/blob/main/images/GatlingRecoder_HAR.PNG)


### Download HAR file from Chrome

In order to use the Gatling, you need to create the HAR file. We will use the Chrome to generate HAR file as it supports by default

- Chrome

``` 
Open the URL

> F12(inspect Element) > Network > (Enable Preserve log)
> Surf the website as you wish
> Download the HAR file

 ```
### Import and convert HAR file

- Import the HAR file in the Reocrder

- Click on save

- Saved file is converted to scala and saved in the location 

``` 
You can change the location of this

Path\to\Gatling\user-files\simulations\RecordedSimulation.scala

```

- I open scala with VS code but you can use IDE like IntelliJ or others.




## Scripting with Gatling - 3 steps:

- Scala Library and Class Setup
Does it automatically so not counted

```
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {
//
// Generated Automatically but can be edited
//
}
```
- Protocol Setup
```
	val httpProtocol = http
		.baseUrl("http://computer-database.gatling.io")
		.inferHtmlResources()
		.acceptHeader("text/css,*/*;q=0.1")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.9")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.66 Safari/537.36")

```

- Scenario Definition

```
val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.get("/computers?f=ACE")
			.resources(http("request_1")
			.get("/assets/css/main.css"),
            http("request_2")
			.get("/assets/css/bootstrap.min.css")))
		.pause(1)
		.exec(http("request_3")
			.get("/computers/330")
			.resources(http("request_4")
			.get("/assets/css/main.css"),
            http("request_5")
			.get("/assets/css/bootstrap.min.css")))
		.pause(5)
```

- Load Simulation Design

```
setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
```

## Cleaning the code

To clean the code, go to the scala docs and learn the scala documentation

## Running the code

- Open the Gatling

```
open recorder file

Gatling\bin\gatling.bat for Windows
Gatling\bin\gatling.sh for Mac
```

- Select 0 to run the recorded test

```
D:\Programs\Gatling\bin>gatling.bat
GATLING_HOME is set to "D:\Programs\Gatling"
JAVA = "java"
Java HotSpot(TM) 64-Bit Server VM warning: Option UseBiasedLocking was deprecated in version 15.0 and will likely be removed in a future release.
Choose a simulation number:
     [0] RecordedSimulation
     [1] computerdatabase.BasicSimulation
     [2] computerdatabase.advanced.AdvancedSimulationStep01
     [3] computerdatabase.advanced.AdvancedSimulationStep02
     [4] computerdatabase.advanced.AdvancedSimulationStep03
     [5] computerdatabase.advanced.AdvancedSimulationStep04
     [6] computerdatabase.advanced.AdvancedSimulationStep05
0
Select run description (optional)
Hello_world_test

```


```
> Global                                                   (OK=4      KO=0     )
> request_0                                                (OK=1      KO=0     )
> request_1                                                (OK=1      KO=0     )
> request_2                                                (OK=1      KO=0     )
> request_3                                                (OK=1      KO=0     )

---- RecordedSimulation --------------------------------------------------------
[--------------------------------------------------------------------------]  0%
          waiting: 0      / active: 1      / done: 0
================================================================================


================================================================================
2020-11-23 23:54:41                                          25s elapsed
---- Requests ------------------------------------------------------------------
> Global                                                   (OK=7      KO=0     )
> request_0                                                (OK=1      KO=0     )
> request_1                                                (OK=1      KO=0     )
> request_2                                                (OK=1      KO=0     )
> request_3                                                (OK=1      KO=0     )
> request_4                                                (OK=1      KO=0     )
> request_5                                                (OK=1      KO=0     )
> request_6                                                (OK=1      KO=0     )

---- RecordedSimulation --------------------------------------------------------
[--------------------------------------------------------------------------]  0%
          waiting: 0      / active: 1      / done: 0
================================================================================


================================================================================
2020-11-23 23:54:46                                          30s elapsed
---- Requests ------------------------------------------------------------------
> Global                                                   (OK=7      KO=0     )
> request_0                                                (OK=1      KO=0     )
> request_1                                                (OK=1      KO=0     )
> request_2                                                (OK=1      KO=0     )
> request_3                                                (OK=1      KO=0     )
> request_4                                                (OK=1      KO=0     )
> request_5                                                (OK=1      KO=0     )
> request_6                                                (OK=1      KO=0     )

---- RecordedSimulation --------------------------------------------------------
[--------------------------------------------------------------------------]  0%
          waiting: 0      / active: 1      / done: 0

```
## Test Results stored location

``` 
Inside the Folder: path\to\Gatling\results\{latestTestfolder}
```

![Gatling Test Location](https://github.com/mkshgh/Gatling101/blob/main/images/Gatling_TestReuslts_Schema.png)

The html files are auto generated by gatling

![Gatling Test Real](https://github.com/mkshgh/Gatling101/blob/main/images/Gatling_TestReuslts_html.png)


## Feeders and Correlators

This concept is again for the code optimization. LEARN SCALA!!!, can't emphasize it more.

- [Feeder](https://gatling.io/docs/current/session/feeder/)
- [Checks](https://gatling.io/docs/current/http/http_check/)



## Things to Remember

- Gatling is not able to record HTTPS traffic
- HTTP headers must not be set as default in the protocol of a Gatling script
- What is the best way to write a transaction that needs to repeat three times

```
repeat(3){
    //Transaction Code
}
```

- Gatling supports the following data types

```
val csvFeeder = csv("foo.csv") // use a comma separator
val tsvFeeder = tsv("foo.tsv") // use a tabulation separator
val ssvFeeder = ssv("foo.ssv") // use a semicolon separator
val customSeparatorFeeder = separatedValues("foo.txt", '#') // use your own separator

JSON and JDBC

```


- A circular feeder strategy goes back to the top of the file, once it has run out of entries

- The following DSL methods are provided by Gatling for closed workload models:


## Testing Workload Models

[Don't Wander](https://gatling.io/2020/04/07/how-easily-can-i-perform-a-load-test/)
- Open vs. Closed 

[]

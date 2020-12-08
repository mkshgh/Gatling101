
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("http://computer-database.gatling.io")
		.inferHtmlResources()
		.acceptHeader("text/css,*/*;q=0.1")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.9")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.66 Safari/537.36")


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
		.exec(http("request_6")
			.get("/computers")
			.resources(http("request_7")
			.get("/assets/css/main.css"),
            http("request_8")
			.get("/assets/css/bootstrap.min.css")))
		.pause(3)
		.exec(http("request_9")
			.get("/computers?p=1&n=10&s=name&d=asc")
			.resources(http("request_10")
			.get("/assets/css/main.css"),
            http("request_11")
			.get("/assets/css/bootstrap.min.css"),
            http("request_12")
			.get("/computers?p=2&n=10&s=name&d=asc"),
            http("request_13")
			.get("/assets/css/main.css"),
            http("request_14")
			.get("/assets/css/bootstrap.min.css")))
		.pause(3)
		.exec(http("request_15")
			.get("/computers/new")
			.resources(http("request_16")
			.get("/assets/css/main.css"),
            http("request_17")
			.get("/assets/css/bootstrap.min.css")))
		.pause(24)
		.exec(http("request_18")
			.post("/computers")
			.formParam("name", "testNPS")
			.formParam("introduced", "2020-10-20")
			.formParam("discontinued", "2020-10-21")
			.formParam("company", "1")
			.resources(http("request_19")
			.get("/assets/css/main.css"),
            http("request_20")
			.get("/assets/css/bootstrap.min.css")))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
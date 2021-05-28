rootProject.name = "terraform-aws-lambda-microservice"
include("prototype:spring-cloud-function-kt")
include("prototype:multi-module:main-multi-module-kts")
include("prototype:multi-module:sub-a-multi-module-kts")
include("prototype:multi-module:sub-b-multi-module-kts")

include("demo:multi-module-spring-boot:backend")
include("demo:multi-module-spring-boot:test-utils")
//include("demo:multi-module-spring-boot") // git clone https://github.com/MrParkerZ7/multi-module-spring-boot.git

rootProject.name = "main-multi-module-kts"

include("prototype:multi-module:sub-a-multi-module-kts")
project(":prototype:multi-module:sub-a-multi-module-kts").projectDir =
    file("../../../prototype/multi-module/sub-a-multi-module-kts")
//project(":prototype:multi-module:sub-a-multi-module-kts").buildFileName = "settings.gradle"

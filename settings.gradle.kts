pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MovieHub"
include(":app")
include(":core")
include(":core:ui")
include(":core:network")
include(":core:database")
include(":core:navigation")
include(":domain")
include(":data")
include(":feature")
include(":feature:main")
include(":feature:description")

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
        maven(url = "https://jitpack.io")
        maven(url =  "https://europe-west3-maven.pkg.dev/talsec-artifact-repository/freerasp" )

    }

}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
        maven(url =  "https://europe-west3-maven.pkg.dev/talsec-artifact-repository/freerasp" )
    }
}

rootProject.name = "Banking"
include(":app")
include(":auth")
include(":account")

# Using NatDS Icons

In order to use `natds-icons` in an Android project, you must add a new dependency.
To download the dependency it is necessary to use a Github active account. You Can create in your project a file - for ex: `github_credentials`- with properties and fill it with Github username and Access token. For getting your GitHub access token see the [Tutorial](https://docs.github.com/en/free-pro-team@latest/github/authenticating-to-github/creating-a-personal-access-token). Its important to check `read:packages` when generating you password. In the file `build.gradle`, insert these informations:

```gradle
repositories {
    def githubProperties = new Properties()
    def githubFile = rootProject.file("github_credentials.properties")
    if (githubFile.exists()) {
        githubProperties.load(new FileInputStream(githubFile))
    }
    //To Access Nat DS Icons dependency at Github Packages
    maven {
        name = "natds-commons"
        url = uri("https://maven.pkg.github.com/natura-cosmeticos/natds-commons")
        credentials {
            username = githubProperties['github.username'] ?: System.getenv("GITHUB_USERNAME")
            password = githubProperties['github.password'] ?: System.getenv("GITHUB_API_KEY")
        }
    }
}
```
And:

```gradle
dependencies {
implementation "com.natura:icons:$rootProject.<version>"
}
```

With the dependency configured, you can access our icons as drawables. 😃

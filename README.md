# scootbattlebots
Robocode Battle Bots, in Kotlin
-----

![](./img/robocode.png)

This repo is a robot battling game using [Robocode](https://robocode.sourceforge.io/). Crush your opponents while learning Kotlin!

Setup
---

- Install Intellij + JDK (if needed)
  - Download [IntelliJ Community](https://www.jetbrains.com/idea/download/#section=mac)
  - `brew tap adoptopenjdk/openjdk`
  - `brew cask install adoptopenjdk/openjdk/adoptopenjdk8`
  - Set up [jenv](https://developer.bring.com/blog/configuring-jenv-the-right-way/) for managing multiple JVM versions
  - `jenv add /path/to/jdk8` (should be `/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home`)

- Install Robocode
  - Download [latest](https://sourceforge.net/projects/robocode/files/robocode/) setup jar (not the testing jar)
  - Install to a directory of choice (I used `~/code/kotlin/robocode`)

- Clone this repo (you can create an IntelliJ project directly from the GitHub link)

- File > Project Structure
    - Modules on left side
      - Sources tab
        - Delete the default sources folder
        - Make sure the `bots/` folder is added as a source folder (You should see it listed in blue on the right) 

      - Dependencies tab
          - Make sure you have the `KotlinJavaRuntime` as a dependency
          - Click plus sign at bottom left, choose JARs and add  `<robocode install dir>/libs/robocode.jar`

- You should now be able to build the project
  - Build > Build Project or CMD + F9

Running
----
![](./img/battle.png)

- Launch the Robocode game itself by running `<robocode install dir>/robocode.sh`
- Options > Preferences > Development options tab
- Click `Add` and navigate to the battlebots repo (*NOT* the Robocode installation directory) and add `out/production/scootbattlebots` to the classpath
- Battle > New or CMD+N to start a new battle. You should see yours and others' robots in the packages on the left. 

Keep Going
----

These are the [API Docs](https://robocode.sourceforge.io/docs/robocode/), and here's a series of [tutorials](http://mark.random-article.com/weber/java/robocode/)
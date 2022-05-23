# VAIRemoteVisualizer



> VAIRemoteVisualizer can be used to display the button presses of the a hardware remote for a device that plugs into a TV. 


[![Build Status][travis-image]][travis-url]

The visualizer can display button presses globally, for example, if the visualizer is not in focus, it will still show buttons being pressed. This is thanks to the [jnativehook](https://github.com/kwhat/jnativehook/ "jnativehook") library. The ui was built using [JavaFX](https://openjfx.io/ "JavaFX").

- The Program can be closed using the `X` key, it will also close globally, be mindful of pressing x during use.
- The OK button and home button can both be visualized using the `Mouse 1` and `Mouse 2` buttons.
- The microphone button can be visualized using the `Space` key.
- If needed the program can be resized using the `+` and `-` keys.

![VAIRemoteVisualizer](/src/main/resources/com/vai/uxremotecontrol/vai.jpg)

## Development setup

#### For IntelliJ IDEA:
- Add the repo and clone the project using `File>New>Project From Version Control` or using the `Get from VCS` button on the home page.
  - This should autopopulate if you log into Github.
- Add a new 'Application configuration under `Run>Edit Configurations...` or at the top right under `Add Configuration...`
- Confirm you are using `Java 17` and choose a main class using the icon on the right, should be `com.ezgrader.pdfgrader.PDFGrader`
  - The main class should autopopulate, if it does not there may be a problem.
- Add a name at the top and hit Apply or OK.
- The project should now run.


#### Troubleshooting tips:
- On the far right there is a 'Maven' tab, within that tab there is `pdfgrader>lifecycle>install` this should install everything in the pom.xml file.
- Sometimes a convinent little Maven icon pops up in the top right when looking at `pom.xml` click that if possible. 

For more info go to the openjfx docs:
https://openjfx.io/openjfx-docs/#IDE-Intellij


<!-- Markdown link & img dfn's -->
[travis-image]: https://img.shields.io/travis/dbader/node-datadog-metrics/master.svg?style=flat-square
[travis-url]: https://travis-ci.org/dbader/node-datadog-metrics
[wiki]: https://github.com/yourname/yourproject/wiki



# Bring up Play Server from Spring XML

1. Spring context created from xml file
2. beans created
3. one of the beans grabs the application context and passes it to bean in Scala
4. bean in Scala create Guice module from it
5. module used in Play application loader
6. Play components (router, etc) now injected with beans instantiated by Spring

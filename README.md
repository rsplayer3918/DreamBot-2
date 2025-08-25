# DreamBot Scripts

A collection of DreamBot scripts.

## Requirements

- DreamBot client version **3.0+**.
- Copy the `client.jar` and `API.jar` from your DreamBot installation into the project's `libs/` directory so build tools can reference them.

## Building

### Maven

```bash
mvn clean package
```

Jars are generated in `target/`. Import `pom.xml` into your IDE and mark the DreamBot jars as `provided`.

### Gradle

```bash
./gradlew build
# or
gradle build
```

Artifacts are created in `build/libs/`. Import `build.gradle` to configure your IDE automatically.

## Launching Scripts

After building, copy the generated jar to the DreamBot `Scripts` directory (`~/DreamBot/Scripts` on macOS/Linux or `C:\\Users\\<username>\\DreamBot\\Scripts` on Windows). Then run the DreamBot client with the script name:

```bash
java -jar client.jar -script ScriptName
```

Example launches:

```bash
java -jar client.jar -script Combat
java -jar client.jar -script GoldCrafter
java -jar client.jar -script Miner
java -jar client.jar -script WC
java -jar client.jar -script Walker
java -jar client.jar -script Template
```

## IDE Configuration

### IntelliJ IDEA

1. File → Open `pom.xml` or `build.gradle`.
2. Add the DreamBot `client.jar` and `API.jar` from `libs/` to the project SDK or module dependencies.
3. Create a run configuration pointing to the DreamBot client jar with `-script <ScriptName>`.

### Eclipse

1. File → Import → Existing Maven/Gradle Project.
2. Add the DreamBot API jars to the build path.
3. Configure an External Tool or Run Configuration to execute `client.jar -script <ScriptName>`.


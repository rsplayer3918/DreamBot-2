# DreamBot Scripts

A collection of [DreamBot](https://dreambot.org/) automation scripts.

## Prerequisites
- [Java Development Kit (JDK) 8 or later](https://adoptium.net/)
- DreamBot client and API JAR (available from the DreamBot [download page](https://dreambot.org/))
- An IDE such as IntelliJ IDEA with the DreamBot API JAR added to the project's classpath

## Build
1. Clone this repository.
2. Import the project into your IDE.
3. Ensure the DreamBot API JAR is added as a global library.
4. Build the desired module to produce a JAR artifact.

## Running Scripts
1. Copy the built JAR into your local `DreamBot/Scripts` directory.
2. Launch the DreamBot client and log in.
3. Select the script from the scripts list and configure it through the GUI.

### Script Overview

#### Miner
Automates mining with task-based powermining and banking support. Configure ore IDs, goal (level or time), bank location, starting tile, powermine option, and whether the player should stand still.

#### Combat
Targets specific NPCs, loots chosen items, eats food at a threshold, optionally buries bones, and banks when inventory is full. Configuration includes target name, fight radius, food type and amount, loot list, bank location, bone burying, loot from other players, and eat percentage.

#### GoldCrafter
Crafts gold jewellery (amulets, necklaces, or rings) at selectable smelting locations. Options allow choosing the jewellery type and furnace location.

#### WC (Woodcutter)
Chops trees within a radius and banks the logs. Set tree type, cutting radius, and bank location.

#### Walker
Walks to a chosen destination such as major cities, banks, or landmarks. Pick a destination from the GUI and the script will path there.

#### Template
Provides a minimal state-driven script skeleton that can be used as a starting point for new DreamBot scripts.

## License
Licensed under the [Apache License, Version 2.0](LICENSE).

## Contributing
1. Fork the repository and create a new branch for your feature or fix.
2. Make your changes and add tests where appropriate.
3. Run any available checks (build, tests) before committing.
4. Submit a pull request with a clear description of the changes.

## Resources
- [DreamBot API reference](https://dreambot.org/javadocs/)
- [Old School RuneScape Wiki](https://oldschool.runescape.wiki/) for game mechanics
- [DreamBot forums](https://dreambot.org/forums/) for community support

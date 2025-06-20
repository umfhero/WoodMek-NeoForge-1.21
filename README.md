# BlockMod - A Minecraft Mod for NeoForge

![Hardwood Alloy Logo](src/main/resources/assets/blockmod/textures/item/hardwood_alloy.png "Logo - Hardwood Alloy Item")

Adds new wood-based materials and integration with Mekanism. Features two new creative tabs for organization and seamless building blocks.

## Key Features

### 🪵 Wood Sheets
![Wood Sheets](src/main/resources/assets/blockmod/textures/item/WoodMek.png#gh-light-mode-only "Items Overview")(https://placehold.co/600x400?text=Light+Mode+Image "Items Overview")(https://placehold.co/600x400?text=Dark+Mode+Image "Items Overview")
- **Obtained by**: 
  - Crafting recipes
  - Chopping wood (modified vanilla loot tables)
- **Primary use**: Base material for advanced components

### 🔥 Hard Wood
- Created by smelting Wood Sheets
- **Uses**:
  1. Crafted into Hard Wood Blocks (2x2 pattern)
  2. Processed into Hardwood Alloy

### ⚙️ Hardwood Alloy
![Alloy](src/main/resources/assets/blockmod/textures/item/hardwood_alloy.png#gh-dark-mode-only "Hardwood Alloy")(https://placehold.co/300x300?text=Alloy+Dark "Hardwood Alloy")(https://placehold.co/300x300?text=Alloy+Light "Hardwood Alloy")
- Created in Mekanism's **Metallurgic Infuser**:
  - Input: Hard Wood + Carbon (coal/charcoal)
- **Purpose**: High-strength material for tools and machines

### 🏗️ Building Blocks
![Building Blocks](src/main/resources/assets/blockmod/textures/item/WoodMek.png#gh-light-mode-only "Blocks")(https://placehold.co/300x300?text=Blocks+Light "Building Blocks")(https://placehold.co/300x300?text=Blocks+Dark "Building Blocks")
1. **Hard Wood Block**:
   - Crafted from 4 Hard Wood (2x2 pattern)
   - Textured seamless edges
   
2. **Hazard Block**:
   - Decorative block with warning styling
   - Seamless edge design

### 📦 Creative Tabs
1. **Wood Items Tab**: Contains all wood-based items
2. **Building Blocks Tab**: Includes Hard Wood Block and Hazard Block

---

## Installation

1. **Clone this template** using [GitHub's template feature](https://docs.github.com/en/repositories/creating-and-managing-repositories/creating-a-repository-from-a-template)
   
2. **Open in IDE** (IntelliJ or Eclipse recommended)

3. **Resolve dependencies**:
   ```shell
   ./gradlew --refresh-dependencies
   ./gradlew clean

# WoodMek! - A 1.21-1.21.1 NeoForge Minecraft Mod for intergration with vanillia lootables (wood) into Mekanism 

<img src="src/main/resources/assets/blockmod/textures/item/hardwood_alloy.png" alt="Hardwood Alloy Logo" width="126">

Adds new wood-based materials and integration with Mekanism. Features two new creative tabs for organization and seamless building blocks.

## Showcase
<img src="src/main/resources/assets/blockmod/textures/item/WoodMek.png" alt="BlockMod Items Showcase" width="500">

## Items

### Wood Sheets
<img src="src/main/resources/assets/blockmod/textures/item/woodsheet.png" alt="Wood Sheet Item" width="64"> 

- **Obtained by**:
  1. Crafting recipes
  2. Chopping wood (I modified vanilla loot tables)
- **Primary use**: Base material for advanced components eg the hard wood then hard wood into hardwood alloy

### Hard Wood
<img src="src/main/resources/assets/blockmod/textures/item/hardwood.png" alt="Hard Wood Item" width="64">

- Created by smelting Wood Sheets
- **Uses**:
  1. Crafted into Hard Wood Blocks (2x2 pattern)
  2. Processed into Hardwood Alloy

### Hardwood Alloy
<img src="src/main/resources/assets/blockmod/textures/item/hardwood_alloy.png" alt="Hardwood Alloy Item" width="64">

- Created in Mekanism's **Metallurgic Infuser**:
  - Input Hard Wood + Carbon (coal/charcoal or any carbon mod ID)
- **Purpose**: tech side no purpose yet, but can be crafted with yellow concrete to make hazard blocks

### 🏗️ Building Blocks
1. **Hard Wood Block**:
   - Crafted from 4 Hard Wood (2x2 pattern)
   - Textured seamless edges
   
2. **Hazard Block**:
   - Decorative block with warning styling
   - Seamless edge design

*(Both blocks visible in Showcase)*

### 📦 Creative Tabs
<img src="src/main/resources/assets/blockmod/textures/item/Creativetabs.png" alt="Creative Tabs" width="400">

---

## Installation

Ill post it once fully polished onto Curseforge luancher + modpack with Mekanism

---

## Changelog

## Latest Release = 2.0.0

### [2.0.0] - Loot tables and Recipes
- Bug fixes with textures on both in inventory and dropped items
- Created basic crafting/smelting recipes
- Added loot tables so blocks now drop themselves (tool required)
- Added sound types to both blocks
- Added backend for next release for custom interactive item (Magic Wand)

### [1.5.1] - Modpack compatible with NeoForge Mods (Mekanism, Create, FTB Ultimine and JEI)
- Modpack 'WoodMek' on Curseforge with Mekanism, JEI, FTB Ultimine (Forge) and create (Version 6)
- Arguably most important version and proof the swap to NeoForge from Forge was for the best

### [1.0.5] - Blocks
- Added blocks, Hazard and Hardwood Blocks alongside there in inventory counterpart item (rending on minecraft:block/cube_all) 
- Created building blocks category for the creative tab

### [1.0.0] - Initial Release + Items
- Added base items such as Wood Sheets, Hard Wood and hardwood alloy
- Added two creative inventory tabs for wood items and another for more building blocks to come
- Backend for future releases eg Loot tables, recipes, textures etc

### [0.0.1] - Pre Release
- Base foundation porting all my previsous code from Forge to NeoForge for future compatability, perfoemance and more
- Setting up directories, Minecraft documenation, build files etc
- Established gradle.properties for mod name, this version is more concrete so name change is now offically WoodMek
- Mod_id=blockmod + MIT licence + mod_group_id=net.umf.blockmod

# WoodMek! - A 1.21-1.21.1 NeoForge Minecraft Mod for integration with vanilla lootables (wood) into Mekanism 

<img src="src/main/resources/assets/blockmod/textures/item/hardwood_alloy.png" alt="Hardwood Alloy Logo" width="126">

Adds new wood-based materials and integration with Mekanism. Features two new creative tabs for organization and seamless building blocks.

## Showcase
<img src="src/main/resources/assets/blockmod/textures/item/ModShowCase.png" alt="BlockMod Items Showcase" width="500">

## Items

### Wood Sheets
<img src="src/main/resources/assets/blockmod/textures/item/woodsheet.png" alt="Wood Sheet Item" width="64"> 
- **Updated in v2.0**: Improved texture with better wood grain detail
- **Obtained by**:
  1. Crafting recipes
  2. Chopping wood (modified vanilla loot tables)
- **Primary use**: Base material for advanced components

### Hard Wood
<img src="src/main/resources/assets/blockmod/textures/item/hardwood.png" alt="Hard Wood Item" width="64">
- **Updated in v2.0**: Enhanced texture with carbonized appearance
- Created by smelting Wood Sheets
- **Uses**:
  1. Crafted into Hard Wood Blocks (2x2 pattern)
  2. Processed into Hardwood Alloy

### Wood Dust
<img src="src/main/resources/assets/blockmod/textures/item/wood_dust.png" alt="Wood Dust Item" width="64">
- **New in v2.0**: Fine powder created from crushing wood
- Obtained by processing Wood Sheets in Mekanism's Crusher
- **Purpose**: Intermediate material for advanced alloys

### Hardwood Alloy
<img src="src/main/resources/assets/blockmod/textures/item/hardwood_alloy.png" alt="Hardwood Alloy Item" width="64">
- Created in Mekanism's **Metallurgic Infuser**:
  - Input: Hard Wood + Carbon (coal/charcoal or any carbon mod ID)
- **Purpose**: Base material for hazard blocks and future tech items

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

I'll post it once fully polished onto CurseForge launcher + modpack with Mekanism

---

## Changelog

## Latest Release = 2.0.0

### [2.0.0] - Loot tables, Recipes & New Content
- **Texture updates** for Hard Wood and Wood Sheets
- **New item**: Wood Dust with custom texture
- Bug fixes with textures on both inventory and dropped items
- Created basic crafting/smelting recipes
- Added loot tables so blocks now drop themselves (tool required)
- Added sound types to both blocks
- Added backend for next release for custom interactive item (Magic Wand)

### [1.5.1] - Modpack compatible with NeoForge Mods (Mekanism, Create, FTB Ultimine and JEI)
- Modpack 'WoodMek' on CurseForge with Mekanism, JEI, FTB Ultimine (Forge) and Create (Version 6)
- Arguably most important version and proof the swap to NeoForge from Forge was for the best

### [1.0.5] - Blocks
- Added blocks: Hazard and Hardwood Blocks alongside their inventory counterpart items (rendering on minecraft:block/cube_all) 
- Created building blocks category for the creative tab

### [1.0.0] - Initial Release + Items
- Added base items: Wood Sheets, Hard Wood and Hardwood Alloy
- Added two creative inventory tabs for wood items and another for building blocks
- Backend for future releases (e.g., loot tables, recipes, textures)

### [0.0.1] - Pre-Release
- Base foundation porting all previous code from Forge to NeoForge for future compatibility, performance and more
- Setting up directories, Minecraft documentation, build files etc.
- Established gradle.properties for mod name (now officially WoodMek)
- Mod_id=blockmod + MIT license + mod_group_id=net.umf.blockmod

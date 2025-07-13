<div align="center">

<br>

<img src="src/main/resources/assets/woodmek/pics/WoodMekLogo.png" alt="Hardwood Alloy Logo" width="600">

<br>

![Static Badge](https://img.shields.io/badge/Requires%20Mekanism-%2010.4%2B-red)
![Commits](https://img.shields.io/github/commit-activity/w/umfhero/WoodMek-NeoForge-1.21.1)
![Last commit](https://img.shields.io/github/last-commit/umfhero/WoodMek-NeoForge-1.21.1)

![Minecraft](https://img.shields.io/badge/Minecraft-1.21.1-green)
![Mod Loader](https://img.shields.io/badge/ModLoader-NeoForge-blueviolet)
![Issues](https://img.shields.io/github/issues/umfhero/WoodMek-NeoForge-1.21)
![Status](https://img.shields.io/badge/status-WIP-yellow)
<br>
### Latest Release 9.0.0

<a href="https://www.curseforge.com/minecraft/mc-mods/woodmek">
  CurseForge Mod Page
</a>

<br><br>

Wood Mekanism or WoodMek for short is a 1.21.1 NeoForge Minecraft Mod which adds wood-based materials with deep Mekanism integration and cross-mod compatibility.

</div>

<br>

## Mekanism API Integration Help
This manual contains notes and instructions on how the mod integrates with Mekanism's API.
<details>
  <summary> Mekanism API Integration Manual (Click to expand)</summary>

[Full text here](https://github.com/umfhero/WoodMek-NeoForge-1.21/blob/main/src/main/resources/assets/woodmek/pics/Mekanism_API_1.21.txt)



</details>
<br><br>

> [!IMPORTANT] 
> # This is not a conventional, playable mod.
> This mod is a WIP, towards no end goal. WoodMek is a functional development mod primarily used as a sandbox for testing and improving my modding workflow. It helps me explore data generation, event
> handling, integration with other mods, working with textures and pixel art, GitHub version control, IntelliJ workspace setup, and preparing mods for publishing on CurseForge.
> This project isn’t intended for actual gameplay, but you're welcome to take a look if you're interested or learning yourself.
> Also note that these ingame screenshots may or may not be the latest reflection of the WoodMek mod (Including blocks, items, features or functions).

<h1><strong>WoodMek Showcase</strong></h1> 

### Mod Items
<img src="src/main/resources/assets/woodmek/pics/17.png" width="300">

<img src="src/main/resources/assets/woodmek/pics/19.png" width="300">

<img src="src/main/resources/assets/woodmek/pics/textureupdate.png" alt="BlockMod Items" width="700">


### WoodMek Creative Tabs / Mod items (JEI - Wood Items & Blocks)
<img src="src/main/resources/assets/woodmek/pics/9.png" alt="Creative Tabs" width="400">

<img src="src/main/resources/assets/woodmek/pics/4.png" alt="Creative Tabs" width="450">
<img src="src/main/resources/assets/woodmek/pics/5.png" alt="Creative Tabs" width="450">

---

### Processing Workflows (New in v3.0.0)
**1. Harvest Logs**  
*Gathered from vanilla loot tables when chopping trees*  
<img src="src/main/resources/assets/woodmek/pics/log.jpg" alt="log" width="400">  
*(standard Minecraft wood collection)*

**2. Crush Logs to Wood Dust**  
<img src="src/main/resources/assets/woodmek/pics/wooddust.png" alt="Crusher" width="400">  
*Process logs through Mekanism's Crusher to create Wood Dust*

**3. Smelt Wood Dust to Hard Wood**  
<img src="src/main/resources/assets/woodmek/pics/hardwood1.png" alt="Smelting Factory" width="400">  
*Smelt Wood Dust in any furnace to create Hard Wood, note that mekanism has a furnance like machine (any furnace will work)*

**4. Infuse Hard Wood to Hardwood Alloy**  
<img src="src/main/resources/assets/woodmek/pics/Hardwood_alloy1.png" alt="Infusing Factory" width="400">  
*Infuse Hard Wood with Carbon in a Metallurgic Infuser to create Hardwood Alloy*

**5. Compact Alloy Production (Efficiency Boost)**  
<img src="src/main/resources/assets/woodmek/pics/CompactHardwoodAlloy.png" alt="Compact Infuser" width="400">  
*Process Hard Wood Blocks (each made from 9 Hard Wood in a 3x3 craft) to get 9x Hardwood Alloy - more efficient than processing individual Hard Wood items!*

---

# Future Plans

WoodMek isn’t just about early-game mod you use once or twice, there’s much more on the horizon im planning to add. 

## Planned features include:
• **Axe progression overhaul:** introducing stronger, more efficient axes with a meaningful upgrade path  
• **Treecapitator-style mechanics:**  cut entire trees with one swing  
• **No-block tree farming (generators):**  automatic tree growth and harvesting  
• **Auto item pickup:**  seamless integration with existing farms  
• **Late-game wood usage:**  features that give purpose to large stockpiles of wood

These additions aim to make WoodMek a long-term companion in your modpack, especially in mid to late game stages where bulk wood production and usage become key.

---

## FTB Quests

**Overview**  
<img src="src/main/resources/assets/woodmek/pics/quest.png" alt="quests" width="400">  
*With any new mod/modpack, a quest is needed and so using FTB quests. I've created just that.*

**Quest Item**  
<img src="src/main/resources/assets/woodmek/pics/quest1.png" alt="quest item" width="400">  
*With each item, comes a description and a linear progression to help players know what steps to take to get to each milestone with custom rewards!*

---

## Items

### Wood Sheets
<img src="src/main/resources/assets/woodmek/textures/item/woodsheet.png" width="64">  

- **v2.0 Update**: Detailed wood grain texture
- **Obtained by**:
  - Crafting recipes
  - Chopping wood (vanilla loot tables)
- **Processing**: Smelt into Hard Wood or crush into Wood Dust

### Hard Wood
<img src="src/main/resources/assets/woodmek/textures/item/hardwood.png" width="64">  

- **v2.0 Update**: Carbonized texture
- **Uses**:
  - Crafted into Hard Wood Blocks (2x2 pattern)
  - Processed into Hardwood Alloy via Infusion

### Wood Dust
<img src="src/main/resources/assets/woodmek/textures/item/wood_dust.png" width="64"> 

- **New in v2.0**: Fine wood powder
- **Creation**: Crush Wood Sheets in Crusher
- **Purpose**: Intermediate for advanced alloys

### Hardwood Alloy
<img src="src/main/resources/assets/woodmek/textures/item/hardwood_alloy.png" width="64">  

- **Crafting**: Metallurgic Infuser (Hard Wood + Carbon)
- **v3.0 Feature**: Cross-mod recipe support via datapacks

### Chisel
<img src="src/main/resources/assets/woodmek/textures/item/chisel.png" width="64">  

- **v3.5.0 Update**: Chisel
- **Uses**:
  - Turn set blocks into its counterpart

### Transformer Block
<img src="src/main/resources/assets/woodmek/pics/transformer.png" width="600">  

- **v4.0.0 Update**: Transformer
- **Uses**:
  - Turns entities thrown ontop to their upgraded versions
  - Wood dust into hardwood alloys
  - Hardwood into hardwood block
  - Works for single items and stacks of items

---

## Changelog


#### [9.0.0] - WoodMek updated to 1.21.1
- Added Chemical Oxidizer recipe for hardwood alloy into wood essence gas

<img src="src/main/resources/assets/woodmek/pics/17.png" width="300">


#### [8.8.0] - Converted wood essence into a gas
- Liquid: Liquid Sap  (Gold)
- Gas: Wood Essence   (Brown)
- Infuse type (Chemical): Enriched wood essence   (purple)

  <img src="src/main/resources/assets/woodmek/pics/19.png" width="300">

#### [8.7.0] - WoodMek updated to 1.21.1
- Gradle properties and Mekanism API updated for 1.21.1
- Bug tested and all functionality working


#### [8.5.0] - Mekanism Custom `Fluid` Functionality

- Liquid Sap (Texture update pending)
- Fluid has lava functionality with no burning effects etc (eg can be placed next to water)

<img src="src/main/resources/assets/woodmek/pics/18.png" width="300">
<img src="src/main/resources/assets/woodmek/pics/20.png" width="300">



#### [8.2.0] - Mekanism Custom `infuse_type` Functionality  (Chemicals)
- A while after adding Wood Essence, the Wood Essence inside the Metallurgic Infuser now works/displays properly. It will be the primary fluid for WoodMek, with more planned in the future.  
- Added documentation for others trying to figure this out:  
  `\src\main\resources\assets\woodmek\pics\Mekanism_API_1.21.txt`
  
  <img src="src/main/resources/assets/woodmek/pics/14.png" width="300">
  
  <img src="src/main/resources/assets/woodmek/pics/15.png" width="300"> 

#### [8.0.0] - Mekanism Wood Essence Infusion Type  
- Returning to WoodMek's roots! Thought it would be a good time to take another shot at integrating with Mekanism, this time with something bigger, a custom infuse-type fluid.  
- Wood Essence and its tank counterpart are now in the game/JEI (added after an hour of debugging).  
- Added Mekanism API and dependencies to Gradle.
  
<img src="src/main/resources/assets/woodmek/pics/16.png" width="300">  

#### [7.5.0] - Sound Events  
- Added sounds to the Flare (for both shooting and locking).  
- Added a full `DeferredSoundType` for the Transformer block, including break, step, place, hit, and fall sounds.  


#### [7.0.0] - Flaregun, Hardwood tools and hammer
- Added Hardwood set of tools (Slightly better than Iron), added Azalea tool set which is slightly better than netherite tools.
- Added a Hardwood Hammer which mines a 3x3 area (only of the same type of block
  
  <img src="src/main/resources/assets/woodmek/pics/11.png" width="300">
  
  <img src="src/main/resources/assets/woodmek/pics/8.png" width="450">
  
- Added a temporary cooldown to the chisel and change to the texture (which changes back after the cooldown)
  
  <img src="src/main/resources/assets/woodmek/pics/12.png" width="300">
  
  <img src="src/main/resources/assets/woodmek/pics/13.png" width="300">

- Added a Flare gun for testing which branches of the chisel cool down. Custom cooldown bar (coloured), with partical trail when shot.
- At the moment it has no recipe.
  
  <img src="src/main/resources/assets/woodmek/pics/6.png" width="450">
  <img src="src/main/resources/assets/woodmek/pics/7.png" width="250">
  <img src="src/main/resources/assets/woodmek/pics/10.png" width="500">

<br>

#### [6.5.0] - Mini hazard block
- Added a new mini hazardblock

<img src="src/main/resources/assets/woodmek/pics/2.png" width="300">

#### [6.4.0] - Polished hardwood Block (2 varients)
- Added a new polished hardwood blcok to go with the new lamp with 2 varients, dented and undented

<img src="src/main/resources/assets/woodmek/pics/1.png" width="350">

#### [6.3.0] - Retexture
- Rextured the base hardwood items and added  hardwood bricks 

<img src="src/main/resources/assets/woodmek/pics/textureupdate.png" width="300">

#### [6.0.0] - Now a standalone mod! - Recipes, Hazard Blocks and ModID Changes
- Added a second hazard block: **Half Hazard Block**
  - Both hazard blocks now have recipes:  
  
    4x Stone + 1x Yellow Dye
  
  <img src="src/main/resources/assets/woodmek/pics/hazardrecipe.png" width="200">
  <img src="src/main/resources/assets/woodmek/pics/hazardrecipe2.png" width="200">
    
  - Both blocks support **directional movement** with the chisel  
    (rotate 90° back and forth)
- Added a new **Blockstate Lamp**
  - Reacts to click inputs and uses blockstates for toggling on/off
    
    <img src="src/main/resources/assets/woodmek/pics/lamp.png" width="400">  
    <img src="src/main/resources/assets/woodmek/pics/fulllamp.png" width="400">  
    
- **Rewrote and restructured the entire project**  
  - Renamed mod from `blockmod` to `woodmek`  
  - New Mod ID: `woodmek` / `WoodMek`
- **Mekanism recipes now built-in**  
  - No datapack required  
  - Recipes are loaded automatically through mod data  
  - Fully functional integration with **Mekanism**




#### [5.5.0] - DataGen
- Added stairs, buttons, doors, fences and fence gates, slabs, walls, pressure plates and trapdoors

#### [5.0.0] - DataGen
- Converted all loot tables, block states, block/item tags, data maps, item models, and recipes to data generators for easier maintenance and future updates.

#### [4.6.0] - Tool Tips
- Added a `Tool tips` to complex items such as the Chisel and the Transformer block

  <img src="src/main/resources/assets/woodmek/pics/tooltip.png" width="250">

  <img src="src/main/resources/assets/woodmek/pics/tooltip1.png" width="550">

  <img src="src/main/resources/assets/woodmek/pics/tooltip2.png" width="550">  

#### [4.2.0] - Burn Rates
- Added a `burn time` to all wooden items with all  values based on the level on compactness and difficulty
  
  <img src="src/main/resources/assets/woodmek/pics/burntime.png" width="300">  

#### [4.0.0] - Custom Block (Transformer)
- Added a `Transformer` block that can turn items (non modded and modded) into their `upgraded` counterparts
- Example of transformations include wood dust into hardwood alloy. hardwood into hardwood_block
- Added recipe for the transformer

#### [3.8.0] - Custom Items (Chisel)
- Added a building `Chisel` that can turn basic blocks into their building block counterparts 

#### [3.4.0] - Cross-Mod Compatibility & Recipes
- Full `Mekanism` recipe integration via datapacks
- Custom `processing GUIs` (see Processing Workflows)
- Compact machine workflows
- Added `pics` folder for this repo documentation and assets
- `FTB Quest` integration (shown in quests)
- Backend support for modpack recipe overrides

#### [2.0.0] - Loot tables, Recipes & New Content
- Texture updates for Hard Wood/Wood Sheets
- Wood Dust item + crusher recipes
- Loot table fixes for block drops
- Sound type additions for blocks

### [1.5.1] - Modpack compatible with NeoForge Mods (Mekanism, Create, FTB Ultimine and JEI)
- Modpack `WoodMek` on CurseForge with Mekanism, JEI, FTB Ultimine (Forge) and Create (Version 6)
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

---

## Installation
CurseForge Mod: https://www.curseforge.com/minecraft/mc-mods/woodmek

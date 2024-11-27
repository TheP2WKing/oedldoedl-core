# Changelog

## [4.2.0] - 2024-11-27

### Added

- added support for registering jer plugins like jei plugins
- added jei and jer plugins bases
- added old not enough items spawner renderer (required codechickenlib)
- added world gen helpers for registering world gen for ores and plants
- added automatic registering of oredict for various tool and items like bows, saplings and wood
- added loggers for world gen
- added helper class for flower bounding boxes
- added registry helper for potions and potion types
- added biome util for getting all biomes a specific mob can spawn in
- added bad luck potion
- added bases fore tiles and containers
- added bases for logs. planks, leaves, saplings and plants
- added texture references for vanilla fluids
- added helper to register flammability
- added falling block base
- added more default config options
- added a helper for injecting loot into loot tables
- added alternative tnt render and tnt base from oedldoedl explosives
- added alternative bauble base from oedldoedl curiosity
- added block compression and decompression recipe helper
- added helper for registering fluids without buckets
- added entity provider fro the one probe
- added even more oredict to vanilla items

### Changed

- changed the system how welcome messages are constructed
- almost all instances of I18n translation was replaced by text translation components
- welcome messages now use regular translation rather be hard coded
- updated creative tab implementation
- made item model registry more flexible
- oedldoedl icons are now hidden by default in jei as well as debug stick if disabled 
- attributes constants now use mod name constants too  
- updated default dark creative tab with search texture
- fluid fog is now able to be added to fluids that use regular texture rather than auto colored
- updated some inconsistent parameters
- made random util null safety

### Fixed

- fixed crashes related to ender dragon spawn eggs
- fixed crashes related to text translation when playing on servers
- fixed not applying oredict for items that have metadata or damage
- fixed armor that has custom attributes crashes on servers when equipping
- fixed fluids can be affected by explosions and being destroyed
- fixed jei unhiding of player head
- fixed the one probe not displaying custom text on servers

### Removed

- removed ender dragon spawn egg

## [4.1.0] - 2024-06-09

### Added

- added dolphin grace potion from Minecraft 1.13+
- added slow falling potion from Minecraft 1.13+
- added glowing potion
- added debug stick (inspired from 1.13)
- added spawn eggs for missing mobs to creative tab
- added helper to add brewing recipes with forge buckets
- added config options to configure the new potions
- added config option to disable block lighting
- added missing parameters
- added shapeless ore recipe base

### Changed

- renamed ModBiomeUtils to ModBiomeUtil to follow class naming conventions
- added spawn eggs for missing mobs to creative tab
- minimized implementation of TheOneProbe integration
- updated shapeless recipes to actually be shapeless recipes and be able to use oredict
- updated join messages across the mod series
- fixed ModItemArmorBase items can be enchanted with every enchantment

### Removed

- removed beacon base properties from ModCropBase
- removed ModLogger.info because it was broken from the beginning on

## [4.0.0] - 2024-03-03

### 1.12.2 isn't dead, it just took some time

Also check out the other mods that have been updated or released! This is a complete rewrite of the old 2.x version and many things have changed since then. The most significant change is that almost everything that was seen in v3.x for 1.16.5 is more or less included in the release, with lots of extras on top.

### Warning

This version is not compatible with older versions and will not work. Back up your world before the update and enjoy the wave of content.

### Added

- added changelog
- added a welcome message for installed modules
- added config options to change nearly all tooltip colors
- added the unobtainable creative tab
- added lot of recipes for reversing compressed blocks and undoing coloring of blocks
- added a lot of oredict entries for vanilla blocks and items
- added 4 new icons for newly released mods
- added integration for jei and top to work with other oedldoedl modules
- added integration for hiding buildcraft and ae2 facades
- added an abundance of helper classes, functions and utils to make my live easier
- added base extendable classes for tools, armor, items, blocks, fluids, potions, mobs, sounds, renders and more
- added a bunch of additional config options for disabling various shared items and block properties

### Changed

- changed license to MIT
- changed jar naming scheme
- updated shields.io badges
- updated curseforge and github page
- updated logo
- updated dependencies
- tooltips have been rewritten to be more modular and consistent
- updated creative tab texture to be darker
- changed default iron nugget and blaze power texture
- changed some minecraft naming inconsistencies

### Removed

- removed origin tooltips
- removed IHasModel Interface
- removed redundant registering of mod icons
- removed now deprecated config options

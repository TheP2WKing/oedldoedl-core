# Changelog

## [4.1.0] - 2024-06-09

### Added

- added dolphin grace potion from Minecraft 1.13+
- added slow falling potion from Minecraft 1.13+
- added glowing potion
- added debuf stick (inspired from 1.13)
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

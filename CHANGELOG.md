# Changelog

All notable changes to this project will be documented in this file.

## Unreleased

- added validation for values that crash Actually Additions: zero empowerer, fermenter, and liquid fuel times, zero laser energy, and negative mining lens weights
- fixed the fermenter fluid ingredient being treated as an output by recipe filters and replacements
- fixed the empower event reporting a player who took their item back off the empowerer before it was refilled
- fixed single output crusher recipes of Actually Additions failing to parse
- fixed crusher outputs being ignored by recipe filters and replacements

## [0.3.0] - 2025-10-28

- updated to KubeJS 7.2 ([max](https://github.com/MaxNeedsSnacks)@[#4](https://github.com/AlmostReliable/kubejs-actuallyadditions/pull/4))

## [0.2.3] - 2025-10-06

- fixed coffee ingredient effects not being optional

## [0.2.2] - 2024-12-22

- fixed crash with new Actually Additions version
- updated minimum Actually Additions version to 1.3.12

## [0.2.1] - 2024-10-31

- switched to the official maven artifacts
- switched to strict single item stack component in laser recipes
- updated coffee ingredient recipe keys
- updated minimum Actually Additions version to 1.3.7

## [0.2.0] - 2024-10-24

- added player context to the empower event

## [0.1.0] - 2024-10-23

Initial 1.21.1 release!

<!-- Versions -->
[0.3.0]: https://github.com/AlmostReliable/kubejs-actuallyadditions/releases/tag/v1.21.1-neoforge-0.3.0
[0.2.3]: https://github.com/AlmostReliable/kubejs-actuallyadditions/releases/tag/v1.21.1-neoforge-0.2.3
[0.2.2]: https://github.com/AlmostReliable/kubejs-actuallyadditions/releases/tag/v1.21.1-neoforge-0.2.2
[0.2.1]: https://github.com/AlmostReliable/kubejs-actuallyadditions/releases/tag/v1.21.1-neoforge-0.2.1
[0.2.0]: https://github.com/AlmostReliable/kubejs-actuallyadditions/releases/tag/v1.21.1-neoforge-0.2.0
[0.1.0]: https://github.com/AlmostReliable/kubejs-actuallyadditions/releases/tag/v1.21.1-neoforge-0.1.0

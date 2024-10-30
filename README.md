# Space-Quest-V-Voice-Acting-Mod

I added full voice acting to Space Quest V. Fixed some bugs along the way.

## Installation

To install, get a copy of Space Quest V from the Space Quest Collection, and run the `exe` found in the [Releases](https://github.com/cdb-boop/Space-Quest-V-Voice-Acting-Mod/releases). Provide the `exe` with the path to your Space Quest 5 folder. The installer should remove all patch files, as they may cause issues running the game.

After installation, download the ~500MB [resource.aud](https://huggingface.co/cdb13/Space-Quest-V-Voice-Acting-Mod/blob/main/resource.aud) file, which contains the synthetized voices, and add it inside the Space Quest 5 folder.

Note that the game must be played with both text and audio, as the branching dialog requires text output from the Messager.

ScummVM has an issue where loading a saved game is missing text boxes.

## Examples

Example of synthetized voices can be found in the [demo](https://github.com/cdb-boop/Space-Quest-V-Voice-Acting-Mod/tree/main/demo) folder.

## Synthetic Voices

Ordered by vocal appearance.

| Character | Training Data | Voice Actor | Method |
| --- | --- | --- | --- |
| Roger Wilco | Roger Wilco (SQ6) | William Hall | Tortoise-TTS, RVC |
| Bridge Simulator #1| Blaine Rohmer (SQ6) | Jarion Monroe | Tortoise-TTS, RVC |
| Bridge Simulator #1 | Rosella (KQ7), Thunderbird (LSL6) | Maureen McVerry, Iona Morris | Tortoise-TTS, RVC |
| Captain Raemes Tipper Quirk | Thunderbird (LSL6), N/A | Iona Morris, Patrick Warburton | Tortoise-TTS, RVC pitch -16 |
| Narrator | Narrator (SQ6) | Gary Owens | Tortoise-TTS, RVC |
| Rotunta Guard (Right) | Johnson (LSL7) | Kevin Michael Richardson | Tortoise-TTS, RVC pitch -16 |
| Rotunta Guard (Left) | Hotel Manager (SQ6) | Roger Jackson | E2-TTS |
| Cadet A. Einstein | Dorff (SQ6) | Joe Paulino | E2-TTS |
| Cadet Schleppo | Woof (KQ6) | Chuck McCann | E2-TTS |
| Ambassador Beatrice "Bea" Wankmeister | Rosella (KQ7) | Maureen McVerry | Tortoise-TTS, RVC |
| Cadet Splock | Elmo Pug (SQ6) | Doug Boyd | F5-TTS |
| Admiral Wil'm Pol'k | Larry Laffer (LSL7) | Jan Rabson | Tortoise-TTS, RVC |
| Rumproast Droole | Commander Kielbasa? Doctor Beleaux? (SQ7) | Jarion Monroe | Tortoise-TTS, RVC pitch +6 |
| Gowitda Florence "Flo" Qwerty | Jamie Lee Coitus (LSL7) | Mary Kay Bergman | Tortoise-TTS, RVC |
| Clifford "Cliffy" Crawford | Desk Sergeant Frick (GK1) | Jim Cummings | Tortoise-TTS, RVC |
| Clifford "Cliffy" Crawford | Desk Sergeant Frick (GK1) | Jim Cummings | Tortoise-TTS, RVC |
| WD40 | Thunderbird (LSL6) | Iona Morris | Tortoise-TTS, RVC pitch -20 |
| "Maggot" | Fester Blats (SQ6) | Joe Paulino | E2-TTS |
| Cocktail Waitress | Waitron (SQ6) | Lucille Bliss | E2-TTS |
| Nelo Jones | Johnson (LSL7) | Kevin Michael Richardson | Tortoise-TTS, RVC |
|  Detention Guard #1 | Detective Franklin Mosley (GK1) | Mark Hamill | E2-TTS |
|  Detention Guard #2 | Daryl (LSL6) | Ed Gilbert | E2-TTS |
|  Angry Bar Patron | Djurkwhad (SQ6) | Joe Paulino | E2-TTS |
| Mutant Colonist (Harry Kerry?) | Pa Conshohocken (SQ6) | Charles Martinet | E2-TTS |
| Slep | Freddy Pharkas (FP1) | Cameron Arthur Clarke | Tortoise-TTS, RVC |
| Crumpella | Wriggley (SQ6) | Carol Bach y Rita | F5-TTS |

## Speech Synthesizers

* [Tortoise-TTS](https://git.ecker.tech/mrq/tortoise-tts)
* [RVC](https://github.com/RVC-Project/Retrieval-based-Voice-Conversion-WebUI)
* [F5-TTS & E2-TTS](https://github.com/SWivid/F5-TTS)
* A handful of free mouth noises from the Internet, most put through RVC.
* A handful of recordings of me delivering lines put through RVC.

## Code

### Unresolved bugs

* The game must be played with both text and audio.
* Dialog in the "Captain's Log" introduction does not move forward automatically.
* Dialog in the inventory does not move forward automatically.
* Branching dialog on Genetix is missing Roger's voiced message for selection.

### Basic audio fixes

* Used `AUDBLAST.DRV`, `SIERRA.EXE` and `INTERP.ERR` files found in the SCI Companion's SCI1.1 TemplateGame.
* Updated `Blink.sc` (`Talker.sc`), `AnimDialog.sc` and `Messager.sc` files to use Audio36, matching code in corresponding files in LSL6.
* Added `case 0` to `Rgn` and `Feature` classes and all inheriting classes in order to work with newer SIERRA.EXE supporting voice audio. This fixes the Audio36 crash `Exit to error: DMA segbound wrapping (read)`.

Rgn (994)

* Rm (994)
* sbar(505)
* kiz (350)
* eureka (210)
* starcon (109)
* genetix (031)

Feature (950)

* Socket (228)
* MyFeature (031)
* View (998)
  * Prop (998)
    * Actor (998)
      * Ego (988)
        * SQEgo (018)
      * Cat (976)
      * MyPuke (660)
      * Fuse (228)
      * Tool (226)
      * MyActor (031)
    * Door (954)
    * ShipChunk, Ship, Button (850)
    * Narrator (928)
      * Talker (928)
        * ChoiceTalker (030)
      * ChoiceNumber (030)
    * FloatObj (801)
      * Asteroid (801)
    * Tumbler (770)
    * LockDevice (335)
    * Multiprop (244)
    * MyCones (119)
    * MyProp (031)
  * Section (246)
  * AnswerBox (137)
  * CrestPiece* (119)
  * Puke (1010)

### Adding missing voicing acting

* Changed `global90` from 1 to 3 (flags `b0001` = text, `b0010` = voice). NOTE: Changing this value doesn't seem to do anything in DOSBOX. Overriding the audio settings to use both audio and text in ScummVM fails to show the text boxes, which is required for selecting branching dialog.
* Added voice acting to death room message types. (deathRoom)
* Added voice acting to captain's log and bridge simulator in the introduction (rm104).
* Added voice acting to ending congratulation scene (rm1041).
* Added voice acting to inventory. (Sp5InvItem)
* Added voice acting for Roger after selecting a dialogue branch (except when beaming out of Genetix). (cliffyGoesWith, rm620, rm640, rm730, sCommandCliffy, sCommandDroole, sCommandFlo, `sDStarconChoices`)
* Added voice acting to space academy test results letter. (rm166)
* Added voice acting to special close up scene scripts where Talker Messager was overridden. (rm440, rm450, rm520, rm530)

### New Messager bug fixes

* Fixed rendering bug (using GetPort and SetPort in Messager) where printing Messager message over another window (i.e. inventory, communicator, etc.) caused other window to get corrupted.

### Messager enhancements

* Dynamically lower music audio while Messager speaking and in special cut scenes.
* Added feature (inspired by LSL7 code) to restore mouse state after Messager completion.
* Added check in Messager (based on LSL7 code) to check if Messager already called and show warning.

### Decompilation or general bug fixes

* Fix bug where Roger holds face hugger close up forever.
* Fix bug where Cliffy is trying to help Roger up from the splits after getting the cloaking device.
* Fix bug where Roger walked to wrong location while exiting screen in Genetix, value reading `(gSQ5 handsOff:)` instead of `register`.
* Fix bug (caused by decompilation?) where red glow at the start of outside view of the bridge simulator room was not showing. This was caused by an extra line palette setting `(Palette palSET_FROM_RESOURCE 600 2)`.
* Fix bug where Roger would enter dumpster screen on Genetix `y` position on bottom edge of screen, likely caused by calling `super init:` too late and causing y value to be overwritten. (rm740)
* Fixed bug where Roger getting on the transported pad from the left would use bad pathing. The lines' `[local20 register]; [local20 (+ (= register (* register 8)) 1)]` array position calculation `(= register (* register 8))` was put before the two array accesses, `(= register (* register 8)); [local20 register]; [local20 (+ register 1)]`.
* Attempted bug fix for Flo's eyes in final scene. (rm1041)
* Fixed mislabeled voice lines to render the correct talker.

### Timing bug fixes

* Added `Wait(1)` to EVA pod minigame to limit FPS to 60 to prevent issues at higher cycle rates. The thrust level's `doit` method appears to be polled every possible cycle. (FloatObj)
* Adjusted code in various places to change `cycles` to ticks (usually where cycles > 1, but sometimes where cycles = 1) and remove or correct setting `cycleSpeed` or `moveSpeed` to 0 where appropriate to allow for better default speeds for added compatibility with high cycle cpus.
  * beaClimbsOut, cliffyGoesWith, deathRoom, fuse, genetix, keyStuff_242, keyStuff, LockDevice, MyPuke, rm100, rm104, rm106, rm107, rm110, rm115, rm117, rm121, rm127, rm132, rm133, rm135, rm166, rm200, rm206, rm212, rm215, rm225, rm250, rm280, rm300, rm305, rm310, rm315, rm420, rm500, rm510, rm640, rm740, rm750, rm760, rm1050, rm1060, sInTheAsteroids, sOpenDoors, sWD40Attacks

## Labor

Rough estimates.

* ~100 Hours of work generating, selecting, splicing and cleaning audio files.
* ~30 Hours of programming with the SCI Companion.
* ~1/2 Hour on SCIProgramming.com.

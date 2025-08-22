## Notes on DoomLazer's fork of this project

While I don't generally like the way capitalists use 'AI', from what I've played of this mod so far the results are suprisingly good in my opinion. My intent with the fork is to work on fixing some of the bugs and record the code changes from the original to CDB-Boops mod, and my bug fixes. We'll see how far I get I guess. Now back to CDB-Boops readme:


# Space-Quest-V-Voice-Acting-Mod

I modified Space Quest V to support full voice acting.

Sample video:

* https://www.youtube.com/watch?v=LB9o2LXhkkY

## Installation

To install, get a copy of Space Quest V from the Space Quest Collection, and run the `exe` found in the [Releases](https://github.com/cdb-boop/Space-Quest-V-Voice-Acting-Mod/releases). Provide the `exe` with the path to your Space Quest 5 folder. The installer should remove all patch files, as they may cause issues running the game.

After installation, download the ~500MB [resource.aud](https://huggingface.co/cdb13/Space-Quest-V-Voice-Acting-Mod/blob/main/resource.aud) file, which contains the synthetized voices, and add it inside the Space Quest 5 folder.

Note that the game must be played with both text and audio, as the branching dialog requires text output from the Messager.

Runs with DOXBox-X and DOSBox (0.74-2 or earlier). ScummVM has an issue where loading a saved game loads with missing text boxes.

## Pipeline

If you want to try adding voices to other old games, here is my general pipeline.

* **Programming**: Decompile and understand a game's code to figure out what and where changes are needed to get both text and speech working.
* **Dataset Collection**: Quality > Quantity. Think about a character and what voice would be appropriate and try to find or make a dataset that matches the character. Consider the trade-offs of using audio denoising on low quality audio.
* **Fine-Tuning**: Fine-tune voice models using Tortoise-TTS and RVC. If you want, you can also experiment with fine-tuning F5-TTS and E2-TTS. You can find some scattered tutorials [here](https://www.youtube.com/@Jarods_Journey).
* **Text Extraction**: Extract text from a game and sort it by speaker if needed.
* **Synthetic Voice Generation**: Tortoise-TTS can take hours to generate hundreds of vocal lines on a GPU. Additionally, you may try generating multiple samples at once, as the quality and delivery may vary with random seed.
* **Quality Control**: Filter out bad audio samples and select the best ones. If a vocal line isn't working try generating more, correcting any issues with the text or rewriting it more phonetically. For example, rewriting "EVA" as "E.V.A." or "II" as "Two".

## Code

### Unresolved bugs

* The game must be played with both text and audio.
* Dialog in the "Captain's Log" introduction does not move forward automatically.
* Dialog in the inventory does not move forward automatically.
* Branching dialog on Genetix is missing Roger's voiced message for selection.
* Lip sync was not used.
 
* 201-11-0-14-5
  * The voice should be Flo's instead of the narrator.
* Pic.064 (Boulder screen)
  * WD40 close-up sprite not disapearing. (DOSBox-X)
* Pic.100 (Thrakus, right screen)
  * After save the program freezes? (DOSBox-X)
* 730-13-0-3-1
  * Talker ID should be Roger's instead of Cliffy's.
* Pic.110 (Genetix, initial beam-down screen)
  * "Hello?" speech bubble from the communicator is missing Flo's voice?
* Pic.127 (Comic-like close-up with "Freeze scum!")
  * WD-40 is missing a voice line for the close-up where she says "Freeze scum!" on the Goliath's bridge.

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

### Adding missing voice acting

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

* Fixed bug where previous save got deleted due to bad decompiled assembly code in the `SRDialog` class's `doit` method.
* Fixed bug where Roger holds face hugger close up forever.
* Fixed bug where Cliffy is trying to help Roger up from the splits after getting the cloaking device.
* Fixed bug where Roger walked to wrong location while exiting screen in Genetix, value reading `(gSQ5 handsOff:)` instead of `register`.
* Fixed bug (caused by decompilation?) where red glow at the start of outside view of the bridge simulator room was not showing. This was caused by an extra line palette setting `(Palette palSET_FROM_RESOURCE 600 2)`.
* Fixed bug where Roger would enter dumpster screen on Genetix `y` position on bottom edge of screen, likely caused by calling `super init:` too late and causing y value to be overwritten. (rm740)
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

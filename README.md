# Space-Quest-V-Voice-Acting-Mod

I added full voice acting to Space Quest V. Fixed some bugs along the way.

## Installation

Only DOSBOX is supported. ScummVM fails to show Messenger text boxes, even with overrides, when audio is played. Text is required for branching dialogue.

To install, get a copy of Space Quest V from the Space Quest Collection, and run the `exe` found in the [Releases](https://github.com/cdb-boop/Space-Quest-V-Voice-Acting-Mod/releases). Provide the `exe` with the path to your Space Quest 5 folder.

After installation, download the [RESOURCE.AUD](https://huggingface.co/cdb13/Space-Quest-V-Voice-Acting-Mod/blob/main/RESOURCE.AUD) file, which contains the synthetized voices, and add it inside the Space Quest 5 folder.

## Examples

Examples can be found in the [demo](https://github.com/cdb-boop/Space-Quest-V-Voice-Acting-Mod/tree/main/demo) folder.

## Synthetic Voices

Ordered by vocal appearance.

| Character | Training Data | Voice Actor | Method |
| --- | --- | --- | --- |
| Roger Wilco | Roger Wilco (SQ6) | William Hall | Tortoise-TTS, RVC |
| Bridge Simulator #1 (rm104) | Blaine Rohmer (SQ6) | Jarion Monroe | Tortoise-TTS, RVC |
| Bridge Simulator #1 (rm104) | Rosella (KQ7), Thunderbird (LSL6) | Maureen McVerry, Iona Morris | Tortoise-TTS, RVC |
| Captain Raemes Tipper Quirk | Thunderbird (LSL6), N/A | Iona Morris, Patrick Warburton | Tortoise-TTS, RVC pitch -16 |
| Narrator | Narrator (SQ6) | Gary Owens | Tortoise-TTS, RVC |
| Rotunta Guard (Right) | Johnson (LSL7) | Kevin Michael Richardson | Tortoise-TTS, RVC pitch -16 |
| Rotunta Guard (Left) | Hotel Manager (SQ6) | Roger Jackson | E2-TTS |
| Cadet A. Einstein | Dorff (SQ6) | Joe Paulino | E2-TTS |
| Cadet Schleppo (rm135) | Woof (KQ6) | Chuck McCann | E2-TTS |
| Ambassador Beatrice "Bea" Wankmeister | Rosella (KQ7) | Maureen McVerry | Tortoise-TTS, RVC |
| Cadet Splock | Elmo Pug (SQ6) | Doug Boyd | F5-TTS |
| Admiral Wil'm Pol'k | Larry Laffer (LSL7) | Jan Rabson | Tortoise-TTS, RVC |
| Rumproast Droole | Commander Kielbasa? Doctor Beleaux? | Jarion Monroe | Tortoise-TTS, RVC pitch +6 |
| Gowitda Florence "Flo" Qwerty | Jamie Lee Coitus (LSL7) | Mary Kay Bergman | Tortoise-TTS, RVC |
| Clifford "Cliffy" Crawford | Desk Sergeant Frick (GK1) | Jim Cummings | Tortoise-TTS, RVC |
| Clifford "Cliffy" Crawford | Desk Sergeant Frick (GK1) | Jim Cummings | Tortoise-TTS, RVC |
| WD40 | Thunderbird (LSL6) | Iona Morris | Tortoise-TTS, RVC pitch -20 |
| "Maggot" | Fester Blats (SQ6) | Joe Paulino | E2-TTS |
| Cocktail Waitress | Waitron (SQ6) | Lucille Bliss | E2-TTS |
| Nelo Jones | Johnson | Kevin Michael Richardson | Tortoise-TTS, RVC |
|  Detention Guard #1 | Franklin Mosley (GK1) | Mark Hamill | E2-TTS |
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

## Labor

Rough estimates.

* ~100 Hours of work generating, selecting, splicing and cleaning audio files.
* ~30 Hours of programming with the SCI Companion.
* ~1/2 Hour on SCIProgramming.com.

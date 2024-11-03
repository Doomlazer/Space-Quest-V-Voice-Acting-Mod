; The name of the installer
Name "Space Quest 5 Message Audio Patch"

; The file to write
OutFile "sq5_message_audio_patch.exe"

; The default installation directory
InstallDir $INSTDIR

; The text to prompt the user to enter a directory
DirText "Select the folder with the original version of Space Quest 5"

; Show details
ShowInstDetails show

!include "VPatchLib.nsh"

!macro Patch oldfile newfile patchfile
  File "/oname=${oldfile}.UPDATE" "${oldfile}"
  DetailPrint "${oldfile} + ${patchfile} -> ${newfile}"
  !insertmacro VPatchFile ${patchfile} "$INSTDIR\${oldfile}.UPDATE" "$INSTDIR\${oldfile}.TEMP"
  Delete "${oldfile}"
  Rename "${oldfile}.UPDATE" "${newfile}"
!macroend

Section
  SetOutPath $INSTDIR

  ; Update sound effects file
  !insertmacro Patch "RESOURCE.AUD" "resource.sfx" ".\patch\RESOURCE.AUD.PAT"

  ; Update non-audio package file
  !insertmacro Patch "RESOURCE.000" "resource.000" ".\patch\RESOURCE.000.PAT"

  ; Update mapping files
  !insertmacro Patch "RESOURCE.MAP" "resource.map" ".\patch\RESOURCE.MAP.PAT"
  Delete "65535.MAP"
  Delete "MESSAGE.MAP"
  Delete "RESOURCE.MSG"

  ; Remove ALL patch files
  ; Is this case-sensitive?
  Delete "$INSTDIR\*.FON"
  Delete "$INSTDIR\*.fon"
  Delete "$INSTDIR\*.P56"
  Delete "$INSTDIR\*.p56"
  Delete "$INSTDIR\*.V56"
  Delete "$INSTDIR\*.v56"
  Delete "$INSTDIR\*.HEP"
  Delete "$INSTDIR\*.hep"
  Delete "$INSTDIR\*.SCR"
  Delete "$INSTDIR\*.scr"
  Delete "$INSTDIR\*.TEX"
  Delete "$INSTDIR\*.tex"

  ; Update Sierra engine
  !insertmacro Patch "SIERRA.EXE" "SIERRA.EXE" ".\patch\SIERRA.EXE.PAT"
  !insertmacro Patch "INTERP.ERR" "INTERP.ERR" ".\patch\INTERP.ERR.PAT"
  !insertmacro Patch "AUDBLAST.DRV" "AUDBLAST.DRV" ".\patch\AUDBLAST.DRV.PAT"

  File ".\new\GMGUS.DRV"

  ; Remind the user to download the audio
  MessageBox MB_OK "Patch complete! Remember to download and add 'RESOURCE.AUD' to hear vocals. You may also need to set 'audioDrv' to 'AUDBLAST.DRV' in your .CFG file."
SectionEnd
#Godot-FileWriter
- File I/O support on Godot engine for Android. (https://github.com/okamstudio/godot)

- Godot version 2.0 stable.

##How to use
- Drop the filewriter folder inside godot/modules

- Move the filewriter/GodotFileWriter.java to godot/platform/android/java/src/org/godotengine/godot

###Compile
1. #> scons platform=android
2. cd godot/platform/android/java
3. #> ./gradlew build
4. The resulting apk will be available at godot/platform/android/java/build/outputs/apk
 
###Configure
Add the following in the engine.cfg file:

> [android]

> modules="org/godotengine/godot/GodotFileWriter"

**Use them in the script:**

> var singleton = Globals.get_singleton("GodotFileWriter")
> singleton.initFile(String filename) # creates a file 'filename' under Documents/MyAppData location. 
> singleton.publish(String content) # writes the content to the file
> singleton.fetchContent() # fetches the file content

**Note:** The 'Documents/MyAppData' location can be easily chnaged through the code. The file can also be created as a hidden file. 

###Build the game apk
From the settings of the godot engine UI:

> Export->Target->Android


Custom Package (Debug/Release): 
> Point to the newly built apk

> Permission check: READ EXTERNAL STORAGE & WRITE EXTERNAL STORAGE

####License
MIT

###Special Mention
Thanks [TeamKrishna](http://teamkrishna.in)

Other plugings:
- [Godot-SpeechToText](https://github.com/literaldumb/Godot-SpeechToText)
- [Godot-TextToSpeech](https://github.com/literaldumb/Godot-TextToSpeech)
- [Godot-CustomSpeech](https://github.com/literaldumb/Godot-CustomSpeech)


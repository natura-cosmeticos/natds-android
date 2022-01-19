#!/bin/sh
adb devices | grep emulator | cut -f1 | while read line; do adb -s "$line" emu kill; done
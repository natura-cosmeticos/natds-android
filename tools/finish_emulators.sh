#!/bin/sh
adb devices | grep emulator | cut -f1 | while read -r line; do adb -s "$line" emu kill; done